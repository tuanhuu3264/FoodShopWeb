/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CountItems;
import DAO.ItemsDAO;
import DAO.ListCatogories;
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
import model.Catogories;
import model.Items;
import org.eclipse.jdt.core.compiler.CategorizedProblem;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "ListCatogoriesServlet", urlPatterns = {"/ListCatogoriesServlet"})
public class ListCatogoriesServlet extends HttpServlet {

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
        String Cid =null;
        Cid = request.getParameter("cid");
        int cid;
        if(Cid==null) Cid="0";
        try{
        cid=Integer.parseInt(Cid);
        }catch(Exception e){
            cid=0;
        }
       ListCatogories l = new ListCatogories();
       List<Items> listt = null;
      CountItems c = new CountItems(); 
      ItemsDAO it = new ItemsDAO();
      String num = request.getParameter("num");          
       if(num==null|| num.isEmpty()){
            num = "1";
            
        }           
        int count = -1;
        int n = Integer.parseInt(num); 
        if(Cid==null|| Cid.equals("0")){
            count = c.getTotalItems();
            listt = c.getItemByPagingBy(n);           
        }
        else{
        count = l.getTotalItems(cid);
        listt = c.getItemByPaging(n, cid);  
        }
        int end = count/12;
        if(count % 12 != 0){
            end++;
        }                      
        request.setAttribute("endP", end);      
     //  request.setAttribute("listC", list1);
       request.setAttribute("cid", cid);
       request.setAttribute("listItems", listt);
       request.setAttribute("num", n);
       request.setAttribute("action", "filter");
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
            Logger.getLogger(ListCatogoriesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ListCatogoriesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
