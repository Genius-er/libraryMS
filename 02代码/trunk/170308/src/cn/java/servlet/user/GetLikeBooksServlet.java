package cn.java.servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.java.service.user.UserService;
import cn.java.service.user.UserServiceImpl;
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

@WebServlet("/GetLikeBooksServlet")
public class GetLikeBooksServlet extends HttpServlet {
    private UserService user = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Map<String, Object>> books = user.getLikeBooks(request);
            JSONArray jsonArray = JSONArray.fromObject(books);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonArray.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}