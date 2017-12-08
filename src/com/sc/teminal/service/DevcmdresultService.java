package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevcmdresultMapper;
import com.sc.teminal.pojo.Devcmdresult;
@Service
public class DevcmdresultService  extends BaseService<Devcmdresult> {

	@Autowired
	DevcmdresultMapper DevcmdresultDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevcmdresultById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				DevcmdresultDao.delete(conditionMap);
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
	public Devcmdresult getDevcmdresultById(ConditionVO vo) throws Exception {
		return DevcmdresultDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevcmdresultInfo(Devcmdresult entity) throws Exception {
		if (entity.getId() == null) {  
			DevcmdresultDao.insert(entity);
		} else {
			DevcmdresultDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Devcmdresult> queryDevcmdresultsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return DevcmdresultDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Devcmdresult> queryDevcmdresultsForPage(ConditionVO vo,
			Page<Devcmdresult> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(DevcmdresultDao, conditionMap, page);
	}
}
