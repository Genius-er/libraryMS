package cn.java.servlet.user;

import cn.java.service.user.UserService;
import cn.java.service.user.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings("serial")
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet{
    private UserService user = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String user_id = request.getParameter("user_id");
            Map<String, Object> map = user.selectUser(user_id, request);
            JSONObject jsonObject = JSONObject.fromObject(map);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonObject.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}