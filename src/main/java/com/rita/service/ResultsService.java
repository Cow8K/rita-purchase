package com.rita.service;

import java.util.List;
import java.util.Map;

import com.rita.model.Results;

public interface ResultsService {

	List<Object> selResults(Results results);

	void delResults(Results results);

	void updateResults(Results results);

	void addResults(Results results);

	List<Object> selResultsMap(Map<String, Object> map);

	Integer count(Results results);

}
