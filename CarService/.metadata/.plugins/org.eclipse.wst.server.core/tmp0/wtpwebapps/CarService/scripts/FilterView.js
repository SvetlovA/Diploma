function FilterView() {
	var view = this,
		propertyNamesNode = document.querySelector(".property-names"),
		signsNode = document.querySelector(".signs"),
		btnApplyNode = document.querySelector(".btn-apply"),
		btnCancelNode = document.querySelector(".btn-cancel");
	
	btnCancelNode.onclick = function() {
		location.reload();
	};
	
	btnApplyNode.onclick = function() {
		applyFilter();
	};
	
	function applyFilter() {
		var tableNode = document.querySelector(".table").children[0],
			rowNodes = tableNode.children,
			headerRowNode = rowNodes[0],
			objects = getObjectsFromRows(rowNodes, headerRowNode),
			valueNode = document.querySelector(".value"),
			filteredObjects;
	
		view[signsNode.value](propertyNamesNode.value, valueNode.value);
		filteredObjects = view.apply(objects);
		filterRowNodes(rowNodes, filteredObjects);
	}
	
	function filterRowNodes(rowNodes, filteredObjects) {
		var i = 1;
		
		while (i < rowNodes.length) {
			if (!filteredObjects.find(function(object) {
				var cellNode,
					isEqual = true;
				
				for (var key in object) {
					cellNode = getChildByClassName(rowNodes[i], key);
					isEqual &= cellNode.innerText === object[key];
				}
				
				return isEqual;
			})) {
				rowNodes[i].parentNode.removeChild(rowNodes[i]);
			} else {
				i++;
			}
		}
	}
	
	function getObjectsFromRows(rowNodes, headerRowNode) {
		var headerRowCellNodes = headerRowNode.children,
			properties = getInnerText(headerRowCellNodes),
			object,
			objects = [],
			i;
		
		for (i = 1; i < rowNodes.length; i++) {
			object = createObject(properties, rowNodes[i]);
			objects.push(object);
		}
		
		return objects;
	}
	
	function createObject(properties, row) {
		var object = {};
		
		properties.forEach(function(property) {
			valueNode = getChildByClassName(row, property);
			object[property] = valueNode.innerText;
		});
		
		return object;
	}
	
	function getChildByClassName(node, className) {
		return node.getElementsByClassName(className)[0];
	}
	
	window.onload = function() {
		fillInitialData();
	};
	
	function fillInitialData() {
		var tableHeaderNodes = document.querySelectorAll(".table-header-cell"),
		signs = view.getSigns(),
		signsOptionNodes = createOptionNodes(signs),
		properties =getInnerText(tableHeaderNodes),
		propertyOptionNodes = createOptionNodes(properties);
	
		addNodes(propertyNamesNode, propertyOptionNodes);
		addNodes(signsNode, signsOptionNodes);
	}
	
	function addNodes(parentNode, nodes) {
		nodes.forEach(function(node) {
			parentNode.appendChild(node);
		});
	}
	
	function getInnerText(nodes) {
		var innerTexts = [],
			i;
		
		for (i = 0; i < nodes.length; i++) {
			if (nodes[i].innerText) {
				innerTexts.push(nodes[i].innerText.toLowerCase());
			}
		}
		
		return innerTexts;
	}
	
	function createOptionNodes(values) {
		var optionNode,
			optionNodes = [];
		
		values.forEach(function(value) {
			optionNode = createOptionNode(value);
			optionNodes.push(optionNode);
		});
		
		return optionNodes;
	}
	
	function createOptionNode(value) {
		var optionNode = document.createElement("option");
		
		optionNode.value = value;
		optionNode.innerHTML = value;
		
		return optionNode;
	}
	
	return this;
}