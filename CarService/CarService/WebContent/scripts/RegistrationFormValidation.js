(function() {
	var formNode = document.getElementById("form"),
		clientPasswordNode = document.getElementById("client-password"),
		repeateClientPasswordNode = document.getElementById("repeat-client-password"),
		indicator = document.getElementById("indicator"),
		isValid = false;
	
	repeateClientPasswordNode.oninput = checkPasswordValid;
	
	clientPasswordNode.oninput = checkPasswordValid;
	
	formNode.onsubmit = function() {
		return isValid;
	};
	
	function checkPasswordValid() {
		if (clientPasswordNode.value &&
				repeateClientPasswordNode.value &&
				clientPasswordNode.value === repeateClientPasswordNode.value) {
			replaceClass(indicator, "invalid", "valid");
			isValid = true;
		} else {
			replaceClass(indicator, "valid", "invalid");
			isValid = false;
		}
	}
	
	function replaceClass(node, oldClass, newClass) {
		node.classList.remove(oldClass);
		node.classList.add(newClass);
	}
})();