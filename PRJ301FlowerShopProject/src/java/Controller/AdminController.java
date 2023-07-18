/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAOBouquet;
import DAL.DAOBouquetType;
import DAL.DAOEmployee;
import Model.Bouquet;
import Model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class AdminController extends HttpServlet {

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
            out.println("<title>Servlet AdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminController at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession(false);
            //check user if login or not
            if (session == null || session.getAttribute("user") == null) {
                out.print("You are not allowed to enter this page!");
                return;
            } //check if user is customer or not
            else if (session.getAttribute("user") instanceof Customer) {
                out.print("You are not allowed to enter this page!");
                return;
            }
            //if admin want to show infomation
            if (request.getParameter("info") != null) {
                request.getRequestDispatcher("AdminInfo.jsp").forward(request, response);
                return;
            }

            DAOBouquetType daoBouquetType = new DAOBouquetType();
            DAOBouquet daoBouquet = new DAOBouquet();
            DAOEmployee daoEmp = new DAOEmployee();
            //import bouquet type map
            request.setAttribute("bouquetTypeMap", daoBouquetType.getBouquetTypeMap());
            //import Bouquet info
            request.setAttribute("bouquetList", daoBouquet.getBouquetList());
            //import Employee info
            request.setAttribute("empList", daoEmp.getEmployeeList());

            doSort(request, response);

            request.getRequestDispatcher("index3.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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

    private void doSort(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DAOBouquet daoBouquet = new DAOBouquet();
        ArrayList<Bouquet> list = new ArrayList<>();
        HttpSession session = request.getSession();
        //check if admin has already searched or not
        if (session.getAttribute("searchList") != null) {
            if (request.getParameter("bouquetName") == null || request.getParameter("bouquetName").isEmpty()) {
                list = daoBouquet.getBouquetList();
            } else {
                request.setAttribute("bouquetName", request.getParameter("bouquetName"));
                list = (ArrayList) session.getAttribute("searchList");
            }
        } else {
            list = daoBouquet.getBouquetList();
        }
        //sort = 0 --> ascending
        //sort = 1 --> descending
        //Check if admin want to sort by id or not
        if (request.getParameter("idSort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("idSort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortId(list, 0));
                request.setAttribute("idSort", 1);
            } else if (request.getParameter("idSort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortId(list, 1));
                request.setAttribute("idSort", 0);
            }
        } else {
            request.setAttribute("idSort", 1);
        }

        //Check id admin want to sort by name or not
        if (request.getParameter("nameSort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("nameSort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortName(list, 0));
                request.setAttribute("nameSort", 1);
            } else if (request.getParameter("nameSort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortName(list, 1));
                request.setAttribute("nameSort", 0);
            }
        } else {
            request.setAttribute("nameSort", 1);
        }

        //check if admin want to sort by type or not
        if (request.getParameter("typeSort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("typeSort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortType(list, 0));
                request.setAttribute("typeSort", 1);
            } else if (request.getParameter("typeSort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortType(list, 1));
                request.setAttribute("typeSort", 0);
            }
        } else {
            request.setAttribute("typeSort", 0);
        }

        //check if admin want to sort by price or not
        if (request.getParameter("priceSort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("priceSort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortPrice(list, 0));
                request.setAttribute("priceSort", 1);
            } else if (request.getParameter("priceSort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortPrice(list, 1));
                request.setAttribute("priceSort", 0);
            }
        } else {
            request.setAttribute("priceSort", 0);
        }

        //check if admin want to sort by discount or not
        if (request.getParameter("discountSort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("discountSort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortDiscount(list, 0));
                request.setAttribute("discountSort", 1);
            } else if (request.getParameter("discountSort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortDiscount(list, 1));
                request.setAttribute("discountSort", 0);
            }
        } else {
            request.setAttribute("discountSort", 0);
        }

        //check if admin want to sort by quantity or not
        if (request.getParameter("quantitySort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("quantitySort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortQuantity(list, 0));
                request.setAttribute("quantitySort", 1);
            } else if (request.getParameter("quantitySort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortQuantity(list, 1));
                request.setAttribute("quantitySort", 0);
            }
        } else {
            request.setAttribute("quantitySort", 0);
        }

        //check if admin want to sort by displayed or not
        if (request.getParameter("displayedSort") != null) {
            //check if admin chose sort in asc or not
            if (request.getParameter("displayedSort").equals("0")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortDisplayed(list, 0));
                request.setAttribute("displayedSort", 1);
            } else if (request.getParameter("displayedSort").equals("1")) {
                request.setAttribute("bouquetList", SortBouquetByCate.sortDisplayed(list, 1));
                request.setAttribute("displayedSort", 0);
            }
        } else {
            request.setAttribute("displayedSort", 0);
        }
    }
}
