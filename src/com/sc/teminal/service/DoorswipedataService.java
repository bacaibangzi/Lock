package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DoorswipedataMapper;
import com.sc.teminal.pojo.Doorswipedata;
@Service
public class DoorswipedataService  extends BaseService<Doorswipedata> {

	@Autowired
	DoorswipedataMapper DoorswipedataDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDoorswipedataById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				DoorswipedataDao.delete(conditionMap);
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
	public Doorswipedata getDoorswipedataById(ConditionVO vo) throws Exception {
		return DoorswipedataDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDoorswipedataInfo(Doorswipedata entity) throws Exception {
		if (entity.getId() == null) {  
			DoorswipedataDao.insert(entity);
		} else {
			DoorswipedataDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Doorswipedata> queryDoorswipedatasByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("swipeType", vo.getCode());
		conditionMap.put("terminalCode", vo.getCode1());
		return DoorswipedataDao.query(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Doorswipedata> queryDoorswipedatasForPage(ConditionVO vo,
			Page<Doorswipedata> page ,String dateStr11,String dateStr22 ,String sbmc ,String sjlx,String kh ,String xh ,String yhxm ,String dateStr1 ,String dateStr2)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		if(dateStr11!=null&&!"".equals(dateStr11)){
			conditionMap.put("swipeTimeBegin", dateStr11);
		}
		if(dateStr22!=null&&!"".equals(dateStr22)){
			conditionMap.put("swipeTimeEnd", dateStr22);
		}
		if(sbmc!=null&&!"".equals(sbmc)){
			conditionMap.put("doorname", sbmc);
		}
		if(sjlx!=null && !"-1".equals(sjlx)){
			conditionMap.put("swipeType", sjlx);
		}
		if(kh!=null&&!"".equals(kh)){
			conditionMap.put("cardNo", kh);
		}
		if(xh!=null&&!"".equals(xh)){
			conditionMap.put("uiNum", xh);
		}
		if(yhxm!=null&&!"".equals(yhxm)){
			conditionMap.put("uiName", yhxm);
		}
		if(dateStr1!=null&&!"".equals(dateStr1)){
			conditionMap.put("gatherTimeBegin", dateStr1);
		}
		if(dateStr2!=null&&!"".equals(dateStr2)){
			conditionMap.put("gatherTimeEnd", dateStr2);
		}
		
		
		return super.queryForPage(DoorswipedataDao, conditionMap, page);
	}
}
