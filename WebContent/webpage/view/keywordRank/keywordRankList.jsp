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
		<!-- 搜索框开始 -->
		<div class="row" style="background: url('${baseUrl}/webpage/images/1.png') no-repeat;background-color: #FFF;">
			<div class="col-lg-12" style="height: 180px;">
				<form id="searchForm" name="searchForm" action="${baseUrl}/keywordRankController/keywordRankList.do" method="post">
					<input id="pageNum" name="pageNum" type="hidden" value="${page.pageNum}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<table class="searchTable">
						<thead>
							<tr>
								<th style="text-align: right;">类型：</th>
								<th><select name="type" id="type" class="form-control" >
										<option value="1">百度</option>
										<option value="2">神马</option>
									</select>
								</th>
								<th style="text-align: right;">前十排序字段：</th>
								<th><select name="orderType" id="orderType" class="form-control"  >
										<option value="1" >消费</option>
										<option value="2">点击</option>
										<option value="3">展现</option>
									</select>
								</th>
							</tr>
							<tr>
								<th style="text-align: right;">开始时间:</th>
								<th>
									<input type="text" name="sendDateStart" id="sendDateStart" class="form-control" placeholder="请选择开始时间" value="${sendDateStart}" 
										onclick="timeBegin('#sendDateEnd')">
								</th>
								<th style="text-align: right;">结束时间:</th>
								<th>
									<input type="text" name="sendDateEnd" id="sendDateEnd" class="form-control" placeholder="请选择结束时间" value="${sendDateEnd}" 
										onclick="timeEnd('#sendDateStart')">
								</th>
							</tr>
						</thead>
					</table>
					
					<button class="btn btn-primary searchButton" type="submit">搜索</button>
				</form>
			</div>
		</div>
		<!-- 搜索框结束 -->
		<!-- <p>${message}</p> -->
		<!-- 列表信息开始 -->
		<div class="row" style="margin-top: 15px;background-color: #fff;">
			<div class="col-lg-12" style="min-height: 600px;padding-top: 15px;">
				<button class="btn btn-primary" type="button" onclick="excelImport();">导入</button>
				
				<div class="table-responsive" style="margin: 10px 0;">
					<table class="table table-bordered table-hover table-responsive">
						<thead>
							<tr>
								<th>类型</th>
								<th>计划名称</th>
								<th>计划单元</th>
								<th>关键字</th>
								<th>消费</th>
								<th>展现</th>
								<th>点击</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.result }">
								<tr>
									<td><c:if test="${item.type=='1'}"> 百度</c:if><c:if test="${item.type=='2'}"> 神马</c:if></td>
									<td>${item.extensionPlan }</td>
									<td>${item.extensionUnit }</td>
									<td>${item.keyword }</td>
									<td>${item.consumeQuantity }</td>
									<td>${item.showQuantity }</td>
									<td>${item.clickQuantity }</td>
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
	  content: '<form action="${baseUrl}/keywordRankController/importKeywordRank.do" method="post" enctype="multipart/form-data">'+
	  '<p><span style="margin: 4px 6px 20px 10px;float: left;">类型:</span><select id="type" name="type" class="form-control" style="width:70%;float: left;"><option value="1">百度</option><option value="2">神马</option></select></p>'+
	  '<input type="file" style="margin: 10px;font-size: 120%;" name="file" size="50" /></td></tr> '+
	  '<input type="submit" class="btn btn-primary" style="margin: 10px;" value="上传" /> '+
	  '<button class="btn btn-default" style="margin: 10px;" type="button" onclick="layer.closeAll()">取消</button> </form>'
	});
}
function page(pageNum,pageSize,funcParam){
	$("#pageNum").val(pageNum);
	$("#pageSize").val(pageSize);
	$("#searchForm").submit();
	return false;
}

$(function (){
	var type="${type}";
	var orderType="${orderType}";
	
	$("#type").val(type);
	$("#orderType").val(orderType);
});	

</script>
</body>
</html>
