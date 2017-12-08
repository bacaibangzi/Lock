package com.sc.zhouse.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.zhouse.dao.VhuserHouseMapper;
import com.sc.zhouse.pojo.VhuserHouse;

@Service
public class VhuserHouseService extends BaseService<VhuserHouse>{
	@Autowired
	VhuserHouseMapper vhuserHouseMapper;
	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<VhuserHouse> queryVhuserHousesForPage(ConditionVO vo,
			Page<VhuserHouse> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId1", vo.getEntityId());
		conditionMap.put("type", vo.getFlag());
		return super.queryForPage(vhuserHouseMapper, conditionMap, page);
	}
	
	public Page<VhuserHouse> queryVhuserHousesForPage1(ConditionVO vo,
			Page<VhuserHouse> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId", vo.getEntityId());
		conditionMap.put("type", vo.getFlag());
		return super.queryForPage(vhuserHouseMapper, conditionMap, page);
	}
	
	
	public boolean deleteVhuserHousesById(String  id)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			conditionMap.put("sn", id);
			vhuserHouseMapper.delete(conditionMap);
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}
}
