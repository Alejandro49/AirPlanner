<!DOCTYPE html>

<html lang = "es">

	<head>
		<!-- Required meta tags -->
		<meta charset = "UTF-8">
		<meta name = "viewport" content = "width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<!-- BOOTSTRAP CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
		<!-- CUSTOM CSS -->
		<link rel="stylesheet" href="../css/dashboard.css">
		<title>Air Planner</title>
	</head>
	
	
	<body class="main-header">
		<!-- Configuración Navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand">
					<img src="../img/logo.png" style="width: 30%;"> </img>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						
					</ul>
				</div>
			</div>
		</nav>
		<div>
			<form id="formulario" class="bg-dark text-white" method="POST" action="buscarVuelos">
				<p> Seleccione el rango de precios que mas se ajuste a su presupuesto </p>
				<select name="precios">
					<option value="bajo"> 0 a 30 euros</option>
					<option value="medio" selected="selected"> 30 a 60 euros</option>
	   				<option value="alto"> M�s de 60 euros </option>
				</select> <br>
				<input type="submit" class="btn btn-primary" value="Buscar vuelos" name="botonEnviar">
			</form>
		</div>
		
	
		<!--BOOTSTRAP JAVASCRIPT + JQuery --> 
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
	</body>
	
	
	
</html>
		
