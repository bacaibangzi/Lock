package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.ControllerinfoMapper;
import com.sc.teminal.pojo.Controllerinfo;
@Service
public class ControllerinfoService  extends BaseService<Controllerinfo> {

	@Autowired
	ControllerinfoMapper ControllerinfoDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteControllerinfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				ControllerinfoDao.delete(conditionMap);
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
	public Controllerinfo getControllerinfoById(ConditionVO vo) throws Exception {
		return ControllerinfoDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateControllerinfoInfo(Controllerinfo entity) throws Exception {
		if (entity.getControllerId() == null) {  
			ControllerinfoDao.insert(entity);
		} else {
			ControllerinfoDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Controllerinfo> queryControllerinfosByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return ControllerinfoDao.query(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Controllerinfo> queryControllerinfosForPage(ConditionVO vo,
			Page<Controllerinfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("controllerName", vo.getNameFilter());
		return super.queryForPage(ControllerinfoDao, conditionMap, page);
	}
}
