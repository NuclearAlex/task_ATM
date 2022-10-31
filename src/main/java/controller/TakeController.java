package controller;

import model.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "take", value = "/take")
public class TakeController extends HttpServlet {
    private final Database database;

    public TakeController() {
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
        database.take(money);

        if (usd != null && usdRu == null) {
            if (money < 0 && money > database.getData().get(Database.getNum()).getMoney().getQuantity()) {
                response.getWriter().write("You input incorrect sum: the sum more than your balance!");
                return;
            }
            response.getWriter().write("Taken: " + money + " " +
                    database.getData().get(Database.getNum()).getMoney().getType() + "\n");
            response.getWriter().write("Actual balance: " + database.check());
        } else {
            if (money < 0 && money > database.check()) {
                response.getWriter().write("You input incorrect sum: the sum more than your balance!");
                return;
            }
            response.getWriter().write("SNYATO: " + money + " " +
                    database.getData().get(Database.getNum()).getMoney().getType() + "\n");
            response.getWriter().write("TEKYSHIY BALANS: " + database.check());
        }
    }
}