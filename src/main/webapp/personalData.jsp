<%-- 
    Document   : personalData
    Created on : 10 déc. 2019, 14:01:03
    Author     : damie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CssSite.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> 
        <title>JSP Page</title>
    </head>
    <body>
        
        <script>
            function enrformtest(){
                var nomod = document.getElementById("modif");
                var nomod2 = document.getElementById("modif2");
                var nomod3= document.getElementById("modif3");
                var nomod4 = document.getElementById("modif4");
                var nomod5 = document.getElementById("modif5");
                var nomod6= document.getElementById("modif6");

                nomod.setAttribute("disabled","disabled");
                nomod2.setAttribute("disabled","disabled");
                nomod3.setAttribute("disabled","disabled");
                nomod4.setAttribute("disabled","disabled");
                nomod5.setAttribute("disabled","disabled");
                nomod6.setAttribute("disabled","disabled");
               }
               
           function modifformtest(){
                var nomod = document.getElementById("modif");
                var nomod2 = document.getElementById("modif2");
                var nomod3= document.getElementById("modif3");
                var nomod4 = document.getElementById("modif4");
                var nomod5 = document.getElementById("modif5");
                var nomod6= document.getElementById("modif6");

                nomod.removeAttribute("disabled");
                nomod2.removeAttribute("disabled");
                nomod3.removeAttribute("disabled");
                nomod4.removeAttribute("disabled");
                nomod5.removeAttribute("disabled");
                nomod6.removeAttribute("disabled");
               }
        </script>
        
        <div class="row">
            <div class="col">
            <form  >
                <div class="form-row">
                    <div class="form-group col-md-6" >
                        <label  for="inputEmail4">Email</label>
                        <input  type="email" class="form-control" id="modif" placeholder="Email">
                     </div> 
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Société</label>
                        <input type="password" class="form-control" id="modif2" placeholder="Société">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAddress">Fonction</label>
                    <input type="text" class="form-control" id="modif3">
                </div>
              <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputAddress2">Addrese</label>
                    <input id="modif4" type="text" class="form-control"  placeholder="Ex: 5 Rue du JavaEE">
                </div>
                    <div class="form-group col-md-4">
                    <label for="inputCity">Ville</label>
                    <input id="modif5" type="text" class="form-control">
                    </div>
                 </div>
                </div>
              </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Ville</label>
                    <input id="modif6" type="text" class="form-control">
                </div>
            <div class="form-group col-md-4">
                <label for="inputState">Pays</label>
                <select  id="inputState" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>

         </div>
        <button   type="button" class="btn btn-dark" ><a onclick='enrformtest()'>Enregistrer</a></button>
        <button type="button" class="btn btn-outline-dark" onclick="modifformtest()" >Modifier</button>


   </form>
            </div>
        </div>
    </body>
</html>
