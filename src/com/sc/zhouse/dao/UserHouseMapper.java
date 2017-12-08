package com.sc.zhouse.dao;

import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.zhouse.pojo.UserHouse;

public interface UserHouseMapper extends BaseDao<UserHouse>{

	
	/**
	 * 审核
	 * 
	 * @param conditionMap
	 * @throws Exception
	 */
	public void sh(Map<String, Object> conditionMap)
			throws Exception;
	
	/**
	 * updateParam
	 * 
	 * @param conditionMap
	 * @throws Exception
	 */
	public void updateParam(Map<String, Object> conditionMap)
			throws Exception;
}
