/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAOBouquet;
import DAL.DAOBouquetType;
import DAL.DAOCustomer;
import DAL.DAOEmployee;
import Model.Customer;
import Model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOBouquetType daoBouquetType = new DAOBouquetType();
        DAOBouquet daoBouquet = new DAOBouquet();
        DAOEmployee daoEmp = new DAOEmployee();
        //if user click logout
        if (request.getParameter("logout") != null) {
            System.out.println("Logout thanh cong!");
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            request.getRequestDispatcher("Homepage").forward(request, response);
        }
        //if user want to modify parameters
        if (request.getParameter("register") != null) {
            try {
                //import bouquet type list
                request.setAttribute("bouquetTypeList", daoBouquetType.getBouquetTypeList());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
        //if user want to check account info
        if (request.getParameter("info") != null) {
            String account = request.getParameter("account");
            HttpSession session = request.getSession(false);
            //check if session is null
            if (session == null || session.getAttribute("user") == null) {
                try {
                    //import bouquet type list
                    request.setAttribute("bouquetTypeList", daoBouquetType.getBouquetTypeList());
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                request.getRequestDispatcher("login").forward(request, response);
            }
            //check if user is admin or not
            if (session.getAttribute("user") instanceof Employee) {
                response.sendRedirect("admin");
            }else{
                try {
                    //import bouquet type list
                    request.setAttribute("bouquetTypeList", daoBouquetType.getBouquetTypeList());
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("UserInfo.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOBouquetType daoBouquetType = new DAOBouquetType();
        try {
            //import bouquet type list
            request.setAttribute("bouquetTypeList", daoBouquetType.getBouquetTypeList());
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Register
        DAOCustomer daoCus = new DAOCustomer();
        if (request.getParameter("register") != null) {
            try {
                //check empty account or password
                if (request.getParameter("accountInput").isEmpty() || request.getParameter("accountInput") == null
                        || request.getParameter("passwordInput") == null || request.getParameter("passwordInput").isEmpty()
                        || request.getParameter("repassword") == null || request.getParameter("repassword").isEmpty()) {
                    String errorMessage = "Error: Account or password is empty!";
                    request.setAttribute("errorMessage", errorMessage);

                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                    return;
                }
                //check password and repassword is the same or not
                if (!request.getParameter("passwordInput").equals(request.getParameter("repassword"))) {
                    String errorMessage = "Error: Password and Repassword must be the same!";
                    request.setAttribute("errorMessage", errorMessage);

                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                    return;
                }
                //check if the account if exist or not
                if (daoCus.checkIdExist(request.getParameter("accountInput")) || request.getParameter("accountInput").equals("admin")
                        || request.getParameter("accountInput").startsWith("emp")) {
                    String errorMessage = "Error: Invalid id!";
                    request.setAttribute("errorMessage", errorMessage);

                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                    return;
                }

                Customer newCustomer = new Customer();
                newCustomer.setCustomerId(request.getParameter("accountInput"));
                newCustomer.setCustomerPassword(request.getParameter("passwordInput"));
                newCustomer.setCustomerFirstName(request.getParameter("firstNameInput"));
                newCustomer.setCustomerLastName(request.getParameter("lastNameInput"));
                newCustomer.setCustomerGender(Integer.parseInt(request.getParameter("genderInput")));
                newCustomer.setCustomerPhone(request.getParameter("phoneInput"));
                newCustomer.setCustomerAddress(request.getParameter("addressInput"));
                newCustomer.setEmail(request.getParameter("emailInput"));

                daoCus.addCustomer(newCustomer);

                HttpSession session = request.getSession();
                session.setAttribute("user", newCustomer);

                DAOBouquet daoBouquet = new DAOBouquet();
                //import bouquet type map
                request.setAttribute("bouquetTypeMap", daoBouquetType.getBouquetTypeMap());
                //import bouquet type list
                request.setAttribute("bouquetTypeList", daoBouquetType.getBouquetTypeList());
                //import Bouquet info
                request.setAttribute("bouquetList", daoBouquet.getBouquetList());

                request.setAttribute("daoBouquet", daoBouquet);

                request.getRequestDispatcher("index2.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
