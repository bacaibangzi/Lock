package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.SystemMenuMapper;
import com.sc.system.pojo.SystemMenu;

/**
 * 系统菜单service
 * 
 * @author cuibin
 * 
 */
@Service
public class SystemMenuService extends BaseService<SystemMenu> {

	@Autowired
	SystemMenuMapper systemMenuMapper;

	/**
	 * 删除系统菜单
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteSystemMenuById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("miId", id);
				systemMenuMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到系统菜单信息
	 * 
	 * @param vo
	 * @return
	 */
	public SystemMenu getSystemMenuById(ConditionVO vo)  throws Exception{
		return systemMenuMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增系统菜单
	 * 
	 * @param entity
	 */
	public void saveOrUpdateSystemMenuInfo(SystemMenu entity) throws Exception {
		if (entity.getMiId() == null) {
			// 防止父节点溢出
			if(entity.getFiId()==null){
				entity.setFiId(0L);
			}
			
			// 默认父节点为0时，为一级菜单
			if(entity.getFiId().longValue()==0){
				entity.setMiLevel(1);
			}else{
				entity.setMiLevel(2);
			}
			
			systemMenuMapper.insert(entity);
		} else {
			systemMenuMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关系统菜单
	 * 
	 * @param vo
	 * @return
	 */
	public List<SystemMenu> querySystemMenusByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return systemMenuMapper.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<SystemMenu> querySystemMenusForPage(ConditionVO vo,
			Page<SystemMenu> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("miName", vo.getNameFilter());
		conditionMap.put("fiId", vo.getCode());
		return super.queryForPage(systemMenuMapper, conditionMap, page);
	}
}
