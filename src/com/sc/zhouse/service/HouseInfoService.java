package com.sc.zhouse.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.base.service.BaseService;
import com.sc.framework.utils.ContextUtil;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.zhouse.dao.HouseInfoMapper;
import com.sc.zhouse.pojo.HouseInfo;

@Service
public class HouseInfoService extends BaseService<HouseInfo>{
	@Autowired
	HouseInfoMapper houseInfoMapper;

	
	public boolean deleteHouseInfoById(String  id)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			conditionMap.put("sn", id);
			houseInfoMapper.delete(conditionMap);
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}
	
	
	// 区域
	public List<Map<String,String>> queryHouseLevel2(String lat,String lon , String fangShi) throws Exception{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		SqlSessionFactory  sqlSessionFactory  = (SqlSessionFactory)ContextUtil.getContext().getBean("sqlSessionFactory");
		SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionFactory);
		Connection conn = sqlSession.getConnection();
		
		Statement stmt= null;
		ResultSet  rs = null;
		String sql = " select "
				+ "count(1)  as tj , tt.area_name ,tt.area_code , tt.lon ,tt.lat "
				+ "from "
				+ "("
				+ "select "
				+ "ROUND(6378.138*2*ASIN(SQRT(POW(SIN(( "+lat+" *PI()/180-lat*PI()/180)/2),2)+COS( "+lat+" *PI()/180)*COS(lat*PI()/180)*POW(SIN(("+lon+"  *PI()/180-lon*PI()/180)/2),2))))   as juli ,"
				+ "t.area_code , t.area_name , t.lon ,t.lat "
				+ "from "
				+ "("
				+ "select  t1.area_code ,  ifnull(t2.lon,0)  as lon  , ifnull( t2.lat,0)  as lat , t2.area_name "
				+ "from "
				+ "("
				+ "select   left( xiao_qu , length(xiao_qu)-2  )  as area_code       from house_info   where ifnull(xiao_qu,'')  <> '' and fang_shi = '"+fangShi+"' and shen_he =1 "
				+ ") t1  "
				+ "left join "
				+ "dev_area_info t2 "
				+ "on t1.area_code = t2.area_code "
				+ ") t"
				+ ") tt  "
				+ "where tt.juli <=50  group by tt. area_code ,tt.area_name ";
		
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { 
				String tj = rs.getString(1);
				String name = rs.getString(2);
				String code = rs.getString(3);
				String lon1 = rs.getString(4);
				String lat1 = rs.getString(5);
				Map<String,String> areaMap = new HashMap<String,String>();
				areaMap.put("tj", tj);
				areaMap.put("name", name);
				areaMap.put("code", code);
				areaMap.put("lon", lon1);
				areaMap.put("lat", lat1);
				list.add(areaMap);
			}
			
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return list;
	}
	

	// 小区
	public List<Map<String,String>> queryHouseLevel3(String lat,String lon ,  String fangShi) throws Exception{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		SqlSessionFactory  sqlSessionFactory  = (SqlSessionFactory)ContextUtil.getContext().getBean("sqlSessionFactory");
		SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionFactory);
		Connection conn = sqlSession.getConnection();
		
		Statement stmt= null;
		ResultSet  rs = null;
		String sql = " select "
				+ "count(1)  as tj , tt.area_name ,tt. area_code , tt.lon ,tt.lat "
				+ "from "
				+ "("
				+ "select "
				+ "ROUND(6378.138*2*ASIN(SQRT(POW(SIN(( "+lat+" *PI()/180-lat*PI()/180)/2),2)+COS( "+lat+" *PI()/180)*COS(lat*PI()/180)*POW(SIN(("+lon+"  *PI()/180-lon*PI()/180)/2),2))))   as juli ,"
				+ "t.area_code , t.area_name , t.lon ,t.lat  "
				+ "from "
				+ "("
				+ "select  t1.area_code ,  ifnull(t2.lon,0)  as lon  , ifnull( t2.lat,0)  as lat , t2.area_name "
				+ "from "
				+ "("
				+ "select  xiao_qu as area_code       from house_info   where  ifnull(xiao_qu,'') <> '' and fang_shi = '"+fangShi+"'   and shen_he =1"
				+ ") t1  "
				+ "left join "
				+ "dev_area_info t2 "
				+ "on t1.area_code = t2.area_code "
				+ ") t"
				+ ") tt  "
				+ "where tt.juli <=50  group by tt. area_code ,tt.area_name ";
		
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { 
				String tj = rs.getString(1);
				String name = rs.getString(2);
				String code = rs.getString(3);
				String lon1 = rs.getString(4);
				String lat1 = rs.getString(5);
				Map<String,String> areaMap = new HashMap<String,String>();
				areaMap.put("tj", tj);
				areaMap.put("name", name);
				areaMap.put("code", code);
				areaMap.put("lon", lon1);
				areaMap.put("lat", lat1);
				list.add(areaMap);
			}
			
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return list;
	}
	
	// 小区字典
	public List<Map<String,String>> queryHouseLevel1(String lat,String lon ) throws Exception{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		SqlSessionFactory  sqlSessionFactory  = (SqlSessionFactory)ContextUtil.getContext().getBean("sqlSessionFactory");
		SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionFactory);
		Connection conn = sqlSession.getConnection();
		
		Statement stmt= null;
		ResultSet  rs = null;
		String sql = " select "
				+ " tt.area_name ,tt. area_code , tt.lon ,tt.lat "
				+ "from "
				+ "("
				+ "select "
				+ "ROUND(6378.138*2*ASIN(SQRT(POW(SIN(( "+lat+" *PI()/180-lat*PI()/180)/2),2)+COS( "+lat+" *PI()/180)*COS(lat*PI()/180)*POW(SIN(("+lon+"  *PI()/180-lon*PI()/180)/2),2))))   as juli ,"
				+ "t.area_code , t.area_name , t.lon ,t.lat  "
				+ "from "
				+ "("
				+ "select  ifnull(t2.lon,0)  as lon  , ifnull( t2.lat,0)  as lat , t2.area_name ,t2.area_code "
				+ "from " 
				+ "dev_area_info t2  where t2.qy = 1 " 
				+ ") t"
				+ ") tt  "
				+ "where tt.juli <=50  ";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { 
				String name = rs.getString(1);
				String code = rs.getString(2);
				String lon1 = rs.getString(3);
				String lat1 = rs.getString(4);
				Map<String,String> areaMap = new HashMap<String,String>();
				areaMap.put("name", name);
				areaMap.put("code", code);
				areaMap.put("lon", lon1);
				areaMap.put("lat", lat1);
				list.add(areaMap);
			}
			
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 * @throws Exception
	 */
	public List<HouseInfo> queryHouseInfoByLocation(String lat,String lon,String houseType,String xingType,String huXingType,String zhuangXiuType,String priceType) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("lat", lat);
		conditionMap.put("lon", lon);

		conditionMap.put("fangShi", houseType);
		
		if("¥150以下".equals(priceType)){
			conditionMap.put("zuJin1", 0);
			conditionMap.put("zuJin2", 150);
		}else if("¥150-300".equals(priceType)){
			conditionMap.put("zuJin1", 150);
			conditionMap.put("zuJin2", 300);
		}else if("¥301-450".equals(priceType)){
			conditionMap.put("zuJin1", 301);
			conditionMap.put("zuJin2", 450);
		}else if("¥451-600".equals(priceType)){
			conditionMap.put("zuJin1", 451);
			conditionMap.put("zuJin2", 600);
		}else if("¥600-1000".equals(priceType)){
			conditionMap.put("zuJin1", 600);
			conditionMap.put("zuJin2", 1000);
		}else if("¥1000以上".equals(priceType)){
			conditionMap.put("zuJin1", 1000);
			conditionMap.put("zuJin2", 999999);
		}
		
		if("酒店".equals(houseType)){
			if(!"不限".equals(xingType)){
				conditionMap.put("chaoXiang", xingType);
			}
			
		}else{
			if(!"不限".equals(zhuangXiuType)){
				conditionMap.put("zhuangXiu", zhuangXiuType);
			}
			if("1居".equals(huXingType)){
				conditionMap.put("huXing1", 1);
				conditionMap.put("huXing2", 1);
			}else if("2居".equals(huXingType)){
				conditionMap.put("huXing1", 2);
				conditionMap.put("huXing2", 2);
			}else if("3居".equals(huXingType)){
				conditionMap.put("huXing1", 3);
				conditionMap.put("huXing2", 3);
			}else if("4居".equals(huXingType)){
				conditionMap.put("huXing1", 4);
				conditionMap.put("huXing2", 4);
			}else if("5居".equals(huXingType)){
				conditionMap.put("huXing1", 5);
				conditionMap.put("huXing2", 5);
			}else if("5居以上".equals(huXingType)){
				conditionMap.put("huXing1", 6);
				conditionMap.put("huXing2", 999);
			}
		}
		
		List<HouseInfo> houseInfoList = houseInfoMapper.queryByLocation(conditionMap);
		return houseInfoList;
	}
	
	
	/**
	 * 删除APP
	 * 
	 * @param vo
	 * @return
	 */
	public boolean deleteHouseInfoById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				houseInfoMapper.delete(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 审核APP
	 * 
	 * @param vo
	 * @return
	 */
	public boolean shById(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			for (String id : vo.getEntityIds().split(",")) {
				conditionMap.put("sn", id);
				conditionMap.put("shenHe", vo.getValue());
				houseInfoMapper.sh(conditionMap);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return true;
	}

	/**
	 * 根据Id得到APP信息
	 * 
	 * @param vo
	 * @return
	 */
	public HouseInfo getHouseInfoById(ConditionVO vo) throws Exception {
		return houseInfoMapper.getById(Long.parseLong(vo.getEntityId()));
	}

	/**
	 * 保存或新增APP
	 * 
	 * @param entity
	 */
	public void saveOrUpdateHouseInfoInfo(HouseInfo entity) throws Exception {
		if (entity.getSn() == null) {  
			houseInfoMapper.insert(entity);
		} else {
			houseInfoMapper.update(entity);
		}
	}

	/**
	 * 根据条件查询相关APP
	 * 
	 * @param vo
	 * @return
	 */
	public List<HouseInfo> queryHouseInfosByCondition(ConditionVO vo)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId", vo.getEntityId());
		return houseInfoMapper.findPage(conditionMap);
	}
	
	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<HouseInfo> queryHouseInfosByHouseCodeForPage(ConditionVO vo,
			Page<HouseInfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("xiaoQu", vo.getCode());
		conditionMap.put("fangShi", vo.getCode1());
		conditionMap.put("shenHe", "1");
		return super.queryForPage(houseInfoMapper, conditionMap, page);
	}

	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<HouseInfo> queryHouseInfosForPage(ConditionVO vo,
			Page<HouseInfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId", vo.getEntityId());
		conditionMap.put("shenHe", vo.getShFilter());
		if(vo.getNameFilter()!=null)
		conditionMap.put("biaoTi", java.net.URLDecoder.decode(vo.getNameFilter(),"UTF-8"));
		if(vo.getFlag()!=null)
		conditionMap.put("fangShi", java.net.URLDecoder.decode(vo.getFlag(),"UTF-8"));
		return super.queryForPage(houseInfoMapper, conditionMap, page);
	}
	
	/**
	 * 根据条件分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public Page<HouseInfo> queryHouseInfosPublishForPage(ConditionVO vo,
			Page<HouseInfo> page)  throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("state", vo.getValue());
		conditionMap.put("name", vo.getNameFilter());
		return super.queryForPage(houseInfoMapper, conditionMap, page); 
	}
	
	/**
	 * 根据条件查询相关APP
	 * 
	 * @param vo
	 * @return
	 */
	public Page<HouseInfo> queryHouseInfosByUserCondition(Map<String, Object> conditionMap,
			Page<HouseInfo> page)  throws Exception{
		return super.queryForPage(houseInfoMapper, conditionMap, page);
	}
}
