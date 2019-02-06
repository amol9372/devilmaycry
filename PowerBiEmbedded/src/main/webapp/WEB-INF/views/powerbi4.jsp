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
			<div class="carousel-inner" id="carousel-inner"></div>
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

<script type="text/javascript">



window.onload = function() {
	
	function loadPages(report, embeddedReport){
		var models = window['powerbi-client'].models;

		var permissions = models.Permissions.All;
		var carouselCount = 0;
		
// 		accessToken: "H4sIAAAAAAAEACWWxwr0CA6E3-W_esBuZw_MwTnn3DfnnLOXffftZe4SSFUl8f3nj5U8_ZTkf_7-Q5thP3ERnJdbZgSxXi8kOetNtkufBhrs4ZYW2InvGLaY_F4DsXh83gpN2s16m_YBC4viRWtn8YgYJdJl36pBOWRwB8rm83BCsg0YDh7YMwG-sAnDPrA_jDWjiGtkKbB2h2CV8YUfBttFDYBEJIDcy9WnAchLrff07eSQtEVqTr7QuHVydNUsMWE0lsAwEhWXOwjcuqg3rgcwtN4SEN9RsVaKzZbs2SRat9q8PZ-Y56Ry8nFUsOuqizV4zznG5KwyNgVGn4wrhBsS9x21ZmF62sKu285_4wobr930X4Vfz0mEsRXUvTYaigDszASNaC_ATV3De0R4YyRir7FXld5yz26UfT0a_RR3g9Moeo7nshv4flgLH0YI--7IDBCuJsfCLX4O2_dyBeStx8JIfQKicLyUvdhwJWBLmHEhh9ka1iIwNDXBGB_JaDHkvJ-QUZSXHGIWHO4487TgR_4-y3EuDHU2uN5HCRqby142NARqMYh8PdRWc86ptfsjGSndETqM3K_GiQyQHpEwlUQfDGG7R5DvSR7r5nEGPWjXZaMAJUodklThQMpmyilFdc4hX-537il9n3lc2MMoP7h0EXURVtWuwqpbQBCq92o7k1lbE9l1z0asMQAeI60cMoTaWj36FlcC2nnAw7ftJAU1FyqNsf1HymzO2sO9DvCcdsMawUNAlNv5kPk-gooFL0mSsBiMeOel14K4jl714dQyR8coTGXgRuUoDuOFFz3e2EujpsFvodaMLm--JvGml3mNmkU1UpmZB-bbgLbRZ91ffqKknFGQjSREaC0SOGosaYfLpPgaTl4x8DpHwSqQrh9l6cOiPY4yCyPAxEjN7htabaCKusMEtiUAe8MkyvhpvaKpKAeLeKqekJBZ2lNXnLm8-JZFDZsVEu_c4GKtJ45m2GGS1-hFwV78COfyfKCiSThoSZn0IbDZOSiOx1-xXU5v9FTTs2546pvLq2FEWCwQU-44ZvF3Ax6EjYGj_oLoXlgbXO_4aUk-ZevVBmeKOio8CgbkhnIaH6Q4nlJ5eHthgCRmj0k7723OfcSawfOwqqjEQBGjsgSFcvFjcM8iDyPxt9YDPNmiRZeYsPL7V2mqzFNycOtbNHx1-cM4U0wQjug6DADOQiK4zgb6tfILZiFz1PdTXbZvz58pZCuOd22V7NuTjzsmXSnWXaWtlk945YPX1mqMGLwXa9R4mn2An3BWzagk11E689_QFOh2SXb-HJViiwM_IEtzMXVd1qGfL5UxS9KoWmAWSqFnmm4Y8n1Cwl3P9Cf-0sUSHlASGnES0oLk-gwykC-8VD4XSVSEMm4bYeiGVrpVH-9O4JC1dZ_hTqkMEStm1IVXQJLtnC_QIEz6iZge2GhEiLYqI8SP7PFTrH5Aie-Fs5eaOqonHuiTA1FgcdukKrTOlLQDmoGnxdbQttcU3N7Yowo6JK9BBCG-ZLeceQ1ZYtgJ_eSfaaZ9z8y7d71dKcQYK0bE3r5FYNkIXXX7rcb28V5tgivOLnACoqtPpxCwi6fMs-5LYg0yfcfIm1xF3m3SQxxLR21Xja17J-gp-ktgY5RPPhcmRKF7WUl8gcpkhNd08lElv1DN1nOsH1W1MbL11Qr-dzwf9KCm7Rok90ItXxFi2puLZRiruwzhkJSMUPNw6pxjp0NE-EDalqYlPTUa2cU_537Uet5MaV2vmghtXPFrOo52TINQrzCbnWG82Kxu4cK-xzky7FZ5hypBTnk53YuWBzh6iezL7w_hiD_9JThQiC34pAuBBRvsDIUISG7DOIwUkCKGiNBZDNpEhfq7Daf7PgTz2mnmGQL1OGqnoMrnrMjmBXx6xIXCl5KQV8OL0K2jdZh4q7CicVbCo0hRRqTeYfnOPOMbYMuUcowrWAmlyu81IukEXSaXZCMziKP_vhGyFgyNnl9OPOqrw9Fyu3IH0m-5KbBplvPlC6cBFpI57KJPD34EOLGtS5feCoZ7CuFim7oXD_7Wn7riZo58XIEefP6SJM6joaocAQ57h3ZtgnhDTiNHsCihQ6q28cob4YMgIbD_PYJDEHbNdjdZ2OIdYjEOU8inQQUXI7qm7BdDPC3BZcDnNkMQnR09q6nUznzcFzfiHTMuuaGyyZWEi6v5k5716fTo_dEW3-hwzWbFpX1VzT5Og2TwU2hL-KW8glWuyTwmJsQ_LHA8XpbVEb468qzPJ0QgLwVXKZlZjea3noh0dTbRMuJfxcI8hZrvCBXvZHQ8ukYh6IQ2hj89crlD8tl9eaPsr3l7aOM5dK95JMCgm8rDYN-PTcCZxwXxhAz_LAehUrP_fsf2ahfv2LNs_4YxRnZDPKwnLkiIFNr__PPnrz_s-sz7pBbPD5MCbA2XvEEDyecN-RqxImCPIUzZbPPten5Egoex_vGqmIwilmGvXGtuOQ0ikz502eTgHcwgGVJk7uU8Y4I_5qf_5f5q1Q-xocdwCqdkv2FmJvINF7etOdsQNgVyYzyxUWweDW-5kkPgzMAjNC9E_OZf78qdcEBcvbhNA87mYIrMFFrJRvPYdb4wluTdm2DaG8BQFkZdio0GclrgtfJCsmwGazfWpvUzuOkstB1djp-RUm-AL06DGr2rLAt8bxdSvwRFw8sOEbrGjqmX6kkYO6JOYfc8hYIb-glMkZNYN-pZrF8a4Krf7sgly9HVy4xNdirtVSLMzK4jIHF2g3HJF5vmX__K_Mx1scrBT2XkKxMPJWeVxw903BRN2uvEv2a4TTUm-7EWvzIPXzw_2Cs2zHPSVKVZrNul-CTI446VrV9b6WdXqYYYGbCx5jqd6WDFO9zfPKS_1mGnyxr5mJ9od5L9YAMLc03gDiABQ82aPTR95ZyF_XjaqyfixG4sd2mgXXd0nWIHEiKM-mSbyeEbzOmtpWfoix69DyVROyBR9YUqByngq6uOfAWBRxg5-sHnDMcA8CIdWv4S3zg_rHTugc5zjugdfi6lQPxRybptRsyaTfrcvWIg1ELSpq1p2wrVx2iqGKYWVlo03yjYDX7yrBPgvVB8_N9V1b0nwzdmic6AXIA0EwWDxaMzssSdArPZKNoHmGGw04P22WBDW-kodcWwdb9Nb5ZpDf3fjP_-D75c-_saDAAA"
// 			embedUrl: "https://app.powerbi.com/reportEmbed?reportId=0f5071ec-0f45-4583-9b00-4be9698ee7ae&groupId=cb6d2214-38ec-405c-a7fc-92d3c32602f9"
// 			groupId: "cb6d2214-38ec-405c-a7fc-92d3c32602f9"
// 			id: "0f5071ec-0f45-4583-9b00-4be9698ee7ae"
// 			permissions: 7
		
		
		embeddedReport.on("loaded", function() {
			//var pages = setTimeout(report.getPages(), 3000);
			    embeddedReport.getPages().then(pages => {
			    	console.log(pages.length);
			    	for(var i=0;i<pages.length;i++){
					   	 console.log(pages[i].name)
						 var embedConfiguration = {
		            		type: 'report',
		                    pageName: pages[i].name,
		                    accessToken: pages[i].report.config.accessToken,
		                    id: pages[i].report.config.id,
		                    tokenType: models.TokenType.Embed,
		                    embedUrl: pages[i].report.config.embedUrl,
		                    permissions: permissions,
		                    settings: {
		                        filterPaneEnabled: true,
		                        navContentPaneEnabled: true
		                    }

		                };  
					   	 
					   	createChildDiv(carouselCount,pages[i].report.config.id);				   	
						var $reportContainer = $('#reportContainer'+carouselCount);
						//report.render(embedConfiguration);
						powerbi.embed($reportContainer.get(0), embedConfiguration);
						carouselCount++;
					}
			    });
		
		});
	}
	
	
	var models = window['powerbi-client'].models;

	var permissions = models.Permissions.All;

	var preloadConfig = {
		type : 'report',
		baseUrl : 'https://embedded.powerbi.com/reportEmbed',
	};

	var preloadElement = powerbi.preload(preloadConfig);
	
	//==========================================
	
	var reportJson = JSON.parse(${reportJson});
	var reports = reportJson.reportList;
	
	var carouselCount = 0;
	
	reports.forEach(function(report, index){
		console.log(report);  
		var embedConfiguration1 = {
				type : 'report',
				accessToken : report.embedToken,
				id : report.reportId,
				tokenType : models.TokenType.Embed,
				embedUrl : report.embedUrl,
				permissions : permissions,
				settings : {
					filterPaneEnabled : true,
					navContentPaneEnabled : true
				}
		        
		};
        createDiv(report.reportId,index);
		
		var $reportContainer = $('#reportContainer'+report.reportId);

		var embeddedReport = powerbi.embed($reportContainer.get(0), embedConfiguration1);
		loadPages(report, embeddedReport);
		 
	});
	
// 	for (reportId in reports) {
// 		console.log('Started for report id  ...'+reports[reportId].reportId);
	
	    
// 	    //var reportId = reports[i]
// 		var embedConfiguration1 = {
// 			type : 'report',
// 			accessToken : reports[reportId].embedToken,
// 			id : reports[reportId].reportId,
// 			tokenType : models.TokenType.Embed,
// 			embedUrl : reports[reportId].embedUrl,
// 			permissions : permissions,
// 			settings : {
// 				filterPaneEnabled : true,
// 				navContentPaneEnabled : true
// 			}

// 		};

// 		createDiv(carouselCount);
		
// 		var $reportContainer = $('#reportContainer'+carouselCount);

// 		var report = powerbi.embed($reportContainer.get(0), embedConfiguration1);

// 		carouselCount++;
		
		
		
// 		report.on("loaded", function() {
// 			//var pages = setTimeout(report.getPages(), 3000);
// 			    report.getPages().then(pages => {
// 			    	for(var i=0;i<pages.length;i++){
// 					   	 console.log(pages[i].name)
// 						 var embedConfiguration = {
// 		            		type: 'report',
// 		                    pageName: pages[i].name,
// 		                    accessToken: reports[reportId].embedToken,
// 		                    id: reports[reportId].reportId,
// 		                    tokenType: models.TokenType.Embed,
// 		                    embedUrl: reports[reportId].embedUrl,
// 		                    permissions: permissions,
// 		                    settings: {
// 		                        filterPaneEnabled: true,
// 		                        navContentPaneEnabled: true
// 		                    }

// 		                };  
					   	 
// 					   	createDiv(carouselCount);				   	
// 						var $reportContainer = $('#reportContainer'+carouselCount);
// 						//report.render(embedConfiguration);
// 						powerbi.embed($reportContainer.get(0), embedConfiguration);
// 						carouselCount++;
// 					}
// 			    });
		
// 		});
		
// 		setInterval(function(){ console.log("waiting .... ") }, 6000); 
		
		
// 	}	
		
	
// 	function getPages(report){
// 			var pages = report.getPages().then(function (pages) {
	             
// 	             return pages;

	            
// 	         }).catch(function (errors) {
// 	             console.log(errors);
// 	         });	
// 	}
		
		
		
		

		
    
	
// 	async function getPages(report){
// 		try{
// 			let pages = await report.getPages();
// 			//await new Promise((resolve, reject) => setTimeout(resolve, 3000));
// 			return pages;
// 		}catch(e) {
// 			console.log('Promise Rejected');
// 		}
// 	}
	
		

}
function createDiv(i,index){
	 var div = document.createElement("div");
	 if(index==0)
	   div.setAttribute('class', 'carousel-item active');
	 else
	   div.setAttribute('class', 'carousel-item'); 	 
	 div.setAttribute('id', 'reportContainer'+i);
	 document.getElementById('carousel-inner').appendChild(div); 
	 
}	


function createChildDiv(i,parentId){
	 var div = document.createElement("div");
	 
	 div.setAttribute('class', 'carousel-item');
	 
	   
	 div.setAttribute('id', 'reportContainer'+i);
	 //console.log($('#reportContainer'+parentId));
	 $('#reportContainer'+parentId).after(div);
	 //document.getElementById('reportContainer'+parentId).appendChild(div); 
	 
}


    </script>


</html>