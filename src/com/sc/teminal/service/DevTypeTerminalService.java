package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevDoorTeminalMapper;
import com.sc.teminal.dao.DevTypeTerminalMapper;
import com.sc.teminal.dao.TerminalinfoMapper;
import com.sc.teminal.pojo.DevDoorTeminal;
import com.sc.teminal.pojo.DevTypeTerminal;
import com.sc.teminal.pojo.Terminalinfo;

@Service
public class DevTypeTerminalService  extends BaseService<DevTypeTerminal>{

	@Autowired
	DevTypeTerminalMapper DevTypeTerminalDao;
	@Autowired
	TerminalinfoMapper terminalinfoMapper;
	@Autowired
	DevDoorTeminalMapper devDoorTeminalMapper;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevTypeTerminalById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("typeId", id);
				DevTypeTerminalDao.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到短信日志信息
	 * 
	 * @param vo
	 * @return
	 */
	public DevTypeTerminal getDevTypeTerminalById(ConditionVO vo) throws Exception {
		return DevTypeTerminalDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevTypeTerminalInfo(DevTypeTerminal entity) throws Exception {
		if (entity.getSn() == null) {  
			DevTypeTerminalDao.insert(entity);
		} else {
			DevTypeTerminalDao.update(entity);
		}
	}
	
	public void save(String ids,int typeId,String typeName,int years) throws Exception{
		// 先删除
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("typeId", typeId);
		DevTypeTerminalDao.delete(conditionMap);
		// 
		String idss[] = ids.split(",");
		for(String id : idss){
			DevTypeTerminal devTypeTerminal = new DevTypeTerminal();
			devTypeTerminal.setTypeId(typeId);
			devTypeTerminal.setTypeName(typeName);
			devTypeTerminal.setYears(years);
			
			Terminalinfo terminalinfo = devDoorTeminalMapper.getById(Long.parseLong(id));
			
			terminalinfo = terminalinfoMapper.getById(terminalinfo.getTerminalId().longValue());
			
			devTypeTerminal.setTerminalId(terminalinfo.getTerminalId());
			devTypeTerminal.setTerminalName(terminalinfo.getTerminalName());
			
			DevTypeTerminalDao.insert(devTypeTerminal);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<DevTypeTerminal> queryDevTypeTerminalsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("typeId", vo.getCode());
		return DevTypeTerminalDao.query(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<DevTypeTerminal> queryDevTypeTerminalsForPage(ConditionVO vo,
			Page<DevTypeTerminal> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalName", vo.getNameFilter());
		conditionMap.put("syncstate", vo.getShFilter());
		
		return super.queryForPage(DevTypeTerminalDao, conditionMap, page);
	}
}
