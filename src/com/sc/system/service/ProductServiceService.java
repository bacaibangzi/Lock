package com.sc.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.dao.ProductServiceDao;
import com.sc.system.pojo.ProductService;

/**
 * 产品服务
 * 
 * @author cuibin
 *
 */
@Service
public class ProductServiceService  extends BaseService<ProductService> {
	@Autowired
	ProductServiceDao productServiceDao;

	/**
	 * 删除产品服务
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteProductServiceById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				productServiceDao.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到产品服务信息
	 * 
	 * @param vo
	 * @return
	 */
	public ProductService getProductServiceById(ConditionVO vo) throws Exception {
		return productServiceDao.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增产品服务
	 * 
	 * @param entity
	 */
	public void saveOrUpdateProductServiceInfo(ProductService entity) throws Exception {
		if (entity.getSn() == null) {  
			productServiceDao.insert(entity);
		} else {
			productServiceDao.update(entity);
		}
	}

	/**
	 * 根据条件查询相关产品服务
	 * 
	 * @param vo
	 * @return
	 */
	public List<ProductService> queryProductServicesByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return productServiceDao.findPage(conditionMap);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<ProductService> queryProductServicesForPage(ConditionVO vo,
			Page<ProductService> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		return super.queryForPage(productServiceDao, conditionMap, page);
	}
}
