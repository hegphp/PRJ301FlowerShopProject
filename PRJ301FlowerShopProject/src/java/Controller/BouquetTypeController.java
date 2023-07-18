/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAOBouquet;
import DAL.DAOBouquetType;
import Model.Bouquet;
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
public class BouquetTypeController extends HttpServlet {

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
            out.println("<title>Servlet BouquetTypeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BouquetTypeController at " + request.getContextPath() + "</h1>");
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
            DAOBouquet daoBouquet = new DAOBouquet();
            DAOBouquetType daoType = new DAOBouquetType();
            request.setAttribute("bouquetList", daoBouquet.getBouquetListByTypeId(Integer.parseInt(request.getParameter("id"))));

            request.setAttribute("bouquetType", daoType.getBouquetTypeNameById(Integer.parseInt(request.getParameter("id"))));
            //import bouquet type list
            request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
            request.setAttribute("id", request.getParameter("id"));

            request.getRequestDispatcher("BouquetListByType.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BouquetTypeController.class.getName()).log(Level.SEVERE, null, ex);
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
        //if user want to sort ascending
        if (request.getParameter("order").equals("asc")) {
            try {
                orderAsc(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BouquetTypeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //if user want to sort descending
        if (request.getParameter("order").equals("desc")) {
            try {
                orderDesc(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BouquetTypeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        DAOBouquetType daoType = new DAOBouquetType();
        try {
            //import bouquetName
            request.setAttribute("bouquetType", daoType.getBouquetTypeNameById(Integer.parseInt(request.getParameter("id"))));
            //import bouquet type list
            request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
        } catch (SQLException ex) {
            Logger.getLogger(BouquetTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("id", request.getParameter("id"));
        request.getRequestDispatcher("BouquetListByType.jsp").forward(request, response);
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

    private void orderAsc(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DAOBouquet daoBouquet = new DAOBouquet();
        HttpSession session = request.getSession();
        ArrayList<Bouquet> inputList = daoBouquet.getBouquetListByTypeId(Integer.parseInt(request.getParameter("id")));
        Collections.sort(inputList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                if (o1.getBouquetPrice() > o2.getBouquetPrice()) {
                    return 1;
                } else if (o1.getBouquetPrice() < o2.getBouquetPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        request.setAttribute("bouquetList", inputList);
    }

    private void orderDesc(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DAOBouquet daoBouquet = new DAOBouquet();
        HttpSession session = request.getSession();
        ArrayList<Bouquet> inputList = daoBouquet.getBouquetListByTypeId(Integer.parseInt(request.getParameter("id")));
        Collections.sort(inputList, new Comparator<Bouquet>() {
            @Override
            public int compare(Bouquet o1, Bouquet o2) {
                if (o1.getBouquetPrice() > o2.getBouquetPrice()) {
                    return -1;
                } else if (o1.getBouquetPrice() < o2.getBouquetPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        request.setAttribute("bouquetList", inputList);
    }

}
