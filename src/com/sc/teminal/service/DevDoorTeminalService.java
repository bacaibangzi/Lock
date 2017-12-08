package com.sc.teminal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.dao.DevDoorTeminalMapper;
import com.sc.teminal.pojo.Terminalinfo;
@Service
public class DevDoorTeminalService  extends BaseService<Terminalinfo> {

	@Autowired
	DevDoorTeminalMapper DevDoorTeminalDao;

	/**
	 * 删除短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteDevDoorTeminalById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				DevDoorTeminalDao.delete(conditionMap);
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
	public Terminalinfo getDevDoorTeminalById(String sn) throws Exception {
		return DevDoorTeminalDao.getById(Long.parseLong(sn));
	}

	public Integer getTeminalIDById(String sn)throws Exception {
		return DevDoorTeminalDao.getTeminalIDById(sn);
	}
	/**
	 * 保存或新增短信日志
	 * 
	 * @param entity
	 */
	public void saveOrUpdateDevDoorTeminalInfo(ConditionVO vo) throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		if("".equals(vo.getEntityIds())){
			return;
		}
		
		String ids[] = vo.getEntityIds().split(",");
		 
		for(int i=0;i<ids.length;i++){
			String id = ids[i];
			// 判断是否存在
			conditionMap.put("doorGroupSn", Integer.parseInt(vo.getCode()));
			conditionMap.put("terminalId", Integer.parseInt(id));
			List<Terminalinfo>  list = DevDoorTeminalDao.query(conditionMap);
			if(list!=null&&list.size()>0){
				continue;
			}
			
			Terminalinfo terminalinfo = new Terminalinfo();
			terminalinfo.setRepeater1(Integer.parseInt(vo.getCode()));
			terminalinfo.setRepeater2(Integer.parseInt(id));
			DevDoorTeminalDao.insert(terminalinfo);
		}	
	}

	/**
	 * 根据条件查询相关短信日志
	 * 
	 * @param vo
	 * @return
	 */
	public List<Terminalinfo> queryDevDoorTeminalsByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("doorGroupSn", vo.getCode());
		return DevDoorTeminalDao.findPage(conditionMap);
	}

	
	public List<Terminalinfo> queryDl(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("doorGroupSn", vo.getCode());
		return DevDoorTeminalDao.queryDl(conditionMap);
	}
	
	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<Terminalinfo> queryDevDoorTeminalsForPage(ConditionVO vo,
			Page<Terminalinfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("doorGroupSn", vo.getCode());
		return super.queryForPage(DevDoorTeminalDao, conditionMap, page);
	}
}
