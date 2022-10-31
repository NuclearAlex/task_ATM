package controller;

import model.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "authorize", value = "/authorize")
public class AuthorizeController extends HttpServlet {
    private final Database database;

    public AuthorizeController() {
        this.database = new Database();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        String ru = request.getParameter("ru");
        String en = request.getParameter("en");
        int num = Integer.parseInt(number);
        int pass = Integer.parseInt(password);
        if (database.authorization(num, pass)) {
            if (ru != null && en == null) {
                response.sendRedirect("/ru/typeRu.html");
            } else {
                response.sendRedirect("/en/typeEn.html");
            }
        } else {
            response.sendRedirect("/index.html");
        }
    }
}