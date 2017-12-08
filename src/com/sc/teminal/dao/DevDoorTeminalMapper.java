package com.sc.teminal.dao;

import java.util.List;
import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.teminal.pojo.Terminalinfo;

public interface DevDoorTeminalMapper extends BaseDao<Terminalinfo>{
	
	public Integer getTeminalIDById(String sn);
	

	public List<Terminalinfo> queryDl(Map<String, Object> conditionMap);
}
