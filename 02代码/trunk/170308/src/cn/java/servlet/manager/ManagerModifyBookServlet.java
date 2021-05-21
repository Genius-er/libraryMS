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

@WebServlet("/ManagerModifyBookServlet")
public class ManagerModifyBookServlet extends HttpServlet {
    private ManagerService manager = new ManagerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String book_id = request.getParameter("book_id");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            String publish = request.getParameter("publish");
            String booktype_name = request.getParameter("booktype_name");
            String cover = request.getParameter("cover");



            boolean flag = manager.managerModifyBook(title, author, isbn, publish, booktype_name, cover,book_id, request);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}