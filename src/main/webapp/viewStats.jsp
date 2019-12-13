<%-- 
    Document   : viewStats
    Created on : 10 déc. 2019, 14:00:17
    Author     : damie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
         <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script type="text/javascript">
    // Chiffres d'affaires par produit           
        google.load("visualization", "1", {packages: ["corechart"]});
        
        $(document).ready(// Exécuté à la fin du chargement de la page
            function () {
                // On montre la liste des codes
                showCodes();
            }
        );
         // Chiffres d'affaires par client
        function drawChartClient(dataClient) {
                var data = google.visualization.arrayToDataTable(dataClient);
                var options = {
                        title: "Chiffre d'affaires par Client",
                        is3D: true
                };
                var Clientchart = new google.visualization.PieChart(document.getElementById('piechartclient'));
                Clientchart.draw(data, options);
        }
        // Afficher les ventes par client
        function doClientAjax() {
                $.ajax({
                        url: "ChiffreAffaireClientServlet",
                        data: $("#codeForm").serialize(),
                        dataType: "json",
                        success: // La fonction qui traite les résultats
                                function (result) {
                                        // On reformate le résultat comme un tableau
                                        var chartData = [];
                                        // On met le descriptif des données
                                        chartData.push(["Client", "chiffre d'affaires"]);
                                        for(var client in result.records) {
                                                chartData.push([client, result.records[client]]);
                                        }
                                        // On dessine le graphique
                                        drawChartClient(chartData);
                                },
                });
        }
        // Afficher les ventes par client
        function showCodes() {
        // On fait un appel AJAX pour chercher les codes
        $.ajax({
            url: "allProduit",
            dataType: "json",
            success: // La fonction qui traite les résultats
                    function (result) {
                        console.log(result);
                        var chartData = [];
                        var h = {};
                        // Le code source du template est dans la page
                        var template = $('#codesTemplate2').html();
                        for(var client in result.records) {
                        chartData.push(result.records[client]);
                    }
                        h.records=chartData;
                        var processedTemplate = Mustache.to_html(template, h);
                        // On combine le template avec le résultat de la requête
                        $('#piechartclient').html(processedTemplate);
                    }
            });
        }
                 function afficherGraphiques(){
                    $('#message').empty();
                    $('#graphique').show();
                    $('#table').hide();
                    $('#piechartclient').empty();
                }
        function ChoixChart(){
        var radios = document.getElementsByName('g');
        var valeur;
        for(var i = 0; i < radios.length; i++){
            if(radios[i].checked){
               valeur = i;
            }
        }
        
        switch(valeur){
            case 2: doClientAjax();break;
        }
    }
    
     function showError(xhr, status, message) {
            alert("Erreur: " + status + " : " + message);
    }

    </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="background-color:lightgray ;padding:5px;text-align:center">
        
        <h1> ADMINISTRATEUR </h1>
    </div>
    <div class="navbar" style="width: 100%;background-color: #555;overflow:auto;" >
        <button type="button" class="btn btn-primary"><a  style="text-decoration:none;color: black;" onclick="disconnect()" href="#" name="home"> Acceuil</a></button>
        <div class="dropdown" >
            <div class="dropdown-content">
                <button type="button" class="btn btn-light"><a style="text-decoration:none; color: black;" href="#" onclick="afficherGraphiques()">Graphiques</a></button>
            </div>
            
        </div>
        
         <fieldset id="graphique" title="Graphiques" style="color:white;font-family:Arial;">
        <legend>Graphiques de chiffre d'affaires</legend>
        <div>
            <label><input name="g" type="radio" onclick="doClientAjax()" checked />Par Client</label>
        </div>
        <div>
            <form id='codeForm' style="text-align:center;">
                <label for="start">Date debut :<input name="dateDebut" type="date" id="start"></label>
                <label for="fin">Date fin :<input name="dateFin" type="date" id="fin"></label>
                <button type="button" onclick="ChoixChart()" >Valider</button>
            </form>

            <script>
            var today = new Date();
            var formattedToday = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            $('#start').val(formattedToday);
            $('#fin').val(formattedToday);
            $('#graphique').hide();
            </script>
        </div>
            </fieldset>
    </body>
</html>
