package com.sc.system.dao;

import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.system.pojo.UserInfo;

/**
 * 系统用户Mapper
 * 
 * @author cuibin
 * 
 */
public interface UserInfoMapper  extends BaseDao<UserInfo>{

	/**
	 * insertSn
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void insertSn(UserInfo entity) throws Exception;
	
	/**
	 * 根据用户登录名称查找用户信息
	 * 
	 * @param uiLoginName
	 * @return
	 */
	 public abstract UserInfo getByLoginName(String uiLoginName);
	 
	 /**
	  * 审核
	  * @param uiSh
	  * @param uiId
	  */
	 public abstract void sh(Map<String, Object> conditionMap);
	 /**
	  * 修改密码
	  * @param userInfo
	  */
	 public abstract void updatepassword(UserInfo userInfo);

	 /**
	 * 根据用户名称查找用户信息
	 * 
	 * @param uiLoginName
	 * @return
	 */
	public abstract UserInfo getByUIName(String loginUserName);
	
	public abstract UserInfo getByUINUm(String uiNum);
	
	/**
	 * 修改
	 * @param userInfo
	 */
	public abstract void saveGly(UserInfo userInfo);
	
	public abstract UserInfo getByNickName(String uiNickName);
}
