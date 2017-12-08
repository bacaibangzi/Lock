package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.TerminalexceptionMapper;
import com.sc.teminal.pojo.Terminalexception;
@Service
public class TerminalexceptionService  extends BaseService<Terminalexception> {

	@Autowired
	TerminalexceptionMapper TerminalexceptionDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteTerminalexceptionById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				TerminalexceptionDao.delete(conditionMap);
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
	public Terminalexception getTerminalexceptionById(ConditionVO vo) throws Exception {
		return TerminalexceptionDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateTerminalexceptionInfo(Terminalexception entity) throws Exception {
		if (entity.getExceptionId() == null) {  
			TerminalexceptionDao.insert(entity);
		} else {
			TerminalexceptionDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Terminalexception> queryTerminalexceptionsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return TerminalexceptionDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Terminalexception> queryTerminalexceptionsForPage(ConditionVO vo,
			Page<Terminalexception> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(TerminalexceptionDao, conditionMap, page);
	}
}
