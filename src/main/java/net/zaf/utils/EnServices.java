package net.zaf.utils;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.aop.Enhancer;

@SuppressWarnings({"unchecked", "rawtypes"})
public class EnServices {

	private static Map<String, Object> services;
	
	public static Object enService(Class clazz) {
		
		Object service = getService(clazz.getName());
		
		if (service == null) {
			
			service = setService(clazz);
			
		}
		
		return service;
	}
	
	private static Object setService(Class clazz) {
		
		if (services == null) {
			
			services = new HashMap<String, Object>();
			
		}
		
		Object service = Enhancer.enhance(clazz);
		
		services.put(clazz.getName(), service);
		
		return service;
	}
	
	private static Object getService(String className) {
		
		if (services == null) {
			
			services = new HashMap<String, Object>();
			
		}
		
		return services.get(className);
	}
}
