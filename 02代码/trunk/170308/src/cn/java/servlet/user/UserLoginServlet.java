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
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet{
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
            String data = user.userLogin(user_id, password, request);
            String flag = data.split(":")[0];
            System.out.println(data);
            if (flag.equals("11")) {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);
            }
            else if (flag.equals("12")){
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(data);
            }
            else {
                response.getWriter().write("400");
            }
        } catch (Exception e) {
            response.getWriter().write(e.toString());
            e.printStackTrace();
        }
    }
}
//hf