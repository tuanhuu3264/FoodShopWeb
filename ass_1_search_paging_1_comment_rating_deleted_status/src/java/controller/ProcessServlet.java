/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ItemsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Items;
import model.Products;

/**
 *
 * @author Tuan
 */
public class ProcessServlet extends HttpServlet {

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
            out.println("<title>Servlet ProcessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
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
      String num = request.getParameter("num");
      String id = request.getParameter("id");
      int numItem = Integer.parseInt(num);
      int idItem = Integer.parseInt(id);
         HttpSession session = request.getSession(true);
       Cart cart = null;
       Object a = session.getAttribute("cart");
       if(a!=null){
           cart = (Cart)a;
       }
       else{
           cart = new Cart();
       }
        try {
            if((numItem==-1) && ((cart.getQuantityByid(idItem))<=1)){
                cart.removeProduct(idItem);
               
            }
            else{
                ItemsDAO it = new ItemsDAO();
                Items i = it.getItembyID(idItem);
                Products p = new Products(i, numItem, i.getPrice());
                cart.addProduct(p);
            }
        } catch (Exception e) {
        }
        List<Products> list = cart.getProduct();
        double totalPrice = 0;
        int t = 0;
        for (Products p : list) {          
            t+=p.getQuantity();
            totalPrice+=p.getPrice()*p.getQuantity();
        }
         session.setAttribute("totalprice", totalPrice);
         session.setAttribute("totalquantity", t);
          session.setAttribute("size", list.size());
       session.setAttribute("cart", cart);
       request.getRequestDispatcher("cartItem.jsp").forward(request, response);
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
       String id = request.getParameter("id");
       int itemId = Integer.parseInt(id);
       HttpSession session = request.getSession(true);
       Cart cart = null;
       Object a = session.getAttribute("cart");
       if(a!=null){
           cart = (Cart)a;
       }
       else{
           cart = new Cart();
       }
       cart.removeProduct(itemId);
       List<Products> list = cart.getProduct();
        double totalPrice = 0;
        int t = 0;
        for (Products p : list) {          
            t+=p.getQuantity();
            totalPrice+=p.getPrice()*p.getQuantity();
        }
         session.setAttribute("totalprice", totalPrice);
         session.setAttribute("totalquantity", t);
       session.setAttribute("size", list.size());
       session.setAttribute("cart", cart);
       request.getRequestDispatcher("cartItem.jsp").forward(request, response);
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
