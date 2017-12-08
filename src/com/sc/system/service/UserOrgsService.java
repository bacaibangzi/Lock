package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.system.dao.UserOrgsMapper;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserOrgs;

@Service
public class UserOrgsService extends BaseService<UserOrgs> {

	@Autowired
	UserOrgsMapper userOrgsMapper;
	@Autowired
	UserInfoService userInfoService;
	
	/**
	 * 保存用户门店数据权限
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void saveUserOrgs(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		// 清除数据
		conditionMap.put("userId", vo.getUserId());
		userOrgsMapper.delete(conditionMap);
		// 保存数据
		UserOrgs userOrgs;
		for (String id : vo.getEntityIds().split(",")) {
			userOrgs = new UserOrgs();
			userOrgs.setOrgCode(id);
			userOrgs.setUserId(vo.getUserId());
			userOrgsMapper.insert(userOrgs);
		}
	}
	
	public void changeUserOrgs(ConditionVO vo) throws Exception {
		for (String id : vo.getEntityIds().split(",")) {
			vo.setEntityId(id);
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			userInfo.setUiOrgCode(vo.getOrgCode());
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
		}
	}
	
	
	public List<UserOrgs> queryUserOrgsById(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId", vo.getUserId());
		return userOrgsMapper.findPage(conditionMap);
	}
	
}
