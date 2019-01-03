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

            var embedConfiguration1 = {
                type: 'report',
                pageName: 'ReportSection',
                accessToken: ${embedToken1},
                id: '3a73c36a-603a-404c-bb62-07068010b2b4',
                tokenType: models.TokenType.Embed,
                embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                permissions: permissions,
                settings: {
                    filterPaneEnabled: true,
                    navContentPaneEnabled: true
                }

            };

            var embedConfiguration2 = {
                type: 'report',
                pageName: 'ReportSectione9dfbb33d4de29236d74',
                accessToken: ${embedToken1},
                id: '3a73c36a-603a-404c-bb62-07068010b2b4',
                tokenType: models.TokenType.Embed,
                embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                permissions: permissions,
                settings: {
                    filterPaneEnabled: true,
                    navContentPaneEnabled: true
                }

            };

            var embedConfiguration3 = {
                type: 'report',
                pageName: 'ReportSection2c716ba95d0899a460d3',
                accessToken: ${embedToken1},
                id: '3a73c36a-603a-404c-bb62-07068010b2b4',
                tokenType: models.TokenType.Embed,
                embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                permissions: permissions,
                settings: {
                    filterPaneEnabled: true,
                    navContentPaneEnabled: true
                }

            };

            var embedConfiguration4 = {
                type: 'report',
                pageName: 'ReportSection66d5d3a400649d0ebc0e',
                accessToken: ${embedToken1},
                id: '3a73c36a-603a-404c-bb62-07068010b2b4',
                tokenType: models.TokenType.Embed,
                embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                permissions: permissions,
                settings: {
                    filterPaneEnabled: true,
                    navContentPaneEnabled: true
                }

            };

            var embedConfiguration5 = {
                type: 'report',
                pageName: 'ReportSection7448903baace16c4aea2',
                accessToken: ${embedToken1},
                id: '3a73c36a-603a-404c-bb62-07068010b2b4',
                tokenType: models.TokenType.Embed,
                embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=3a73c36a-603a-404c-bb62-07068010b2b4&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                permissions: permissions,
                settings: {
                    filterPaneEnabled: true,
                    navContentPaneEnabled: true
                }

            };
            
            var embedConfiguration6 = {
                    type: 'report',
                    pageName: 'ReportSection',
                    accessToken: ${embedToken2},
                    id: '12b1b8d1-1703-4c8f-a2dc-118c12010652',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=12b1b8d1-1703-4c8f-a2dc-118c12010652&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };

            var embedConfiguration7 = {
                    type: 'report',
                    pageName: 'ReportSection',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration8 = {
                    type: 'report',
                    pageName: 'ReportSection1119bbc1d9d99655d7e0',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration9 = {
                    type: 'report',
                    pageName: 'ReportSection52ccde0d16090a5222c4',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration10 = {
                    type: 'report',
                    pageName: 'ReportSection02f03a7880a7ca9accd3',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration11 = {
                    type: 'report',
                    pageName: 'ReportSection36c3c5e25562b0a81a82',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration12 = {
                    type: 'report',
                    pageName: 'ReportSectioneb027911d16b1662b6a2',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var embedConfiguration13 = {
                    type: 'report',
                    pageName: 'ReportSection58535320973d8f0664f2',
                    accessToken: ${embedToken3},
                    id: '35fdaeec-503e-40c9-890b-b33fe449de56',
                    tokenType: models.TokenType.Embed,
                    embedUrl: 'https://app.powerbi.com/reportEmbed?reportId=35fdaeec-503e-40c9-890b-b33fe449de56&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9',
                    permissions: permissions,
                    settings: {
                        filterPaneEnabled: true,
                        navContentPaneEnabled: true
                    }

            };
            
            var $reportContainer1 = $('#reportContainer1');
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

            var report1 = powerbi.embed($reportContainer1.get(0), embedConfiguration1);
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
				<div class="carousel-item active" id="reportContainer1"></div>
				<div class="carousel-item" id="reportContainer2"></div>
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