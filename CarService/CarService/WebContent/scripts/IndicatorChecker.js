(function() {
	var indicators = document.querySelectorAll(".indicator"),
		parentNode,
		i;
	
	for (i = 0; i < indicators.length; i++) {
		parentNode = indicators[i].parentNode;
		if (parentNode.innerText.trim() === "Online") {
			indicators[i].classList.add("online");
		}
	}
})();