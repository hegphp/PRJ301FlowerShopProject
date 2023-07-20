/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAOBouquet;
import DAL.DAOBouquetType;
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
public class HomepageController extends HttpServlet {

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
            out.println("<title>Servlet Homepage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessRequest - HOMEPAGE at " + request.getContextPath() + "</h1>");
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
        try {

            HttpSession session = request.getSession(false);
            //check if user login or not
            if (session == null || session.getAttribute("user") == null) {
                DAOBouquetType daoType = new DAOBouquetType();
                DAOBouquet daoBouquet = new DAOBouquet();
                //import bouquet Type list
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                //import daoBouquet
                request.setAttribute("daoBouquet", daoBouquet);

                request.getRequestDispatcher("index4.jsp").forward(request, response);
            } else {
                DAOBouquetType daoType = new DAOBouquetType();
                DAOBouquet daoBouquet = new DAOBouquet();
                //import bouquet type list
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                //import bouquetDAO
                request.setAttribute("daoBouquet", daoBouquet);

                request.getRequestDispatcher("index4.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {

            HttpSession session = request.getSession(false);
            //check if user login or not
            if (session == null || session.getAttribute("user") == null) {
                DAOBouquetType daoType = new DAOBouquetType();
                DAOBouquet daoBouquet = new DAOBouquet();
                //import bouquet Type list
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                //import daoBouquet
                request.setAttribute("daoBouquet", daoBouquet);

                request.getRequestDispatcher("index4.jsp").forward(request, response);
            } else {
                DAOBouquetType daoType = new DAOBouquetType();
                DAOBouquet daoBouquet = new DAOBouquet();
                //import bouquet type map
                request.setAttribute("bouquetTypeMap", daoType.getBouquetTypeMap());
                //import bouquet type list
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                //import Bouquet info
                request.setAttribute("bouquetList", daoBouquet.getBouquetList());
                //import bouquetDAO
                request.setAttribute("daoBouquet", daoBouquet);

                request.getRequestDispatcher("index4.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, e);
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
