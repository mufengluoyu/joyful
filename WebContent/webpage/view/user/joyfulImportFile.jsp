<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>xtest</title>
<%@ include file="/webpage/common.jsp" %>

<style type="text/css">
	body{background: url('${baseUrl}/webpage/images/background1.jpg') no-repeat;background-size: 100%;}
	#left_menu .navbar-nav > li {float: left;width: 150px;}
	#left_menu .navbar-nav > li > .dropdown-menu {margin-top: -50px;border-top-left-radius: 0;border-top-right-radius: 0;margin-left: 150px;}
	
	
</style>

</head>

<body>
<div >
	<!-- method必须为post 及enctype属性-->  
	<form align="center" style="width:100%;heigth:100%;" action="${ baseUrl }/userController/xtest/import.do" method="post" enctype="multipart/form-data">  
		<input type="file" name="file">  
		<input type="submit" value="上传">  
	</form>
</div>
<script type="text/javascript">
	

</script>
</body>
</html>
