
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--ICONO DE LA WEB-->
    <link rel="icon" href="img/nlc_icon.ico">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="CSS/historia.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- CSS animacion-->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <title>Historia</title>
    <!-- FUENTES CSS-->
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
    <!-- script de instagram -->
    <script type="text/javascript" src="java/insta.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- BOOTSTRAP JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </head>
  <body>
    <!-- Script para las animaciones-->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script>
      AOS.init();
    </script>
<!--NAVBAR-->


<nav class="navbar navbar-expand-lg fixed-top bg-primary">
  <div class="container-fluid">
    <div class="titulo navbar-brand">
      <span>N.L.C</span>
      </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item">
        <a href="index.php" class="nav-link active" aria-current="page">
          <div class="enlaces">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16" >
              <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
              <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
            </svg>
            <span>Inicio</span>
          </div>
        </a>
        </li>

        <li class="nav-item">
        <a href="proyectos.php" class="nav-link">
           <div class="enlaces">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-diagram-3" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M6 3.5A1.5 1.5 0 0 1 7.5 2h1A1.5 1.5 0 0 1 10 3.5v1A1.5 1.5 0 0 1 8.5 6v1H14a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-1 0V8h-5v.5a.5.5 0 0 1-1 0V8h-5v.5a.5.5 0 0 1-1 0v-1A.5.5 0 0 1 2 7h5.5V6A1.5 1.5 0 0 1 6 4.5v-1zM8.5 5a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1zM0 11.5A1.5 1.5 0 0 1 1.5 10h1A1.5 1.5 0 0 1 4 11.5v1A1.5 1.5 0 0 1 2.5 14h-1A1.5 1.5 0 0 1 0 12.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5- .5h-1zm4.5.5A1.5 1.5 0 0 1 7.5 10h1a1.5 1.5 0 0 1 1.5 1.5v1A1.5 1.5 0 0 1 8.5 14h-1A1.5 1.5 0 0 1 6 12.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm4.5.5a1.5 1.5 0 0 1 1.5-1.5h1a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1-1.5 1.5h-1a1.5 1.5 0 0 1-1.5-1.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1z"/>
            </svg>

            <span>Proyectos</span>
          </div>
          </a>
        </li>
        <li class="nav-item">
        <a href="#" class="nav-link">
          <div class="enlaceprin">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-calendar-week" viewBox="0 0 16 16">
                <path d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm-5 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z"/>
                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
              </svg>
              <span>Historia</span>
          </div>
        </a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="cuerpo_page">
  <div class="cont-inv">
    <h1 data-aos="zoom-in" data-aos-duration="3000">Proyecto Pre-Fowler</h1>
    </div>
    <div class="timeline">
  		<div class="timeline-row" >
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Octubre 2020
  			</div>
  			<div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/logo_VIT.png" >
          <br>
  				<h3><u>Nacimiento de  NLC-VIT</u></h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Noviembre 2020 <br> 500 €
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/motherboard.png" >
          <br>
  				<h3><u>Diseño del primer prototipo:</u>
            <br><br>
            -Diseño 3D
            <br>
            -Diseño hardware
            <br>
            -Diseño del código
            <br>
            -Diseño Web
        </h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Febrero 2021 <br> 1,250 €
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/modelado-3d.png" >
          <br>
  				<h3><u>Primer Prototipo V1</u>
            <br><br>
            -Instalación electrónica
            <br>
            -Impresión 3D
            <br>
            -Comprobación del prototipo
          </h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Junio 2021
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/primero.png" >
          <br><br>
  				<h3>Premio al proyecto más innovador en el concurso organizado por la Universidad Francisco de Vitoria</h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Enero 2022 <br> 1,600 €
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/seleccion.png" >
          <br><br>
          <h3><u>Seleccionados en el programa de Santander Explorer</u>
            <br><br>
            -Consulta a un experto en modelaje 3D
            <br>
            -Consulta a un experto en hardware
            <br>
            -Consulta a un experto software
          </h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Febrero 2022 <br> 2,750 €
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
          <img src="img/icons/patentar.png">
          <br>
          <h3><u>Patente</u>
            <br><br>
            -Abogados
            <br>
            -Pagar las cuotas de inscripción
            <br>
            -Pagar las cuotas de agencia
            <br>
            -Consultas a expertos
          </h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Marzo 2022 <br> 3,700 €
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/motherboard.png" >
          <br>
          <h3><u>Diseño del segundo prototipo:</u>
            <br><br>
            -Diseño 3D
            <br>
            -Diseño hardware
            <br>
            -Diseño del código
            <br>
            -Diseño web
            <br>
            -Dominio
            <br>
            -Adquisición de un servidor
          </h3>
  			</div>
  		</div>

      <div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				Abril 2022 <br> 5,000 €
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/modelado-3d.png">
          <br>
          <h3><u>Segundo prototipo</u>
            <br><br>
            -Instalación electrónica
            <br>
            -Impresión 3D
            <br>
            -Comprobación del prototipo
          </h3>
  			</div>
  		</div>

  		<div class="timeline-row">
  			<div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
          <img src="img/icons/fowler.jpg" alt="">
          <br><br>
  				<h2>Top 17 de SAN DIEGO FOWLER 2022</h2>
  			</div>
  		</div>
  	</div>
    <h1>Proyecto Post-Fowler</h1>
    <h2>¿Dónde se puede instalar nuestro sistema?</h2>
    <div class="timeline">
      <div class="timeline-row">
        <div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
    			<span>Actualidad</span>
    		</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/nlcastlogo.png" >
          <br>
  				<h3><u>Nacimiento de NLCast - 1ª Temporada</u></h3>
  			</div>
  		</div>

  		<div class="timeline-row" >
  			<div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
  				<img src="img/icons/once.jpg" >
  				<h3><u>Despliegue en:</u>
            <br><br>
            -Supermercados y centros comerciales
            <br>
            -Transporte público, edificios públicos u oficinas
            <br>
            -Universidades
          </h3>
  			</div>
  		</div>

      <div class="timeline-row">
  			<div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				<h2>Modelo de negocio B2B</h2>
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
          <div class="especial">
            <img src="img/icons/baston.png" >
            <img src="img/icons/supermercado.png" >
          </div>
          <br>
  				<h3><u>Futura solución propuesta (Modelo B2B)</u>
          <br><br>
          - 1 mango = 100 € x 5
          <br>
          - 500 m2 = 500 €
          </h3>
  			</div>
  		</div>

  		<div class="timeline-row">
        <div class="timeline-time" data-aos="fade-down" data-aos-duration=2000>
  				<h2>Modelo de negocio B2C</h2>
  			</div>
        <div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
          <div class="especial">
            <img src="img/icons/baston.png" >
            <img src="img/icons/empresa.png" >
          </div>
          <br>
  				<h3><u>Futura solución propuesta (Modelo B2C)</u>
          <br><br>
          - 1 mango = 150 - 200€
          </h3>
  			</div>
  		</div>


      <div class="timeline-row">
			<div class="timeline-content" data-aos="zoom-in" data-aos-duration=2000>
				<p class="m-0">Proximamente...</p>
			</div>
		</div>
    </div>
  </div>


<!--FOOTER-->
<footer class="footing">
  <div class="footing-container">
    <div class="footing-row">
      <div class="footing-col">
        <img src="img/logo_nlc_solo_foot.png" >
      </div>
      <div class="footing-col-links">
        <h4>Follow us</h4>
        <div class="enlaces_redes">
            <a href="https://twitter.com/NLCapacities"> <i class="fab fa-twitter"></i></a>
            <a href="https://www.instagram.com/nlcapacities"> <i class="fab fa-instagram"></i></a>
        </div>
      </div>
    </div>

  </div>
</footer>
<script type="text/javascript" src="java/inversiones.js"></script>

  </body>
</html>
