package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.AttendancedataMapper;
import com.sc.teminal.pojo.Attendancedata;
@Service
public class AttendancedataService   extends BaseService<Attendancedata>{

	@Autowired
	AttendancedataMapper AttendancedataDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteAttendancedataById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				AttendancedataDao.delete(conditionMap);
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
	public Attendancedata getAttendancedataById(ConditionVO vo) throws Exception {
		return AttendancedataDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateAttendancedataInfo(Attendancedata entity) throws Exception {
		if (entity.getId() == null) {  
			AttendancedataDao.insert(entity);
		} else {
			AttendancedataDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Attendancedata> queryAttendancedatasByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return AttendancedataDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Attendancedata> queryAttendancedatasForPage(ConditionVO vo,
			Page<Attendancedata> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(AttendancedataDao, conditionMap, page);
	}
}
