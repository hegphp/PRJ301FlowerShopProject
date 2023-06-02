/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAL.DALEmployee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Lenovo
 */
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        DAL.DALEmployee dalEmployee = new DALEmployee();
        try(PrintWriter out = resp.getWriter()){
//            Hiện mới chỉ đang check login cho trường hợp Employee, chưa làm cho customer,
            out.print("account = "+account);
            out.print("<br>password = "+password);
            if(account.equals("admin")||account.startsWith("emp_")){
                if(dalEmployee.checkLogin(account, password)){
                    out.print("<br>Dang nhap thanh cong");
                }
                else {
                    out.print("<br>Dang nhap that bai");
                }
            }else{
                out.print("<br>Hien chua support Customer!");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Support Vietnamese font
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            out.print("<h1>Ðăng nhập</h1>");
//          form
            out.print("<form action='login' method='post'>");
            out.print("<label for account>Tài khoản </label>");
            out.print("<input type='text' name='account'>");
            out.print("<br><br><label for password>Mật khẩu </label>");
            out.print("<input type='password' name='password'>");
            out.print("<br><input type='submit' value='login'>");
            out.print("</form>");
        }
    }
}
