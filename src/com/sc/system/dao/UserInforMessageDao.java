package com.sc.system.dao;

import java.util.Map;

import com.sc.framework.base.dao.BaseDao;
import com.sc.system.pojo.UserInforMessage;

public interface UserInforMessageDao  extends BaseDao<UserInforMessage>{

	public void updateDealFlag(Map<String, Object> conditionMap);


	public void del(Map<String, Object> conditionMap);

	public void syn(Map<String, Object> conditionMap);
}
