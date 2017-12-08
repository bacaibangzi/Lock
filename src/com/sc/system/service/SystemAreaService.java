package com.sc.system.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.SystemAreaMapper;
import com.sc.system.pojo.AreaInfo;

/**
 * 系统区域service
 * 
 * @author cuibin
 * 
 */
@Service
public class SystemAreaService extends BaseService<AreaInfo> {

	@Autowired
	SystemAreaMapper systemAreaMapper;

	/**
	 * 删除区域
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteAreaInfoById(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("areaId", id);
				systemAreaMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到区域信息
	 * 
	 * @param vo
	 * @return
	 */
	public AreaInfo getAreaInfoById(ConditionVO vo) throws Exception {
		return systemAreaMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增区域
	 * 
	 * @param entity
	 */
	public void saveOrUpdateAreaInfoInfo(AreaInfo entity) throws Exception {
		if (entity.getAreaId() == null) {
			// 防止编码溢出
			if (entity.getAreaParentCode() == null
					|| entity.getAreaParentCode().intern() == "") {
				entity.setAreaParentCode("0");
			}
			systemAreaMapper.insert(entity);
		} else {
			systemAreaMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关区域
	 * 
	 * @param vo
	 * @return
	 */
	public List<AreaInfo> queryAreaInfosByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return systemAreaMapper.findPage(conditionMap);
	}
	
	/**
	 * 根据条件查询相关区域
	 * 
	 * @param vo
	 * @return
	 */
	public List<AreaInfo> queryAreaInfosByConditionValue(String value)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("areaCode", value);
		return systemAreaMapper.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<AreaInfo> queryAreaInfosForPage(ConditionVO vo,
			Page<AreaInfo> page) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("areaName", vo.getNameFilter());
		conditionMap.put("areaParentCode", vo.getCode());
		return super.queryForPage(systemAreaMapper, conditionMap, page);
	}

	/**
	 * 根据父code查找子集区域
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> queryAreaInfoForMapByCondition(String code)
			throws Exception {
		LinkedHashMap<String, String> areaInfoMap = new LinkedHashMap<String, String>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("areaParentCode", code);
		List<AreaInfo> areaInfoList = systemAreaMapper.query(conditionMap);
		for (AreaInfo areaInfo : areaInfoList) {
			areaInfoMap.put(areaInfo.getAreaCode(), areaInfo.getAreaName());
		}
		return areaInfoMap;
	}
	
	/*
	 * 根据父code查询子集全部信息
	 */
	public List<AreaInfo> queryAreaInfoByCode(String code) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("areaParentCode", code);
		List<AreaInfo> list = systemAreaMapper.query(conditionMap);
		return list;
	}
	
}
