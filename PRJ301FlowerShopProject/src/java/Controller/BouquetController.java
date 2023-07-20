/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAOBouquet;
import DAL.DAOBouquetType;
import DAL.DAOEmployee;
import Model.Bouquet;
import Model.BouquetType;
import Model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@MultipartConfig(
        fileSizeThreshold = 2048,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 50
)
/**
 *
 * @author Lenovo
 */
public class BouquetController extends HttpServlet {

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
            out.println("<title>Servlet BouquetController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BouquetController at " + request.getContextPath() + "</h1>");
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
            //Display bouquet Info
            if (request.getParameter("info") != null) {
                HttpSession session = request.getSession(false);
                //check if user login or not
                if (session.getAttribute("user") == null) {
                    response.sendRedirect("login");
                    return;
                }

                
                
                //import bouquet Type List
                DAOBouquetType daoType = new DAOBouquetType();
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());

                DAOBouquet daoBouquet = new DAOBouquet();
                request.setAttribute("bouquetInfo", daoBouquet.getBouquetById(request.getParameter("id")));
                
                DAOBouquetType daoBouquetType = new DAOBouquetType();
                request.setAttribute("daoBouquetType", daoBouquetType);
                
                request.getRequestDispatcher("BouquetInfo.jsp").forward(request, response);
            }

            //If admin choose add
            if (request.getParameter("add") != null) {
                //check session is valid or not
                HttpSession session = request.getSession(false);
                //check user is login or not
                if (session == null || session.getAttribute("user") == null) {
                    out.print("You are not allowed to enter this page");
                    return;
                    //check if user is admin or not
                } else if (session.getAttribute("user") instanceof Customer) {
                    out.print("You are not allowed to enter this page!");
                    return;
                }

                DAOBouquetType daoType = new DAOBouquetType();
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                request.getRequestDispatcher("addBouquet.jsp").forward(request, response);
                //If admin want to update Bouquet
            } else if (request.getParameter("update") != null) {
                //check session is valid or not
                HttpSession session = request.getSession(false);
                //check the user is logined or not
                if (session == null || session.getAttribute("user") == null) {
                    out.print("You are not allowed to enter this page!");
                    return;
                    //check if the user is admin or not
                } else if (session.getAttribute("user") instanceof Customer) {
                    out.print("You are not allowed to enter this page!");
                    return;
                }
                //import bouquet Type List
                DAOBouquetType daoType = new DAOBouquetType();
                request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
                DAOBouquet daoBouquet = new DAOBouquet();
                //import Bouquet Info
                Bouquet newBouquet = daoBouquet.getBouquetById(request.getParameter("id"));
                request.setAttribute("bouquetInfo", newBouquet);
                request.getRequestDispatcher("UpdateBouquet.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BouquetController.class.getName()).log(Level.SEVERE, null, ex);
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
        DAOBouquet daoBouquet = new DAOBouquet();
        DAOEmployee daoEmp = new DAOEmployee();
        DAOBouquetType daoBouquetType = new DAOBouquetType();

        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            //check if user if login or not
            if (session == null || session.getAttribute("user") == null) {
                out.print("You are not allowed to enter this page!");
                return;
            }
            //check if user is admin or not
            if (session.getAttribute("user") instanceof Customer) {
                out.print("You are not allowed to enter this page!");
                return;
            }

            //check if admin want to update or not
            if (request.getParameter("update") != null) {       //Update Bouquet
                if(!checkValid(request, response)){
                    return;
                }

                Bouquet newBouquet = new Bouquet();
                newBouquet.setBouquetId(request.getParameter("bouquetId"));
                newBouquet.setBouquetName(request.getParameter("bouquetName"));
                newBouquet.setBouquetType(Integer.parseInt(request.getParameter("bouquetTypeId")));
                newBouquet.setBouquetDesc(request.getParameter("bouquetDescription"));
                newBouquet.setBouquetPrice(Float.parseFloat(request.getParameter("bouquetPrice")));
                newBouquet.setBouquetDiscount(Float.parseFloat(request.getParameter("bouquetDiscount")));
                //check if the file is upload or not
                if (request.getPart("fileInput") != null && request.getPart("fileInput").getSize() != 0) {
                    uploadFile(request, response, newBouquet);
                } else {
                    newBouquet.setBouquetImageUrl(request.getParameter("bouquetImageUrl"));
                }
                newBouquet.setBouquetQuantity(Integer.parseInt(request.getParameter("bouquetQuantity")));

                if(request.getParameter("isDisplayed").equals("true"))
                    newBouquet.setDisplayed(true);
                else
                    newBouquet.setDisplayed(false);

                daoBouquet.updateBouquet(newBouquet, request.getParameter("bouquetId"));
                //if admin want to delete bouquet
            } else if (request.getParameter("delete") != null) {    //Delete Bouquet
                String id = request.getParameter("bouquetId");
                daoBouquet.deleteBouquetById(id);

            } else {                                              //Add Bouquet
                if(!checkValid(request, response)){
                    return;
                }

                Bouquet newBouquet = new Bouquet();
                newBouquet.setBouquetId(request.getParameter("bouquetId"));
                newBouquet.setBouquetName(request.getParameter("bouquetName"));
                newBouquet.setBouquetType(Integer.parseInt(request.getParameter("bouquetTypeId")));
                newBouquet.setBouquetDesc(request.getParameter("bouquetDescription"));
                newBouquet.setBouquetPrice(Float.parseFloat(request.getParameter("bouquetPrice")));
                newBouquet.setBouquetDiscount(Float.parseFloat(request.getParameter("bouquetDiscount")));
                
                //check if the file is upload or not
                if (request.getPart("fileInput") != null && request.getPart("fileInput").getSize() != 0) {
                    uploadFile(request, response, newBouquet);
                } else {
                    newBouquet.setBouquetImageUrl(request.getParameter("bouquetImageUrl"));
                }
                newBouquet.setBouquetQuantity(Integer.parseInt(request.getParameter("bouquetQuantity")));
                newBouquet.setDisplayed(request.getParameter("isDisplayed") != null);

                daoBouquet.addBouquet(newBouquet);
            }

            response.sendRedirect("admin");
        } catch (SQLException ex) {
            Logger.getLogger(BouquetController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BouquetController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void saveInfomation(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("bouquetId", request.getParameter("bouquetId"));
        request.setAttribute("bouquetName", request.getParameter("bouquetName"));
        request.setAttribute("bouquetTypeId", request.getParameter("bouquetTypeId"));
        request.setAttribute("bouquetDescription", request.getParameter("bouquetDescription"));
        request.setAttribute("bouquetPrice", request.getParameter("bouquetPrice"));
        request.setAttribute("bouquetDiscount", request.getParameter("bouquetDiscount"));
        request.setAttribute("bouquetImageUrl", request.getParameter("bouquetImageUrl"));
        request.setAttribute("bouquetQuantity", request.getParameter("bouquetQuantity"));
        request.setAttribute("isDisplayed", request.getParameter("isDisplayed"));
    }

    private void uploadFile(HttpServletRequest req, HttpServletResponse resp, Bouquet newBouquet) {
        try {
            Part part = req.getPart("fileInput");
            String realPath = getInitParameter("fileUpload");
            System.out.println(realPath);
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectory(Paths.get(realPath));
            }
            newBouquet.setBouquetImageUrl("http://localhost:8080/PRJ301FlowerShopProject/Resource/object-image/" + part.getSubmittedFileName());
            part.write(realPath + "/" + part.getSubmittedFileName());
        } catch (Exception ex) {
            Logger.getLogger(BouquetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkValid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, Exception {
        DAOBouquet daoBouquet = new DAOBouquet();
        try {
            //check if user typed empty value or not
            if (request.getParameter("bouquetId") == null || request.getParameter("bouquetId").isEmpty()
                    || request.getParameter("bouquetName") == null || request.getParameter("bouquetName").isEmpty()
                    || request.getParameter("bouquetTypeId") == null || request.getParameter("bouquetTypeId").isEmpty()
                    || request.getParameter("bouquetDescription") == null || request.getParameter("bouquetDescription").isEmpty()
                    || request.getParameter("bouquetPrice") == null || request.getParameter("bouquetPrice").isEmpty()
                    || request.getParameter("bouquetDiscount") == null || request.getParameter("bouquetDiscount").isEmpty()
                    || ((request.getParameter("bouquetImageUrl") == null || request.getParameter("bouquetImageUrl").isEmpty()) && request.getPart("fileInput") == null)
                    || request.getParameter("bouquetQuantity") == null || request.getParameter("bouquetQuantity").isEmpty()) {
                throw new Exception("Error: Empty String!");
            }
            //check if Bouquet id is duplicate or not
            if (request.getParameter("update")==null&&daoBouquet.checkExistBouquetId(request.getParameter("bouquetId"))) {
                throw new Exception("Error: Duplicate Id!");
            }
            //check if admin choose 0 or not
            if (request.getParameter("bouquetTypeId").equals("0")) {
                throw new Exception("Error: You must select an Type option!");
            }
            float test = Float.parseFloat(request.getParameter("bouquetDiscount"));
            //check if the discount is >= 1 and <0 or not
            if (Float.parseFloat(request.getParameter("bouquetDiscount")) >= 1 || Float.parseFloat(request.getParameter("bouquetDiscount")) < 0) {
                throw new Exception("Error: The discount must be positive and < 1");
            }
            return true;
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            //import bouquet Type List
            DAOBouquetType daoType = new DAOBouquetType();
            request.setAttribute("bouquetTypeList", daoType.getBouquetTypeList());
            saveInfomation(request, response);
            if(request.getParameter("add")!=null)
                request.getRequestDispatcher("addBouquet.jsp").forward(request, response);
            //update
            else{
                request.setAttribute("bouquetInfo", daoBouquet.getBouquetById(request.getParameter("bouquetId")));
                request.getRequestDispatcher("UpdateBouquet.jsp").forward(request, response);
            }
            return false;
        }
    }
}
