<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/src/layuiadmin/layui/css/layui.css" media="all">
<style type="text/css">
	/* 关于图片的显示 
	.layui-table-cell {
	     height: 40px!important;
	     white-space: normal;
	} */
	.layui-table-cell img {
		width: 35px;
	}
</style>
<title>采购单管理页面</title>
</head>
<body>
	<table id="studentsList" lay-filter="test"></table>
	
	<script type="text/html" id="topToolBar">
		<div class="layui-inline">
			<label for="purchaseOrderNumber"></label>
			<input class="layui-input" name="purchaseOrderNumber" id="purchaseOrderNumber" placeholder="采购单号" autocomplete="off">
		</div>
		<div class="layui-inline">
			<label for="supplierName"></label>
			<input class="layui-input" name="supplierName" id="supplierName" placeholder="供应商名称" autocomplete="off">
		</div>
		<div class="layui-input-inline">
			<label for="purchaseOrderStatus"></label>
			<select name="purchaseOrderStatus" id="purchaseOrderStatus">
				<option value="">采购单状态</option>
				<option value="1">已下单</option>
				<option value="2">已入库</option>
				<option value="3">在途</option>
			</select>
		</div>
		<div class="layui-btn-group">
			<button class="layui-btn" lay-event="search">搜索</button>
			<button class="layui-btn" lay-event="add">添加</button>
			<button class="layui-btn" lay-event="multiDelete">删除</button>
		</div>
	</script>
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="addScores">添加成绩</a>
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="scores">成绩</a>
  		<a class="layui-btn layui-btn-xs" lay-event="detail">详情</a>
	</script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/src/layuiadmin/layui/layui.js"></script>
	
	<script type="text/javascript">
	
		layui.use(['table', 'jquery', 'layer', 'form'], function() {
			let table = layui.table, $ = layui.jquery, layer = layui.layer, form = layui.form;
			table.render({
				elem: '#studentsList',
				url: '${pageContext.request.contextPath}/purchase/order/search.action',
				method: 'post',
				page: true,
				toolbar: '#topToolBar',
				done: function(res, curr, count) {
					console.log("服务器返回数据: ", res, "数据数量: ", count)
				},
				cols: [
					[
						{
							type: 'checkbox',
							fixed: 'left',
						},
						{
							field: 'orderNumber',
							title: '采购单编号',
							sort: true,
							align: 'center',
							templet: function (data) {
								return data ? `<div>\${data.orderNumber}</div>` : ``;
							},
						},
						{
							field: 'supplier',
							title: '供应商名称',
							sort: true,
							align: 'center',
							templet: function (data) {
								return data ? `<div>\${data.supplier}</div>` : ``;
							},
						},
						{
							field: 'productImg',
							title: '产品图片',
							align: 'center',
							templet: function (data) {
								if (!data.img)
									return '<img alt="未上传产品图片" src="">';
								else
									return `<img src="${pageContext.request.contextPath}/\${data.img}" alt="产品图片"/>`
							},
						},
						{
							field: 'remark',
							title: '备注',
							align: 'center',
							templet: function (data) {
								return '<input type="checkbox"'
										+ (data.status === 1 ? 'checked' : '')
										+ ' id=' + data.id
										+ ' lay-filter="switchTest" lay-skin="switch" lay-text="在学|休学">';
							},
						},
						{
							field: 'realPaid',
							title: '实际支付（￥）',
							align: 'center',
							sort: true,
							templet: function (data) {
								return data ? `<div>\${data.realPaid}</div>` : ``;
							}
						},
						{
							field: 'purchaseOrderStatus',
							title: '状态',
							align: 'center',
							sort: true
						},
						{
							field: 'createTime',
							title: '创建时间',
							align: 'center',
							sort: true
						},
						{
							field: 'edit',
							title: '操作',
							align: 'center',
							toolbar: '#barDemo',
							fixed: 'right',
						}
					],
				]
			}) // table.render
			
			// 头部事件处理
			table.on('toolbar(test)', function(obj){
				let event = obj.event;
				let stuId = $('#stuId').val();
				let className = $('#className').val();
				let studentName = $('#studentName').val();
			    if (event === 'search') {
			    	if (!className && !stuId && !studentName) {
			    		// 未输入任何值点击搜索按钮时，刷新页面，因为如果之前进行过搜索，那么limit为null，刷新以重置limit值
			    		location.reload()
			    	} else {
				    	table.reload('studentsList', {
							url : '${pageContext.request.contextPath}/purchase/order/search.action',
							where : {
								classId: className || 0,
								id: stuId || 0,
								name: studentName || null,
								// 当是搜索时，设置为null，对应后台的条件检查 if (pageOV.getLimit() != null)
								limit: null
							}
						});
				    	getClassNameList()
			    	} // else
			    } else if (event === 'multiDelete') {
			    	if (ids.length === 0) {
			    		return;
			    	}

					layer['confirm']('确认删除？', {
						success: function(layerObj, index){
							// 点击esc关闭弹出层
							this.esc = function(event){
								if(event.keyCode === 27){
									layer.close(index);
									return false; //阻止系统默认回车事件
								}
							};
							$(document).on('keydown', this.esc); //监听键盘事件，关闭层
						},
						end: function(){
							$(document).off('keydown', this.esc);	//解除键盘关闭事件
						}
					}, function(index) {
						table['reload']('studentsList', {
							url: '${pageContext.request.contextPath}/students/delStudents.action',
							where: { ids: ids },
							page: { curr: 1  }
						});
						layer.close(index);
						getClassNameList()
					})
			    } else if (event === 'add') {
					layer.open({
						type: 2, 
						content: '${pageContext.request.contextPath}/src/views/studentForm.jsp',
						area: ['100%', '100%'],
						shadeClose: true,
						success: function(layero, index){
							// 点击esc关闭弹出层
						    this.esc = function(event){
						      if(event.keyCode === 27){
						        layer.close(index);
						        return false; //阻止系统默认回车事件
						      }
						    };
						    $(document).on('keydown', this.esc); //监听键盘事件，关闭层
					    },
					    end: function(){
					      $(document).off('keydown', this.esc);	//解除键盘关闭事件
					    }
					}); 
			    }
			    
			}); // table.on
			
			// 行内工具栏事件
			table.on('tool(test)', function(obj){ // test是table原始容器的属性 lay-filter="对应的值"
				  let data = obj.data; // 获得当前行数据
				  let event = obj.event; // 获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
				  window.myData = data;
				  if (event === 'del') {
					  layer['confirm']('确认删除？', {
						  success: function(layerObj, index){
								// 点击esc关闭弹出层
							    this.esc = function(event){
							      if(event.keyCode === 27){
							        layer.close(index);
							        return false; //阻止系统默认回车事件
							      }
							    };
							    $(document).on('keydown', this.esc); //监听键盘事件，关闭层
						    },
						    end: function(){
						      $(document).off('keydown', this.esc);	//解除键盘关闭事件
						    }
					    }, function(index){
						  table.reload('studentsList', {
								url : '${pageContext.request.contextPath}/students/delStudents.action',
								where : { id: data.id }
							});
					      layer.close(index);
				    	});
				  	} else if (event === 'scores') {
				  		layer.open({
							type: 2, 
							title: data.name + '的成绩',
							content: '${pageContext.request.contextPath}/students/editResults.action?stuId=' + data.id,
							area: ['40%', '60%'],
							shadeClose: true,
							success: function(layerObj, index){
								// 点击esc关闭弹出层
							    this.esc = function(event){
							      if(event.keyCode === 27){
							        layer.close(index);
							        return false; //阻止系统默认回车事件
							      }
							    };
							    $(document).on('keydown', this.esc); //监听键盘事件，关闭层
						    },
						    end: function(){
						      $(document).off('keydown', this.esc);	//解除键盘关闭事件
						    }
						}); 
				  	} else if (event === 'detail') {
				  		layer.open({
							type: 2, 
							content: '${pageContext.request.contextPath}/students/editStudent.action?id=' + data.id,
							area: ['100%', '100%'],
							shadeClose: true,
							success: function(layero, index){
								// 点击esc关闭弹出层
							    this.esc = function(event){
							      if(event.keyCode === 27){
							        layer.close(index);
							        return false; //阻止系统默认回车事件
							      }
							    };
							    $(document).on('keydown', this.esc); //监听键盘事件，关闭层
						    },
						    end: function(){
						      $(document).off('keydown', this.esc);	//解除键盘关闭事件
						    }
						});
				  	} else if (event === 'addScores') {
				  		layer.open({
							type: 2, 
							title: '为' + data.name + '添加成绩',
							content: '${pageContext.request.contextPath}/src/views/resultsForm.jsp',
							area: ['40%', '60%'],
							shadeClose: true,
							success: function(layerObj, index){
								// 点击esc关闭弹出层
							    this.esc = function(event){
							      if(event.keyCode === 27){
							        layer.close(index);
							        return false; //阻止系统默认回车事件
							      }
							    };
							    $(document).on('keydown', this.esc); //监听键盘事件，关闭层
						    },
						    end: function(){
						      $(document).off('keydown', this.esc);	//解除键盘关闭事件
						    }
						});
				  	}
			}); // table.on
			
			// 动态渲染下拉框
			function getClassNameList() {
				$.ajax({
					url: '${pageContext.request.contextPath}/classes/selClass.action',
					method: 'get',
					success: function(res) {
						let data = res.data;
						let html = '';
						data.forEach(function(item) {
							html += '<option value="' + item.id + '">' + item.className + '</option>';
						})
						$('#className').append(html);
						form.render('select');
					}
				})
			}
			getClassNameList()
			
			let ids = '';
			// 复选框事件
			table.on('checkbox(test)', function(obj){ 
				let checkStatus = table['checkStatus']('studentsList'); // 获取所有选中行的相关信息
				let data = checkStatus.data;
				ids = '';
				data.forEach(function(item) {
					ids += item.id + ',';
				})
			});
			
			// 监听switch按钮切换学生状态
			form.on('switch(switchTest)', function(res){
				let elem = res.elem;
				let data = {
						status: elem.checked ? 1 : 2,
						id: elem.id
					}
				$.ajax({
					url: "${pageContext.request.contextPath}/students/updateStatus.action",
					data: data,
					type: 'post',
					success: function() { console.log('status修改成功！') }
	 			})
				
			}); 
		})
	</script>
</body>
</html>