<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<!-- JS file -->
<script src="../static/js/jquery.easy-autocomplete.min.js"></script>

<!-- CSS file -->
<link rel="stylesheet" href="../static/css/easy-autocomplete.min.css">

<!-- Additional CSS Themes file - not required-->
<link rel="stylesheet" href="../static/css/easy-autocomplete.themes.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../static/js/test.js"></script>
<link rel="stylesheet" href="../static/css/test.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test view</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="input-group">
					<div class="input-group-btn search-panel">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							<span id="search_concept">Filter by</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li value="movies"><a href="movies">Movies</a></li>
							<li><a href="titles">Titles</a></li>
							<li><a href="names">Names</a></li>
							<li><a href="tvepisodes">TV Episodes</a></li>
							<li class="divider"></li>
							<li><a href="all">All</a></li>
						</ul>
					</div>
					<input type="hidden" name="search_param" value="all"
						id="search_param"> 
					<input type="text" class="form-control"
						name="x" placeholder="Find Movies,Titles or Episodes ...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>