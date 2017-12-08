package com.sc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sc.dbutil.DBConn;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.utils.ContextUtil;
import com.sc.system.pojo.DevUserCard;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.DevUserCardService;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.UserInfoService;
import com.sc.teminal.pojo.DevLog;
import com.sc.teminal.pojo.Devnamelistinfo;
import com.sc.teminal.service.CmdlogService;
import com.sc.teminal.service.DevLogService;
import com.sc.teminal.service.DevnamelistinfoService;

/**
 * 同步第三方
 * 
 * @author Admin
 *
 */
public class SynDataQuartz2 extends Thread implements ServletContextListener{
	// 
	private Thread sendThread; 
	//
	private DBConn mDBConn;
	//
	public SynDataQuartz2(){
		
	}

	/**
	 * contextDestroyed
	 */
	public void contextDestroyed(ServletContextEvent e) {
		if (sendThread != null && sendThread.isInterrupted()) {  
			sendThread.interrupt();  
        } 
	}

	/**
	 * contextInitialized
	 */
	public void contextInitialized(ServletContextEvent e) {
		sendThread = new Thread(this);
		mDBConn = new DBConn();
		//sendThread.start();
	}
	
	OrgInfoService orgInfoService = null; 
	DevUserCardService devUserCardService = null;
	UserInfoService userInfoService = null;
	DevnamelistinfoService devnamelistinfoService = null;
	CmdlogService cmdlogService = null;
	DevLogService devLogService = null;
	
	public void run() {
		try{
			Connection conn = null;
			Statement statement = null;
			ResultSet resultSet = null;
			String sql = "";
			List<Map<String,Object>> list = null;
			orgInfoService = (OrgInfoService) ContextUtil.getContext().getBean("orgInfoService");
			devUserCardService = (DevUserCardService) ContextUtil.getContext().getBean("devUserCardService");
			userInfoService = (UserInfoService) ContextUtil.getContext().getBean("userInfoService");
			devnamelistinfoService = (DevnamelistinfoService) ContextUtil.getContext().getBean("devnamelistinfoService");
			cmdlogService = (CmdlogService) ContextUtil.getContext().getBean("cmdlogService");
			devLogService = (DevLogService) ContextUtil.getContext().getBean("devLogService");
			
			//orgInfoMapper = (OrgInfoMapper) ContextUtil.getContext().getBean("orgInfoService");
			while (true) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>定时同步数据<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
				try{
					conn = mDBConn.getConntion();
					statement = conn.createStatement();
					// 同步部门
					sql = " select  ID, DEPTNAME,PARENTID, DEPTCODE, PLEVEL, STATUS,INPUTUSERID,INPUTDATE,DEPTSTR  from  SYS_DEPARTMENT where PARENTID = -1 ";
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					//System.out.println( "====================> list.size :"+ list.size());
					if(list!=null&&list.size()>0){
						synBum(statement,resultSet,list,"0000");
					}
				
					// 同步新增用户
					sql = " select  IDNumber, MessageType, CARDNO, USERNAME, DEPTSTR ,SEX  from  User_Infor_Message where MessageType = 0 ";
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					//System.out.println( "====================> list.size :"+ list.size());
					

					String IDNumber = null,MessageType=null,CARDNO=null,USERNAME=null,DEPTSTR=null,SEX=null;
					UserInfo userInfo = null;
					OrgInfo orgInfo = null;
					DevUserCard devUserCard = null;
					for(Map<String,Object> map : list){
						//IDNumber 	= map.get("IDNumber").toString();
						MessageType = map.get("MessageType").toString();
						CARDNO 		= map.get("CARDNO").toString();
						USERNAME 	= map.get("USERNAME").toString();
						DEPTSTR 	= map.get("DEPTSTR").toString();
						SEX 		= map.get("SEX").toString();
						
						userInfo = new UserInfo();
						
						orgInfo = orgInfoService.getByName(DEPTSTR);
						
						if(orgInfo!=null){
							userInfo.setUiOrgCode(orgInfo.getOiCode());
							userInfo.setUiType(0L);
							userInfo.setUiName(USERNAME);
							userInfo.setUiSex(Long.parseLong(SEX));
							userInfo.setUiNickName(USERNAME);
							userInfo.setUiImg("0");
							
							// 保存用户
							
							// 保存用户卡
							if(userInfoService.getByNickName(USERNAME)==null){

								userInfoService.save(userInfo);
								
								userInfo = userInfoService.getByNickName(USERNAME);
							
								devUserCard = new DevUserCard();
								devUserCard.setBm(orgInfo.getOiCode());
								devUserCard.setCardNum(CARDNO);
								devUserCard.setUserId(userInfo.getUiId().intValue());
								devUserCard.setFlag("1");
								devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard);
							
							}
							
						}
					}
					
					// 同步修改用户
					
					
					// 删除
					sql = " select  IDNumber, MessageType, CARDNO, USERNAME, DEPTSTR ,SEX  from  User_Infor_Message where MessageType = 1 ";
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					//System.out.println( "====================> list.size :"+ list.size());
					for(Map<String,Object> map : list){
						USERNAME 	= map.get("USERNAME").toString();
						userInfo = userInfoService.getByNickName(USERNAME);
						userInfoService.deleteUserInfoById(userInfo.getUiId());
					}
					
					// 1 换卡
					sql = " select  IDNumber, MessageType, CARDNO, USERNAME, DEPTSTR ,SEX ,OLDCARDNO  from  User_Infor_Message where MessageType = 3 ";
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					//System.out.println( "====================> list.size :"+ list.size());
					for(Map<String,Object> map : list){
						CARDNO 		= map.get("CARDNO").toString();
						IDNumber 	= map.get("IDNumber").toString();
						//String OLDCARDNO  = map.get("OLDCARDNO").toString();
						// 判断是否执行过
						List<DevLog> devLogList = devLogService.queryDevsByEx1(IDNumber);
						if(devLogList==null||devLogList.size()==0){
							continue;
						}
						
						List<Devnamelistinfo> devnamelistinfoList = devnamelistinfoService.query(devUserCard.getCardNum());
						//String kh = vo.getCode();
						String kh = CARDNO;
						String khStr = getKhh(kh);
						for(Devnamelistinfo devnamelistinfo : devnamelistinfoList){
							String content = devnamelistinfo.getContent();
							content = content.substring(kh.length());
							devnamelistinfo.setContent(khStr+content);
							devnamelistinfo.setUpdateType(1);
							devnamelistinfo.setEditTime(new Date());
							
							// 指令表需要重新下达
							devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId().toString(), devnamelistinfo.getCardNo());
							devnamelistinfo.setCardNo(kh);
							devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);

							// 插入日志
							cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "换卡");
							
							// 日志
							String userName = "同步";
							String ip = "127.0.0.1";
							String context = " 换卡卡号:"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLogService.saveOrUpdateDevInfo(devLog);				
						}
						// 对应表需要修改
						devUserCard.setCardNum(kh);
						devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard);
						
					}
					

					
					// 2 挂失
					sql = " select  IDNumber, MessageType, CARDNO, USERNAME, DEPTSTR ,SEX  from  User_Infor_Message where MessageType = 5 ";
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					//System.out.println( "====================> list.size :"+ list.size());
					for(Map<String,Object> map : list){
						CARDNO 		= map.get("CARDNO").toString();
						IDNumber 	= map.get("IDNumber").toString();
						
						// 判断是否执行过
						List<DevLog> devLogList = devLogService.queryDevsByEx1(IDNumber);
						if(devLogList==null||devLogList.size()==0){
							continue;
						}
						List<Devnamelistinfo> devnamelistinfoList = devnamelistinfoService.queryByCardNo(devUserCard.getCardNum());
						// 先记下来
						for(Devnamelistinfo devnamelistinfo : devnamelistinfoList){
							// 再回收
							devnamelistinfo.setUpdateType(3);
							devnamelistinfo.setEditTime(new Date());
							devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
							

							try {
								// 插入日志
								cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "挂失");
							} catch (Exception e) {
							}
							
							// 日志
							String userName = "同步";
							String ip = "127.0.0.1";
							String context = " 挂失卡号:"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLog.setEx1(IDNumber);
							devLogService.saveOrUpdateDevInfo(devLog);		 
							
						}

						// 修改用户卡状态
						devUserCard.setFlag("0");
						devUserCardService.updateFlag("0", devUserCard.getUserId()+"", devUserCard.getCardNum());
						
						
					}
					

					
					// 3、解挂
					sql = " select  IDNumber, MessageType, CARDNO, USERNAME, DEPTSTR ,SEX  from  User_Infor_Message where MessageType = 6 ";
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					//System.out.println( "====================> list.size :"+ list.size());
					for(Map<String,Object> map : list){
						CARDNO 		= map.get("CARDNO").toString();
						IDNumber 	= map.get("IDNumber").toString();
						
						// 判断是否执行过
						List<DevLog> devLogList = devLogService.queryDevsByEx1(IDNumber);
						if(devLogList==null||devLogList.size()==0){
							continue;
						}
						
						List<Devnamelistinfo> devnamelistinfoList = devnamelistinfoService.queryLog(devUserCard.getCardNum());
						// 重新下发
						for(Devnamelistinfo devnamelistinfo : devnamelistinfoList){
							String maxId = devnamelistinfoService.getMaxVersion("");
							devnamelistinfo.setNameListId(Integer.parseInt(maxId));
							devnamelistinfo.setUpdateType(1);
							devnamelistinfo.setEditTime(new Date());
							devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
							

							// 插入日志
							cmdlogService.insertLog(maxId+"", "解挂");
							
							// 日志
							String userName = "同步";
							String ip = "127.0.0.1";
							String context = " 解挂卡号:"+devnamelistinfo.getCardNo();
							DevLog devLog = new DevLog();
							devLog.setContext(context);
							devLog.setUser(userName);
							devLog.setIp(ip);
							devLog.setDate(new Date());
							devLogService.saveOrUpdateDevInfo(devLog);				
										
							
						}
						// 删除日志
						devnamelistinfoService.deleteLogByCardNo(devUserCard.getCardNum());
						

						// 修改用户卡状态
						devUserCard.setFlag("1");
						devUserCardService.updateFlag("1", devUserCard.getUserId()+"", devUserCard.getCardNum());
						
					}
					
				}catch(Exception er){
					er.printStackTrace();
				}finally{
					mDBConn.closeConn();
					sql = null;
					list =null;
				}
				Thread.sleep(DBConn.refresh * 1000);
			}
			
			
		}catch(Exception err){
			System.out.println("******************************* err:"+err.getMessage());
			err.printStackTrace();
		} 
	}
	
	// 部门
	public void synBum(Statement statement,ResultSet resultSet,List<Map<String,Object>> list,String code) throws Exception{
		for(Map<String,Object> map : list){
			String id  =  map.get("ID").toString();
			String dEPTNAME =  map.get("DEPTNAME").toString();
			String orgCode = "";
			
			System.out.println("id:"+id +", dEPTNAME:"+dEPTNAME +", code:"+code);
			

			// 根据名称查找是否存在
			OrgInfo orgInfo = orgInfoService.getByName(id);
			if(orgInfo==null){
				
				OrgInfo mOrgInfo = new OrgInfo();
				mOrgInfo.setOiCode(orgCode);
				mOrgInfo.setOiName(dEPTNAME);
				mOrgInfo.setOiType(id);
				
				orgCode = orgInfoService.saveOrUpdateOrgInfoInfo(mOrgInfo,"",code);
				
			}else{
				orgCode = orgInfo.getOiCode();
				
				orgInfo.setOiName(dEPTNAME);
				orgInfo.setOiType(id);
				orgInfoService.update(orgInfo);
			}
			
			// 判断子查询
			String sql = " select  ID, DEPTNAME,PARENTID, DEPTCODE, PLEVEL, STATUS,INPUTUSERID,INPUTDATE,DEPTSTR  from  SYS_DEPARTMENT where PARENTID ="+id;
			resultSet = statement.executeQuery(sql);
			list = mDBConn.getResultList(resultSet);
			if(list!=null&&list.size()>0){
				synBum(statement,resultSet,list,orgCode);
			}
		}
	}
	
	
	public static String getKhh (String str){

		Long int32 = new Long( str);
		System.out.println("->"+Long.toHexString(int32));
		String hex = Long.toHexString(int32);
		hex ="00000000"+hex;
		hex = hex.substring(hex.length()-8);
		String tkh = "";
		while(true){
			if(hex.length()>2){
				tkh = hex.substring(0,2)+tkh;
				hex = hex.substring(2,hex.length());
			}else if(hex.length()==2){
				tkh = hex.substring(0,2)+tkh;
				break;
			}else{
				tkh = "0"+hex.substring(0,1)+tkh;
				break;
			}
		}
		System.out.println("->"+tkh);
		
		return tkh;
	}
}
