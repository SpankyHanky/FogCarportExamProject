<%-- 
    Document   : carpportDesignPointyRoof
    Created on : 05-05-2017, 12:45:27
    Author     : @author Kasper and Anton
--%>
<%@page import="BusinessLogic.SVGDrawing.SVGDrawCompleteCarport"%>
<%@page import="BusinessLogic.SVGDrawing.SVGDrawCompleteCarport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Johannes Fog</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link type="text/css" rel="stylesheet" href="CSS/FogCarportCSS.css" />
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-left" href="https://www.johannesfog.dk/"><img src="Img/logo.png"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" >
      <ul class="nav navbar-nav">
         <li><a href="http://207.154.197.214:8080/FogExamProjectGroup5A/index.html">Carporte</a></li>
        <li><a href="https://www.johannesfog.dk/byggecenter/om-fog/">About</a></li>
        <li><a href="https://johannesfog.dk/byggecenter/find-butik/">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
    <div class="container-fluid text-center">
        <h1>Bekræft ordre!</h1>
        
        <p>
        
        

        <form action= "FrontController" method="GET">
        <button> Køb Carport </button>
        
        <input type="hidden" name="cmd" value="order-carport">    
            
        <input type="text" placeholder="Navn" name="cName" id="cName" value="">
        <input type="text" placeholder="Tlf.nr." name="cNumber" id="cNumber" value="">
        <input type="text" placeholder="Email" name="cEmail" id="cEmail" value="">
        <input type="text" placeholder="Adresse" name="cAdress" id="cAdress" value="">
        
        <input type="hidden" name ="length" id = "length" value="<%= request.getAttribute("length")%>">
        <input type="hidden" name ="width" id = "width" value="<%= request.getAttribute("width")%>">
        <input type="hidden" name ="height" id = "height" value="<%= request.getAttribute("height")%>">
        <input type="hidden" name ="shedLength" id = "shedLength" value="<%= request.getAttribute("shedLength")%>">
        <input type="hidden" name ="shedWidth" id = "shedWidth" value="<%= request.getAttribute("shedWidth")%>">
        <input type="hidden" name ="angle" id = "angle" value="<%= request.getAttribute("angle")%>">
        
        <h3> Du har valgt en Carport med følgende mål: </h3>
        
        <h4> Længde:     <%= request.getAttribute("length")%> </h4>
        <h4> Bredde:     <%= request.getAttribute("width")%> </h4>
        <h4> Højde:      <%= request.getAttribute("height")%> </h4>
        <h4> Skurlængde: <%= request.getAttribute("shedLength")%> </h4>
        <h4> Skurbredde: <%= request.getAttribute("shedWidth")%> </h4>
        <h4> Tagvinkel:  <%= request.getAttribute("angle")%> </h4>
        <h4> Pris:  <%= request.getAttribute("price")%> </h4>
        
        <div3>
        
        <% SVGDrawCompleteCarport SVGDrawCompleteCarport = new SVGDrawCompleteCarport(); %>
        <%= SVGDrawCompleteCarport.drawCompleteCarport(   
                                
                    
                                (Double) request.getAttribute("length"),
                                (Double) request.getAttribute("width"),
                                (Double) request.getAttribute("height"),
                                (Double) request.getAttribute("shedLength"),
                                (Double) request.getAttribute("shedWidth"),
                                (Integer) request.getAttribute("angle")
                                
                        ) %>
            
        </div3>    
        
        

        

        </form>
        

        

        
        
        </p>
</div>
        <footer class="container-fluid text-center">
  <div class="pull-left">
    Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439
</div>
<div class="pull-right">
    Alle priser er inkl. moms
</div>
</footer>
        
    </body>
</html>
