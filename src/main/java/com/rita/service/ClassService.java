package com.rita.service;

import java.util.List;
import java.util.Map;

import com.rita.model.Classes;

public interface ClassService {

	List<Object> selClass(Classes classes);

	void delClass(Classes classes);

	void updateClass(Classes classes);

	void addClass(Classes classes);

	Integer count(Classes classes);

	List<Object> selClassMap(Map<String, Object> map);

	List<Object> existClassName(Classes classes);
	
}
