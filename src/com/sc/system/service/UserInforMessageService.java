package com.sc.system.service;

import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dbutil.DBConn;
import com.sc.framework.base.service.BaseService;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.UserInforMessageDao;
import com.sc.system.dao.ViewXsZhusuDao;
import com.sc.system.pojo.DevUserCard;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserInforMessage;
import com.sc.system.pojo.ViewXsZhusu;
import com.sc.teminal.action.DevcmdlistAction;
import com.sc.teminal.dao.TerminalinfoMapper;
import com.sc.teminal.pojo.DevLog;
import com.sc.teminal.pojo.Devnamelistinfo;
import com.sc.teminal.pojo.Terminalinfo;
import com.sc.teminal.pojo.VhuisYanc;
import com.sc.teminal.service.CmdlogService;
import com.sc.teminal.service.DevLogService;
import com.sc.teminal.service.DevnamelistinfoService;
import com.sc.teminal.service.TerminalinfoService;
import com.sc.teminal.service.VhuisYancService;
import com.sc.util.CommonUtil;
import com.sc.util.DateUtil;
@Service
public class UserInforMessageService extends BaseService<UserInforMessage> {
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
	@Autowired
	TerminalinfoService terminalinfoService;
	@Autowired
	ViewXsZhusuDao viewXsZhusuDao;
	@Autowired
	TerminalinfoMapper terminalinfoMapper;
	
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void syn(HttpServletRequest request) throws Exception{
		
		synchronized(UserInforMessageService.class){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		int zhusu = 0;
		// 同步数据
		System.out.println("##################同步数据#####################");
		try {
			userInforMessageDao.syn(conditionMap);
			
			Properties properties = new Properties();  
			InputStream inStream = DBConn.class.getClassLoader()  
			        .getResourceAsStream("jdbc.properties");  
			properties.load(inStream);
			
			// 宿管接口
			zhusu = Integer.parseInt(properties.getProperty("zhusu"));  
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		//0  档案新增 
		conditionMap.put("dealFlag", "0");
		//conditionMap.put("messageType", "0");
		
		List<UserInforMessage> userInfoList = userInforMessageDao.query(conditionMap);
		UserInfo userInfo = null;
		OrgInfo orgInfo = null;
		DevUserCard devUserCard = null;
		ConditionVO vo = null;
		
		for(UserInforMessage userInforMessage : userInfoList) {
			
			if("0".equals(userInforMessage.getMessageType())) {
				conditionMap = new HashMap<String, Object>();
				try {
					
					// 保存人员
					userInfo = new UserInfo();
					try {
						orgInfo = orgInfoService.getByName(userInforMessage.getDeptstr());
					} catch (Exception e1) {
						orgInfo = new OrgInfo();
						orgInfo.setOiCode("00000001");
						conditionMap.put("remark", "人员部门信息不存在,");
					}
					if(orgInfo==null) {
						//userInfo.setUiOrgCode("0000");
						orgInfo = new OrgInfo();
						orgInfo.setOiCode("00000001");
						
						//throw new Exception("人员部门信息不存在");
						conditionMap.put("remark", "人员部门信息不存在,");
					}
					
					userInfo.setUiOrgCode(orgInfo.getOiCode());
					userInfo.setUiType(0L);
					userInfo.setUiName(userInforMessage.getUsername());
					//userInfo.setUiSex(Long.parseLong(userInforMessage.getSex()==null?"0":userInforMessage.getSex()));
					userInfo.setUiNickName(userInforMessage.getIdserial());
					userInfo.setUiImg("0");
					userInfo.setUiNum(userInforMessage.getIdserial());
					
					if(userInfoService.getByUINUm(userInforMessage.getIdserial())==null) {
						userInfoService.save(userInfo);
					}
					
					// 保存人员卡
					userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
				
					if(userInforMessage.getCardid()!=null&&!"".equals(userInforMessage.getCardid())) {
						devUserCard = new DevUserCard();
						devUserCard.setBm(orgInfo.getOiCode());
						//devUserCard.setCardNum(userInforMessage.getCardno());
						devUserCard.setCardNum(userInforMessage.getCardid().trim());
						devUserCard.setUserId(userInfo.getUiId().intValue());
						devUserCard.setFlag("1");
						try {
							devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard);
						} catch (Exception e) {
						}
					}
					// 宿管接口 zhusu =1 发卡
					if(zhusu==1) {
						Map<String, Object> cmap = new HashMap<String, Object>();
						cmap.put("stuNo", userInforMessage.getIdserial());
						List<ViewXsZhusu> viewXsZhusuList = viewXsZhusuDao.query(conditionMap);
						if(viewXsZhusuList!=null&&viewXsZhusuList.size()>0) {
							for(ViewXsZhusu viewXsZhusu : viewXsZhusuList) {
								// 根据宿舍名称查找设备信息
								cmap.put("terminalName", viewXsZhusu.getFjmc());
								Terminalinfo tInfo = terminalinfoMapper.getByName(cmap);
								if(tInfo!=null) {
									// 发卡
									Devnamelistinfo devnamelistinfo = new Devnamelistinfo(); 
									String devModel = tInfo.getDevModel();
									String devType = tInfo.getDevType().toString();
									devnamelistinfo.setTerminalId(tInfo.getTemplateId());
									devnamelistinfo.setEditTime(new Date());
									devnamelistinfo.setSyncState(0);
									devnamelistinfo.setCardNo(userInforMessage.getCardid());
									// 日期
									/*
									String rqStr = userInforMessage.getGrade();
									if(rqStr==null||"".equals(rqStr)) {
										rqStr = 
									}*/
									String rqStr = DateUtil.getDateAddYear(4);
									
									devnamelistinfo.setContent(DevcmdlistAction.getKhh(userInforMessage.getCardid(), devType, devModel, DateUtil.getCurrentDATEStart(), rqStr, "1"));
									devnamelistinfo.setUpdateType(1);
									// 判断是否存在，存在的话更新
									Devnamelistinfo devnamelistinfo1 = devnamelistinfoService.getByTerminalIDCardNo(tInfo.getTemplateId().toString(), devnamelistinfo.getCardNo());
									

									String maxId = "";
									if(devnamelistinfo1!=null){
										if(devnamelistinfo1.getSyncState()==0) {
											devnamelistinfo.setUpdateType(1);
										}else {
											devnamelistinfo.setUpdateType(2);
										}
										devnamelistinfo.setNameListId(devnamelistinfo1.getNameListId());
										devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
										maxId = devnamelistinfo1.getNameListId().toString();
									}else{
										// 不存在就插入
										// 先删除再插入
										devnamelistinfoService.deleteByTerminalIDCardNo(tInfo.getTemplateId().toString(), devnamelistinfo.getCardNo());
										maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
									
									}
									
									
									devnamelistinfo.setNameListId(Integer.parseInt(maxId));
									// 插入日志
									cmdlogService.insertLog(maxId, "发卡");
									
									// 日志
									String userName = "宿管接口同步";
									String ip = CommonUtil.getRemoteHost(request);
									String context = "卡号:"+userInforMessage.getCardid()+"发卡,有效期至:"+rqStr;
									DevLog devLog = new DevLog();
									devLog.setContext(context);
									devLog.setUser(userName);
									devLog.setIp(ip);
									devLog.setDate(new Date());
									devLogService.saveOrUpdateDevInfo(devLog);
									
								}
							}	
						}else {
							conditionMap.put("remark", "未找到设备信息，请手工发卡");
						}
						
						cmap = null;
					}
					

					
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "1");
					userInforMessageDao.updateDealFlag(conditionMap);
					
				
				}catch(Exception err) {
					System.out.println("->err");
					err.printStackTrace();
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "2");
					conditionMap.put("remark", err.getMessage());
					userInforMessageDao.updateDealFlag(conditionMap);
				}
			
			}else if("1".equals(userInforMessage.getMessageType())) {conditionMap = new HashMap<String, Object>();
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
					if(userInfo==null) {
						//throw new Exception("系统不存在该用户信息");
						conditionMap.put("remark", "系统不存在该用户信息");
					}else {
						List<DevUserCard>  devUserCardList = devUserCardService.queryDevUserCardsByUser(""+userInfo.getUiId());
						for(DevUserCard devUserCard1 : devUserCardList) {
							vo = new ConditionVO();
							vo.setEntityIds(devUserCard1.getSn().toString());
							devUserCardService.deleteDevUserCardById(vo);
						}
						
						// 删除用户
						vo = new ConditionVO();
						vo.setEntityId(userInfo.getUiId().toString());
						userInfoService.deleteUserInfoById(vo);
					}
					
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "1");
					userInforMessageDao.updateDealFlag(conditionMap);
				}catch(Exception err) {
					err.printStackTrace();
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "2");
					conditionMap.put("remark", err.getMessage());
					userInforMessageDao.updateDealFlag(conditionMap);
				}
				
			}else if("2".equals(userInforMessage.getMessageType())) {conditionMap = new HashMap<String, Object>();
				try {
					userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
					if(userInfo==null) {
						//throw new Exception("系统不存在该用户信息");
						conditionMap.put("remark", "系统不存在该用户信息");
						
						userInfo = new UserInfo();
						userInfo.setUiType(0L);
						userInfo.setUiName(userInforMessage.getUsername());
						userInfo.setUiSex(Long.parseLong(userInforMessage.getSex()));
						userInfo.setUiNickName(userInforMessage.getIdserial());
						userInfo.setUiImg("0");
						userInfo.setUiNum(userInforMessage.getIdserial());
	
						orgInfo = orgInfoService.getByName(userInforMessage.getDeptstr());
						if(orgInfo==null) {
							userInfo.setUiOrgCode("00000001");
							conditionMap.put("remark", "人员部门信息不存在");
						}else {
							userInfo.setUiOrgCode(orgInfo.getOiCode());
						}
						
						userInfoService.updateUserInfo(userInfo);
						
					}else {
					
						userInfo.setUiType(0L);
						userInfo.setUiName(userInforMessage.getUsername());
						userInfo.setUiSex(Long.parseLong(userInforMessage.getSex()));
						userInfo.setUiNickName(userInforMessage.getIdserial());
						userInfo.setUiImg("0");
						userInfo.setUiNum(userInforMessage.getIdserial());
	
						orgInfo = orgInfoService.getByName(userInforMessage.getDeptstr());
						if(orgInfo==null) {
							userInfo.setUiOrgCode("00000001");
							conditionMap.put("remark", "人员部门信息不存在");
						}else {
							userInfo.setUiOrgCode(orgInfo.getOiCode());
						}
						
						userInfoService.updateUserInfo(userInfo);
					}
					
					
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "1");
					userInforMessageDao.updateDealFlag(conditionMap);
					
				}catch(Exception err) {
					err.printStackTrace();
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "2");
					conditionMap.put("remark", err.getMessage());
					userInforMessageDao.updateDealFlag(conditionMap);
				}
				
			}else if("3".equals(userInforMessage.getMessageType())) {conditionMap = new HashMap<String, Object>();
				try {
					userInfo = userInfoService.getByNickName(userInforMessage.getIdserial());
					if(userInfo==null) {
						throw new Exception("系统不存在该用户信息");
					}
					// 判断旧卡是否一致
					DevUserCard devUserCard1 = null;
					try {
						devUserCard1 = devUserCardService.queryDevUserCardsByCondition(userInforMessage.getOldcardid().trim()).get(0);
					} catch (Exception e1) {
						//throw new Exception("该用户卡号信息不存在");
					}
					
					if(devUserCard1==null){
						devUserCard1 = new DevUserCard();
						devUserCard1.setBm(userInfo.getUiOrgCode());
						//devUserCard.setCardNum(userInforMessage.getCardno());
						devUserCard1.setCardNum(userInforMessage.getCardid().trim());
						devUserCard1.setUserId(userInfo.getUiId().intValue());
						devUserCard1.setFlag("1"); // 1:正常，0：挂失
						try {
							devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard1);
						} catch (Exception e) {
						}
						conditionMap.put("remark", "未找到旧卡信息，请手工下发新卡");
					}else{
						if(devUserCard1.getUserId().intValue()!=userInfo.getUiId().intValue()) {
							throw new Exception("该用户旧卡信息不一致");
						}
						
						// 新卡号
						//String kh = userInforMessage.getCardno();
						String kh = userInforMessage.getCardid().trim();
						//String khStr = DevcmdlistAction.getKhh(kh);
						// 根据旧卡号获取之前下达信息
						List<Devnamelistinfo> list = devnamelistinfoService.query(userInforMessage.getOldcardid().trim());
						// 根据挂失日志表找数据
						if(list==null || list.size()==0) {
							list = devnamelistinfoService.queryLog(userInforMessage.getOldcardid().trim());
						}
						
						// 存在的信息
						if(list!=null&list.size()>0) {
							for(Devnamelistinfo devnamelistinfo : list){
								// 新发删除指令
								devnamelistinfo.setSyncState(0);
								devnamelistinfo.setUpdateType(3);
								devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
								
								
								Terminalinfo terminalinfo =terminalinfoService.getTerminalinfoById(devnamelistinfo.getTerminalId().toString());
								String devModel = terminalinfo.getDevModel();
								String devType = terminalinfo.getDevType().toString();
								
								String content = devnamelistinfo.getContent();
								//content = content.substring(khStr.length());
								devnamelistinfo.setContent(DevcmdlistAction.huank(content, devnamelistinfo.getCardNo(), kh, devType, devModel));
								devnamelistinfo.setUpdateType(1);
								devnamelistinfo.setSyncState(0);
								devnamelistinfo.setEditTime(new Date());
								
								// 指令表需要重新下达
								devnamelistinfo.setCardNo(kh);
								// 先删除再插入
								//devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId().toString(), devnamelistinfo.getCardNo());
								//String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo); // 插入新卡

								
								/*
								Devnamelistinfo devnamelistinfo1 = devnamelistinfoService.getByTerminalIDCardNo(devnamelistinfo.getTerminalId().toString(), devnamelistinfo.getCardNo());
								String maxId = "";
								if(devnamelistinfo1!=null){
									if(devnamelistinfo1.getSyncState()==0) {
										devnamelistinfo.setUpdateType(1);
									}else {
										devnamelistinfo.setUpdateType(2);
									}
									devnamelistinfo.setNameListId(devnamelistinfo1.getNameListId());
									devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
									maxId = devnamelistinfo.getNameListId().toString();
								}else{
									// 不存在就插入
									// 先删除再插入 可以删除其他人持卡
									//devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId().toString(), devnamelistinfo.getCardNo());
									maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
								}
								*/
								
								// 如果新卡存在，先将新发的卡作废，更新新的信息
								Devnamelistinfo devnamelistinfo1 = devnamelistinfoService.getByTerminalIDCardNo(devnamelistinfo.getTerminalId().toString(), devnamelistinfo.getCardNo());
								if(devnamelistinfo1!=null){
									devnamelistinfo1.setUpdateType(3);
									devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo1);
								}
								String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo); // 插入新卡
		
								// 插入日志
								//String maxId = devnamelistinfoService.getMaxVersion("");
								cmdlogService.insertLog(maxId, "换卡");
								
								// 日志
								if(request==null) {
									String userName = "同步";
									String ip = "";
									String context = userInfo.getUiName()+"("+userInforMessage.getOldcardid()+")  换卡:"+devnamelistinfo.getCardNo()+"->"+kh;
									DevLog devLog = new DevLog();
									devLog.setContext(context);
									devLog.setUser(userName);
									devLog.setIp(ip);
									devLog.setDate(new Date());
									devLogService.saveOrUpdateDevInfo(devLog);
								}else {
									String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
									String ip = CommonUtil.getRemoteHost(request);
									String context = userInfo.getUiName()+"("+userInforMessage.getOldcardid()+")  换卡:"+devnamelistinfo.getCardNo()+"->"+kh;
									DevLog devLog = new DevLog();
									devLog.setContext(context);
									devLog.setUser(userName);
									devLog.setIp(ip);
									devLog.setDate(new Date());
									devLogService.saveOrUpdateDevInfo(devLog);	
								}
							}
						}
						// 已经删除的 到日志表中找到重新发卡
						else {
							conditionMap.put("remark", "未找到该卡关联的设备");
							//throw new Exception("未找到旧卡的授权记录");
						}
						
						// 根据旧卡编号查找人员卡记录
						
						try {
							//
							
						///	devUserCard1.setCardNum(kh);
						//	devUserCard1.setFlag("1"); // 把旧卡改成新卡的时候，要注意旧卡可能是挂失状态，更换成新卡后状态要变成正常。
						//	devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard1);
							
							
							// 判断新卡是否存在
							vo = new ConditionVO();
							vo.setCode(userInforMessage.getCardid().trim());
							List<DevUserCard> duclist = devUserCardService.getByCardNum(vo);
							DevUserCard duc = null;
							if(duclist!=null&&duclist.size()>0){
								duc = duclist.get(0);
							}
							if(duc!=null){
								duc.setFlag("1"); // 把旧卡改成新卡的时候，要注意旧卡可能是挂失状态，更换成新卡后状态要变成正常。
								//duc.setCardNum(kh); // 更新新卡号
								duc.setUserId(devUserCard1.getUserId());
								devUserCardService.saveOrUpdateDevUserCardInfo(duc);

								//devUserCard1.setFlag("0"); // 旧卡要挂失
								//devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard1);
								
							}else{
								devUserCard1.setCardNum(kh);
								devUserCard1.setFlag("1"); // 把旧卡改成新卡的时候，要注意旧卡可能是挂失状态，更换成新卡后状态要变成正常。
								devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard1);
							}
							
							
						} catch (Exception e) {
							//Log.log(1, e.getMessage());
							throw new Exception("人员卡err:"+e.getMessage());
						}
						
					
					}
					
					
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "1");
					userInforMessageDao.updateDealFlag(conditionMap);
					
				}catch(Exception err) {
					err.printStackTrace();
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "2");
					conditionMap.put("remark", err.getMessage());
					userInforMessageDao.updateDealFlag(conditionMap);
				}
				
			}else if("5".equals(userInforMessage.getMessageType())) {conditionMap = new HashMap<String, Object>();
				try {
					userInfo = userInfoService.getByNickName(userInforMessage.getIdserial().trim());
					if(userInfo==null) {
						throw new Exception("系统不存在该用户信息");
					}
					// 判断卡是否是挂失状态
					DevUserCard devUserCard1 = devUserCardService.queryDevUserCardsByCondition(userInforMessage.getCardid().trim()).get(0);
					if(devUserCard1.getUserId().intValue()!=userInfo.getUiId().intValue()) {
						throw new Exception("该用户卡信息不一致");
					}
					
					if(!"0".equals(devUserCard1.getFlag())) {
						List<Devnamelistinfo> list = devnamelistinfoService.queryByCardNo(userInforMessage.getCardid().trim()); 
						if(list!=null) {
							for(Devnamelistinfo devnamelistinfo : list){  
								devnamelistinfo.setSyncState(0);
								devnamelistinfo.setUpdateType(3);
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
					err.printStackTrace();
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "2");
					conditionMap.put("remark", err.getMessage());
					userInforMessageDao.updateDealFlag(conditionMap);
				}
				
			}else if("6".equals(userInforMessage.getMessageType())) {conditionMap = new HashMap<String, Object>();
				try {
					userInfo = userInfoService.getByNickName(userInforMessage.getIdserial().trim());
					if(userInfo==null) {
						throw new Exception("系统不存在该用户信息");
					}
					
					// 判断卡是否是挂失状态
					DevUserCard devUserCard1 = devUserCardService.queryDevUserCardsByCondition(userInforMessage.getCardid().trim()).get(0);
					if(devUserCard1.getUserId().intValue()!=userInfo.getUiId().intValue()) {
						throw new Exception("该用户卡信息不一致");
					}
					
					if(!"1".equals(devUserCard1.getFlag())) {
						
						List<Devnamelistinfo> list = devnamelistinfoService.queryLog(devUserCard1.getCardNum());
						
						if(list!=null) {
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
									String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
									// 插入日志
									//String maxId = devnamelistinfoService.getMaxVersion("");
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
						}else {
							throw new Exception("未找到该卡关联的设备");
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
					err.printStackTrace();
					conditionMap.put("idnumber", userInforMessage.getIdnumber());
					conditionMap.put("dealFlag", "2");
					conditionMap.put("remark", err.getMessage());
					userInforMessageDao.updateDealFlag(conditionMap);
				}
				
			}
			
		}
		
		/*
		//1 档案删除
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "1");
		 
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			
				
			
		}
		
		// 2  档案 修改
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "2");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			
		}
		
		
		//3  换卡 
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "3");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			
		}
		
		//5 、挂失 
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "5");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			
		}
		
		
		//6、解挂
		conditionMap.put("dealFlag", "0");
		conditionMap.put("messageType", "6");
		
		userInfoList = userInforMessageDao.query(conditionMap);
		for(UserInforMessage userInforMessage : userInfoList) {
			
		}
		*/
		}
	}
	
	public Page<UserInforMessage> queryUserInforMessagesForPage(ConditionVO vo,
			Page<UserInforMessage> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		if(vo.getCode1()!=null&&!"".equals(vo.getCode1())){
			conditionMap.put("username", URLDecoder.decode(vo.getCode1(),"utf-8"));
		}
		if(vo.getCode2()!=null&&!"".equals(vo.getCode2())){
			conditionMap.put("idserial", URLDecoder.decode(vo.getCode2(),"utf-8"));
		}
		if(vo.getCode3()!=null&&!"".equals(vo.getCode3())){
			conditionMap.put("cardid", URLDecoder.decode(vo.getCode3(),"utf-8"));
		}
		if(vo.getCode4()!=null&&!"".equals(vo.getCode4())){
			conditionMap.put("oldcardid", URLDecoder.decode(vo.getCode4(),"utf-8"));
		}
		
		return super.queryForPage(userInforMessageDao, conditionMap, page);
	}
}
