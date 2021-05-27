<%@ taglib prefix="s" uri="/struts-tags" %>
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
</head>
<body>
<s:a action="home"><h2>Calculatrice</h2></s:a>
<!--<s:set var="expRes" value="expRes"/>-->
<s:form name="calcForm"
        action="calculer" method="POST">
    <s:textfield label="Expression" name="expression"/>
    <s:submit value="Calculer"/>
</s:form>
</body>
</html>
