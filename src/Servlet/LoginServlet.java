package Servlet;

import DAO.Userdao;
import Module.TokenTool;
//import Util.TOKENUtil;
//import Util.JSONUtil;
//import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

//        JSONObject json = JSONUtil.getRequestJsonObject(request);

        String email = request.getParameter("username");
        String password = request.getParameter("password");

        Userdao dao = new Userdao();
        int userID = dao.login(email, password);
        if(userID != 0 ){
            TokenTool tokenTool = new TokenTool();
            String user = tokenTool.makeToken();
            Cookie cookie = new Cookie("SERVER_TOKEN",user);
            cookie.setMaxAge(60*3);
            response.addCookie(cookie);
//            TOKENUtil tokenUtil = new TOKENUtil();
//            tokenUtil.saveTokenString();
            System.out.print("呦西");
            System.out.print(user);
        }else{
            response.sendError(407, "Need authentication!!!" );
            System.out.print(userID);
            System.out.print("不呦西");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
