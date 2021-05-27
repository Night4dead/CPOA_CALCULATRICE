<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: night
  Date: 5/25/21
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultat</title>
</head>
<body>
<s:a action="home"><h2>Calculatrice</h2></s:a>
<p style="color: dodgerblue;"><s:property value="expression"/> = <s:property value="expRes"/> </p>
<s:form name="formHome" action="home">
    <s:submit name="Retour" value="Retour"/>
</s:form>
</body>
</html>
