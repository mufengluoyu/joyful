<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>列表</title>
<%@ include file="/webpage/common.jsp" %>

<style type="text/css">
	body{background: url('${baseUrl}/webpage/images/bg5.jpg') no-repeat;background-size: 100% 100%;}
	.searchTable{width: 100%;margin: 10px 0;border-collapse:separate;border-spacing:10px;}
	.searchButton {float: right;margin-right: 10px;width: 80px;height: 40px;font-size: 120%;font-weight: bold;}
</style>


</head>

<body>
	<%@ include file="/webpage/head.jsp" %>
	
	<!-- 内容开始 -->
	<div class="container" style="background-color: #E9E4E4;">
<%-- 		<div class="row" style="background: url('${baseUrl}/webpage/images/top_bg.jpg') no-repeat;background-size: 100% 100%;height: 80px;"> --%>
<!-- 		</div> -->
		<!-- 
		<div class="row" style="background-color: #FFF;">
			<div class="col-lg-12" style="height: 200px;border: 1px dashed #000;">
				<div class="input-group" style="width: 25%; margin: 10px 0;">
	               <input type="text" class="form-control" placeholder="请输入搜索内容" value="">
	               <span class="input-group-btn">
	                  <button class="btn btn-default" type="button">搜索</button>
	               </span>
	            </div>
			</div>
		</div>
		 -->
		
		<!-- 搜索框开始 -->
		<div class="row" style="background: url('${baseUrl}/webpage/images/1.png') no-repeat;background-color: #FFF;">
			<div class="col-lg-12" style="height: 180px;">
				<form id="searchForm" name="searchForm" action="${baseUrl}/userController/userList.do" method="post">
					<input id="pageNum" name="pageNum" type="hidden" value="${page.pageNum}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<table class="searchTable">
						<thead>
							<tr>
								<th style="text-align: right;">输入信息:</th>
								<th><input type="text" class="form-control" placeholder="请输入搜索内容" value=""></th>
								<th style="text-align: right;">开始时间:</th>
								<th>
									<input type="text" id="beginTime" class="form-control" placeholder="请输入搜索内容" value="" 
										onclick="timeBegin('#endTime')">
								</th>
								<th style="text-align: right;">结束时间:</th>
								<th>
									<input type="text" id="endTime" class="form-control" placeholder="请输入搜索内容" value="" 
										onclick="timeEnd('#beginTime')">
								</th>
							</tr>
							
							<tr >
								<th style="text-align: right;">数据日期为:</th>
								<th><input type="text" class="form-control" placeholder="请输入搜索内容" value="" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></th>
								<th style="text-align: right;">选择项:</th>
								<th>
									<select class="form-control">
										<option value="1" selected="selected">全部</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
									</select>
								</th>
								<th style="text-align: right;"></th>
								<th></th>
							</tr>
						</thead>
					</table>
					
					<button class="btn btn-primary searchButton" type="submit">搜索</button>
				</form>
			</div>
		</div>
		<!-- 搜索框结束 -->
		
		<!-- 列表信息开始 -->
		<div class="row" style="margin-top: 15px;background-color: #fff;">
			<div class="col-lg-12" style="min-height: 600px;padding-top: 15px;">
				<button class="btn btn-primary" type="button" onclick="excelImport();">导入</button>
				<button class="btn btn-primary" type="button">导出</button>
				
				<div class="table-responsive" style="margin: 10px 0;">
					<table class="table table-bordered table-hover table-responsive">
						<thead>
							<tr>
								<th>名称</th>
								<th>城市</th>
								<th>密码</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.result }">
								<tr>
									<td>${item.userName }</td>
									<td>${item.password }</td>
									<td>${item.age }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<!-- 分页开始 -->
				<div align="center" style="width: 100%;margin: auto;">
					<ul  class="pagination">
					 ${pageStr }
					</ul>
				</div>
				<!-- 分页结束 -->

			</div>
		</div>
		<!-- 列表信息结束 -->
<%-- 		<div class="row" style="background: url('${baseUrl}/webpage/images/end_bg.jpg') no-repeat;background-size: 100% 100%;height: 80px;"> --%>
<!-- 		</div> -->

		<!-- 柱形图demo -->
	 	<div id="demo1" style="width: 600px;height:400px;"></div>
		
		<!-- 复杂曲线图demo -->
	 	<div id=demo2 style="width: 600px;height:400px;"></div>
	 	
	</div>
	<!-- 内容结束 -->
	
<script type="text/javascript">
function excelImport(){
	//页面层-自定义
	layer.open({
	  type: 1,
	  title: "上传",
	  offset: ['40%', '40%'],
	  closeBtn: 0,
	  shadeClose: false,
	  content: '<form action="'+baseUrl+'/userController/import.do" method="post" enctype="multipart/form-data"> <input type="file" style="margin: 10px;font-size: 120%;" name="file" size="50" /> <input type="submit" class="btn btn-primary" style="margin: 10px;" value="上传" /> <button class="btn btn-default" style="margin: 10px;" type="button" onclick="layer.closeAll()">取消</button> </form>'
	});
}
function page(pageNum,pageSize,funcParam){
	$("#pageNum").val(pageNum);
	$("#pageSize").val(pageSize);
	$("#searchForm").submit();
	return false;
}

$(function (){
	// 基于准备好的dom，初始化echarts实例
	var myChart1 = echarts.init(document.getElementById('demo1'));
	// 指定图表的配置项和数据
	var option1 = {
		title : {
			text : 'ECharts 示例'
		},
		tooltip : {},
		legend : {
			data : [ '销量' ]
		},
		xAxis : {
			data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
		},
		yAxis : {},
		series : [ {
			name : '销量',
			type : 'bar',
			data : [ 5, 20, 36, 10, 10, 20 ]
		} ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart1.setOption(option1);



	// 基于准备好的dom，初始化echarts实例
	var myChart2 = echarts.init(document.getElementById('demo2'));
	// 指定图表的配置项和数据
	var option2 = {
		title : {
			text : 'demo'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎' ]
		},
		toolbox : {
			feature : {
				saveAsImage : {}
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '邮件营销',
			type : 'line',
			stack : '总量',
			areaStyle : {
				normal : {}
			},
			data : [ 120, 132, 101, 134, 90, 230, 210 ]
		}, {
			name : '联盟广告',
			type : 'line',
			stack : '总量',
			areaStyle : {
				normal : {}
			},
			data : [ 220, 182, 191, 234, 290, 330, 310 ]
		}, {
			name : '视频广告',
			type : 'line',
			stack : '总量',
			areaStyle : {
				normal : {}
			},
			data : [ 150, 232, 201, 154, 190, 330, 410 ]
		}, {
			name : '直接访问',
			type : 'line',
			stack : '总量',
			areaStyle : {
				normal : {}
			},
			data : [ 320, 332, 301, 334, 390, 330, 320 ]
		}, {
			name : '搜索引擎',
			type : 'line',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'top'
				}
			},
			areaStyle : {
				normal : {}
			},
			data : [ 820, 932, 901, 934, 1290, 1330, 1320 ]
		} ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart2.setOption(option2);
	
});	

</script>
</body>
</html>
