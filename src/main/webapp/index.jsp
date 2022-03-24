<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="text-align: center"><%= "Bank of Betül!" %>
</h1>
<br/>


<%--
<a href="hello-servlet">Hello Servlet</a>

<br>
<br>
--%>

${requestScope.besked}
${requestScope.fejl}


<%--<c:forEach items="${applicationScope.konti}" var="item" >

    ${item.value.navn} : ${item.value.saldo}
    <br>

</c:forEach>--%>



<form align="center" action="Login" method="post">
    <label for="Brugernavn">Brugernavn:</label><br>
    <input type="text" id="Brugernavn" name="Brugernavn"><br>
    <label for="Adgangskode">Adgangskode:</label><br>
    <input type="text" id="Adgangskode" name="Adgangskode"><br>
    <input type="Submit" value="Log Ind">

</form>

</body>
</html>