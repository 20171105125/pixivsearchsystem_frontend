package Servlet;

import DAO.Userdao;
//import Util.JSONUtil;
//import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

//        JSONObject json = JSONUtil.getRequestJsonObject(request);

        String email = request.getParameter("username");
        String password = request.getParameter("password");

        Userdao dao = new Userdao();
        boolean flag = dao.isExistEmail(email);
        if(flag) {
            response.sendError(407, "Need authentication!!!" );
            System.out.print("不呦西");
        } else {
            dao.save(email,password);
            System.out.print("呦西");
            System.out.print(email);
            System.out.print(password);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
