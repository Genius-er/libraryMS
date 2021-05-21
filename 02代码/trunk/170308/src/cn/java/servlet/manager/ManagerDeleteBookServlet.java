package cn.java.servlet.manager;

import cn.java.service.manager.ManagerService;
import cn.java.service.manager.ManagerServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/ManagerDeleteBookServlet")
public class ManagerDeleteBookServlet extends HttpServlet {
    private ManagerService manager = new ManagerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String book_id = request.getParameter("book_id");

            boolean flag = manager.deleteBook(book_id, request);
            if (flag) {
                response.getWriter().write("200");
            } else {
                response.getWriter().write("400");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
