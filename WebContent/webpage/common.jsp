<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="baseUrl" value="<%=basePath %>" scope="request"/>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="网站关键字：xman">
<meta http-equiv="description" content="网站描述信息：xman's test">
<link type="text/css" rel="stylesheet" href="${ baseUrl }/webpage/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="${ baseUrl }/webpage/css/layer.css"/>
<script type="text/javascript" src="${ baseUrl }/webpage/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${ baseUrl }/webpage/js/bootstrap.js"></script>
<script type="text/javascript" src="${ baseUrl }/webpage/js/layer.js"></script>
<script type="text/javascript" src="${ baseUrl }/webpage/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ baseUrl }/webpage/js/laydate/laydate.js"></script>
<style>
	body{font-family: MicrosoftYaHei;margin: 80px 15px 30px 15px;}
	table{border-collapse: collapse;border-spacing: 0;text-align: center;}
	table thead tr th{border-bottom-width: 1px !important;text-align: center;}
	
</style>
<script type="text/javascript">
	var baseUrl = '${baseUrl}';
	
	/*
	layerdate 设置开始日期和结束日期
	*/
	var minEndTime = ''; //结束日的最小日期
	var maxBeginTime = ''; //开始时间的最大日期
	//开始日期调用方法
	function timeBegin(endId){
		console.log(endId);
		if($(endId).val()=='') maxBeginTime='';//如果结束时间为空，则开始时间的最大日期不设置
		laydate({
			istime: true,
			//format: 'YYYY-MM-DD hh:mm:ss',
			format: 'YYYY-MM-DD',
			max: maxBeginTime,
			choose: function(datas){
				minEndTime = datas;//开始日选好后，重置结束日的最小日期
				
			}
		});
	}
	//结束日期调用方法
	function timeEnd(beginId){
		console.log(beginId);
		if($(beginId).val()=='') minEndTime='';//如果开始时间为空，则结束时间的最小日期不设置
		laydate({
			istime: true, 
			//format: 'YYYY-MM-DD hh:mm:ss',
			format: 'YYYY-MM-DD',
			min: minEndTime,
			choose: function(datas){
				maxBeginTime = datas;//结束日选好后，重置开始日的最大日期
			}
		});
	}
	
	
</script>