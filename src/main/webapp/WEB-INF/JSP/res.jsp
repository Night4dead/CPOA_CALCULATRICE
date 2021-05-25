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
    <h1><s:property value="expression"/> = <s:property value="exp"/> </h1>
    <s:form name="formHome" action="home">
        <s:submit name="Retour" value="Retour"/>
    </s:form>
</body>
</html>
