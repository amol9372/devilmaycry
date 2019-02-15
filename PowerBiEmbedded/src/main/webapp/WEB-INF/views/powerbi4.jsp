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

#hiddenReport {
    display: none;
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
			<div class="carousel-inner" id="carousel-inner">




     
				

				<div id="hiddenReport" class="carousel-item">
				  <div id="passw">
					<div>
						(THE PASSWORD IS PASSWORD) <br /> Enter the password to proceed:
					</div>
					<div>

						<input type="password" id="password"
							onkeydown="if (event.keyCode == 13) document.getElementById('button').click()" />
						<!-- IMPORTANT! this part is so if you click enter, it works. -->
					</div>


					<div>
						<br /> <input id="button" type="button" value="Login"
							onclick="if (document.getElementById('password').value == 'PASSWORD') { 
document.getElementById('hiddenReport').classList.toggle('show');   document.getElementById('passw').style.display='none'; } 
else {  alert('Invalid Password!'); password.setSelectionRange(0, password.value.length);   } " />
					</div>
					<!-- it will autoselect wrong input if wrong -->
					<br />
					<br />
					<br />
				 </div>				
				</div>






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
	<script>
		$('.carousel').carousel({
		    interval: false
		}); 
	</script>
</body>

<script type="text/javascript">



window.onload = function() {
	var preloadConfig = {
		type : 'report',
		baseUrl : 'https://embedded.powerbi.com/reportEmbed',
	};

	var preloadElement = powerbi.preload(preloadConfig);

	var childCaraoselCount = 0;
	function loadPages(report, embeddedReport){
		var models = window['powerbi-client'].models;

		var permissions = models.Permissions.All;
		var carouselCount = 0;
		
		embeddedReport.on("loaded", function() {
			//var pages = setTimeout(report.getPages(), 3000);
			    embeddedReport.getPages().then(pages => {
			    	
			    	console.log(pages.length);
			    	if(pages.length == 1)
			    		return;
			    	for(var i=(pages.length-1);i>=1;i--){
			    		 createChildDiv(childCaraoselCount,pages[i].report.config.id);
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
					   	 
					   					   	
						var $reportContainer = $('#reportContainer'+childCaraoselCount);
						//embeddedReport.render(embedConfiguration);
						powerbi.embed($reportContainer.get(0), embedConfiguration);
						childCaraoselCount++;
					}
			    });
		
		});
	}
	
	
	var models = window['powerbi-client'].models;

	var permissions = models.Permissions.All;


	
	//==========================================
	
	var reportJson = JSON.parse(${reportJson});
	var reports = reportJson.reportList;
	
	//var carouselCount = 0;
	
	reports.forEach(function(report, index){
		
		createDiv(report.reportId,index);
		
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
        
		if(report.reportId == 'cd1de139-444b-4360-b845-a0989ba86b46'){
			document.getElementById('passw').style.display = 'inline'; 
			var embeddedReport = powerbi.embed($('#hiddenReport').get(0), embedConfiguration1);
		} else {	
		    var embeddedReport = powerbi.embed($('#reportContainer'+report.reportId).get(0), embedConfiguration1);
		    loadPages(report, embeddedReport);
		} 
	});
	

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