package com.rita.model;

import lombok.Data;

import java.util.List;

/**
 * layui中table组件默认数据交换格式
 */

@Data
public class DataGridView {
	private Integer	code = 0;
	private String msg = "";
	private Integer count;
	private List<Object> data;
}
