package com.sc.zhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.zhouse.dao.HouseTypeMapper;
import com.sc.zhouse.pojo.HouseType;
import com.sc.zhouse.pojo.HouseType;

@Service
public class HouseTypeService extends BaseService<HouseType>{
	@Autowired
	HouseTypeMapper houseTypeMapper;

	/**
	 * 删除APP
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteHouseTypeById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				houseTypeMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}
	 

	/**
	 * 根据Id得到APP信息
	 * 
	 * @param vo
	 * @return
	 */
	public HouseType getHouseTypeById(ConditionVO vo) throws Exception {
		return houseTypeMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增APP
	 * 
	 * @param entity
	 */
	public void saveOrUpdateHouseTypeInfo(HouseType entity) throws Exception {
		if (entity.getSn() == null) {  
			houseTypeMapper.insert(entity);
		} else {
			houseTypeMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关APP
	 * 
	 * @param vo
	 * @return
	 */
	public List<HouseType> queryHouseTypesByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return houseTypeMapper.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<HouseType> queryHouseTypesForPage(ConditionVO vo,
			Page<HouseType> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userid", vo.getOrgCode());
		return super.queryForPage(houseTypeMapper, conditionMap, page);
	}
	 
}
