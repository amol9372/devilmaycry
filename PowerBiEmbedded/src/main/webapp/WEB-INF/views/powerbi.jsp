<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://microsoft.github.io/PowerBI-JavaScript/demo/node_modules/jquery/dist/jquery.js"></script>
<script
	src="https://microsoft.github.io/PowerBI-JavaScript/demo/node_modules/powerbi-client/dist/powerbi.js"></script>
<script
	src="https://microsoft.github.io/PowerBI-JavaScript/demo/node_modules/powerbi-client/dist/powerbi.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/es6-shim/0.35.3/es6-shim.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Power Bi - Report</title>
<style>
div {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
/* 	margin-top: 100px; */
/* 	margin-right: 100px; */
/* 	margin-left: 200px */
}

.powerbi {
	display: none;
}
</style>
<script type="text/javascript">


window.onload = function () {
	
	    var obj = JSON.parse(${reportJson});
		var reports = obj.reportList;
		var count=1;
		for (reportId in reports) {
// 			console.log("ReportId is " + reports[reportId].reportId);
// 			console.log("GroupId is " + reports[reportId].groupId);
// 			console.log("embedToken is " + reports[reportId].embedToken);
			var models = window['powerbi-client'].models;

			var permissions = models.Permissions.All;

			var embedConfiguration = {
				type : 'report',
				accessToken : reports[reportId].embedToken,
				id : reports[reportId].reportId,
				//for Power BI Embedded
				tokenType : models.TokenType.Embed,
				//tokenType: tokenType == '0' ? models.TokenType.Aad : models.TokenType.Embed,
				embedUrl : reports[reportId].embedUrl,
				permissions : permissions,
				settings : {
					filterPaneEnabled : true,
					navContentPaneEnabled : true
				}

			};
			
			var $reportContainer1 = $('#reportContainer' + count);
			count++;
// 			var $reportContainer2 = $('#reportContainer2');
// 			var $reportContainer3 = $('#reportContainer3');
            
            var report1 = powerbi.embed($reportContainer1.get(0), embedConfiguration);
            
            report1.getPages()
            .then(function (pages) {
              // Retrieve first page.
              var firstPage = pages[0];
           
              firstPage.getVisuals()
                .then(function (visuals) {
                  console.log(visuals);
                })
            })
//             var report2 = powerbi.embed($reportContainer2.get(0), embedConfiguration);
//             var report3 = powerbi.embed($reportContainer3.get(0), embedConfiguration);
		}		

//             //report.fullscreen();
            
            var activeDiv = 1;
            showDiv(activeDiv); // show first one because all are hidden by default
            var timer = setInterval(changeDiv, 11000);

    function changeDiv() {
        activeDiv++;
        if (activeDiv == 4) {
            activeDiv = 1;
        }
        showDiv(activeDiv);
    }

    function showDiv(num) {
        $('div.powerbi').fadeOut("slow"); // hide all
        $('#reportContainer' + num).fadeIn(3000); // show active
    }
					
}
</script>
</head>
<body>
	
	<div class="powerbi" id="reportContainer1"></div>
	<div class="powerbi" id="reportContainer2"></div>
	<div class="powerbi" id="reportContainer3"></div>
</body>
</html>