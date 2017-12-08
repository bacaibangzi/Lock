package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.TradeLogDao;
import com.sc.system.pojo.TradeLog;

/**
 * 
 * 缴费日志
 * 
 * @author cuibin
 *
 */
public class TradeLogService  extends BaseService<TradeLog> {
	@Autowired
	TradeLogDao tradeLogDao;

	/**
	 * 删除缴费日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteTradeLogById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				tradeLogDao.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到缴费日志信息
	 * 
	 * @param vo
	 * @return
	 */
	public TradeLog getTradeLogById(ConditionVO vo) throws Exception {
		return tradeLogDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增缴费日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateTradeLogInfo(TradeLog entity) throws Exception {
		if (entity.getSn() == null) {  
			tradeLogDao.insert(entity);
		} else {
			tradeLogDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关缴费日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<TradeLog> queryTradeLogsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return tradeLogDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<TradeLog> queryTradeLogsForPage(ConditionVO vo,
			Page<TradeLog> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(tradeLogDao, conditionMap, page);
	}
}
