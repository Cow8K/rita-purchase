package com.rita.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rita.mapper.ResultsMapper;
import com.rita.model.Results;
import com.rita.service.ResultsService;

@Service
public class ResultsServiceImpl implements ResultsService{
	@Autowired
	private ResultsMapper resultsMapper;
	
	@Override
	public List<Object> selResults(Results results) {
		return resultsMapper.selResults(results);
	}
	
	@Override
	public List<Object> selResultsMap(Map<String, Object> map) {
		return resultsMapper.selResultsMap(map);
	}
	
	@Override
	public void delResults(Results results) {
		resultsMapper.delResults(results);
	}
	
	@Override
	public void updateResults(Results results) {
		resultsMapper.updateResults(results);
	}
	
	@Override
	public void addResults(Results results) {
		resultsMapper.addResults(results);
	}
	
	@Override
	public Integer count(Results results) {
		return resultsMapper.count(results);
	}
}
