package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.DataDao;
import com.sc.system.pojo.Data;

@Service
public class DataService  extends BaseService<Data> {

	@Autowired
	DataDao DataMapper;
	

	/**
	 * 删除菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDataById(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				DataMapper.delete(conditionMap);
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
	public Data getDataById(ConditionVO vo) throws Exception {
		return DataMapper.getById(Long.parseLong(vo.getEntityId()));
	}
	
	/**
	 * 保存或新增菜品原料信息
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDataInfo(Data entity) throws Exception {
		if (entity.getSn() == null) {
			DataMapper.insert(entity);
		} else {
			DataMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<Data> queryDatasByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return DataMapper.query(conditionMap);
	}
	
	/**
	 * 根据条件查询相关菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<Data> queryDatasByKeys(String keys)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("keys", keys);
		return DataMapper.query(conditionMap);
	}
	
	/**
	 * 根据条件查询相关菜品原料信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<Data> queryRechargeableCardDataByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("orgCode", vo.getOrgCode());
		conditionMap.put("chAttribute", "充值卡");
		return DataMapper.query(conditionMap);
	}
	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Data> queryDatasForPage(ConditionVO vo,
			Page<Data> page) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("orgCode", vo.getOrgCode());
		return super.queryForPage(DataMapper, conditionMap, page);
	}

}
