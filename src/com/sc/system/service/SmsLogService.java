package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.SmsLogDao;
import com.sc.system.pojo.SmsLog;

/**
 * 短信日志
 * 
 * @author cuibin
 *
 */
public class SmsLogService  extends BaseService<SmsLog> {
	@Autowired
	SmsLogDao smsLogDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteSmsLogById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				smsLogDao.delete(conditionMap);
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
	public SmsLog getSmsLogById(ConditionVO vo) throws Exception {
		return smsLogDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateSmsLogInfo(SmsLog entity) throws Exception {
		if (entity.getSn() == null) {  
			smsLogDao.insert(entity);
		} else {
			smsLogDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<SmsLog> querySmsLogsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return smsLogDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<SmsLog> querySmsLogsForPage(ConditionVO vo,
			Page<SmsLog> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(smsLogDao, conditionMap, page);
	}
}
