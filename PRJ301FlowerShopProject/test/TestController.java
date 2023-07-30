

import DAL.DAOBouquet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class TestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String imgNumValue = req.getParameter("imgNum");
            DAOBouquet daoBouquet = new DAOBouquet();
            req.setAttribute("bouquetList", daoBouquet.getBouquetList());
            if (req.getParameter("imgNumValue") != null) {
                int pageNum;
                if (req.getParameter("Next") != null) {
                    pageNum = Integer.parseInt(req.getParameter("imgNumValue")) + 1;
                    if (pageNum == daoBouquet.getBouquetList().size()) {
                        req.setAttribute("imgNum", 0);
                    }
                } else {
                    pageNum = Integer.parseInt(req.getParameter("imgNumValue")) - 1;
                    if (pageNum == 0) {
                        req.setAttribute("imgNum", daoBouquet.getBouquetList().size()-1);
                    }
                }
            } else {
                int pageNum = 0;
                req.setAttribute("imgNum", pageNum);
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
