
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: night
  Date: 5/22/21
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculatrice</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
    <style>
        html {
            font-size: 62.5%;
            box-sizing: border-box;
        }

        *, *::before, *::after {
            margin: 0;
            padding: 0;
            box-sizing: inherit;
        }

        .calculator {
            border: 1px solid #ccc;
            border-radius: 5px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
        }

        .calculator-screen {
            width: 100%;
            font-size: 3rem;
            min-height: 80px;
            border: none;
            background-color: #252525;
            color: #fff;
            text-align: right;
            padding-right: 20px;
            padding-left: 10px;
            text-wrap: normal;
        }

        .calculator-screen-result {
            width: 100%;
            min-height: 80px;
            text-wrap: initial;
            font-size: 3rem;
            border: none;
            background-color: #252525;
            color: #fff;
            text-align: right;
            padding-right: 20px;
            padding-left: 10px;
        }

        .calculator-screen-errors {
            width: 100%;
            border: none;
            font-size: 3rem;
            min-height: 80px;
            background-color: #252525;
            color: red;
            text-align: right;
            padding-right: 20px;
            padding-left: 10px;
            text-wrap: normal;
        }

        button {
            height: 60px;
            background-color: #fff;
            border-radius: 3px;
            border: 1px solid #c4c4c4;
            background-color: transparent;
            font-size: 2rem;
            color: #333;
            background-image: linear-gradient(to bottom,transparent,transparent 50%,rgba(0,0,0,.04));
            box-shadow: inset 0 0 0 1px rgba(255,255,255,.05), inset 0 1px 0 0 rgba(255,255,255,.45), inset 0 -1px 0 0 rgba(255,255,255,.15), 0 1px 0 0 rgba(255,255,255,.15);
            text-shadow: 0 1px rgba(255,255,255,.4);
        }



        .history {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */

            /*

            border: 1px solid #ccc;
            border-radius: 5px;
            position: absolute;
            top:75%;
            left: 85%;
            transform: translate(-50%, -50%);
            width: 400px;
            */
        }

        .history-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 20%;
        }

        .history-table {

        }

        .history-table > td > button{
            width: 100%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #eaeaea;
        }

        .operator {
            color: #337cac;
        }

        .all-clear {
            background-color: #f0595f;
            border-color: #b0353a;
            color: #fff;
        }

        .all-clear:hover {
            background-color: #f17377;
        }

        .equal-sign:hover {
            background-color: #4e9ed4;
        }

        .calculator-keys {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
        }

        .equal-sign {
            background-color: #2e86c0;
            border-color: #337cac;
            color: #fff;
            height: 100%;
        }

        .history-buttons {
            display: grid;
            grid-template-columns: repeat(2, 2fr);
        }

        .btn-show {
            background-color: #2e86c0;
            border-color: #337cac;
            color: #fff;
            width: 200px;
        }

        .btn-delete {
            background-color: #f0595f;
            border-color: #b0353a;
            color: #fff;
            width: 200px;
        }

        footer {

            position: absolute;
            bottom:10%;
            left: 40%;
            right:40%;
        }

        h1 {
            position: absolute;
            top:10%;
            left: 40%;
            right:40%;
        }
    </style>
</head>
<body>

<center>
    <h1>Calculatrice CPOA </h1>
</center>

<div style="display: none">
    <p id="errors">${errors}</p>
    <p id="result">${expression.res}</p>
    <form:form action="deleteAll" method="get">test</form:form>
</div>

<div class="calculator">
    <form:form action="calculate" method="POST" modelAttribute="expression">
        <form:input id="expression" path="exp" class="calculator-screen" />
    </form:form>
    <div id="calculate-res">

    </div>

    <div class="calculator-keys">

        <button class="btn-value" type="button " class="operator" value="+">+</button>
        <button class="btn-value" type="button " class="operator" value="-">-</button>
        <button class="btn-value" type="button " class="operator" value="*">&times;</button>
        <button class="btn-value" type="button " class="operator" value="/">&divide;</button>

        <button class="btn-value" type="button " value="(">(</button>
        <button class="btn-value" type="button " value="7">7</button>
        <button class="btn-value" type="button " value="8">8</button>
        <button class="btn-value" type="button " value="9">9</button>

        <button class="btn-value" type="button " value=")">)</button>
        <button class="btn-value" type="button " value="4">4</button>
        <button class="btn-value" type="button " value="5">5</button>
        <button class="btn-value" type="button " value="6">6</button>

        <button onclick="clearForm()" type="button" class="all-clear" value="all-clear">AC</button>
        <button class="btn-value" type="button " value="1">1</button>
        <button class="btn-value" type="button " value="2">2</button>
        <button class="btn-value" type="button " value="3">3</button>


        <button onclick="submitForm()" type="button" class="equal-sign" value="=">=</button>
        <button type="button " class="decimal" value="." disabled></button>
        <button class="btn-value" type="button " value="0">0</button>



        <button onclick="removeOne()" type="button" class="equal-sign"><=</button>

    </div>
    <br/>
    <div class="history-buttons">
        <button class="btn-show">Afficher historique</button>
        <button class="btn-delete" onclick="deleteAll()">supprimer historique</button>
    </div>
</div>

<div id="modal-history" class="history">
    <center>
        <div class="history-content">
            <span class="close">&times;</span>
            <table class="history-table">
                <tr>
                    <th>Expression</th>
                </tr>
                <c:forEach items="${expressions}" var="expressionItem">
                    <tr>
                        <td><button class="btn-history-item">${expressionItem.exp}</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </center>
</div>
<footer>
    <p>2021 - by Quentin KACZMAREK and Florian TRAMOY</p>
</footer>
<script>
    window.onload = function (){
        if (checkErrors()){
            document.getElementById("calculate-res").innerHTML = `<p id="errors-p" class="calculator-screen-errors"></p>`;
            document.getElementById("errors-p").innerHTML = document.getElementById('errors').innerHTML;
        } else {
            document.getElementById("calculate-res").innerHTML = `<p id="result-p" class="calculator-screen-result"></p>`;
            if (document.getElementById('result').innerHTML!=""){
                document.getElementById("result-p").innerHTML = document.forms[1].elements.namedItem("expression").value+" = "+document.getElementById('result').innerHTML;
            }
        }
        document.forms[1].elements.namedItem("expression").value = "";
    }

    $(".btn-history-item").click(function(){
        document.forms[1].elements.namedItem("expression").value = this.innerHTML;
        modal.style.display = "none";
    });


    function deleteAll(){
        console.log("hello " + document.forms[0].innerHTML);
        document.forms[0].submit();
    }

    let modal_btn = document.getElementsByClassName("btn-show")[0];
    let modal_close = document.getElementsByClassName("close")[0];

    let modal = document.getElementById("modal-history");

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

    function checkErrors(){
        if (document.getElementById('errors').innerHTML==""){
            return false;
        }
        return true;
    }

    function submitForm(){
        if (validateCalculator()){
            document.forms[1].submit();
        } else {
            document.getElementById("errors-p").innerHTML = 'Veuillez entrez une expression';
        }
    }

    function removeOne(){
        document.forms[1].elements.namedItem("expression").value = document.forms[1].elements.namedItem("expression").value.substring(0,document.forms[1].elements.namedItem("expression").value.length-1);
    }

    function validateCalculator(){
        if (document.forms[1].elements.namedItem("expression").value == ""){
            return false;
        }
        return true;
    }

    $('.btn-value').click(function (){
        document.forms[1].elements.namedItem("expression").value += this.value;
    })

    async function clearForm(){
        document.forms[1].elements.namedItem("expression").value = "";
        if(!checkErrors()){
            document.getElementById("result").innerHTML ="";
            document.getElementById("result-p").innerHTML = "";
        }
        document.getElementById("errors").innerHTML ="";
        document.getElementById("errors-p").innerHTML = "";
    }
</script>
</body>
</html>
