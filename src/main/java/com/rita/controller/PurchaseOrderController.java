package com.rita.controller;

import com.rita.bean.PurchaseOrder;
import com.rita.model.*;
import com.rita.query.PurchaseOrderQuery;
import com.rita.service.PurchaseOrderService;
import com.rita.service.ResultsService;
import com.rita.service.StudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("purchase/order")
public class PurchaseOrderController {
	@Resource
	private StudentsService studentsService;

	@Resource
	private ResultsService resultsService;

	@Resource
	private PurchaseOrderService purchaseOrderService;

	@RequestMapping("selStudents")
	@ResponseBody
	public DataGridView selStudents(Students students) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}

	@ResponseBody
	@RequestMapping("search")
	public DataGridView search(PurchaseOrderQuery purchaseOrderQuery, PageOV pageOV) {
		List<PurchaseOrder> purchaseOrderList;

		if (pageOV.getLimit() != null) {
			// 表格渲染时用
			pageOV.setPage((pageOV.getPage()-1) * pageOV.getLimit());
			Map<String, Object> map = new HashMap<>();
			map.put("purchaseOrder", purchaseOrderQuery);
			map.put("page", pageOV);
			purchaseOrderList = purchaseOrderService.queryPurchaseOrders(purchaseOrderQuery);
		}
		else {
			// 搜索时用
			purchaseOrderList = purchaseOrderService.queryPurchaseOrders(purchaseOrderQuery);
		}
		DataGridView dgv = new DataGridView();
		dgv.setData(purchaseOrderList);
		dgv.setMsg("查询成功！！");
		dgv.setCount(10);
		return dgv;
	}

	@RequestMapping("delStudents")
	@ResponseBody
	public DataGridView delStudents(Students students) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("updateStatus")
	@ResponseBody
	public void updateStatus(Students students) {

	}
	
	@RequestMapping("editResults")
	public String editResults(Results results, Model model) {
		return "";
	}
	
	@RequestMapping("getProvince")
	@ResponseBody
	public DataGridView getProvince(PCAList pcalist) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("getCity")
	@ResponseBody
	public DataGridView getCity(PCAList pcalist) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("getArea")
	@ResponseBody
	public DataGridView getArea(PCAList pcalist) {
		DataGridView dgv = new DataGridView();
		return dgv;
	}
	
	@RequestMapping("addStudent") 
	@ResponseBody
	public void addStudent(Students students) {
	}
	
	@RequestMapping("editStudent")
	public String editStudent(Students students, Model model) {
		return "editStudent";
	}
	
	@RequestMapping("updateStudent")
	@ResponseBody
	public Integer updateStudent(Students students) {
		return 200;
	}
}
