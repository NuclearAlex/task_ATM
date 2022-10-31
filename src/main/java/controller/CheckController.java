package controller;

import model.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "check", value = "/check")
public class CheckController extends HttpServlet {
    private final Database database;

    public CheckController() {
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
        String ru = request.getParameter("ru");
        String en = request.getParameter("en");
        if (ru != null && en == null) {
            response.getWriter().write("TEKYSHIY BALANS: " + database.check() + " "
                    + database.getData().get(Database.getNum()).getMoney().getType());
        } else {
            response.getWriter().write("Actual balance: " + database.check() + " "
                    + database.getData().get(Database.getNum()).getMoney().getType());
        }
    }
}