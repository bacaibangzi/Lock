package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevLogMapper;
import com.sc.teminal.pojo.DevLog;

@Service
public class DevLogService   extends BaseService<DevLog> {

	@Autowired
	DevLogMapper devMapper;
	

	/**
	 * 删除菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevById(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				devMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到菜品原料信息信息
	 * 
	 * @param vo
	 * @return
	 */
	public DevLog getDevById(ConditionVO vo) throws Exception {
		return devMapper.getById(Long.parseLong(vo.getEntityId()));
	}
	
	/**
	 * 保存或新增菜品原料信息
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevInfo(DevLog entity) throws Exception {
		if (entity.getSn() == null) {
			devMapper.insert(entity);
		} else {
			devMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<DevLog> queryDevsByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return devMapper.query(conditionMap);
	}
	
	public List<DevLog> queryDevsByEx1(String ex1)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("ex1", ex1);
		return devMapper.query(conditionMap);
	}
	
	/**
	 * 根据条件查询相关菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<DevLog> queryDevsByKeys(String keys)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("keys", keys);
		return devMapper.query(conditionMap);
	}
	
	/**
	 * 根据条件查询相关菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<DevLog> queryRechargeableCardDevByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("orgCode", vo.getOrgCode());
		conditionMap.put("chAttribute", "充值卡");
		return devMapper.query(conditionMap);
	}
	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<DevLog> queryDevsForPage(ConditionVO vo,
			Page<DevLog> page) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("orgCode", vo.getOrgCode());
		return super.queryForPage(devMapper, conditionMap, page);
	}

	
	
}
