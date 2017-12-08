package com.sc.teminal.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.VhuisYancMapper;
import com.sc.teminal.pojo.VhuisYanc;
@Service
public class VhuisYancService  extends BaseService<VhuisYanc> {


	@Autowired
	VhuisYancMapper vhuisYancDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteVhuisYancById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				vhuisYancDao.delete(conditionMap);
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
	public VhuisYanc getVhuisYancById(ConditionVO vo) throws Exception {
		return vhuisYancDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateVhuisYancInfo(VhuisYanc entity) throws Exception {
		if (entity.getNamelistid() == null) {  
			vhuisYancDao.insert(entity);
		} else {
			vhuisYancDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<VhuisYanc> queryVhuisYancsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("uiNum", vo.getCode());
		return vhuisYancDao.findPage(conditionMap);
	}
	
	public List<VhuisYanc> queryVhuisYancsByCondition(String uiNum)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("uiNum", uiNum);
		return vhuisYancDao.query(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<VhuisYanc> queryVhuisYancsForPage(ConditionVO vo,
			Page<VhuisYanc> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("terminalName", vo.getNameFilter());
		conditionMap.put("syncstate", vo.getShFilter());
		
		if(vo.getCode()!=null)
		conditionMap.put("uiName",  URLDecoder.decode(vo.getCode(),"utf-8") );
		if(vo.getCode1()!=null)
		conditionMap.put("uiNum", URLDecoder.decode(vo.getCode1(),"utf-8"));
		if(vo.getCode2()!=null)
		conditionMap.put("terminalname", URLDecoder.decode(vo.getCode2(),"utf-8"));
		if(vo.getCode3()!=null)
		conditionMap.put("edittimeBegin", URLDecoder.decode(vo.getCode3(),"utf-8"));
		if(vo.getCode4()!=null)
		conditionMap.put("edittimeEnd", URLDecoder.decode(vo.getCode4(),"utf-8"));
		if(vo.getCode5()!=null)
		conditionMap.put("cardNum", URLDecoder.decode(vo.getCode5(),"utf-8"));
		
		return super.queryForPage(vhuisYancDao, conditionMap, page);
	}
}
