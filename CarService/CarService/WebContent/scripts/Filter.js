function Filter() {
	this.expression = "true";
}

Filter.prototype.apply = function(items) {
	var expression = this.expression;
	
	return items.filter(function(item) {
		return eval(expression);
	});
};

Filter.prototype.equal = function (propertyName, value) {
	this.expression += " && item['" + propertyName + "'] === '" + value + "'";
};

Filter.prototype.startsWith = function (propertyName, value) {
	this.expression += " && item['" + propertyName + "'].startsWith('" + value + "')";
};

Filter.prototype.includes = function (propertyName, value) {
	this.expression += " && item['" + propertyName + "'].includes('" + value + "')";
};

Filter.prototype.getSigns = function () {
	var signs = [];
	
	for (var key in this) {
		if (key !== "expression" && key !== "apply" && key !== "getSigns") {
			signs.push(key);
		}
	}
	
	return signs;
};