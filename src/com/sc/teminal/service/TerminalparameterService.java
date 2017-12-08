package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.TerminalparameterMapper;
import com.sc.teminal.pojo.Terminalparameter;
@Service
public class TerminalparameterService  extends BaseService<Terminalparameter> {

	@Autowired
	TerminalparameterMapper TerminalparameterDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteTerminalparameterById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				TerminalparameterDao.delete(conditionMap);
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
	public Terminalparameter getTerminalparameterById(ConditionVO vo) throws Exception {
		return TerminalparameterDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateTerminalparameterInfo(Terminalparameter entity) throws Exception {
		if (entity.getTemplateId() == null) {  
			TerminalparameterDao.insert(entity);
		} else {
			TerminalparameterDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Terminalparameter> queryTerminalparametersByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return TerminalparameterDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Terminalparameter> queryTerminalparametersForPage(ConditionVO vo,
			Page<Terminalparameter> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(TerminalparameterDao, conditionMap, page);
	}
}
