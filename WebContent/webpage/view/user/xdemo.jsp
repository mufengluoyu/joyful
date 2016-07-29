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
	
	
});	

</script>
</body>
</html>
