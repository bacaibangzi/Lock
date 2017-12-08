package com.sc.framework.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.framework.vo.Page;

public abstract class BaseService<T> {

	public  Page<T> queryForPage(BaseDao<T> dao,Map<String, Object> conditionMap, Page<T> page,
			boolean... bs)  throws Exception {
		if (bs.length == 0 || bs[0] == true) { // 不传值或传入的值为true则进行数据库页数查询
			Object count;
			try {
				count = dao.findPageCount(conditionMap);
				page.setTotalCount(Integer.parseInt(count.toString()));
				page.getTotalPages();
			} catch (Exception e) {
			}
		}

		conditionMap.put("oracleStart", (page.getPageNo() - 1)
				* page.getPageSize());
		conditionMap.put("oracleEnd",  page.getPageSize());

		List<T> result = dao.findPage(conditionMap);
		page.setResult(result);
		return page;
	}
	

}
