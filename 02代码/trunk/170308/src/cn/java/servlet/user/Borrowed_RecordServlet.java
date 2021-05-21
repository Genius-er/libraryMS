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
@WebServlet("/Borrowed_RecordServlet")
public class Borrowed_RecordServlet extends HttpServlet{
    private UserService user = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().write("ok");
        try {
            String book_id = request.getParameter("book_id");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String bb_date = request.getParameter("bb_date");
            String peality_date = request.getParameter("peality_date");
            String return_date = request.getParameter("return_date");
            Map<String, Object> map = user.borrowed_record(book_id,title,author,bb_date,peality_date,return_date, request);
            JSONObject jsonObject = JSONObject.fromObject(map);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonObject.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}