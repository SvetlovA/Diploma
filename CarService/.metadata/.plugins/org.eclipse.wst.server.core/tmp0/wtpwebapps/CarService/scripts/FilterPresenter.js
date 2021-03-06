function FilterPresenter(view) {
	var filter = new Filter();
	
	view.equal = function (propertyName, value) {
		filter.equal(propertyName, value);
	};
	
	view.startsWith = function (propertyName, value) {
		filter.startsWith(propertyName, value);
	};
	
	view.includes = function (propertyName, value) {
		filter.includes(propertyName, value);
	};
	
	view.apply = function (items) {
		return filter.apply(items);
	};
	
	view.getSigns = function() {
		return filter.getSigns();
	};
}