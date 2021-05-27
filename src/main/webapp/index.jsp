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
<body>
<h2>Calculatrice</h2>

<s:form name="calcForm"
    action="res" method="POST">
    <!--<p>Res : <s:property value="expression"/> = <s:property value="exp_res"/></p>-->
    <s:textfield label="Expression" name="expression"/>
    <s:submit value="res" label="Calculer"/>
</s:form>

</body>
</html>
