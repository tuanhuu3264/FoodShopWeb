/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.addtocart.buynow;

import DAO.ItemsDAO;
import DAO.status.statusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.CartBuynow;
import model.Items;
import model.Products;
import model.Productsbuynow;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "BuynowServlet", urlPatterns = {"/buynow"})
public class BuynowServlet extends HttpServlet {

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
          HttpSession session = request.getSession(true);
       CartBuynow cart1 = new CartBuynow();
//       Object o = session.getAttribute("cart1");
//       //có rồi
//       if(o!=null){
//           cart1 = (CartBuynow)o;
//       }else{
//           cart1 = new CartBuynow();
//       }
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
        statusDAO st = new statusDAO();
       int status = 0;
        status = st.getStatusItem(itemID);
        try {
             if(status==1){
            ItemsDAO itemDAO = new ItemsDAO();
            Items item = new Items();
            item = itemDAO.getItembyID(itemID);
            Productsbuynow p = new Productsbuynow(item, num, item.getPrice());
            cart1.addProduct(p);         
            session.setAttribute("cart1", cart1);
            request.getRequestDispatcher("inforCheckout_buynow.jsp").forward(request, response);
             }
             else{                
               request.setAttribute("hetHang", 0);
               request.getRequestDispatcher("list").forward(request, response);
             }
        } catch (Exception e) {
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
