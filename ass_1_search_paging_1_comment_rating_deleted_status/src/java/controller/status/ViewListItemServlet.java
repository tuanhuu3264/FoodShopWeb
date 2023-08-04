/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.status;

import DAO.status.statusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Orders;
import model.statusItem;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "ViewListItemServlet", urlPatterns = {"/view"})
public class ViewListItemServlet extends HttpServlet {

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
      String o = request.getParameter("orderid");
      String s = request.getParameter("status");
      int status = Integer.parseInt(s);
      int orderID = Integer.parseInt(o);
      List<statusItem> list = new ArrayList<>();
      statusDAO st = new statusDAO();
      HttpSession session = request.getSession();
      Account account = null;
      Object a = session.getAttribute("account");
      if(a!=null){     
           list = st.listItemPending(orderID);
           double total = 0;
           for (statusItem item : list) {
              total+=item.getTotal();
          }
           request.setAttribute("total", total);
           request.setAttribute("viewlist", list);
           request.setAttribute("orderid", orderID);
           request.setAttribute("status", status);
           request.getRequestDispatcher("numberSizeStatus").forward(request, response);
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
        processRequest(request, response);
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

}
