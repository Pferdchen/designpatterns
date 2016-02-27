window.onload = init;

function addEvent(obj, type, fn) {
	obj.attachedEvent("on" + type, fn);
}

function init() {
	var saveobj = document.getElementById("save");
	var checkobj = document.getElementById("check");
	var tabobj = document.getElementById("studtab");
	var check = document.getElementById("checkvalue");
	if (check.value != "y")
		addEvent(tabobj, "click", editProc);
	addEvent(saveobj, "click", saveProc);
	addEvent(checkobj, "click", checkProc);
}

function getDate() {
	var tabobj = document.getElementById("studtab");
	var studno = "";
	var studgrade = "";
	for (var i = 1; i < tabobj.rows.length; i++) {
		studno += tabobj.rows[i].cells[1].innerText + "-";
		studgrade += tabobj.rows[i].cells[3].innerText + "-";
	}
	document.getElementById("studno").value = studno;
	document.getElementById("studgrade").value = studgrade;
}

function saveProc(e) {
	getData();
	document.getElementById("mark").value = "1";
	var studobj = document.getElementById("studform");
	studobj.submit();
}

function checkProc(e) {
	getData();
	document.getElementById("mark").value = "2";
	var studobj = document.getElementById("studform");
	studobj.submit();
}

function editProc(e) {
	var obj = e.target || window.event.srcElement;
	if (obj.tagName != "TD")
		return;
	var trobj = obj.parentElement;
	if (trobj.cells[3] == obj)
		entryeditcell(obj);
}

function entryeditcell(obj) {
	var w = obj.offsetWidth - 4;
	var subs = "style='border-style:none;width:" + w + "px;'";
	obj.innerHTML = "<input id='myedit' type='text' " + subs + "value="
			+ obj.innerText + "onblur='leaveeditcell(this)'>";
	myedit.focus();
}

function leaveeditcell(obj) {
	var tdobj = obj.parentElement;
	tdobj.innerText = obj.value;
}