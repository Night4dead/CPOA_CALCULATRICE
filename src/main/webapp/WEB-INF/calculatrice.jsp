
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

    <link href='<spring:url value="resources/css/calculatrice-web.css"/>' rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
</head>
<body>


<!-- div cachée pour stocker des variables à traiter au loading de la page, plus le form permettant de supprimer l'historique-->
<div style="display: none">
    <p id="errors">${errors}</p>
    <div id="result" data_res="${expression.res}">${expression.res}</div>
    <form:form action="deleteAll" modelAttribute="expressions" method="POST"></form:form>
</div>


<div class="calculator">
    <div class="title">
        <center>
            <a href="/calculatrice"><h1>Calculatrice CPOA </h1></a>
        </center>
        <span class="div-span"></span>
    </div>
    <div id="calculate-res">

    </div>
    <form:form action="calculate" method="POST" modelAttribute="expression">
        <form:input id="expression" path="exp" class="calculator-screen" />
    </form:form>

    <div class="calculator-keys">

        <button onclick="clearForm()" type="button" class="all-clear" value="all-clear">AC</button>
        <button class="btn-value operator" type="button " value="(">(</button>
        <button class="btn-value operator" type="button " value=")">)</button>
        <button onclick="removeOne()" type="button" class="return"><=</button>


        <button class="btn-value" type="button " value="7">7</button>
        <button class="btn-value" type="button " value="8">8</button>
        <button class="btn-value" type="button " value="9">9</button>
        <button class="btn-value operator" type="button " value="/">&divide;</button>

        <button class="btn-value" type="button " value="4">4</button>
        <button class="btn-value" type="button " value="5">5</button>
        <button class="btn-value" type="button " value="6">6</button>
        <button class="btn-value operator" type="button " value="*">&times;</button>

        <button class="btn-value" type="button " value="1">1</button>
        <button class="btn-value" type="button " value="2">2</button>
        <button class="btn-value" type="button " value="3">3</button>
        <button class="btn-value operator" type="button " value="-">-</button>


        <button class="btn-value" type="button " class="decimal" value=".">.</button>
        <button class="btn-value" type="button " value="0">0</button>
        <button onclick="submitForm()" type="button" class="equal-sign" value="=">=</button>
        <button class="btn-value operator" type="button "  value="+">+</button>

    </div>
    <div class="history-buttons">
        <button class="btn-show">Afficher historique</button>
        <button class="btn-delete" onclick="deleteAll()">Supprimer historique</button>
    </div>
    <div class="footer">
        <center>
            <p>2021 - by
                <a href="https://www.linkedin.com/in/quentinkaczmarek" target="_blank">Quentin KACZMAREK </a>
                and
                <a href="https://www.linkedin.com/in/florian-tramoy" target="_blank">Florian TRAMOY</a>
            </p>
            <br/>
            <p>
                Find the repository for this project @ <a href="https://github.com/Night4dead/CPOA_CALCULATRICE/releases" target="_blank">Github</a>
            </p>
        </center>
    </div>
</div>

<!-- historique de la calculatrice, en modal -->
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
                        <td>
                            <center>
                                <button class="btn-history-item" value="${expressionItem.exp}">${expressionItem.exp}</button>
                                =
                                <button class="btn-history-item btn-history-item-res" value="${expressionItem.res}">${expressionItem.res}</button>
                            </center>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </center>
</div>
<script src='<spring:url value="resources/js/calculatrice.js"/>' type="text/javascript"></script>
</body>
</html>
