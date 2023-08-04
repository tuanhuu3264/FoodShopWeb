/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ItemsDAO;
import DAO.RatingDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.Items;
import model.Rating;

/**
 *
 * @author DELL
 */
@WebServlet(name = "detailProductServlet", urlPatterns = {"/detailproduct"})
public class detailProductServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("sid");
        int id = 0;
        try {
            id = Integer.parseInt(sid);
        } catch (Exception e) {
            response.sendRedirect("list");
        }
        ItemsDAO dao = new ItemsDAO();
        Items t = dao.getItembyID(id);
        int totalquantity = dao.getQuantitybyID(id);
        List<Rating> listR = RatingDAO.getRatingByProduct(id);
        HttpSession session = request.getSession(true);
        Account a = (Account) session.getAttribute("account");
        boolean checkAccount = false;
        boolean checkBought = false;
        boolean checkCommentRating = false;
        Rating com=null;
        double avgRating= RatingDAO.arrageStar(id);
        if (a != null) {

            checkAccount = true;
            checkBought = RatingDAO.checkBought(id, a.getId());
            if (checkBought == true) {
                checkCommentRating = RatingDAO.checkCommentRating(id, a.getId());
                if(checkCommentRating==true) com=RatingDAO.getRatingWithAcc(id,a.getId());
                request.setAttribute("yourComment", com);
            }
            request.setAttribute("checkAccount", checkAccount);
            request.setAttribute("checkBought", checkBought);
        }
        request.setAttribute("totalquantity", totalquantity);
        request.setAttribute("avgRating", avgRating);
        request.setAttribute("item", t);
        request.setAttribute("listR", listR);
        request.getRequestDispatcher("detailItem.jsp").forward(request, response);
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
            Logger.getLogger(detailProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(detailProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
