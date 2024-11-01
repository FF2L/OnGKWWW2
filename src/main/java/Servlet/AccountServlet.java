package Servlet;

import Dao_imp.Dao_Account_imp;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/List")
public class AccountServlet extends HttpServlet {
    private Dao_Account_imp dao = new Dao_Account_imp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = dao.getAllAccount();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("Views/List.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            String id = req.getParameter("accountID");
            String name = req.getParameter("tenChu");
            int number = Integer.parseInt(req.getParameter("sotai")) ;
            String Address = req.getParameter("dichi");
            Float amount = Float.parseFloat(req.getParameter("sosi"));

            Account account = new Account(id,name,number,Address,amount);

            if (action.equalsIgnoreCase("Them")) {
                dao.addNewAddCount(account);
            }
            resp.sendRedirect("List");

        }catch (Exception e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
        }
    }
}
