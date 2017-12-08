package com.sc.merchantset.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.enums.UserTypeEnum;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.RoleInfoMapper;
import com.sc.system.pojo.RoleInfo;

/**
 * 商户服务service
 * 
 * @author cuibin
 * 
 */
@Service
public class ServerService extends BaseService<RoleInfo> {

	@Autowired
	RoleInfoMapper roleInfoMapper;

	/**
	 * 删除商户服务
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteServerById(ConditionVO vo) throws Exception {
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
	 * 根据Id得到商户服务
	 * 
	 * @param vo
	 * @return
	 */
	public RoleInfo getServerById(ConditionVO vo) throws Exception {
		return roleInfoMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增商户服务
	 * 
	 * @param entity
	 */
	public void saveOrUpdateServer(RoleInfo entity) throws Exception {
		if (entity.getRiId() == null) {
			// 系统添加角色默认为1
			entity.setRiLevel(UserTypeEnum.merchant.id());
			roleInfoMapper.insert(entity);
		} else {
			roleInfoMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关商户服务
	 * 
	 * @param vo
	 * @return
	 */
	public List<RoleInfo> queryServerByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("riLevel", UserTypeEnum.merchant.id());
		return roleInfoMapper.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<RoleInfo> queryServerForPage(ConditionVO vo, Page<RoleInfo> page)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("riName", vo.getNameFilter());
		conditionMap.put("riLevel", UserTypeEnum.merchant.id());
		return super.queryForPage(roleInfoMapper, conditionMap, page);
	}
}
