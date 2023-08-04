/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CountItems;
import DAO.countSearch;
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
import model.Items;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "searchServlet", urlPatterns = {"/search"})
public class searchServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
       String searchTxt = request.getParameter("search");
       String num = request.getParameter("num");
       if(num==null || num.isEmpty()){
           num = "1";
       }
           int n = Integer.parseInt(num);
       
       List<Items> list = new ArrayList<>();
       int count = -1;
        countSearch c = new countSearch();
        CountItems ci = new CountItems();
         count = ci.getTotalItems();
         list = ci.getItemByPagingBy(n);
        if(!searchTxt.isEmpty()){
         count = c.countItemsbySearch(searchTxt);
         list = ci.getItemBySearch(n, searchTxt);
        }      
        int endPage = count/12;
        if(endPage%12!=0){
            endPage++;
        }
        request.setAttribute("listItems", list);
        request.setAttribute("endP", endPage);
        request.setAttribute("searcht", searchTxt);
        request.setAttribute("num", n);   
        request.setAttribute("action", "search");
       request.getRequestDispatcher("ListNameCateServlet").forward(request, response);
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
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
