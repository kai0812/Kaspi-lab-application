
import main.java.database.DBConnection;
import main.java.logic.CreditApprover;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "/home")
public class BlackListCheck extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fnameV = request.getParameter("fname");
        String lnameV = request.getParameter("lname");
        String snameV = request.getParameter("sname");
        String iinV = request.getParameter("iin");

        try {
            CreditApprover ca = new CreditApprover();
            boolean flagIIN = ca.approveByIin(iinV);
            boolean flafID = ca.approveById(fnameV, snameV, lnameV);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher disp = request.getRequestDispatcher("/pages/creditRequestForm.jsp");
        disp.forward(request, response);

    }
}