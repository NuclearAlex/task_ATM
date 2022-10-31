package controller;

import model.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "put", value = "/put")
public class PutController extends HttpServlet {
    private final Database database;

    public PutController() {
        database = new Database();
    }

    public Database getDatabase() {
        return database;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usdRu = request.getParameter("usdRu");
        String usd = request.getParameter("usd");
        String result = "";
        if (usd == null && usdRu != null) {
            result = usdRu;
        } else {
            result = usd;
        }
        int money = Integer.parseInt(result);
        database.put(money);
        if (usd != null && usdRu == null) {
            response.getWriter().write("Added: " + money + " " +
                    database.getData().get(Database.getNum()).getMoney().getType() + "\n");
            response.getWriter().write("Actual balance: " + database.check());
        } else {
            response.getWriter().write("DOBAVLENO: " + money + " " +
                    database.getData().get(Database.getNum()).getMoney().getType() + "\n");
            response.getWriter().write("TEKYSHIY BALANS: " + database.check());
        }
    }
}