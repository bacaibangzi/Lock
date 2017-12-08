package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevcmdlistMapper;
import com.sc.teminal.pojo.Devcmdlist;
@Service
public class DevcmdlistService  extends BaseService<Devcmdlist> {

	@Autowired
	DevcmdlistMapper DevcmdlistDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevcmdlistById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				DevcmdlistDao.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到短信日志信息
	 * 
	 * @param vo
	 * @return
	 */
	public Devcmdlist getDevcmdlistById(ConditionVO vo) throws Exception {
		return DevcmdlistDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevcmdlistInfo(Devcmdlist entity) throws Exception {
			DevcmdlistDao.insert(entity);
		
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Devcmdlist> queryDevcmdlistsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return DevcmdlistDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Devcmdlist> queryDevcmdlistsForPage(ConditionVO vo,
			Page<Devcmdlist> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(DevcmdlistDao, conditionMap, page);
	}
	

	public String getMaxVersion(String orgCode)throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return DevcmdlistDao.getMaxVersion(conditionMap);
	}
}
