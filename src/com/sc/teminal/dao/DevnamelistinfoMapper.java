package com.sc.teminal.dao;

import java.util.List;
import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.teminal.pojo.Devnamelistinfo;

public interface DevnamelistinfoMapper extends BaseDao<Devnamelistinfo>{

	public abstract void deleteByTerminalIDCardNo(Map<String, Object> conditionMap);
	
	public abstract Devnamelistinfo getByTerminalIDCardNo(Map<String, Object> conditionMap);
	
	public abstract void insertlog(Devnamelistinfo devnamelistinfo) ;
	
	public abstract void deleteLogByCardNo(Map<String, Object> conditionMap);
	
	public abstract List<Devnamelistinfo> queryLog(Map<String, Object> conditionMap);
}
