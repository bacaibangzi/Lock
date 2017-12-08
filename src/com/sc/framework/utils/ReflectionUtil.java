package com.sc.framework.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionUtil {
	/**
	 * <p>
	 * 注入数据
	 * </p>
	 * 
	 * @param obj
	 * @param paramName
	 * @param value
	 */
	public final static void register(Object obj, String paramName, String value) {

		Class<?> clazz = obj.getClass();
		Method[] methods = clazz.getMethods();// 返回这个类里面方法的集合
		char[] ch = paramName.toCharArray();
		ch[0] = Character.toUpperCase(ch[0]);
		String s = new String(ch);
		String[] names = new String[] { ("set" + s).intern(),
				("get" + s).intern(), ("is" + s).intern(),
				("read" + s).intern() };
		Method setter = null;
		Method getter = null;
		int length = methods.length;
		for (int i = 0; i < length; ++i) {
			Method method = methods[i];
			/**
			 * 检查该方法是否为公共方法,如果非公共方法就继续
			 */
			if (!Modifier.isPublic(method.getModifiers()))
				continue;
			String methodName = method.getName();

			for (String name : names) {
				if (name.equals(methodName)) {
					if (name.startsWith("set") || name.startsWith("read"))
						setter = method;
					else if (name.startsWith("get") || name.startsWith("is"))
						getter = method;

				}
			}
		}
		Object[] param = buildParam(getter.getReturnType().getName(), value);
		try {
			setter.invoke(obj, param);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据注入失败:" + e.getMessage());
		}
	}

	/**
	 * <p>
	 * 构造注入数据的参数
	 * </p>
	 * 
	 * @param paramType
	 * @param value
	 * @return Object[]
	 */
	private final static Object[] buildParam(String paramType, String value) {
		Object[] param = new Object[1];
		if (paramType.equalsIgnoreCase("java.lang.String")) {
			param[0] = new String(value);
		} else if (paramType.equalsIgnoreCase("int")
				|| paramType.equalsIgnoreCase("Integer")) {
			param[0] = new Integer(value);
		} else if (paramType.equalsIgnoreCase("long")) {
			param[0] = new Long(value);
		} else if (paramType.equalsIgnoreCase("double")) {
			param[0] = new Double(value);
		} else if (paramType.equalsIgnoreCase("float")) {
			param[0] = new Float(value);
		} else if (paramType.equalsIgnoreCase("char")
				|| paramType.equalsIgnoreCase("Character")) {
			param[0] = Character.valueOf(value.charAt(0));
		}
		return param;
	}
}
