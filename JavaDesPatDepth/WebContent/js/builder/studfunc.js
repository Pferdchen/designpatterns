var curObj = null;
var xmlHtpRq;
if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlHtpRq = new XMLHttpRequest();
} else {// code for IE6, IE5
	xmlHtpRq = new ActiveXObject("Microsoft.XMLHTTP");
}

function addEvent(obj, type, fn) {
	if (obj && obj.attachEvent) { // IE
		obj.attachEvent("on" + type, fn);
	}
}

function select(type) {
	switch (type) {
	case 1:
		curObj = new StudObj();
		break;
	case 2:
		curObj = new TeacherObj();
		break;
	}
}

function StudObj() {
}

StudObj.prototype.update = function(e) {
	url = "updateservlet?mytype=1";
	xmlHtpRq.open("post", url, true);
	xmlHtpRq.onreadystatechange = curObj.update_state;
	xmlHtpRq.send(null);
}

StudObj.prototype.update_state = function() {
	if (xmlHtpRq.readyState == 4) {
		if (xmlHtpRq.status == 200) {
			var obj = document.getElementById("content");
			obj.innerHTML = xmlHtpRq.responseText;
			obj = document.getElementById("myupdate");
			addEvent(obj, "click", curObj.updateProc);
		}
	}
}

StudObj.prototype.updateProc = function(e) {
	var account = document.getElementById("account").value;
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	var major = document.getElementById("major").value;
	var depart = document.getElementById("depart").value;
	var strsql = "update student set name='" + name + "', age='" + age + "', "
			+ "major='" + major + "', depart='" + depart + "' where user='"
			+ user + "'";
	url = "dbservlet";
	xmlHtpRq.open("post", url, true);
	xmlHtpRq.onreadystatechange = StudObj.updateProc_state;
	xmlHtpRq.sent(null);
}

StudObj.prototype.updateProc_state = function() {
}