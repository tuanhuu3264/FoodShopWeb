/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUntils.DBUtils;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CommentRating;

/**
 *
 * @author DELL
 */
public class CommentRatingDAO {
    public static List<CommentRating> listComment() throws Exception{
        List<CommentRating> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
         String PreparedStatement;
       String sql="select accountId,productId, content, rating\n" +
             "from commentRating\n" ;
       PreparedStatement st = cn.prepareStatement(sql); 


       try{ 
           ResultSet r=st.executeQuery(); 
           while(r.next()){
                CommentRating item= new CommentRating(r.getInt("accountId"),r.getInt("productId"),r.getString("content"),r.getInt("rating"));
                a.add(item);
               }
           
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       return a;
    }
    
    public static List<CommentRating> acordingComment(int idProduct) throws Exception{
        List<CommentRating> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
         String PreparedStatement;
       String sql="select accountId,productId, content, rating\n" +
             "from commentRating\n"
               + "where productId=?";
       PreparedStatement st = cn.prepareStatement(sql); 
       st.setInt(1, idProduct);

       try{ 
           ResultSet r=st.executeQuery(); 
           while(r.next()){
                CommentRating item= new CommentRating(r.getInt("accountId"),r.getInt("productId"),r.getString("content"),r.getInt("rating"));
                a.add(item);
               }
           
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       return a;
    } 
    public static void AddComment(CommentRating a) throws Exception{
         Connection cn=DBUtils.makeConnection();
         String PreparedStatement;
       String sql="insert into commentRating(accountId,productId,content,rating)\n" +
                   "values(?,?,?,?)";
       PreparedStatement st = cn.prepareStatement(sql); 
           st.setInt(1, a.getAccountID());
           st.setInt(2, a.getProductID());
           st.setString(3, a.getContent());
           st.setInt(4,a.getRating());
       try{ 
           st.executeUpdate(); 
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
    }
    public static int exist(int idAccount,int idProduct) throws Exception{
        List<CommentRating> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
         String PreparedStatement;
       String sql="select accountId,productId, content, rating\n" +
             "from commentRating\n"+
               "where accountId=? and productId=?";
       PreparedStatement st = cn.prepareStatement(sql); 
            st.setInt(1, idAccount);
            st.setInt(2, idProduct);

       try{ 
           ResultSet r=st.executeQuery(); 
           while(r.next()){
                CommentRating item= new CommentRating(r.getInt("accountId"),r.getInt("productId"),r.getString("content"),r.getInt("rating"));
                a.add(item);
               }
           
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       if(a.isEmpty()) return 0;
       else return 1;
       
    }
}
