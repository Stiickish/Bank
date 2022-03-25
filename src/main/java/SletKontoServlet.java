import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "SletKontoServlet", value = "/SletKontoServlet")
public class SletKontoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");
        HttpSession httpSession = request.getSession();
        String Brugernavn = (String)httpSession.getAttribute("Brugernavn");
        boolean exist = kontoMap.containsKey(Brugernavn);
        String fejlBesked;
        if(exist){
            kontoMap.remove(Brugernavn);
            fejlBesked = "Kontoen er nu slettet. Hav en god dag";
            request.setAttribute("fejl",fejlBesked);
        }else{
            fejlBesked = "Noget gik galt, kontoen kunne ikke slettes. Kontakt kundeservice";
            request.setAttribute("fejl",fejlBesked);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
