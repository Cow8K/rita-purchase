package com.rita.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rita.model.DataGridView;
import com.rita.model.PageOV;
import com.rita.model.Results;
import com.rita.service.ResultsService;

@Controller
@RequestMapping("results")
public class ResultsController {
	@Autowired
	private ResultsService resultsService;
	
	@RequestMapping("selResults")
	@ResponseBody
	public DataGridView selResults(Results results) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("selResultsMap")
	@ResponseBody
	public DataGridView selResultsMap(Results results, PageOV pageOV) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("delResults")
	@ResponseBody
	public Integer delResults(Results results) {
		return 0;
	}
	
	@RequestMapping("updateResults")
	@ResponseBody
	public void updateResults(Results results) {
	}
	
	@RequestMapping("addResults")
	@ResponseBody
	public void addResults(Results results) {
	}
}
