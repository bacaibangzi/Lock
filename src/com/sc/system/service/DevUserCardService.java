package com.sc.system.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.DevUserCardMapper;
import com.sc.system.pojo.DevUserCard;

@Service
public class DevUserCardService extends BaseService<DevUserCard>{
	@Autowired
	DevUserCardMapper devUserCardDao;

	/**
	 * 删除用户卡
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevUserCardById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				devUserCardDao.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}


	
	/**
	 * 根据Id得到用户卡信息
	 * 
	 * @param vo
	 * @return
	 */
	public DevUserCard getDevUserCardById(ConditionVO vo) throws Exception {
		return devUserCardDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增用户卡
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevUserCardInfo(DevUserCard entity) throws Exception {
		if (entity.getSn() == null) {  
			devUserCardDao.insert(entity);
		} else {
			devUserCardDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关用户卡
	 * 
	 * @param vo
	 * @return
	 */
	public List<DevUserCard> queryDevUserCardsByCondition(String cardNum)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("cardNum", cardNum);
		return devUserCardDao.query(conditionMap);
	}
	
	public List<DevUserCard> queryDevUserCardsByUser(String userId)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId", userId);
		return devUserCardDao.query(conditionMap);
	}
	
	
	public List<DevUserCard> getByCardNum(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("cardNum", vo.getCode());
		return devUserCardDao.query(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<DevUserCard> queryDevUserCardsForPage(ConditionVO vo,
			Page<DevUserCard> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		if(vo.getCode()!=null&&!"".equals(vo.getCode())){
			conditionMap.put("mc", URLDecoder.decode(vo.getCode(),"utf-8"));
		}
		conditionMap.put("gh", vo.getCode1());
		conditionMap.put("flag", vo.getCode2());
		conditionMap.put("userId", vo.getEntityId());
		conditionMap.put("kh", vo.getCode3());
		System.out.println("******************************>>>"+vo.getCode3());
		
		return super.queryForPage(devUserCardDao, conditionMap, page);
	}
	
	public void updateFlag(String flag,String userId,String cardNum){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId",userId);
		conditionMap.put("cardNum", cardNum);
		conditionMap.put("flag", flag);
		devUserCardDao.updateFlag(conditionMap);
	}
}
