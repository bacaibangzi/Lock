package com.sc.merchantset.service;

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
 * 注册商户service
 * 
 * @author cuibin
 * 
 */
@Service
public class MerchantserService extends BaseService<UserInfo> {

	@Autowired
	UserInfoMapper userInfoMapper;

	/**
	 * 删除注册商户
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteMerchantserById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("uiId", id);
				userInfoMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 审核用户
	 * @param vo
	 * @return
	 */
	public boolean shMerchantserById(ConditionVO vo) throws Exception{
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
	 * 根据Id得到注册商户信息
	 * 
	 * @param vo
	 * @return
	 */
	public UserInfo getMerchantserById(ConditionVO vo)  throws Exception{
		return userInfoMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增注册商户
	 * 
	 * @param entity
	 */
	public void saveOrUpdateMerchantserInfo(UserInfo entity) throws Exception {
		if (entity.getUiId() == null) {
			// 新增员工为未审核
			entity.setUiSh(0L);
			// 系统添加默认用户为员工
			entity.setUiType(UserTypeEnum.merchant.id());
			entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
			userInfoMapper.insert(entity);
		} else {
			userInfoMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关注册商户
	 * 
	 * @param vo
	 * @return
	 */
	public List<UserInfo> queryMerchantsersByCondition(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return userInfoMapper.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<UserInfo> queryMerchantsersForPage(ConditionVO vo,
			Page<UserInfo> page) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		System.out.println("-------------------------------->>>");
		
		conditionMap.put("uiName", vo.getNameFilter());
		conditionMap.put("uiOrgCode", vo.getOrgCode());
		conditionMap.put("uiSh",vo.getShFilter());
		conditionMap.put("uiType",UserTypeEnum.merchant.id());
		return super.queryForPage(userInfoMapper, conditionMap, page);
	}
}
