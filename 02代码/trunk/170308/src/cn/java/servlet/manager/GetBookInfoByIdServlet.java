package cn.java.servlet.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.java.service.manager.ManagerService;
import cn.java.service.manager.ManagerServiceImpl;

@WebServlet("/GetBookInfoByIdServlet")
public class GetBookInfoByIdServlet extends HttpServlet {
    private ManagerService manager = new ManagerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String book_id = request.getParameter("book_id");
            Map<String, Object> bookInfo = manager.getBookInfoById(book_id, request);
            JSONObject jsonObject = JSONObject.fromObject(bookInfo);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonObject.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
