/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static java.lang.System.out;
import java.util.List;
import model.Account;
import model.Category;
import model.CommentRating;
import model.Order;
import model.Order_Items;
import model.Product;
import model.ProductTop;
import model.Revenue;

/**
 *
 * @author DELL
 */
public class main {
    public static void main(String[] args) throws Exception{
        Product o = ProductDAO.getProduct(40);
        List<Category> a= CategoryDAO.getAll();
      out.println(o.getId()+" - "+o.getName());
      out.println(ProductDAO.updateProduct(40, "sadsasda", "asdsada", 7.2, "123321", 1, 1004));
      
        /*Account a= AccountDAO.getAccount("tuantrinh","0905164896");
    if (a!=null)        System.out.println(a.getId()+","+a.getUsername()+","+a.getPassword());
    List<Product> list= ProductDAO.listProduct();
    for(Product i : list) out.println(i.getId()+","+i.getName());
    List<CommentRating> listE=CommentRatingDAO.acordingComment(1);
    for(CommentRating i : listE) out.println(i.getAccountID()+","+i.getProductID()+","+i.getContent()+","+i.getRating());
    Product b= ProductDAO.getProduct(1); 
    System.out.println(b.getId()+","+b.getName());
    CommentRatingDAO.AddComment(new CommentRating(1,1,"1",1));
    out.println(DAO.CommentRatingDAO.exist(3, 1));*/
    }
    
    
}
