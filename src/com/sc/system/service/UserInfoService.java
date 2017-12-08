package com.sc.system.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.enums.UserTypeEnum;
import com.sc.framework.utils.StringUtil;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.UserInfoMapper;
import com.sc.system.pojo.UserInfo;

/**
 * 系统用户service
 * 
 * @author cuibin
 * 
 */
@Service
public class UserInfoService extends BaseService<UserInfo> {

	@Autowired
	UserInfoMapper userInfoMapper;

	/**
	 * 删除系统用户
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteUserInfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		UserInfo userInfo = null;
		try {
			for (String id : vo.getEntityIds().split(",")) {
				// 判断是否审核
				userInfo = userInfoMapper.getById(Long.parseLong(id));

				/*
				if (userInfo.getUiSh()==1) {
					throw new Exception("只能删除未审核用户！");
				}*/
				conditionMap.put("uiId", id);
				userInfoMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
			return false;
		}
		return true;
	}

	public void deleteUserInfoById(Long id)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			conditionMap.put("uiId", id);
			userInfoMapper.delete(conditionMap);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * 审核用户
	 * @param vo
	 * @return
	 */
	public boolean shUserInfoById(ConditionVO vo) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try{
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("uiId", id);
				conditionMap.put("uiSh", vo.getValue());
				userInfoMapper.sh(conditionMap);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * 根据Id得到系统用户信息
	 * 
	 * @param vo
	 * @return
	 */
	public UserInfo getUserInfoById(ConditionVO vo)  throws Exception{
		//return userInfoMapper.getById(Long.parseLong(vo.getEntityId()));
		UserInfo userInfo = userInfoMapper.getById(Long.parseLong(vo.getEntityId()));
		//userInfo.setUiPassword(StringUtil.decodeStr(userInfo.getUiPassword()));
		if(userInfo.getUiPassword()!=null){
			userInfo.setUiPassword(StringUtil.decodeStr(userInfo.getUiPassword()));
		}
		return userInfo;
	}
	public UserInfo getUserInfoById1(ConditionVO vo)  throws Exception{
		//return userInfoMapper.getById(Long.parseLong(vo.getEntityId()));
		UserInfo userInfo = userInfoMapper.getById(Long.parseLong(vo.getEntityId()));
		if(userInfo.getUiPassword()!=null){
			userInfo.setUiPassword(StringUtil.decodeStr(userInfo.getUiPassword()));
		}
		return userInfo;
	}

	/**
	 * 保存或新增系统用户(系统设置员工管理)
	 * 
	 * @param entity
	 */
	public void saveOrUpdateUserInfoInfo(UserInfo entity) throws Exception {
		entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
		if (entity.getUiId() == null) {
			// 新增员工为未审核
			entity.setUiSh(1L);
			// 系统添加默认用户为员工
			entity.setUiType(1L);//1L代表系统设置中新增员工
			userInfoMapper.insert(entity);
		} else {
			userInfoMapper.update(entity);
		}
	}
	
	public void save(UserInfo entity) throws Exception {
		userInfoMapper.insert(entity);
	}
	
	/**
	 * 保存或新增系统用户(系统设置员工管理)
	 * 
	 * @param entity
	 */
	public void saveOrUpdateUserInfoInfo1(UserInfo entity) throws Exception {
		if (entity.getUiId() == null) {
			// 新增员工为未审核
			entity.setUiSh(1L);
			// 系统添加默认用户为员工
			//entity.setUiType(1L);//1L代表系统设置中新增员工
			userInfoMapper.insert(entity);
		} else {
			userInfoMapper.update(entity);
		}
	}
	
	
	public void saveGly(UserInfo entity) throws Exception{
		entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
		userInfoMapper.saveGly(entity);
	}
	
	/**
	 * 保存或新增系统用户(经销商信息维护)
	 * 
	 * @param entity
	 */
	public void agentSaveOrUpdateUserInfoInfo(UserInfo entity) throws Exception {
		entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
		if (entity.getUiId() == null) {
			// 新增员工为未审核
			entity.setUiSh(0L);
			entity.setUiType(2L);//2L代表经销商信息维护新增经销商用户
			userInfoMapper.insert(entity);
		} else {
			userInfoMapper.update(entity);
		}
	}
	
	/**
	 * 保存或新增系统用户(商户用户信息维护)
	 * 
	 * @param entity
	 */
	public void BusinessmenSaveOrUpdateUserInfoInfo(UserInfo entity) throws Exception {
		entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
		if (entity.getUiId() == null) {
			// 新增员工为未审核
			entity.setUiSh(0L);
			entity.setUiType(3L);//3L代表商户用户新增
			userInfoMapper.insert(entity);
		} else {
			userInfoMapper.update(entity);
		}
	}
	
	/**
	 * 保存或新增系统用户(门店员工管理)
	 * 
	 * @param entity
	 */
	public void BusinessUserSaveOrUpdateUserInfoInfo(UserInfo entity) throws Exception {
		entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
		if (entity.getUiId() == null) {
			// 新增员工为未审核
			entity.setUiSh(0L);
			entity.setUiType(4L);//4L代表门店员工新增
			userInfoMapper.insert(entity);
		} else {
			userInfoMapper.update(entity);
		}
	}


	/**
	 * 根据条件查询相关系统用户
	 * 
	 * @param vo
	 * @return
	 */
	public List<UserInfo> queryUserInfosByCondition(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return userInfoMapper.findPage(conditionMap);
	}
	
	public List<UserInfo> queryUserInfosByCondition(Map<String, Object> conditionMap) throws Exception {
		return userInfoMapper.findPage(conditionMap);
	}
	
	public List<UserInfo> query(Map<String, Object> conditionMap) throws Exception {
		return userInfoMapper.query(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<UserInfo> queryUserInfosForPage(ConditionVO vo,
			Page<UserInfo> page) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		conditionMap.put("uiName", vo.getNameFilter());
		conditionMap.put("uiSh",vo.getShFilter());
		
		conditionMap.put("uiImg",vo.getCode());
		
		return super.queryForPage(userInfoMapper, conditionMap, page);
	}
	
	public Page<UserInfo> queryUserInfosForPage1(ConditionVO vo,
			Page<UserInfo> page) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		if(vo.getCode1()!=null) {
			conditionMap.put("uiName", URLDecoder.decode(vo.getCode1(),"utf-8"));
		}
		if(vo.getCode2()!=null) {
			conditionMap.put("uiNum", URLDecoder.decode(vo.getCode2(),"utf-8"));
		}
		/*
		conditionMap.put("uiNum", vo.getCode2());
		conditionMap.put("uiSh",vo.getShFilter());
		conditionMap.put("uiImg",vo.getCode());
		conditionMap.put("uiOrgCode",vo.getOrgCode());
		*/
		
		if(!"0000".equals(vo.getOrgCode())){
			conditionMap.put("uiOrgCode",vo.getOrgCode());
		}
		
		return super.queryForPage(userInfoMapper, conditionMap, page);
	}
	
	/*
	 * 修改用户
	 */
	public void updateUserInfo(UserInfo userInfo) throws Exception{
		userInfoMapper.update(userInfo);
	}
	
	public UserInfo getByUINUm(String uiNum) throws Exception{
		
		return userInfoMapper.getByUINUm(uiNum);
	}
	
	public UserInfo getByNickName(String uiNickName) throws Exception{
		
		return userInfoMapper.getByNickName(uiNickName);
	}
}
