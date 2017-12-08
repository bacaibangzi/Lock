package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevnamelistinfoMapper;
import com.sc.teminal.pojo.Devnamelistinfo;
@Service
public class DevnamelistinfoService  extends BaseService<Devnamelistinfo> {

	@Autowired
	DevnamelistinfoMapper DevnamelistinfoDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevnamelistinfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				DevnamelistinfoDao.delete(conditionMap);
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
	public Devnamelistinfo getDevnamelistinfoById(ConditionVO vo) throws Exception {
		return DevnamelistinfoDao.getById(Long.parseLong(vo.getEntityId()));
	}
	
	public Devnamelistinfo getDevnamelistinfoById(Long id) throws Exception {
		return DevnamelistinfoDao.getById(id);
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public String saveOrUpdateDevnamelistinfoInfo(Devnamelistinfo entity) throws Exception {
		DevnamelistinfoDao.insert(entity);
		return entity.getNameListId().toString();
	}
	
	public void updateDevnamelistinfoInfo(Devnamelistinfo entity) throws Exception {
		DevnamelistinfoDao.update(entity);
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Devnamelistinfo> queryDevnamelistinfosByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalId", vo.getEntityId());
		return DevnamelistinfoDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Devnamelistinfo> queryDevnamelistinfosForPage(ConditionVO vo,
			Page<Devnamelistinfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(DevnamelistinfoDao, conditionMap, page);
	}
	
	public String getMaxVersion(String orgCode)throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return DevnamelistinfoDao.getMaxVersion(conditionMap);
	}
	
	public void deleteByTerminalIDCardNo(String terminalId,String cardNo){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalId",terminalId);
		conditionMap.put("cardNo",cardNo);
		DevnamelistinfoDao.deleteByTerminalIDCardNo(conditionMap);
	}
	
	public Devnamelistinfo getByTerminalIDCardNo(String terminalId,String cardNo){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalId",terminalId);
		conditionMap.put("cardNo",cardNo);
		return DevnamelistinfoDao.getByTerminalIDCardNo(conditionMap);
	}
	
	/////////////////////////////////////////////////////////
	public List<Devnamelistinfo> queryByCardNo(String cardNo) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("cardNo",cardNo);
		return DevnamelistinfoDao.query(conditionMap);
	}

	public void insertlog(Devnamelistinfo devnamelistinfo) throws Exception{
		DevnamelistinfoDao.getById(devnamelistinfo.getNameListId().longValue());
		DevnamelistinfoDao.insertlog(devnamelistinfo);
	}
	

	public void deleteLogByCardNo(String cardNo){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("cardNo",cardNo);
		DevnamelistinfoDao.deleteLogByCardNo(conditionMap);
	}
	
	public List<Devnamelistinfo> queryLog(String cardNo){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("cardNo",cardNo);
		return DevnamelistinfoDao.queryLog(conditionMap);
	}
	
	public List<Devnamelistinfo> query(String cardNo) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("cardNo",cardNo);
		return DevnamelistinfoDao.query(conditionMap);
	}
}
