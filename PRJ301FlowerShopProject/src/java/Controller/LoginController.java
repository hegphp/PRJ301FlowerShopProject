/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAL.DAOBouquet;
import DAL.DAOCustomer;
import DAL.DAOEmployee;
import DAL.DAOFlower;
import Model.Customer;
import Model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
public class LoginController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String errorMessage = "";
        DAOEmployee daoEmp = new DAOEmployee();
        DAOCustomer daoCus = new DAOCustomer();
        DAOFlower daoFlower = new DAOFlower();
        DAOBouquet daoBouquet = new DAOBouquet();
        try{
            //check if User login is Employee or not
            if(!request.getParameter("account").isEmpty()&&
                    (request.getParameter("account").startsWith("emp")||request.getParameter("account").equals("admin"))){
                //Check if the user typed valid account and password or not
                if(daoEmp.checkLogin(request.getParameter("account"), request.getParameter("password"))){
                    //import user info
                    Employee newEmp = daoEmp.getEmployeeById(request.getParameter("account"));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", newEmp);
                    //import Bouquet info
                    request.setAttribute("bouquetList", daoBouquet.getBouquetList());
                    //import Flower info
                    request.setAttribute("flowerList", daoFlower.getFlowerList());
                    //import Employee info
                    request.setAttribute("empList", daoEmp.getEmployeeList());
                    request.getRequestDispatcher("index3.jsp").forward(request, response);
                    return;
                }else{
                    errorMessage = "Đăng nhập thất bại, tài khoản hoặc mật khẩu không hợp lệ!";
                    request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                    return;
                }
            //check if the account or password is empty or not
            }else if(request.getParameter("account").isEmpty()||request.getParameter("password").isEmpty()){
                System.out.println("TH2");
                errorMessage = "Đăng nhập thất bại, tài khoản hoặc mật khẩu không hợp lệ!";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                return;
            //If user is Customer
            }else{
                if(daoCus.checkLogin(request.getParameter("account"), request.getParameter("password"))){
                    Customer newCus = daoCus.getCustomerById(request.getParameter("account"));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", newCus);
                    request.getRequestDispatcher("index2.jsp").forward(request, response);
                    return;
                }else{
                    errorMessage = "Đăng nhập thất bại, tài khoản hoặc mật khẩu không hợp lệ!";
                    request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                    return;
                }
            }
        }catch(Exception ex){
            System.out.println("LoginController-doPost:"+ex.getMessage());
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
