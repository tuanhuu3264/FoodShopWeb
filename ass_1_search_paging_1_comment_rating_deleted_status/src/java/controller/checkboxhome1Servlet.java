/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CountItems;

import DAO.ListCatogories;
import DAO.countcheckbox;
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
import static jdk.nashorn.internal.objects.NativeMath.min;
import model.Catogories;
import model.Items;

/**
 *
 * @author Tuan
 */
@WebServlet(name = "checkboxhome1Servlet", urlPatterns = {"/home1"})
public class checkboxhome1Servlet extends HttpServlet {

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
            out.println("<title>Servlet checkboxhome1Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkboxhome1Servlet at " + request.getContextPath() + "</h1>");
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
     String[] pp = {"UNDER $2",
           "$2 TO $4",
           "ABOVE $4"
       }; 
    
      boolean[] pb = new boolean[pp.length+1];
      List<Items> items = new ArrayList<>();
      String[] price = request.getParameterValues("price");
    String num = request.getParameter("num");          

       if(num==null|| num.isEmpty()){
            num = "1";
            
        }     
        int count = -1;
        int n = Integer.parseInt(num); 
    countcheckbox co = new countcheckbox();
    CountItems cou = new CountItems();
    String pricex = "null";
      if(price!=null){
          double from = 0, to = 0;
          for(int i = 0; i < price.length; i++){
              List<Items> temp = new ArrayList<>();        
              if(price[i].equals("0")){
                  from = 0;
                  to = 100;
                   
                  try {
                      count = cou.getTotalItems();
                      items = cou.getItemByPagingBy(n);
                      
                  } catch (Exception ex) {
                      Logger.getLogger(checkboxhome1Servlet.class.getName()).log(Level.SEVERE, null, ex);
                  }               
                  pb[0] = true;
                  pricex=price[i];              
                  break;
              }
              else{
                if(price[i].equals("1")){
                    from = 0;
                    to = 2;
                    try {
                      count = co.countCheckBox(from, to);
                     temp = co.getItemByPaging(from, to, n);
                      
                  } catch (Exception ex) {
                      Logger.getLogger(checkboxhome1Servlet.class.getName()).log(Level.SEVERE, null, ex);
                  } 
                     items.addAll(temp);
                    pricex=price[i];
                     pb[1] = true;
                
                }
                if(price[i].equals("2")){
                    from = 2;
                    to = 4;
                    try {
                      count = co.countCheckBox(from, to);
                      temp = co.getItemByPaging(from, to, n);
                      
                  } catch (Exception ex) {
                      Logger.getLogger(checkboxhome1Servlet.class.getName()).log(Level.SEVERE, null, ex);
                  }
                     items.addAll(temp);
                     pricex=price[i];         
                     pb[2] = true;
                }
                if(price[i].equals("3")){
                    from = 4;
                    to = 100;
                    try {
                      count = co.countCheckBox(from, to);
                      temp = co.getItemByPaging(from, to, n);
                      
                  } catch (Exception ex) {
                      Logger.getLogger(checkboxhome1Servlet.class.getName()).log(Level.SEVERE, null, ex);
                  } 
                    items.addAll(temp);
                    pricex=price[i];                
                    pb[3] = true;
                }
              }
          }
      }
       int end = count/12;
        if(count % 12 != 0){
            end++;
        }        
      if(price == null){
          pb[0] = true;
      }
      
      request.setAttribute("endP", end); 
      request.setAttribute("listItems", items);     
      request.setAttribute("price", pricex);
      request.setAttribute("pb", pb);
      request.setAttribute("num", n);
      request.setAttribute("action", "checkbox");
      request.getRequestDispatcher("ListNameCateServlet").forward(request, response);   

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
