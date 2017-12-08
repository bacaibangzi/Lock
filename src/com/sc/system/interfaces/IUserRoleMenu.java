package com.sc.system.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.system.dao.UserRoleMenuMapper;
import com.sc.system.pojo.UserRoleMenu;

/**
 * 用户角色功能对外服务接口
 * 
 * @author cuibin
 *
 */
@Service
public class IUserRoleMenu { 
	
	@Autowired
	UserRoleMenuMapper userRoleMenuMapper;

	/**
	 * 根据条件返回相应的菜单选项
	 * @param conditionMap
	 * @return
	 */
	public List<UserRoleMenu> queryUserRoleMenuAll(Map<String, Object> conditionMap) throws Exception{
		return userRoleMenuMapper.query(conditionMap);
	}
}
