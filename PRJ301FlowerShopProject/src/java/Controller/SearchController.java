/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAOBouquet;
import DAL.DAOBouquetType;
import Model.Bouquet;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class SearchController extends HttpServlet {

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
            out.println("<title>Servlet SearchController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchController at " + request.getContextPath() + "</h1>");
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
        try ( PrintWriter out = response.getWriter()) {
            DAOBouquet daoBouquet = new DAOBouquet();
            String input = request.getParameter("bouquetName");
            ArrayList<Bouquet> output = daoBouquet.searchBouquetByName(input);
            request.setAttribute("result", output);

            HttpSession session = request.getSession(false);
            //import result
            session.setAttribute("searchList", output);

            //import bouquet Type List
            DAOBouquetType daoType = new DAOBouquetType();
            request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
            //import bouquet Name
            request.setAttribute("bouquetName", request.getParameter("bouquetName"));
            //import bouquet type map
            request.setAttribute("bouquetTypeMap", daoType.getBouquetTypeMap());
            //check user login or not
            if (session == null || session.getAttribute("user") == null) {
                request.getRequestDispatcher("SearchBouquet.jsp").forward(request, response);
                return;
                //check if user is Customer or not
            } else if (session.getAttribute("user") instanceof Customer) {
                request.getRequestDispatcher("SearchBouquet.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("bouquetList", output);
                session.setAttribute("searchList", output);
                
                request.setAttribute("nameSort", 0);
                request.setAttribute("typeSort", 0);
                request.setAttribute("priceSort", 0);
                request.setAttribute("discountSort", 0);
                request.setAttribute("quantitySort", 0);
                request.setAttribute("displayedSort", 0);
                request.setAttribute("idSort", 1);
                
                request.getRequestDispatcher("index3.jsp").forward(request, response);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
        //If user order asc
        if (request.getParameter("order").equals("asc")) {
            try {
                orderAsc(request, response);
                //import bouquet Type List
                DAOBouquetType daoType = new DAOBouquetType();
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                request.getRequestDispatcher("SearchBouquet.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //If user want to order desc
        if (request.getParameter("order").equals("desc")) {
            try {
                orderDesc(request, response);
                //import bouquet Type List
                DAOBouquetType daoType = new DAOBouquetType();
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                request.getRequestDispatcher("SearchBouquet.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        HttpSession session = request.getSession(false);
        if(session!=null&&(session.getAttribute("user") instanceof Employee)){
            
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

    private void orderAsc(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Bouquet> inputList = (ArrayList) session.getAttribute("searchList");
        inputList = SortBouquetByCate.sortPrice(inputList, 0);
        session.setAttribute("searchList", inputList);
        request.setAttribute("bouquetList", inputList);
        request.setAttribute("bouquetName", request.getParameter("bouquetName"));
    }

    private void orderDesc(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Bouquet> inputList = (ArrayList) session.getAttribute("searchList");
        inputList = SortBouquetByCate.sortPrice(inputList, 1);
        session.setAttribute("searchList", inputList);
        request.setAttribute("bouquetList", inputList);
        request.setAttribute("bouquetName", request.getParameter("bouquetName"));
    }

}
