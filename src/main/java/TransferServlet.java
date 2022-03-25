import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "TransferServlet", value = "/TransferServlet")
public class TransferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Map med alle konti
        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");

        //Ny Http session
        HttpSession httpSession = request.getSession();

        //Finder konto via Brugernavn
        Konto konto = (Konto) httpSession.getAttribute("konto");


        String transferTo = request.getParameter("transfer");
        Konto transferKonto = kontoMap.get(transferTo);
        int amount;
        String besked;
        try {
            amount = Integer.parseInt(request.getParameter("amount"));
            konto.hæv(amount);
            transferKonto.indsæt(amount);
            besked = "Ding! Penge overført";
            request.setAttribute("besked", besked);
            request.getRequestDispatcher("WEB-INF/Brugerside.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            besked = "Der opstod en fejl, penge kunne ikke overføres";
            request.setAttribute("besked",besked);
            request.getRequestDispatcher("WEB-INF/Brugerside.jsp").forward(request, response);
        }

    }
}
