package com.sc.zhouse.dao;

import java.util.List;
import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.zhouse.pojo.HouseInfo;

public interface HouseInfoMapper extends BaseDao<HouseInfo>{

	
	/**
	 * 审核
	 * 
	 * @param conditionMap
	 * @throws Exception
	 */
	public void sh(Map<String, Object> conditionMap)
			throws Exception;
	
	
	/**
	 * 根据经纬度获取房屋信息
	 * 
	 * @param conditionMap
	 * @return
	 * @throws Exception
	 */
	public List<HouseInfo> queryByLocation(Map<String, Object> conditionMap)
			throws Exception;
}
