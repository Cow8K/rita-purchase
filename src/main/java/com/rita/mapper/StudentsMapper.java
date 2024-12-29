package com.rita.mapper;

import java.util.List;
import java.util.Map;

import com.rita.model.PCAList;
import com.rita.model.Students;

public interface StudentsMapper {
	List<Object> selStudentsMap(Map<String, Object> map);
	List<Object> selStudents(Students students);
	void delStudents(Students students);
	void updateStatus(Students students);
	List<Object> getProvince(PCAList pcaList);
	List<Object> getCity(PCAList pcalist);
	List<Object> getArea(PCAList pcalist);
	void addStudent(Students students);
	void updateStudent(Students students);
	Integer count(Students students);
}
