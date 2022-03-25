<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Bank</title>
</head>
<body>
<h1 style="text-align: center"><%= "Schweizer Bank" %>
</h1>
<br/>
<div style="text-align: center">
${requestScope.besked}
${requestScope.fejl}
</div>
<br>
<form align="center" method="post">
    <label for="Brugernavn">Brugernavn:</label><br>
    <input type="text" id="Brugernavn" name="Brugernavn"><br>
    <label for="Adgangskode">Adgangskode:</label><br>
    <input type="text" id="Adgangskode" name="Adgangskode"><br>
    <input type="Submit" value="Log Ind" formaction="Login">
    <input type="Submit" value="Opret Bruger" formaction="OpretServlet">
</form>

<style>
    body {
        background-image: url("banking-business-banner-finance-savings-silhouette-city-background_48369-11851.jpg");
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
</style>


</body>
</html>