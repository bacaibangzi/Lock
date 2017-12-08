package com.sc.system.dao;

import java.util.List;
import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.system.pojo.OrgInfo;

/**
 * 机构信息Mapper
 * 
 * @author cuibin
 * 
 */
public interface OrgInfoMapper extends BaseDao<OrgInfo> {

	public void insertForValue(OrgInfo orgInfo);

	public List<OrgInfo> findPageByOrgCode(Map<String, Object> conditionMap)
			throws Exception;

	public List<OrgInfo> findPageByOrgCodeData(Map<String, Object> conditionMap)
			throws Exception;	
	
	
	/**
	 * 获取总店信息
	 * 
	 * @param conditionMap
	 * @return
	 * @throws Exception
	 */
	public List<OrgInfo> findZongdByOrgCode(Map<String, Object> conditionMap)
			throws Exception;
	
	/**
	 * 获取门店信息
	 * 
	 * @param conditionMap
	 * @return
	 * @throws Exception
	 */
	public OrgInfo findMengdByOrgCode(Map<String, Object> conditionMap)
			throws Exception;

	/**
	 * 根据门店编码获取门店信息
	 * 
	 * @param oiCode
	 * @return
	 * @throws Exception
	 */
	public OrgInfo getByCode(String oiCode) throws Exception;
	public OrgInfo getByName(String oiName) throws Exception;
	
	/**
	 * 根据orgCode和oiType查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrgInfo> findPageByOrgCodeAndOiType(
			Map<String, Object> conditionMap) throws Exception;

	/**
	 * 查询子机构
	 * @param oiCode
	 * @return
	 * @throws Exception
	 */
	public List<OrgInfo> querySubOrgByOrgCode(Map<String, Object> conditionMap) throws Exception;
	
	
	public  String findNextCode(Map<String, Object> conditionMap);
	
	public void deleteSyn() throws Exception;
}
