<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript">
	var page = 1;
	var xmlHtpRq = new ActiveXObject("Microsoft.XMLHTTP");
	function go(e) {
		var max = document.getElementById("selctl").option.length;
		if (e.title == "first")
			page = 1;
		if (e.title == "prev")
			page--;
		if (e.title == "next")
			page++;
		if (e.title == "tail")
			page = document.getElementById("selctl").Option.length;
		if (page < 1)
			page = 1;
		if (page > max)
			page = max;
		productShow();
	}
	function go_sel(e) {
		page = parselInt(e.value);
		go();
	}
	function productShow() {
		var strSQL = "select * from product";
		var t = new Array("NO", "Name", "Price");
		var w = new Array(100, 200, 50);
		var i = 0, title = "", width = "";
		for (i = 0; i < t.length - 1; i++)
			title += "title=" + t[i] + "&";
		title += "title=" + t[i];
		for (i = 0; i < w.length - 1; i++)
			width += "width=" + w[i] + "&";
		width += "width=" + w[i];
		var url = "product?page=" + page + "&strsql=" + strSQL + "&" + title
				+ "&" + width;
		xmlHtpRq.open("post", url, true);
		xmlHtpRq.onreadystatechange = productShow_state;
		xmlHtpRq.send(null);
	}
	function productShow_state() {
		if (xmlHtpRq.readyState == 4) {
			if (xmlHtpRq.status == 200) {
				var obj = document.getElementById("show");
				obj.innerHTML = xmlHtpRq.responseText;
			}
		}
	}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Web</title>
</head>

<body>
	<div>
		<input type="button" value='Show product table'
			onclick="productShow()" />
	</div>
	<div id="show"></div>
</body>
</html>