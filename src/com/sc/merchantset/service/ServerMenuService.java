package com.sc.merchantset.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.vo.ConditionVO;
import com.sc.system.dao.RoleMenuMapper;
import com.sc.system.pojo.RoleMenu;

/**
 * 商户服务对应菜单功能service
 * 
 * @author cuibin
 * 
 */
@Service
public class ServerMenuService {
	
	@Autowired
	RoleMenuMapper roleMenuMapper;
	
	
	/**
	 * 根据Id得到商户服务对应菜单功能
	 * 
	 * @param vo
	 * @return
	 */
	public RoleMenu getServerMenuById(ConditionVO vo)  throws Exception{
		return roleMenuMapper.getById(Long.parseLong(vo.getEntityId()));
	}
	
	/**
	 * 保存商户服务对应菜单
	 * 
	 * @param entity
	 */
	public void saveOrUpdateServerMenu(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		// 先删除角色下所有菜单
		conditionMap.put("riId", vo.getId());
		roleMenuMapper.delete(conditionMap);
		
		// 再添加相应的角色菜单
		RoleMenu roleMenu = null;
		for(String menuId:vo.getEntityIds().split(",")){
			roleMenu = new RoleMenu();
			roleMenu.setRiId(vo.getId());
			roleMenu.setMiId(Long.parseLong(menuId));
			roleMenuMapper.insert(roleMenu);
		}
	}
	
	/**
	 * 根据条件查询商户服务对应菜单
	 * 
	 * @param vo
	 * @return
	 */
	public List<RoleMenu> queryRoleServerByCondition(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		// 防止角色ID溢出
		if(vo.getId()==null){
			conditionMap.put("riId", -1L);
		}else{
			conditionMap.put("riId", vo.getId());
		}
		return roleMenuMapper.query(conditionMap);
	}
	
	
}
