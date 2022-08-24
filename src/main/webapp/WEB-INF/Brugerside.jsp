<%--
  Created by IntelliJ IDEA.
  User: yelon
  Date: 22-03-2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Velkommen</title>
</head>

<h1 style="text-align: center">Velkommen ${sessionScope.Brugernavn}. Her kan du indsætte penge på din konto</h1>

<p style="text-align: center"> Din saldo er ${sessionScope.konto.saldo} kr. </p>
<br>
<h2 style="text-align: center">Indsæt penge</h2>
<h3 style="text-align: center">${requestScope.fejl}</h3>
<br>
<form align = "center" action="IndsætPengeServlet">
    <label for="beløb">Angiv beløb:</label><br>
    <input type="text" id="beløb" name="beløb" value=0><br>
    <input type="submit" value="Indsæt">
</form>
<br>
<h2 style="text-align: center">Hæv penge</h2>
<h3 style="text-align: center">${requestScope.fejl}</h3>
<form align="center" action="WithdrawServlet" method="post">
    <label for="withdraw">Angiv beløb:</label><br>
    <input type="text" id="withdraw" name="withdraw" value=0><br>
    <input type="submit" value="Hæv">
</form>
<br>
<h2 style="text-align: center">Overfør penge</h2>
<h3 style="text-align: center">${requestScope.fejl}</h3>
<form align="center" action="TransferServlet" method="post">
    <label for="amount">Angiv Beløb</label>
    <input type="text" id="amount" name="amount"><br>
    <label for="transfer">Angiv Kontonavn du vil overføre til</label>
    <input type="search" id="transfer" name="transfer"><br>
    <input type="submit" value="Overfør">
</form>
<br>
<br>
<div style="text-align:center">
<ul>
    <li style="display:inline-block;">
        <a href="LogAfServlet"><p style="text-align: center">Log af og gå til Index</p></a>
    </li>
    <li style="display:inline-block;">
        <a href="SletKontoServlet"><p style="text-align: center">Slet Bankkonto</p></a>
    </li>
</ul>
</div>

<style>
    body {
        background-image: url("../banking-business-banner-finance-savings-silhouette-city-background_48369-11851.jpg");
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
</style>

</body>
</html>
