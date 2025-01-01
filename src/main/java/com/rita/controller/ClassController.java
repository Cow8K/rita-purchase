package com.rita.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rita.model.Classes;
import com.rita.model.DataGridView;
import com.rita.model.PageOV;
import com.rita.service.ClassService;

@Controller
@RequestMapping("classes")
public class ClassController {
	@Autowired
	private ClassService classService; 
	
	@RequestMapping("selClass")
	@ResponseBody
	public DataGridView selClass(Classes classes) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("selClassMap")
	@ResponseBody
	public DataGridView selClassMap(Classes classes, PageOV pageOV) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("delClass")
	@ResponseBody
	public void delClass(Classes classes) {

	}
	
	@RequestMapping("updateClass")
	@ResponseBody
	public Integer updateClass(Classes classes) {
		return -1;
	}
	
	@RequestMapping("addClass")
	@ResponseBody
	public Integer addClass(Classes classes) {
		return -1;
	}
}
