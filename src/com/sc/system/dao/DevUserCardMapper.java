package com.sc.system.dao;

import java.util.List;
import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.system.pojo.DevUserCard;

public interface DevUserCardMapper extends BaseDao<DevUserCard>{

	
	List<DevUserCard> getByCardNum(Map<String, Object> conditionMap);
	
	
	void updateFlag(Map<String, Object> conditionMap);
	
	void updateCardNumFlag(Map<String, Object> conditionMap);
}
