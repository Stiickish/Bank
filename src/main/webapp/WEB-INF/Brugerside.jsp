<%--
  Created by IntelliJ IDEA.
  User: yelon
  Date: 22-03-2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Velkommen</title>
</head>

<h1 style="text-align: center">Velkommen ${sessionScope.Brugernavn}, til din brugerside</h1>
<h2 style="text-align: center">Her kan du tilgå dine konti eller bestille tid med din bankrådgiver</h2>

<p style="text-align: center"> Din saldo er ${sessionScope.konto.saldo} kr. </p>
<br>
<br>
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
<br>
<h2 style="text-align: center">Hæv penge</h2>
<h3 style="text-align: center">${requestScope.fejl}</h3>
<form align="center" action="WithdrawServlet" method="post">
    <label for="withdraw">Angiv beløb:</label><br>
    <input type="text" id="withdraw" name="withdraw" value=0><br>
    <input type="submit" value="Hæv">
</form>
<br>
<br>
<a style="text-align: center" href="LogAfServlet">Log af og gå til Index</a>

</body>
</html>
