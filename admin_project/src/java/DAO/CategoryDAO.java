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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author DELL
 */
public class CategoryDAO {
 public static List<Category> getAll() throws SQLException, Exception{
       List<Category> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
         String PreparedStatement;
       String sql="select id, name from categorys" ;
       PreparedStatement st = cn.prepareStatement(sql); 


       try{ 
           ResultSet r=st.executeQuery(); 
           while(r.next()){
                Category item= new Category(r.getInt("id"), r.getString("name"));
                a.add(item);
               }
           
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       return a;
    }    
    
}
