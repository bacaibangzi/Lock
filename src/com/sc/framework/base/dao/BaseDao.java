package com.sc.framework.base.dao;

/**
 * dao操作接口类
 * cuibin
 */
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	/**
	 * 生成主键
	 * 
	 * @param conditionMap
	 * @return
	 */
	public String nextValue(Map<String, Object> conditionMap) throws Exception;

	/**
	 * 最大版本号
	 * 
	 * @param conditionMap
	 * @return
	 * @throws Exception
	 */
	public String getMaxVersion(Map<String, Object> conditionMap) throws Exception;
	
	/**
	 * 添加
	 * 
	 * @param
	 * @return
	 */
	public void insert(T entity) throws Exception;

	/**
	 * 批量添加
	 * 
	 * @param
	 * @return
	 */
	public void batchInsert(List<T> list) throws Exception;

	/**
	 * 修改
	 * 
	 * @param
	 * @return
	 */
	public void update(T entity) throws Exception;

	/**
	 * 删除
	 * 
	 * @param
	 * @return
	 */
	public int delete(Map<String, Object> conditionMap) throws Exception;

	/**
	 * 删除
	 * 
	 * @param
	 * @return
	 */
	public int batchDelete(Map<String, Object> conditionMap) throws Exception;

	/**
	 * 根据ID查找
	 * 
	 * @param
	 * @return
	 */
	public T getById(Long systemId) throws Exception;

	/**
	 * 根据条件统计分页
	 * 
	 * @param
	 * @return
	 */
	public int findPageCount(Map<String, Object> conditionMap) throws Exception;

	/**
	 * 根据条件查询分页
	 * 
	 * @param
	 * @return
	 */
	public List<T> findPage(Map<String, Object> conditionMap) throws Exception;

	/**
	 * 根据条件查询
	 * 
	 * @param
	 * @return
	 */
	public List<T> query(Map<String, Object> conditionMap) throws Exception;

	/**
	 * queryForPage
	 * 
	 * @param conditionMap
	 * @param page
	 * @param bs
	 * @return public abstract Page<T> queryForPage(Map<String, Object>
	 *         conditionMap, Page<T> page, boolean... bs);
	 */
	/**
	 * 
	 public Page<T> queryForPage(Map<String, Object> conditionMap, Page<T>
	 * page, boolean... bs) { if (bs.length == 0 || bs[0] == true) { //
	 * 不传值或传入的值为true则进行数据库页数查询 Object count; try { count =
	 * this.findPageCount(conditionMap);
	 * page.setTotalCount(Integer.parseInt(count.toString()));
	 * page.getTotalPages(); } catch (Exception e) { log.error("分页总数取出错误", e); }
	 * }
	 * 
	 * conditionMap.put("oracleStart", (page.getPageNo() - 1)
	 * page.getPageSize()); conditionMap.put("oracleEnd", page.getPageNo() *
	 * page.getPageSize());
	 * 
	 * List<T> result = this.findPage(conditionMap); page.setResult(result);
	 * return page; }
	 */
}
