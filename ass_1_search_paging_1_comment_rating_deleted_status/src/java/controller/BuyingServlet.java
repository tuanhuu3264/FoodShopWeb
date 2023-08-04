/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import DAO.ItemsDAO;
import DAO.ListCatogories;
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
import model.Cart;
import model.Catogories;
import model.Items;
import model.Products;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "BuyingServlet", urlPatterns = {"/buy"})
public class BuyingServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
       Cart cart = null;
       Object o = session.getAttribute("cart");
       //có rồi
       if(o!=null){
           cart = (Cart)o;
       }else{
           cart = new Cart();
       }
        int num;
//       String n = request.getParameter("num");
//     num1 = Integer.parseInt(n);
        if(request.getParameter("numvalue")==null){
            num = 1;
        }
        else{
            num = Integer.parseInt(request.getParameter("numvalue"));
        }
       String id = request.getParameter("id");
       int itemID = Integer.parseInt(id);
       // check xem còn hàng hay không
       statusDAO st = new statusDAO();
       int status = 0;
        status = st.getStatusItem(itemID);
       
        try {
            if(status==1){
            ItemsDAO itemDAO = new ItemsDAO();
            Items item = new Items();
            item = itemDAO.getItembyID(itemID);
            Products p = new Products(item, num, item.getPrice());
            cart.addProduct(p);
             
            }
            else{
                request.setAttribute("hetHang", 0);
               request.getRequestDispatcher("list").forward(request, response);
            
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
        session.setAttribute("cart", cart);
        request.setAttribute("success", 1);
      //  request.setAttribute("id", itemID);
        session.setAttribute("size", list.size());
        request.getRequestDispatcher("list").forward(request, response);
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
            Logger.getLogger(BuyingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BuyingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
