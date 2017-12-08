package com.sc.framework.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 返回ApplicationContext
 * 
 */
@Service
public class ContextUtil
{
    /**
     * ApplicationContext实例
     */
    private static ApplicationContext context;

    public static ApplicationContext getContext()
    {
        return context;
    }

    public void setContext(ApplicationContext context)
    {
        ContextUtil.context = context;
    }
}
