package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.vo.ConditionVO;
import com.sc.system.dao.WebLocationMapper;
import com.sc.system.pojo.WebLocation;

@Service
public class WebLocationService {
	@Autowired
	WebLocationMapper webLocationMapper;
	/**
	 * 根据Id得到组织机构信息
	 * 
	 * @param vo
	 * @return
	 */
	public WebLocation getWebLocationById(ConditionVO vo)  throws Exception{
		return webLocationMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增组织机构
	 * 
	 * @param entity
	 */
	public void saveWebLocationInfo(WebLocation entity)  throws Exception{
		webLocationMapper.insert(entity);
	}

	/**
	 * 根据条件查询相关组织机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<WebLocation> queryWebLocationsByCondition(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return webLocationMapper.findPage(conditionMap);
	}
}
