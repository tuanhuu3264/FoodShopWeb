/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.RevenueDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductTop;
import model.Revenue;

/**
 *
 * @author DELL
 */
public class dashboard extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        String revenuetxt= request.getParameter("revenue");
        if(revenuetxt==null||revenuetxt.equals("")) revenuetxt="Month";
        
        response.setContentType("text/html;charset=UTF-8");
        List<ProductTop> listT= ProductDAO.getTopProduct();
        List<Revenue> listR;
        String tileRevenueDash;
        if(revenuetxt.equals("Month")) { tileRevenueDash="Revenue by Month of Year";
                                        listR=RevenueDAO.getMonth();
        }
        else {
            tileRevenueDash="Revenue by Day of Month";
            listR=RevenueDAO.getDay();
        }
        int numberRefused = OrderDAO.numberRefusedOrder();
        double revenue=OrderDAO.RevenueMonth(); 
        int numberPending= OrderDAO.PendingOrder();
        double yearRevenue=OrderDAO.RevenueYear();
        double dayRevenue=OrderDAO.RevenueDay();
        request.setAttribute("yearrevenue", yearRevenue);
        request.setAttribute("dayrevenue", dayRevenue);
        request.setAttribute("monthrevenue",revenue);
        request.setAttribute("pendingOrder",numberPending);
        request.setAttribute("refusedOrder", numberRefused);
        request.setAttribute("Tlist", listT);
        request.setAttribute("revenues", listR);
        request.setAttribute("checkSelect",revenuetxt);
        request.setAttribute("titleDashBoard",tileRevenueDash);
        request.getRequestDispatcher("DashBoard.jsp").forward(request, response);
        
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
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
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
