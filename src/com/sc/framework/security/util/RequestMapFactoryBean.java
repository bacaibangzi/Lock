package com.sc.framework.security.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.RequestKey;

/**
 * 启动过程中负责将所有的资源权限家在进入内存 Copyright:
 * 
 * @author: cuibin
 * 
 */
// @Service("requestMap")
// @Transactional
public class RequestMapFactoryBean implements FactoryBean
{
    private LinkedHashMap<RequestKey, Collection<ConfigAttribute>> requestMap;
    Map<String, List<ConfigAttribute>> info = new HashMap<String, List<ConfigAttribute>>();
    Logger log = LoggerFactory.getLogger(this.getClass());

    private void initRequestMap()
    {
        log.info("当前正在初始化权限缓存数据requestMap");
        requestMap = new LinkedHashMap<RequestKey, Collection<ConfigAttribute>>();
        log.info("requestMap初始化完毕");
        // Collection collection1 = new ArrayList();
        // collection1.add((new SecurityConfig("user_view")));
        // requestMap.put(new RequestKey("/contact/contact.action*"),
        // collection1);
        //
        // Collection collection2 = new ArrayList();
        // collection2.add((new SecurityConfig("user_debug")));
        // requestMap.put(new RequestKey("/contact/contact!debug.action*"),
        // collection2);
        //
        // Collection collection3 = new ArrayList();
        // collection3.add((new SecurityConfig("user_grant")));
        // requestMap.put(new RequestKey("/open/open*"), collection3);
        //
        // Collection collection4 = new ArrayList();
        // collection4.add((new SecurityConfig("user_grant")));
        // requestMap.put(new RequestKey("/contact/contact!privil.action*"),
        // collection4);
        //
        // Collection collection5 = new ArrayList();
        // collection5.add((new SecurityConfig("test")));
        // requestMap.put(new RequestKey("/js/jquery*"), collection5);
    }

    @Override
    public Object getObject() throws Exception
    {
        // TODO Auto-generated method stub
        if (requestMap == null)
        {
            initRequestMap();
        }
        return requestMap;
    }

    @Override
    public Class getObjectType()
    {
        // TODO Auto-generated method stub
        return LinkedHashMap.class;
    }

    @Override
    public boolean isSingleton()
    {
        // TODO Auto-generated method stub
        return true;
    }
}
