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
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
html, body, .container {
	height: 100%;
	background-color: #eee;
}

.carousel, .carousel-inner, .carousel-item {
	height: calc(100vh - 120px);
}

.container {
	max-width: 100%;
	width: 100%;
}

.logo {
	text-align: right;
	padding: 15px;
}

.carousel-control-next, .carousel-control-prev {
	opacity: 1;
	width: auto;
}

.carousel-control-next-icon, .carousel-control-prev-icon {
	background-color: #124c91;
	padding: 10px;
}
</style>
<script type="text/javascript">
        window.onload = function () {
            var models = window['powerbi-client'].models;

            var permissions = models.Permissions.All;

            var embedConfiguration2 = {
            		type: 'report',
                    pageName: 'ReportSection',
                    accessToken: ${embedToken2},
                    id: '80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };

            var embedConfiguration3 = {
            		 type: 'report',
                     pageName: 'ReportSection77444ecbe48543310f51',
                     accessToken: ${embedToken2},
                     id: '80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff',
                     tokenType: models.TokenType.Embed,
                     embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                     permissions: permissions,
                     settings: {
                         filterPaneEnabled: true,
                         navContentPaneEnabled: true
                     }

            };

            var embedConfiguration4 = {
            		 type: 'report',
                     pageName: 'ReportSection7feebe91c97813db77b5',
                     accessToken: ${embedToken2},
                     id: '80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff',
                     tokenType: models.TokenType.Embed,
                     embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                     permissions: permissions,
                     settings: {
                         filterPaneEnabled: true,
                         navContentPaneEnabled: true
                     }

            };

            var embedConfiguration5 = {
            		 type: 'report',
                     pageName: 'ReportSectiond4c75c267fc17f3c8133',
                     accessToken: ${embedToken2},
                     id: '80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff',
                     tokenType: models.TokenType.Embed,
                     embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=80ba1f19-28f5-4d3b-bae9-56ad7c1f26ff&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                     permissions: permissions,
                     settings: {
                         filterPaneEnabled: true,
                         navContentPaneEnabled: true
                     }

            };
            
            var embedConfiguration6 = {
                    type: 'report',
                    pageName: 'ReportSection',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration7 = {
                    type: 'report',
                    pageName: 'ReportSection77444ecbe48543310f51',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration8 = {
                    type: 'report',
                    pageName: 'ReportSection7feebe91c97813db77b5',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration9 = {
                    type: 'report',
                    pageName: 'ReportSectiond4c75c267fc17f3c8133',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration10 = {
                    type: 'report',
                    pageName: 'ReportSection358d1eaa37f6b3f5fc0f',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration11 = {
                    type: 'report',
                    pageName: 'ReportSectiona9898332021f950d2e79',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=8f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration12 = {
                    type: 'report',
                    pageName: 'ReportSection0f19016d780ae90839b4',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration13 = {
                    type: 'report',
                    pageName: 'ReportSection56751ed2f9147e4fe1c6',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration14 = {
                    type: 'report',
                    pageName: 'ReportSection13e4b15000646b92b393',
                    accessToken: ${embedToken3},
                    id: 'f353054b-1e85-4043-9e40-5eb91dc06d9b',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=f353054b-1e85-4043-9e40-5eb91dc06d9b&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            
            
            var $reportContainer2 = $('#reportContainer2');
            var $reportContainer3 = $('#reportContainer3');
            var $reportContainer4 = $('#reportContainer4');
            var $reportContainer5 = $('#reportContainer5');
            
            var $reportContainer6 = $('#reportContainer6');            
            var $reportContainer7 = $('#reportContainer7');
            var $reportContainer8 = $('#reportContainer8');
            var $reportContainer9 = $('#reportContainer9');
            var $reportContainer10 = $('#reportContainer10');
            var $reportContainer11 = $('#reportContainer11');
            var $reportContainer12 = $('#reportContainer12');
            var $reportContainer13 = $('#reportContainer13');
            var $reportContainer14 = $('#reportContainer14');

           
            var report2 = powerbi.embed($reportContainer2.get(0), embedConfiguration2);
            var report3 = powerbi.embed($reportContainer3.get(0), embedConfiguration3);
            var report4 = powerbi.embed($reportContainer4.get(0), embedConfiguration4);
            var report5 = powerbi.embed($reportContainer5.get(0), embedConfiguration5);
            var report6 = powerbi.embed($reportContainer6.get(0), embedConfiguration6);
            var report7 = powerbi.embed($reportContainer7.get(0), embedConfiguration7);
            var report8 = powerbi.embed($reportContainer8.get(0), embedConfiguration8);
            var report9 = powerbi.embed($reportContainer9.get(0), embedConfiguration9);
            var report10 = powerbi.embed($reportContainer10.get(0), embedConfiguration10);
            var report11 = powerbi.embed($reportContainer11.get(0), embedConfiguration11);
            var report12 = powerbi.embed($reportContainer12.get(0), embedConfiguration12);
            var report13 = powerbi.embed($reportContainer13.get(0), embedConfiguration13);
            var report14 = powerbi.embed($reportContainer14.get(0), embedConfiguration14);
            
            
            
           
            
            
        }

    </script>
</head>

<body>

	<div class="container">
		<div class="logo">
			<img
				src="http://www.espire.com/-/media/feature/identity/logo.png?h=76&w=101&la=en&hash=5C02FB870E77014A8E0FF7449D833852A1FBE517"
				alt="espire Logo">
		</div>
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
			    
			    
			    <div class="carousel-item active" id="reportContainer2"></div>				
				<div class="carousel-item" id="reportContainer3"></div>
				<div class="carousel-item" id="reportContainer4"></div>
				<div class="carousel-item" id="reportContainer5"></div>
				
				<div class="carousel-item" id="reportContainer6"></div>
				<div class="carousel-item" id="reportContainer7"></div>
				<div class="carousel-item" id="reportContainer8"></div>
				<div class="carousel-item" id="reportContainer9"></div>
				<div class="carousel-item" id="reportContainer10"></div>
				<div class="carousel-item" id="reportContainer11"></div>
				<div class="carousel-item" id="reportContainer12"></div>
				<div class="carousel-item" id="reportContainer13"></div>	
				<div class="carousel-item" id="reportContainer14"></div>
				
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>

</html>