(function() {
	var rows = document.querySelectorAll(".table-row"),
		rowChildNodes,
		cellChildNodes,
		i,
		j,
		k;
	
	for (i = 0; i < rows.length; i++) {
		rowChildNodes = rows[i].children;
		for (j = 0; j < rowChildNodes.length; j++) {
			if (rowChildNodes[j].getAttribute("class") === "table-cell work-status" &&
					rowChildNodes[j].innerText === "Completed") {
				cellChildNodes = rowChildNodes[rowChildNodes.length - 1].children;
				for (k = 0; k < cellChildNodes.length; k++) {
					if (cellChildNodes[k].getAttribute("class") === "hide-action") {
						cellChildNodes[k].classList.add("hide");
					}
				}
			}
		}
	}
})();