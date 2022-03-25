import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "OpretServlet", value = "/OpretServlet")
public class OpretServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Brugernavn = request.getParameter("Brugernavn");
        String Adgangskode = request.getParameter("Adgangskode");

        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");

        String besked;

        if (kontoMap.containsKey(Brugernavn)) {
            besked = "Kontoen eksistere allerede";
            request.setAttribute("fejl", besked);
        } else {
            Konto konto = new Konto(Brugernavn, Adgangskode, 100);

            kontoMap.put(Brugernavn, konto);
            getServletContext().setAttribute("konti", kontoMap);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
