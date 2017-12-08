package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.OrgInfoMapper;
import com.sc.system.dao.UserInfoMapper;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;

/**
 * 组织机构service
 * 
 * @author cuibin
 * 
 */
@Service
public class OrgInfoService extends BaseService<OrgInfo> {

	@Autowired
	OrgInfoMapper orgInfoMapper;
	@Autowired
	UserInfoMapper userInfoMapper;

	/**
	 * 删除组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteOrgInfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			OrgInfo orgInfo = null;
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("oiId", id);
				orgInfo = orgInfoMapper.getById(Long.parseLong(id));
				
				orgInfoMapper.delete(conditionMap);
				
				conditionMap.put("orgCode", orgInfo.getOiCode());
				
			}
			
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	public boolean deleteSyn() throws Exception{
		try {
		orgInfoMapper.deleteSyn();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 根据Id得到组织机构信息
	 * 
	 * @param vo
	 * @return
	 */
	public OrgInfo getOrgInfoById(ConditionVO vo)  throws Exception{
		return orgInfoMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	
	public String findNextCode(String code){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiCode", code);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> code :"+code);
		String orgCode = orgInfoMapper.findNextCode(conditionMap);
		return orgCode;
	}
	
	/**
	 * 保存或新增组织机构
	 * 
	 * @param entity
	 */
	public String saveOrUpdateOrgInfoInfo(OrgInfo entity,String userId,String code)  throws Exception{
		
		if (entity.getOiId() == null) {
			// 机构编码根据函数自动生成4位一级
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("oiCode", code);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> code :"+code);
			String orgCode = orgInfoMapper.findNextCode(conditionMap);
			if(orgCode==null)
				orgCode = "0000";
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> orgCode :"+orgCode);
			if(orgCode.length()<=code.length()){
				orgCode = orgCode +"0000";
			}
			
			String q1 = orgCode.substring(0,orgCode.length()-4);
			String q2 = orgCode.substring(orgCode.length()-4);
			
			String _q2 = String.valueOf(Integer.parseInt(q2)+1);
			if(_q2.length()==1){
				_q2 = "000"+_q2;
			}else if(_q2.length()==2){
				_q2 = "00"+_q2;
			}else if(_q2.length()==3){
				_q2 = "0"+_q2;
			}

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> q :"+q1+_q2);
			
			entity.setOiCode(q1+_q2);
			orgInfoMapper.insert(entity);
			return q1+_q2;
			
		} else {
			orgInfoMapper.update(entity);
			return entity.getOiCode();
		}
	}
	
	public void save(OrgInfo entity) throws Exception{
		orgInfoMapper.insert(entity);
	}
	
	public void update(OrgInfo entity) throws Exception{
		orgInfoMapper.update(entity);
	}

	/**
	 * 根据条件查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> queryOrgInfosByCondition(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiCode", vo.getOrgCode());
		System.out.println("********************>"+vo.getOrgCode());
		return orgInfoMapper.query(conditionMap);
	}
	
	/**
	 * 根据条件查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> queryOrgInfoByOrgCode(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("wholeOiCode", vo.getOrgCode());
		return orgInfoMapper.findPage(conditionMap);
	}
	
	/**
	 * 根据条件查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> queryOrgInfoByParentOrgCode(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("subOiCode", vo.getOrgCode());
		return orgInfoMapper.findPage(conditionMap);
	}
	
	/**
	 * 根据orgCode查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> queryOrgInfosByOrgCode(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiCode", vo.getOrgCode());
		return orgInfoMapper.findPageByOrgCode(conditionMap);
	}
	
	
	/**
	 * 根据orgCode查询相关组织机构（过滤权限）
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> queryOrgInfosByOrgCodeData(ConditionVO vo) throws Exception {
		System.out.println("---------> 过滤权限");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiCode", vo.getOrgCode());
		conditionMap.put("userId", vo.getUserId());
		return orgInfoMapper.findPageByOrgCodeData(conditionMap);
	}
	
	/**
	 * 根据orgCode和oiType查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> queryOrgInfosByOrgCodeAndOiType(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiCode", vo.getOrgCode());
		return orgInfoMapper.findPageByOrgCodeAndOiType(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<OrgInfo> queryOrgInfosForPage(ConditionVO vo,
			Page<OrgInfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiName", vo.getNameFilter());
		conditionMap.put("oiCode", vo.getCode());
		conditionMap.put("notOiCode", "1");
		return super.queryForPage(orgInfoMapper, conditionMap, page);
	}
	
	/**
	 * 根据条件分页查询(经销商机构)
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<OrgInfo> queryAgOrgInfosForPage(ConditionVO vo,
			Page<OrgInfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiName", vo.getNameFilter());
		conditionMap.put("oiCode", vo.getCode());
		conditionMap.put("oiType", vo.getOrgType());//过滤选择机构类型
		return super.queryForPage(orgInfoMapper, conditionMap, page);
	}
	
	/**
	 * 获取总店信息
	 * 
	 * @param orgCode
	 * @return
	 * @throws Exception
	 */
	public OrgInfo findZongdByOrgCode(String orgCode) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("orgCode", orgCode);
		return orgInfoMapper.findZongdByOrgCode(conditionMap).get(0);
	}	
	
	/**
	 * 获取门店信息
	 * 
	 * @param orgCode
	 * @return
	 * @throws Exception
	 */
	public OrgInfo findMengdByOrgCode(String orgCode) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("orgCode", orgCode);
		return orgInfoMapper.findMengdByOrgCode(conditionMap);
	}
	
	public OrgInfo getByName(String oiName) throws Exception{
		return orgInfoMapper.getByName(oiName);
	}
	
	
	public List<OrgInfo> queryOrgInfosByOrgCodeAndOrgType(ConditionVO vo) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("oiCode", vo.getOrgCode());
		conditionMap.put("oiType", vo.getOrgType());
		return orgInfoMapper.findPage(conditionMap);
	}
	/**
	 * 验证节点结构下是否已经存在子机构和用户
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	public String checkIfCanbeDeleted(ConditionVO vo) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		Map<String, Object> userInfoConditionMap = new HashMap<String, Object>();
		Map<String, Object> subOrgInfoConditionMap = new HashMap<String, Object>();
		OrgInfo orgInfo = null;
		String message = "ok";//ok表示可以删除
		for (String id : vo.getEntityIds().split(",")) {
			conditionMap.put("oiId", id);
			orgInfo = orgInfoMapper.getById(Long.parseLong(id));
			if(orgInfo!=null){
				//查询子机构
				subOrgInfoConditionMap.put("notOiCode", orgInfo.getOiCode());
				subOrgInfoConditionMap.put("oiCode", orgInfo.getOiCode());
				List<OrgInfo> orgInfos = orgInfoMapper.querySubOrgByOrgCode(subOrgInfoConditionMap);
				if(orgInfos.size()>0){
					message = orgInfo.getOiName()+"下已经存在子机构！无法删除！"; 
					return message;
				}else{
					//查询机构下用户
					userInfoConditionMap.put("uiOrgCode", orgInfo.getOiCode());
					List<UserInfo> userInfos = userInfoMapper.query(userInfoConditionMap);
					if(userInfos.size()>0){
						message = orgInfo.getOiName()+"下已经存在用户！无法删除！"; 
						return message;
					}
				}
			}
		}
		return message;
	}
}
