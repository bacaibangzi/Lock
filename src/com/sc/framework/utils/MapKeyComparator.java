package com.sc.framework.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.sc.system.pojo.UserRoleMenu;

public class MapKeyComparator<T> implements Comparator<String> {

	public static Map<String, UserRoleMenu> sortMapByKeyUserRoleMenu(Map<String, UserRoleMenu> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, UserRoleMenu> sortMap = new TreeMap<String, UserRoleMenu>(
				new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}
	
	public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Object> sortMap = new TreeMap<String, Object>(
				new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}

	public int compare(String str1, String str2) {
		return str1.compareTo(str2);
	}
}
