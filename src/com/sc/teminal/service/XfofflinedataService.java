package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.XfofflinedataMapper;
import com.sc.teminal.pojo.Xfofflinedata;
@Service
public class XfofflinedataService  extends BaseService<Xfofflinedata> {

	@Autowired
	XfofflinedataMapper XfofflinedataDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteXfofflinedataById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				XfofflinedataDao.delete(conditionMap);
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
	public Xfofflinedata getXfofflinedataById(ConditionVO vo) throws Exception {
		return XfofflinedataDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateXfofflinedataInfo(Xfofflinedata entity) throws Exception {
		if (entity.getId() == null) {  
			XfofflinedataDao.insert(entity);
		} else {
			XfofflinedataDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Xfofflinedata> queryXfofflinedatasByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return XfofflinedataDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Xfofflinedata> queryXfofflinedatasForPage(ConditionVO vo,
			Page<Xfofflinedata> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(XfofflinedataDao, conditionMap, page);
	}
}
