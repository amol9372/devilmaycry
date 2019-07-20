<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://microsoft.github.io/PowerBI-JavaScript/demo/node_modules/jquery/dist/jquery.js"></script>
<script src="https://microsoft.github.io/PowerBI-JavaScript/demo/node_modules/powerbi-client/dist/powerbi.js"></script>
<script src="https://microsoft.github.io/PowerBI-JavaScript/demo/node_modules/powerbi-client/dist/powerbi.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-shim/0.35.3/es6-shim.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Power Bi - Report</title>
<style>
div {position: absolute; top: 0; right: 0; bottom: 0; left: 0; margin-top: 100px}
</style>
<script type="text/javascript">


window.onload = function () {
	
	
	var models = window['powerbi-client'].models;

	var permissions = models.Permissions.All;
    
	var embedConfiguration = {
		type : 'report',
		accessToken : ${embedToken},
		id : ${reportId},
		//for Power BI Embedded
		tokenType : models.TokenType.Embed,
		//tokenType: tokenType == '0' ? models.TokenType.Aad : models.TokenType.Embed,
		embedUrl : ${embedUrl},
		permissions : permissions,
		settings : {
			filterPaneEnabled : true,
			navContentPaneEnabled : true
		}

	};

	var $reportContainer = $('#reportContainer');

	var report = powerbi.embed($reportContainer.get(0), embedConfiguration);

	report.fullscreen();
}	
</script>
</head>
<body>
    <h1>Check your Report below</h1>
    <div id="reportContainer"></div>
</body>
</html>