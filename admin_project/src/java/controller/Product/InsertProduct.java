/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Product;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name = "InsertProduct", urlPatterns = {"/editCreate"})
public class InsertProduct extends HttpServlet {

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
//        
        String message=null;
        String messageName=null; 
        String messageImage=null; 
        String messagePrice=null; 
        String messageDes=null;
        int status=0;
        try{ 
            status=Integer.parseInt(request.getParameter("status")); 
        } catch( Exception e)
        {
            status=0;
        }
        double price = 0;
        String name=request.getParameter("name");
        int categoryId=Integer.parseInt(request.getParameter("category"));
        try{
         price = Double.parseDouble(request.getParameter("price"));
        } catch(NumberFormatException e){
            messagePrice="The price is not empty and must be a double. Please fill it!"; 
        }
        String imageP= request.getParameter("imagepath");
        String des= request.getParameter("description");
        if(name.equals("")) messageName="The name is not empty. Please fill it!";
        if(imageP.equals("")) messageImage="The image path is not empty. Please fill it!";
        if(des.equals("")) messageDes="The Describle is not empty. Please fill it!";
        if(messageName==null && messageDes==null && messageImage==null && messagePrice==null)
        {
         Product a= new Product (name,des,imageP,price,categoryId,status);
         ProductDAO.insertProduct(a);
         message="Create Successfully!"; 
         
        }
        else message="Create Fail!";
        request.setAttribute("categoryId",categoryId);
        request.setAttribute("name", name);
        request.setAttribute("imagepath", imageP);
        request.setAttribute("description", des);
        request.setAttribute("price", price);
        request.setAttribute("messageName", messageName);
        request.setAttribute("messageImage",messageImage);
        request.setAttribute("messagePrice", messagePrice);
        request.setAttribute("messageDes",messageDes);
        request.setAttribute("message",message);
  
       request.getRequestDispatcher("create").forward(request, response);
       
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
            Logger.getLogger(InsertProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertProduct.class.getName()).log(Level.SEVERE, null, ex);
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
