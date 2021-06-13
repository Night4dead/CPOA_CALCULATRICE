/**
 * Au chargement de la page, charge les erreurs s'il y en as, sinon charge le résultat s'il y en as un
 * */
window.onload = function (){
    if (checkErrors()){
        loadErrors();
        document.getElementById("errors-p").innerHTML = document.getElementById('errors').innerHTML;
    } else {
        document.getElementById("calculate-res").innerHTML = `<p id="result-p" class="calculator-screen-result"></p>`;
        if (document.getElementById('result').innerHTML!=""){
            let res = document.getElementById('result').getAttribute("data_res");
            document.getElementById("result-p").innerHTML = document.forms[1].elements.namedItem("expression").value+" = "+ res;
            document.forms[1].elements.namedItem("expression").value = res;
        }
    }

}

/**
 * Permet de charger une expression passé ou son résultat dans le input de la calculatrice
 * */
$(".btn-history-item").click(function(){
    document.forms[1].elements.namedItem("expression").value = this.value;
    modal.style.display = "none";
});

/**
 * charge le display des erreurs
 * */
function loadErrors(){
    document.getElementById("calculate-res").innerHTML = `<p id="errors-p" class="calculator-screen-errors"></p>`;
}

/**
 * Supprime l'historique
 * */
function deleteAll(){
    document.forms[0].submit();
}

/**
 * Partie faisant fonctionner le modal de l'historique
 * */
let modal = document.getElementById("modal-history");
let modal_btn = document.getElementsByClassName("btn-show")[0];
let modal_close = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
modal_btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
modal_close.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

/**
 * Vérifie la présence d'erreurs
 * */
function checkErrors(){
    if (document.getElementById('errors').innerHTML==""
        && document.getElementById('errors-p') == null){
        return false;
    }
    return true;
}

/**
 * Réalise le calcul de l'expression si elle n'est pas vide
 * */
function submitForm(){
    if (validateCalculator()){
        document.forms[1].submit();
    }
}

/**
 * bouton backspace pour le input
 * */
function removeOne(){
    document.forms[1].elements.namedItem("expression").value = document.forms[1].elements.namedItem("expression").value.substring(0,document.forms[1].elements.namedItem("expression").value.length-1);
}

/**
 * Vérifie qu'une expression est bien écrit dans le input
 * */
function validateCalculator(){
    if (document.forms[1].elements.namedItem("expression").value == ""){
        return false;
    }
    return true;
}

/**
 * Listener pour les boutons digit de la calculatrice, ajoute la value du bouton au input
 * */
$('.btn-value').click(function (){
    document.forms[1].elements.namedItem("expression").value += this.value;
})

/**
 * vide tout les champs de la calculatrice
 * */
async function clearForm(){
    document.forms[1].elements.namedItem("expression").value = "";
    if (!checkErrors()) {
        document.getElementById("result").innerHTML = "";
        document.getElementById("result-p").innerHTML = "";
    } else {
        document.getElementById("errors").innerHTML ="";
        document.getElementById("errors-p").innerHTML = "";
    }
}