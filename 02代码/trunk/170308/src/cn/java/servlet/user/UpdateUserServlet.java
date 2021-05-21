package cn.java.servlet.user;

import cn.java.service.user.UserService;
import cn.java.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("serial")
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{
    private UserService user = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().write("ok");
        try {
            String user_id = request.getParameter("user_id");
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String tel = request.getParameter("tel");
            String sex = request.getParameter("sex");
            String favorite = request.getParameter("favorite");

            System.out.println("这里是" + user_id);

            boolean flag = user.updateUser(user_id, password, username, tel, sex, favorite, request);
            if (flag) {
                //JSONObject jsonObject = JSONObject.fromObject(manager.getMtoken(ID, request));
                //response.getWriter().print(jsonObject.toString());
                response.getWriter().write("200");
            } else {
                response.getWriter().write("400");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}