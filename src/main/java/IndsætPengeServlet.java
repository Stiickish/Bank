import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndsætPengeServlet", value = "/IndsætPengeServlet")
public class IndsætPengeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String beløb = request.getParameter("beløb");

        int amount = 0;
        try {
            amount = Integer.parseInt(beløb);
        } catch (NumberFormatException e) {
            String fejlBesked = "Husk beløbet skal være et tal";
            request.setAttribute("fejl", fejlBesked);
            request.getRequestDispatcher("WEB-INF/Brugerside.jsp").forward(request, response);
        }

        Konto konto = (Konto) httpSession.getAttribute("konto");
        konto.indsæt(amount); //Ny saldo. Viser kun hvis der indsættes et positivt tal.
        httpSession.setAttribute("konto",konto);
        request.getRequestDispatcher("WEB-INF/Brugerside.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
