function validateTime(id) {
	var inpObj = document.getElementById(id);
	if (!inpObj.checkValidity()) {
		document.getElementById(id).style.backgroundColor = "pink";
		document.getElementById(id).focus();
	} else {
		document.getElementById(id).style.backgroundColor = "white";
	}
}

function validateText(id, requiredLength) {
	var value = document.getElementById(id).value;
	var textLength = value.length;
	if (textLength <= requiredLength) {
		document.getElementById(id).style.backgroundColor = "pink";
		document.getElementById(id).focus();
	} else {
		document.getElementById(id).style.backgroundColor = "white";
	}
}
function validateDropDown(id) {
	var value = document.getElementById(id).value;
	if (value === 'Java') {
		document.getElementById(id).style.backgroundColor = "white";
	} else {
		alert('Note: This feature is only applicable to Java');
	//	document.getElementById(id).value = "Java";
	}
}
