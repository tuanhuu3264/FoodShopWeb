/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.status;

import DAO.status.statusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "statuscontroller", urlPatterns = {"/statuscontroller"})
public class statuscontroller extends HttpServlet {

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
            String action = request.getParameter("action");
            if (action.equals("pending")) {
                request.getRequestDispatcher("pending").forward(request, response);
            } else if (action.equals("progress")) {
                request.getRequestDispatcher("progress").forward(request, response);
            } else if (action.equals("complete")) {
                request.getRequestDispatcher("complete").forward(request, response);
            } else if (action.equals("cancel")) {
                request.getRequestDispatcher("cancell").forward(request, response);
            }
//            else if (action==null || action.equals("")) {
////                HttpSession session = request.getSession(true);
////                Account account = null;        
////                Object a = session.getAttribute("account");
////                if(a!=null){
////                 account = (Account)a;
////                 statusDAO dao= new statusDAO(); 
////                int listsize1=dao.getSizeStatus("Pending", account.getId());
////                int listsize2=dao.getSizeStatus("In Progress", account.getId());
////                int listsize3=dao.getSizeStatus("Completed", account.getId());
////                int listsize4=dao.getSizeStatus("Cancel", account.getId());
////                request.setAttribute("listsize1", listsize1);
////                request.setAttribute("listsize2", listsize2);
////                request.setAttribute("listsize3", listsize3);
////                request.setAttribute("listsize4", listsize4);
//            }

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
