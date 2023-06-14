/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAL.DALCustomer;
import DAL.DALEmployee;
import Model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Support Vietnamese font
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //Check if user want to login or not
        if (req.getParameter("login") != null) {
            DAL.DALEmployee dalEmployee = new DALEmployee();
            DAL.DALCustomer dalCustomer = new DALCustomer();
            String account = req.getParameter("account");
            String password = req.getParameter("password");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("account = " + account);
                out.print("<br>password = " + password);
                //Check if the user is staff or employee or not
                if (account.equals("admin") || account.startsWith("emp_")) {
                    //check the login is valid or not
                    if (dalEmployee.checkLogin(account, password)) {
                        req.setAttribute("login", 1);
                        req.setAttribute("account",account);
                        req.getRequestDispatcher("index.jsp").forward(req,resp);
                    } else {
                        System.out.println("Dang nhap employee that bai");
                        String errorMessage = "Đăng nhập thất bại";
                        req.setAttribute("errorMessage", errorMessage);
                        req.getRequestDispatcher("Login.jsp").forward(req, resp);
                    }
                //If the user is employee
                } else {
                    //check the login is valid or not
                    if(dalCustomer.checkLogin(account, password)){
                        req.setAttribute("login", 1);
                        req.setAttribute("account",account);
                        req.getRequestDispatcher("index.jsp").forward(req,resp);
                    }else{
                        System.out.println("Dang nhap Customer that bai");
                        String errorMessage = "Đăng nhập thất bại";
                        req.setAttribute("errorMessage", errorMessage);
                        req.getRequestDispatcher("Login.jsp").forward(req, resp);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Check if user want to register new account or not
        if (req.getParameter("register") != null) {
            try {
                Customer newCustomer = new Customer(String.valueOf(req.getParameter("accountInput")),String.valueOf(req.getParameter("passwordInput")),String.valueOf(req.getParameter("phoneInput")),
                        String.valueOf(req.getParameter("addressInput")),String.valueOf(req.getParameter("firstNameInput")),String.valueOf(req.getParameter("lastNameInput")),String.valueOf(req.getParameter("emailInput")));
                DALCustomer dalCustomer = new DALCustomer();
                //check if user registed successfully or not
                if(dalCustomer.addCustomer(newCustomer)){
//                    String errorMessage = "Đăng kí thành công";
                    req.setAttribute("login", 1);
                    req.setAttribute("account",newCustomer.getId());
                    req.getRequestDispatcher("index.jsp").forward(req,resp);
                }else{
                    String errorMessage = "Đăng kí thất bại";
                    req.setAttribute("errorMessage", errorMessage);
                    req.getRequestDispatcher("Register.jsp").forward(req, resp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Support Vietnamese font
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
    }
}
