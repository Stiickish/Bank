package com.example.bank;

import DomæneObjekter.Konto;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    Map<String, Konto> konti = new HashMap<>();

    public void init() {
        Konto konto1 = new Konto("Nikolai", "1234", 150);
        Konto konto2 = new Konto("Denis", "12", 15);
        Konto konto3 = new Konto("Betül", "34", 170);
        Konto konto4 = new Konto("Long", "123456", 15);
        Konto konto5 = new Konto("Kristofer", "1234567", 1500);

        konti.put(konto1.getNavn(),konto1);
        konti.put(konto2.getNavn(),konto2);
        konti.put(konto3.getNavn(),konto3);
        konti.put(konto4.getNavn(),konto4);
        konti.put(konto5.getNavn(),konto5);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("konti",konti);

        String besked = "Her er en oversigt over dine konti";

        request.setAttribute("besked",besked);

        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void destroy() {
    }
}