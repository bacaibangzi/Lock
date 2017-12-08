package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevDoorGroupMapper;
import com.sc.teminal.dao.DevDoorTeminalMapper;
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.pojo.Terminalinfo;
@Service
public class DevDoorGroupService  extends BaseService<DevDoorGroup> {

	@Autowired
	DevDoorGroupMapper DevDoorGroupDao;

	@Autowired
	DevDoorTeminalMapper DevDoorTeminalDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevDoorGroupById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				
				// 判断是否存在门
				conditionMap.put("doorGroupSn", Integer.parseInt(id));
				List<Terminalinfo>  list = DevDoorTeminalDao.query(conditionMap);
				if(list!=null&&list.size()>0){
					continue;
				}
				
				DevDoorGroupDao.delete(conditionMap);
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
	public DevDoorGroup getDevDoorGroupById(ConditionVO vo) throws Exception {
		return DevDoorGroupDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevDoorGroupInfo(DevDoorGroup entity) throws Exception {
		if (entity.getSn() == null) {  
			DevDoorGroupDao.insert(entity);
		} else {
			DevDoorGroupDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<DevDoorGroup> queryDevDoorGroupsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return DevDoorGroupDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<DevDoorGroup> queryDevDoorGroupsForPage(ConditionVO vo,
			Page<DevDoorGroup> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		//conditionMap.put("fisn", vo.getCode());
		conditionMap.put("name", vo.getNameFilter());
		conditionMap.put("userId", vo.getUserId());
		return super.queryForPage(DevDoorGroupDao, conditionMap, page);
	}
}
