import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Brugernavn = request.getParameter("Brugernavn");
        String Adgangskode = request.getParameter("Adgangskode");
        HttpSession session = request.getSession(true);
        session.setAttribute("Adgangskode", Adgangskode);



        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");

        Konto konto = kontoMap.getOrDefault(Brugernavn, null);

        String fejlBesked;
        if (kontoMap.get(Brugernavn).getLogingCounter()>3) {
            fejlBesked = "For mange forsøg. Kontakt kundeservice";
            request.setAttribute("fejl", fejlBesked);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (konto == null) {
            fejlBesked = "Kontoen eksistere ikke";
            request.setAttribute("fejl", fejlBesked);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (!konto.getKode().equals(Adgangskode)) {
            fejlBesked = "Dit brugernavn eller adgangskode er forkert, prøv igen : forsøg " + konto.getLogingCounter();
            request.setAttribute("fejl", fejlBesked);
            konto.setLogingCounter();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("Brugernavn", Brugernavn);
        httpSession.setAttribute("konto", konto);

        request.getRequestDispatcher("WEB-INF/Brugerside.jsp").forward(request, response);
    }


}

