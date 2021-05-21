package cn.java.servlet.manager;

import cn.java.service.manager.ManagerService;
import cn.java.service.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/AddUserServlet")

public class AddUserServlet extends HttpServlet {
    private ManagerService manager = new ManagerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().write("ok");
        try {
            String user_id = request.getParameter("user_id");
            String password = request.getParameter("password");
            String china_name = request.getParameter("china_name");
            String tel = request.getParameter("tel");
            String sex = request.getParameter("sex");
            String user_type = request.getParameter("user_type");

            System.out.println(china_name);

            boolean flag = manager.addUser(user_id, password, china_name, tel, sex, user_type, request);
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
