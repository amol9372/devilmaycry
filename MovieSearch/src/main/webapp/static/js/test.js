$(document).ready(function(e) {

	var options = {
		url : function(phrase) {
			return "restApi/getSampleList?phrase=" + phrase + "&format=json";
		},

		getValue : "name"
	};

	$(".form-control").easyAutocomplete(options);
});
