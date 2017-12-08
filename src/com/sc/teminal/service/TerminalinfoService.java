package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.TerminalinfoMapper;
import com.sc.teminal.pojo.Terminalinfo;
@Service
public class TerminalinfoService  extends BaseService<Terminalinfo> {

	@Autowired
	TerminalinfoMapper TerminalinfoDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteTerminalinfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				TerminalinfoDao.delete(conditionMap);
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
	public Terminalinfo getTerminalinfoById(String id) throws Exception {
		return TerminalinfoDao.getById(Long.parseLong(id));
	}
	
	public Terminalinfo getTerminalinfoById(ConditionVO vo) throws Exception {
		return TerminalinfoDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateTerminalinfoInfo(Terminalinfo entity) throws Exception {
		if (entity.getTerminalId() == null) {  
			TerminalinfoDao.insert(entity);
		} else {
			TerminalinfoDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Terminalinfo> queryTerminalinfosByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return TerminalinfoDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Terminalinfo> queryTerminalinfosForPage(ConditionVO vo,
			Page<Terminalinfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalName", vo.getNameFilter());
		conditionMap.put("controllerName", vo.getNameFilter1());
		//conditionMap.put("terminalId", vo.getCode1());
		//conditionMap.put("controllerId", vo.getCode2());
		//conditionMap.put("remark", vo.getCode3());
		return super.queryForPage(TerminalinfoDao, conditionMap, page);
	}
	
	
	public Page<Terminalinfo> queryTerminalinfosForPage1(ConditionVO vo,
			Page<Terminalinfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalName", vo.getCode());
		conditionMap.put("terminalId", vo.getCode1());
		conditionMap.put("controllerId", vo.getCode2());
		conditionMap.put("remark", vo.getCode3());
		return super.queryForPage(TerminalinfoDao, conditionMap, page);
	}
}
