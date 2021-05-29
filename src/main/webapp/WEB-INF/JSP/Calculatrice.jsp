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
<s:a action=""><h2>Calculatrice</h2></s:a>
<s:set var="expRes" value="expRes"/>
<s:set var="errors" value="error"/>

<s:if test="%{#errors!=null}">
    <p style="color: red;"> Erreur : <s:property value="error"/> </p>
</s:if>
<s:form name="calcForm"
        action="calculer" method="POST">
    <s:if test="%{#errors==null && #expRes!=null}">
        <p style="color: dodgerblue;"><s:property value="expression"/> = <s:property value="expRes"/> </p>
    </s:if>
    <s:else>
        <br>
    </s:else>
    <s:textfield label="Expression" name="expression"/>
    <s:submit value="Calculer"/>
</s:form>
</body>
</html>
