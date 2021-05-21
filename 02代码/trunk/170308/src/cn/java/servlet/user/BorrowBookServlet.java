package cn.java.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.service.user.UserService;
import cn.java.service.user.UserServiceImpl;
import net.sf.json.JSONObject;
import cn.java.service.manager.ManagerService;
import cn.java.service.manager.ManagerServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/BorrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
    private UserService user = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String book_id = request.getParameter("book_id");
            String user_id = request.getParameter("user_id");
            String bb_id = request.getParameter("bb_id");
            String bb_date = request.getParameter("bb_date");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String peality_date = request.getParameter("peality_date");
            String return_date = request.getParameter("return_date");
            String state = request.getParameter("state");
            boolean flag = user.isempty(book_id, request);
            //boolean flag=true;

            if (flag) {
                //JSONObject jsonObject = JSONObject.fromObject(manager.getMtoken(ID, request));
                //response.getWriter().print(jsonObject.toString());
                boolean flag2 = user.borrowbook(user_id, bb_id, bb_date, book_id, title, author, peality_date, return_date, state, request);
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