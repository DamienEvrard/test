<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<link rel="stylesheet" href="CssSite.css" />
        	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> 



        <title>Projet JavaEE</title>
    </head>
    <body>
       
        
        <div class="container-fluid">
			<div class="row" id="navigation">
				<div class ="col">
					<div class ="nav">
						<p id="connexion">
		<button data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" " type="button" id="butconnexion" class="btn btn-outline-warning"> <a style="text-decoration: none; color: red; "> Connexion </a> </button>

		</button>
	  </p>
	  <div class="collapse" id="collapseExample">
		<form  action="" method="post" class="form-connexion">
			<div class="form-example">
				<label for="name">Votre login </label>
				<input type="text" name="name" id="name" required>
			 </div>

		<div class="form-example">
			<label for="mdp">Votre mot de passe </label>

			 <input type="text" name="email" id="email" required>
		</div>

		<div class="form-example">
			<input type="submit" name="action" value="Se connecter">

		</div>
		</form>
	  </div>
            </div>
					</div>
                            
				</div>
            
			</div>
        
        
            <div align="center">
                <form method="post" id="formC">
                    <select name="categories" id="categorie-select">
                        <option id="cate" value="0">Tous les produis</option>
                        <c:forEach items="${ list_categorie}" var="categorie">
                            <option id="cate" value="${categorie.getCode()}">${categorie.getLibelle()}</option>
                        </c:forEach>
                    </select>
                           
                    
                    <script>
                        function getSelectedOption() {
                            var cate = $('#categorie-select').val();
                            ServletContext context = getServletContext();
                            context.setAttribut("categ", cate);
                            console.log(cate);
                        }
                        
                    </script>
                    
                    <input type="hidden" id="test" value="1">
                        
                    <input type="submit" onclick="getSelectedOption()" value="Rechercher"></input>
                </form>
            </div>
        
        
           <div class="row" style="background-color:cornsilk;width: 101%" id="vitrine_site">
               
               <div class="col">
        
                    <c:forEach items="${ list_produit}" var="produit" varStatus="status">
                        
                     <p id="lesproduits" style="background-repeat: no-repeat; background-size: 210px; background-position-x: center; background-position-y:center; background-image :url('indisponible.png')">
                         

                      <button style="float:right; position: relative; top:300px; right: 3px;"   type="button" class="btn btn-success"><i class="fas fa-cart-arrow-down"></i></button>
                         
                     <c:out value="${ produit.getNom() }"  /></p>



                    </c:forEach>
            </div>
          </div>

                
	
               
            
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
    </body>
</html>
    