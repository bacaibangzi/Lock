package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.RoleInfoMapper;
import com.sc.system.pojo.RoleInfo;

/**
 * 系统角色service
 * 
 * @author cuibin
 * 
 */
@Service
public class RoleInfoService extends BaseService<RoleInfo> {

	@Autowired
	RoleInfoMapper roleInfoMapper;

	/**
	 * 删除系统角色
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteRoleInfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("riId", id);
				roleInfoMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到系统角色信息
	 * 
	 * @param vo
	 * @return
	 */
	public RoleInfo getRoleInfoById(ConditionVO vo) throws Exception {
		return roleInfoMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增系统角色
	 * 
	 * @param entity
	 */
	public void saveOrUpdateRoleInfoInfo(RoleInfo entity) throws Exception {
		if (entity.getRiId() == null) { 
			// 系统添加角色默认为1
			entity.setRiLevel(1L);
			roleInfoMapper.insert(entity);
		} else {
			roleInfoMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关系统角色
	 * 
	 * @param vo
	 * @return
	 */
	public List<RoleInfo> queryRoleInfosByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("riLevel", 1);
		return roleInfoMapper.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<RoleInfo> queryRoleInfosForPage(ConditionVO vo,
			Page<RoleInfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("riName", vo.getNameFilter());
		conditionMap.put("riLevel", 1);
		return super.queryForPage(roleInfoMapper, conditionMap, page);
	}
}
