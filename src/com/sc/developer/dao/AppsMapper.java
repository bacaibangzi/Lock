package com.sc.developer.dao;

import java.util.Map;

import com.sc.developer.pojo.Apps;
import com.sc.framework.base.dao.BaseDao;

public interface AppsMapper  extends BaseDao<Apps>{
	
	/**
	 * 审核
	 * 
	 * @param conditionMap
	 * @throws Exception
	 */
	public void sh(Map<String, Object> conditionMap)
			throws Exception;
}
