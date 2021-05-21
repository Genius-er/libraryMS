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

@WebServlet("/ManagerGetAllUsersServlet")
public class ManagerGetAllUsersServlet extends HttpServlet{
    private ManagerService manager = new ManagerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Map<String, Object>> users = manager.getAllUsers(request);
            JSONArray jsonArray = JSONArray.fromObject(users);
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
