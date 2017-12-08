package com.sc.teminal.dao;

import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.teminal.pojo.Terminalinfo;

public interface TerminalinfoMapper extends BaseDao<Terminalinfo>{
	/**
	 *  getByName
	 * @param conditionMap
	 * @return
	 */
	public Terminalinfo getByName(Map<String, Object> conditionMap);
}
