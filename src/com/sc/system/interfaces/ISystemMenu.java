package com.sc.system.interfaces;

import java.util.List;
import java.util.Map;

import com.sc.system.pojo.SystemMenu;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public interface ISystemMenu{
	
    /**
     * @brief   功能: 新增/修改
     * @param   entity: SystemMenu对象
     * @return  true: 成功;false: 失败
     */
    public boolean saveSystemMenu(SystemMenu entity);

    /**
     * @brief 功能: 根据id进行删除
     * @param systemId: 待删除对象id
     * @return true: 成功；false: 失败
     */
    public boolean deleteSystemMenuById(Long systemId);

    /**
     * @brief 功能: 根据id进行查询
     * @param systemId: 待查询对象id
     * @return SystemMenu: 查询结果对象
     */
    public SystemMenu getSystemMenuById(Long systemId);

    /**
     * @brief 功能: 分页查询
     * @param conditionMap: 查询条件
     * @param page: 分页对象
     */
    public List<SystemMenu> querySystemMenusForPage(Map<String, Object> conditionMap);

}
