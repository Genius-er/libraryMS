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
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet{
    private UserService user = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().write("ok");
        try {
            String user_id = request.getParameter("user_id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String china_name = request.getParameter("china_name");
            String user_type = request.getParameter("user_type");
            String tel = request.getParameter("tel");
            String sex = request.getParameter("sex");
            String favorite = request.getParameter("favorite");

            boolean flag = user.registerUser(user_id, username, password, china_name, user_type, tel, sex, favorite, request);
            if (flag) {
                //JSONObject jsonObject = JSONObject.fromObject(manager.getMtoken(ID, request));
                //response.getWriter().print(jsonObject.toString());
                response.getWriter().write("success???????");
            } else {
                response.getWriter().write("fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}