package com.rita.mapper;

import java.util.List;
import java.util.Map;

import com.rita.model.Classes;

public interface ClassMapper {
	List<Object> selClass(Classes classes);
	List<Object> selClassMap(Map<String, Object> map);
	void delClass(Classes classes);
	void updateClass(Classes classes);
	void addClass(Classes classes);
	Integer count(Classes classes);
	List<Object> existClassName(Classes classes);
}
