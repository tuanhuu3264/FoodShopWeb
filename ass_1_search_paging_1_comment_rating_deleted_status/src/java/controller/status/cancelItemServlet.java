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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Orders;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "cancelServlet", urlPatterns = {"/cancel"})
public class cancelItemServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cancelServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cancelServlet at " + request.getContextPath() + "</h1>");
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
      String i = request.getParameter("orderid");
       String sta = request.getParameter("sta");
       int status = Integer.parseInt(sta);
         List<Orders> list = new ArrayList<>();       
        statusDAO st = new statusDAO();
        HttpSession session = request.getSession(true);
        Account account = null;        
        Object a = session.getAttribute("account");
      int orderid = Integer.parseInt(i); 
        try {
            st.cancelUser(orderid);                   
        if(a!=null){
            account = (Account)a;
            list = st.listItemByStatus(status, account.getId());
            if((status==0)){
                list = st.listsizeItem(status,account.getId());
            }
            request.setAttribute("liststatusUser", list);
            request.setAttribute("listsize1", list.size());
            request.setAttribute("sta", sta);
            request.getRequestDispatcher("numberSizeStatus").forward(request, response);
        }
        else{
             request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        } catch (Exception ex) {
            Logger.getLogger(cancelItemServlet.class.getName()).log(Level.SEVERE, null, ex);
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
