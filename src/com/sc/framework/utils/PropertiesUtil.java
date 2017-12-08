package com.sc.framework.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil
{
    public static Properties readProperties(String fileName)
    {
        Properties props = new Properties();
        try
        {
            props = PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName));
            return props;
        } catch (Exception e)
        {
            return null;
        }
    }

    public static Properties readPropertiesFile(String filePath)
    {
        if (!new File(filePath).exists())
        {
            return null;
        }
        Properties props = new Properties();
        InputStream in;
        try
        {
            in = new BufferedInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
            return null;
        }
        try
        {
            props.load(in);
            return props;
        } catch (Exception e)
        {
            return null;
        }
    }
}
