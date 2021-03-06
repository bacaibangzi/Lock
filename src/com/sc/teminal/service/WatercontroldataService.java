package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.WatercontroldataMapper;
import com.sc.teminal.pojo.Watercontroldata;
@Service
public class WatercontroldataService  extends BaseService<Watercontroldata> {

	@Autowired
	WatercontroldataMapper WatercontroldataDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteWatercontroldataById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				WatercontroldataDao.delete(conditionMap);
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
	public Watercontroldata getWatercontroldataById(ConditionVO vo) throws Exception {
		return WatercontroldataDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateWatercontroldataInfo(Watercontroldata entity) throws Exception {
		if (entity.getId() == null) {  
			WatercontroldataDao.insert(entity);
		} else {
			WatercontroldataDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Watercontroldata> queryWatercontroldatasByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return WatercontroldataDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Watercontroldata> queryWatercontroldatasForPage(ConditionVO vo,
			Page<Watercontroldata> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(WatercontroldataDao, conditionMap, page);
	}
}
