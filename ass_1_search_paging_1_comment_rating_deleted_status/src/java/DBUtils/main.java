/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import DAO.CountItems;
import DAO.RatingDAO;
import static java.lang.System.out;
import java.util.List;
import model.Items;
import model.Rating;
/**
 *
 * @author DELL
 */
public class main {
    public static void main(String[] args) throws Exception {
        
  
        Rating a= new Rating(1,40,3,"133","adad",null);
        boolean test=RatingDAO.insertComment(a);
        out.println(test);
    }
    
}
