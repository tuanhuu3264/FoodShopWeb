///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import DAO.CountItems;
//import DAO.ListCatogories;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import model.Catogories;
//import model.Items;
//
///**
// *
// * @author Tuan
// */
//@WebServlet(name = "pagingServlet", urlPatterns = {"/pagingServlet"})
//public class pagingServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, Exception {
//        response.setContentType("text/html;charset=UTF-8");
//        CountItems c = new CountItems();  
//        ListCatogories l = new ListCatogories();
//        String Cid = request.getParameter("cid");
//        int cid=Integer.parseInt(Cid);
//        String num = request.getParameter("num");      
//        if(num==null|| num.isEmpty()){
//            num = "1";
//            
//        }
//        List<Items> listt;
//        int count = -1;
//        int n = Integer.parseInt(num);
//
//        if (Cid == null) {
//            count = c.getTotalItems();
//            listt = c.getItemByPagingBy(n);
//        } else if ("0".equals(Cid)) {
//            count = c.getTotalItems();
//            listt = c.getItemByPagingBy(n);
//        } else {
//            count = l.getTotalItems(cid);
//            listt = c.getItemByPaging(n, cid);
//        }
//
//        int end = count / 12;
//        if (count % 12 != 0) {
//            end++;
//        }
//        ListCatogories a = new ListCatogories();
//        List<Catogories> list = a.listAll();
//         request.setAttribute("listC", list);
//         request.setAttribute("listItems", listt);
//        request.setAttribute("endP", end); 
//        request.setAttribute("cid", cid);
//        request.getRequestDispatcher("index.jsp").forward(request, response);
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (Exception ex) {
//            Logger.getLogger(pagingServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (Exception ex) {
//            Logger.getLogger(pagingServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
