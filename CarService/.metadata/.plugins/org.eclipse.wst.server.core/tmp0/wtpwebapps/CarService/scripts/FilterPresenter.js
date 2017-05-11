function FilterPresenter(view) {
	var filter = new Filter();
	
	view.equal = function(propertyName, value) {
		filter.equal(propertyName, value);
	};
	
	view.apply = function(items) {
		return filter.apply(items);
	};
	
	view.getSigns = function() {
		return filter.getSigns();
	};
}