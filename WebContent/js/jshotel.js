 $(document).ready(function(){
      //$('.carousel').carousel();
     $('.carousel.carousel-slider').carousel({fullWidth: true});
    /* window.alert('chargement carousel');*/
    $('select').material_select();
    $(".button-collapse").sideNav();
     $('.parallax').parallax();
     });

var element = document.getElementById('boutonEstimation');
    element.addEventListener('click',calculPrix);

function calculPrix(){
    var Nuit = document.getElementById("nbNuit").value;
    var resultat = Nuit * 50;
   /* console.log(resultat); */  
    var esti = document.getElementById("estimation");
    esti.innerHTML= "Estimation du prix : " + resultat + " €";
}