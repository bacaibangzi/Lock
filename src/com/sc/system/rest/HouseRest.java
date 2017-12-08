package com.sc.system.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.system.dao.SystemAreaMapper;
import com.sc.system.pojo.AreaInfo;

@Controller
@RequestMapping("/houseRest")
public class HouseRest extends BaseAction{

	@Autowired
	SystemAreaMapper systemAreaMapper;

	/**
	 * 返回区域
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public List<AreaInfo> queryAreaInfosByCondition(ConditionVO vo)
			throws Exception {
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("", vo.getValue());
		return systemAreaMapper.query(conditionMap);
	}
}
