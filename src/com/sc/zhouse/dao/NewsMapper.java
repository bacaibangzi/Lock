package com.sc.zhouse.dao;

import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.zhouse.pojo.News;

public interface NewsMapper extends BaseDao<News>{

	
	/**
	 * 审核
	 * 
	 * @param conditionMap
	 * @throws Exception
	 */
	public void sh(Map<String, Object> conditionMap)
			throws Exception;
}
