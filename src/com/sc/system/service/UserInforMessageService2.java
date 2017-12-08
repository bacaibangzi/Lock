package com.sc.system.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.UserInforMessageDao;
import com.sc.system.pojo.DevUserCard;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserInforMessage;
import com.sc.teminal.action.DevcmdlistAction;
import com.sc.teminal.pojo.DevLog;
import com.sc.teminal.pojo.Devnamelistinfo;
import com.sc.teminal.pojo.VhuisYanc;
import com.sc.teminal.service.CmdlogService;
import com.sc.teminal.service.DevLogService;
import com.sc.teminal.service.DevnamelistinfoService;
import com.sc.teminal.service.VhuisYancService;
import com.sc.util.CommonUtil;

public class UserInforMessageService2 extends BaseService<UserInforMessage> {
	@Autowired
	UserInforMessageDao userInforMessageDao;
	@Autowired
	OrgInfoService orgInfoService;
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	DevUserCardService devUserCardService;
	@Autowired
	VhuisYancService vhuisYancService;
	@Autowired
	DevnamelistinfoService devnamelistinfoService;
	@Autowired
	CmdlogService cmdlogService;
	@Autowired
	DevLogService devLogService;
	
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public synchronized void syn(HttpServletRequest request) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		//0  档案新增 
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "0");
		
		List<UserInforMessage> userInfoList = userInforMessageDao.query(conditionMap);
		UserInfo userInfo = null;
		OrgInfo orgInfo = null;
		DevUserCard devUserCard = null;
		for(UserInforMessage userInforMessage : userInfoList) {
			
			try {
				// 保存人员
				userInfo = new UserInfo();
				orgInfo = orgInfoService.getByName(userInforMessage.getDeptstr());
				userInfo.setUiOrgCode(orgInfo.getOiCode());
				userInfo.setUiType(0L);
				userInfo.setUiName(userInforMessage.getUsername());
				userInfo.setUiSex(Long.parseLong(userInforMessage.getSex()));
				userInfo.setUiNickName(userInforMessage.getIdserial());
				userInfo.setUiImg("0");
				userInfo.setUiNum(userInforMessage.getIdserial());
				
				userInfoService.save(userInfo);
				
				// 保存人员卡
				userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
			
				devUserCard = new DevUserCard();
				devUserCard.setBm(orgInfo.getOiCode());
				//devUserCard.setCardNum(userInforMessage.getCardno());
				devUserCard.setCardNum(userInforMessage.getCardid());
				devUserCard.setUserId(userInfo.getUiId().intValue());
				devUserCard.setFlag("1");
				devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard);
				
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "1");
				userInforMessageDao.updateDealFlag(conditionMap);
			
			}catch(Exception err) {
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "2");
				userInforMessageDao.updateDealFlag(conditionMap);
			}
		}
		
		//1 档案删除
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "1");
		 
		userInfoList = userInforMessageDao.query(conditionMap);
		ConditionVO vo = null;
		for(UserInforMessage userInforMessage : userInfoList) {
			try {
				// 先判断是否下达
				List<VhuisYanc> VhuisYancList = vhuisYancService.queryVhuisYancsByCondition(userInforMessage.getIdserial());
				if(VhuisYancList!=null) {
					for(VhuisYanc vhuisYanc :VhuisYancList){
						Devnamelistinfo devnamelistinfo = devnamelistinfoService.getDevnamelistinfoById(vhuisYanc.getNamelistid().longValue());
						devnamelistinfo.setUpdateType(3);
						devnamelistinfo.setSyncState(0);
						devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);

						// 插入日志
						cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "回收");
						
						// 日志
						if(request==null) {
							String userName = "同步";
							String ip = "127.0.0.1";
							String context = vhuisYanc.getUiName()+"("+vhuisYanc.getUiNum()+"),回收卡号"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLogService.saveOrUpdateDevInfo(devLog);	
						}else {
							String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
							String ip = CommonUtil.getRemoteHost(request);
							String context = vhuisYanc.getUiName()+"("+vhuisYanc.getUiNum()+"),回收卡号"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLogService.saveOrUpdateDevInfo(devLog);	
						}
					}
				}
				
				// 删除用户卡
				userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
				List<DevUserCard>  devUserCardList = devUserCardService.queryDevUserCardsByUser(""+userInfo.getUiId());
				for(DevUserCard devUserCard1 : devUserCardList) {
					vo = new ConditionVO();
					vo.setEntityId(devUserCard1.getSn().toString());
					devUserCardService.deleteDevUserCardById(vo);
				}
				
				// 删除用户
				vo = new ConditionVO();
				vo.setEntityId(userInfo.getUiId().toString());
				userInfoService.deleteUserInfoById(vo);
				
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "1");
				userInforMessageDao.updateDealFlag(conditionMap);
				
			}catch(Exception err) {
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "2");
				userInforMessageDao.updateDealFlag(conditionMap);
			}
		}
		
		// 2  档案 修改
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "2");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			try {
				userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
				
				userInfo.setUiType(0L);
				userInfo.setUiName(userInforMessage.getUsername());
				userInfo.setUiSex(Long.parseLong(userInforMessage.getSex()));
				userInfo.setUiNickName(userInforMessage.getIdserial());
				userInfo.setUiImg("0");
				userInfo.setUiNum(userInforMessage.getIdserial());
				userInfoService.updateUserInfo(userInfo);
				
				
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "1");
				userInforMessageDao.updateDealFlag(conditionMap);
				
			}catch(Exception err) {
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "2");
				userInforMessageDao.updateDealFlag(conditionMap);
			}
		}
		
		
		//3  换卡 
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "3");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			try {
				userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
				
				// 新卡号
				//String kh = userInforMessage.getCardno();
				String kh = userInforMessage.getCardid();
				String khStr = DevcmdlistAction.getKhh(kh);
				// 根据旧卡号获取之前下达信息
				List<Devnamelistinfo> list = devnamelistinfoService.query(userInforMessage.getOldcardid());
				
				for(Devnamelistinfo devnamelistinfo : list){
					// 新发删除指令
					devnamelistinfo.setSyncState(0);
					devnamelistinfo.setUpdateType(3);
					devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
					
					String content = devnamelistinfo.getContent();
					content = content.substring(khStr.length());
					devnamelistinfo.setContent(khStr+content);
					devnamelistinfo.setUpdateType(1);
					devnamelistinfo.setSyncState(0);
					devnamelistinfo.setEditTime(new Date());
					
					// 指令表需要重新下达
					devnamelistinfo.setCardNo(kh);
					devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo); // 插入新卡

					// 插入日志
					String maxId = devnamelistinfoService.getMaxVersion("");
					cmdlogService.insertLog(maxId, "换卡");
					
					// 日志
					if(request==null) {
						String userName = "同步";
						String ip = "";
						String context = userInfo.getUiName()+"("+devUserCard.getCardNum()+")  换卡:"+devnamelistinfo.getCardNo()+"->"+kh;
						DevLog devLog = new DevLog();
						devLog.setContext(context);
						devLog.setUser(userName);
						devLog.setIp(ip);
						devLog.setDate(new Date());
						devLogService.saveOrUpdateDevInfo(devLog);
					}else {
						String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
						String ip = CommonUtil.getRemoteHost(request);
						String context = userInfo.getUiName()+"("+devUserCard.getCardNum()+")  换卡:"+devnamelistinfo.getCardNo()+"->"+kh;
						DevLog devLog = new DevLog();
						devLog.setContext(context);
						devLog.setUser(userName);
						devLog.setIp(ip);
						devLog.setDate(new Date());
						devLogService.saveOrUpdateDevInfo(devLog);	
					}
				}
				devUserCard.setCardNum(kh);
				devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard);
				
				
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "1");
				userInforMessageDao.updateDealFlag(conditionMap);
				
			}catch(Exception err) {
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "2");
				userInforMessageDao.updateDealFlag(conditionMap);
			}
		}
		
		//5 、挂失 
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "5");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			try {
				userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
				// 判断卡是否是挂失状态
				DevUserCard devUserCard1 = devUserCardService.queryDevUserCardsByCondition(userInforMessage.getCardid()).get(0);
				
				if(!"0".equals(devUserCard1.getFlag())) {
					List<Devnamelistinfo> list = devnamelistinfoService.queryByCardNo(userInforMessage.getCardid()); 
					if(list!=null) {
						for(Devnamelistinfo devnamelistinfo : list){
							// 再回收
							devnamelistinfo.setUpdateType(3);
							devnamelistinfo.setEditTime(new Date());
							devnamelistinfo.setSyncState(0);
							devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
							
							// 将数据插入日志
							devnamelistinfoService.insertlog(devnamelistinfo);
	
							try {
								// 插入日志
								cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "挂失");
							} catch (Exception e) {
							}
							
							// 日志
							if(request==null) {
								String userName = "同步";
								String ip = "127.0.0.1";
								String context = userInfo.getUiName()+"("+devUserCard1.getCardNum()+") 挂失卡号:"+devnamelistinfo.getCardNo();
								DevLog devLog = new DevLog();
								devLog.setContext(context);
								devLog.setUser(userName);
								devLog.setIp(ip);
								devLog.setDate(new Date());
								devLogService.saveOrUpdateDevInfo(devLog);
							}else {
								String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
								String ip = CommonUtil.getRemoteHost(request);
								String context = userInfo.getUiName()+"("+devUserCard1.getCardNum()+") 挂失卡号:"+devnamelistinfo.getCardNo();
								DevLog devLog = new DevLog();
								devLog.setContext(context);
								devLog.setUser(userName);
								devLog.setIp(ip);
								devLog.setDate(new Date());
								devLogService.saveOrUpdateDevInfo(devLog);		
							}
							
						}
					}
					
					devUserCard1.setFlag("0");
					devUserCardService.updateFlag("0", devUserCard1.getUserId()+"", devUserCard1.getCardNum());
				}
				
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "1");
				userInforMessageDao.updateDealFlag(conditionMap);
				
			}catch(Exception err) {
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "2");
				userInforMessageDao.updateDealFlag(conditionMap);
			}
		}
		
		
		//6、解挂
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "6");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			try {
				userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
				// 判断卡是否是挂失状态
				DevUserCard devUserCard1 = devUserCardService.queryDevUserCardsByCondition(userInforMessage.getCardid()).get(0);
				
				if(!"1".equals(devUserCard1.getFlag())) {
					
					List<Devnamelistinfo> list = devnamelistinfoService.queryLog(devUserCard1.getCardNum());
					// 重新下发
					for(Devnamelistinfo devnamelistinfo : list){
						devnamelistinfo.setUpdateType(1);
						devnamelistinfo.setSyncState(0);
						devnamelistinfo.setEditTime(new Date());
						
						Devnamelistinfo dlinfo = devnamelistinfoService.getByTerminalIDCardNo(""+devnamelistinfo.getTerminalId(), devnamelistinfo.getCardNo());
						// 存在就更新
						if(dlinfo!=null) {
							dlinfo.setUpdateType(1);
							dlinfo.setSyncState(0);
							dlinfo.setEditTime(new Date());
							devnamelistinfoService.updateDevnamelistinfoInfo(dlinfo);

							// 插入日志
							cmdlogService.insertLog(dlinfo.getNameListId()+"", "解挂");
						}
						// 没有就插入
						else {
							devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
							// 插入日志
							String maxId = devnamelistinfoService.getMaxVersion("");
							cmdlogService.insertLog(maxId+"", "解挂");
						}
						

						// 日志
						if(request==null) {
							String userName = "同步";
							String ip = "127.0.0.1";
							String context = userInfo.getUiName()+"("+devUserCard1.getCardNum()+")  解挂卡号:"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLogService.saveOrUpdateDevInfo(devLog);	
						}else {
							String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
							String ip = CommonUtil.getRemoteHost(request);
							String context = userInfo.getUiName()+"("+devUserCard1.getCardNum()+")  解挂卡号:"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLogService.saveOrUpdateDevInfo(devLog);	
						}
									
						
					}
					// 删除日志
					devnamelistinfoService.deleteLogByCardNo(devUserCard1.getCardNum());
					

					// 修改用户卡状态
					devUserCard1.setFlag("1");
					devUserCardService.updateFlag("1", devUserCard1.getUserId()+"", devUserCard1.getCardNum());
					
					
				}
				
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "1");
				userInforMessageDao.updateDealFlag(conditionMap);
				
			}catch(Exception err) {
				conditionMap.put("idnumber", userInforMessage.getIdnumber());
				conditionMap.put("dealFlag", "2");
				userInforMessageDao.updateDealFlag(conditionMap);
			}
		}
		
	}
	
	public Page<UserInforMessage> queryUserInforMessagesForPage(ConditionVO vo,
			Page<UserInforMessage> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(userInforMessageDao, conditionMap, page);
	}
}
