<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/builder/studfunc.js"></script>
<script type="text/javascript">
	function window.onload() {
		select(1);
		var obj = document.getElementById("studedit");
		addEvent(obj, "click", curObj.update);
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update Personal Information</title>
</head>
<body>
<div><input type="button" id="studedit" value = "Update" /></div>
<div id="content"></div>
</body>
</html>