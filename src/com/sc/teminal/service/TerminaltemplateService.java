package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.TerminaltemplateMapper;
import com.sc.teminal.pojo.Terminaltemplate;
@Service
public class TerminaltemplateService  extends BaseService<Terminaltemplate> {

	@Autowired
	TerminaltemplateMapper TerminaltemplateDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteTerminaltemplateById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				TerminaltemplateDao.delete(conditionMap);
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
	public Terminaltemplate getTerminaltemplateById(ConditionVO vo) throws Exception {
		return TerminaltemplateDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateTerminaltemplateInfo(Terminaltemplate entity) throws Exception {
		if (entity.getTemplateId() == null) {  
			TerminaltemplateDao.insert(entity);
		} else {
			TerminaltemplateDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Terminaltemplate> queryTerminaltemplatesByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return TerminaltemplateDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Terminaltemplate> queryTerminaltemplatesForPage(ConditionVO vo,
			Page<Terminaltemplate> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(TerminaltemplateDao, conditionMap, page);
	}
}
