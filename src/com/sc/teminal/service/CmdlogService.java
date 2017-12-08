package com.sc.teminal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.teminal.dao.CmdlogMapper;
import com.sc.teminal.pojo.Cmdlog;
@Service
public class CmdlogService  extends BaseService<Cmdlog>{

	@Autowired
	CmdlogMapper cmdlogMapper;
	
	public void insertLog(String sn,String type) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("sn", sn);
		cmdlogMapper.delete(conditionMap);
		
		Cmdlog cmdlog = new Cmdlog();
		cmdlog.setSn(sn);
		cmdlog.setType(type);
		
		cmdlogMapper.insert(cmdlog);
	}
}
