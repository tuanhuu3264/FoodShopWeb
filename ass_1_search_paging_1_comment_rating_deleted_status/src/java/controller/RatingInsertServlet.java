package controller;

import DAO.RatingDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Rating;

@WebServlet(name = "ratingInsert", urlPatterns = {"/ratingInsert"})
public class RatingInsertServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rating = request.getParameter("rating");
        String comment = request.getParameter("comment");
        int sid = Integer.parseInt(request.getParameter("sid"));

        HttpSession session=request.getSession(); 
        Account a = (Account) session.getAttribute("account");
        
        int ratings = 0;
        String messageRating = null;

        try {
            ratings = Integer.parseInt(rating);
        } catch (NumberFormatException e) {
            messageRating = "You need to choose a rating level.";
        }

        if (messageRating != null) {
            request.setAttribute("messageRating", messageRating);
            request.getRequestDispatcher("detailproduct").forward(request, response);
            return;
        }
         Rating rate=null;
        String message;
        if(a!=null)
        rate = new Rating(a.getId(), sid, ratings, a.getUsername(), comment, " ");
        
        try {
            boolean result = RatingDAO.insertComment(rate);

            if (result) {
                message = "Comment successful!";
            } else {
                message = "Failed to insert comment.";
            }
        } catch (Exception e) {
            message = "An error occurred while inserting the comment.";
            Logger.getLogger(RatingInsertServlet.class.getName()).log(Level.SEVERE, null, e);
        }

        request.setAttribute("message", message);
        request.setAttribute("sid", sid);
        request.getRequestDispatcher("detailproduct").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Rating Insert Servlet";
    }
}
