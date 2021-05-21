package cn.java.servlet.manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java.swing.plaf.windows.resources.windows;
import net.sf.json.JSONObject;
import cn.java.service.manager.ManagerService;
import cn.java.service.manager.ManagerServiceImpl;


@WebServlet("/ManagerDeleteUserServlet")
public class ManagerDeleteUserServlet extends HttpServlet{
    private ManagerService manager = new ManagerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try{
            String user_id=request.getParameter("user_id");

            boolean flag = manager.deleteUser(user_id, request);
            if (flag) {
                response.setCharacterEncoding("GB2312");
                response.getWriter().print("<script language='javascript' >alert('删除成功 !')</script>");
                response.setHeader("refresh", "1;URL=http://localhost:8080/manager_UserManage/manager_UserManage.jsp");
            } else {
                response.getWriter().write("删除失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}