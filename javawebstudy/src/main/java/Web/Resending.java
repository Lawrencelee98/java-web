package Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resending")
public class Resending extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        重定向
        resp.sendRedirect("/httpservlet");
//        内部转发
        req.getRequestDispatcher("/httpservlet").forward(req, resp);
    }

}
