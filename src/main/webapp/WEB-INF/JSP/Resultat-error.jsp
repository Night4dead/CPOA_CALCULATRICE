<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: night
  Date: 5/25/21
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erreur</title>
</head>
<body>
<s:a action="home"><h2>Calculatrice</h2></s:a>
<h2>Erreur sur l'expression <s:property value="expression"/> :</h2>
<h2 style="color: red;"><s:property value="error"/> </h2>
<s:form name="formHome" action="home">
  <s:submit name="Retour" value="Retour"/>
</s:form>
</body>
</html>
