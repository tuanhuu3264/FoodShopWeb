/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Items;

/**
 *
 * @author DELL
 */
public class ItemsDAO {
    public List<Items> getAll() throws Exception{        
        Connection cn=DBUtils.makeConnection();
       String sql="select * from items where deleted = 1";
       PreparedStatement st=cn.prepareStatement(sql); 
       List<Items> list= new ArrayList<>();
       ResultSet rs=st.executeQuery(); 
       try{    
           while(rs.next()){
             Items i = new Items();
             i.setId(rs.getInt("id"));
              i.setName(rs.getString("name"));
               i.setDesciption(rs.getString("description"));
                i.setPrice(rs.getDouble("price"));
                 i.setImagePath(rs.getString("imagePath"));
                 i.setCategoryID(rs.getInt("categoryID"));
                 i.setStatus(rs.getInt("status"));
                 list.add(i);              
           }
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
      return list;
    }
    public Items getItembyID(int id) throws Exception{
        Connection cn=DBUtils.makeConnection();
       String sql="select * from items where id = ?  and deleted = 1";
       PreparedStatement st=cn.prepareStatement(sql); 
       st.setInt(1, id);
       List<Items> list= new ArrayList<>();
       ResultSet rs=st.executeQuery(); 
       try{    
           while(rs.next()){
             Items i = new Items();
             i.setId(rs.getInt("id"));
              i.setName(rs.getString("name"));
               i.setDesciption(rs.getString("description"));
                i.setPrice(rs.getDouble("price"));
                 i.setImagePath(rs.getString("imagePath"));
                 i.setCategoryID(rs.getInt("categoryID"));
                 i.setStatus(rs.getInt("status"));
                 return i;          
           }
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       return null;
    }
    public int getQuantitybyID(int id) throws SQLException, Exception{
       Connection con = DBUtils.makeConnection();
       String sql = " SELECT SUM(op.quantity) AS total_quantity\n" +
"FROM orderProperties op\n" +
"JOIN orders o ON op.orderID = o.orderID\n" +
"WHERE o.status = 2 AND op.itemID = ?;";
       PreparedStatement st = con.prepareStatement(sql);
       st.setInt(1, id);
       ResultSet rs = st.executeQuery();
        try {
            if(rs.next()){
            return rs.getInt(1);   
            }
        } catch (Exception e) {
        }
         return 0;   
    }
    public static void main(String[] args) throws Exception {
        ItemsDAO i = new ItemsDAO();
        int count = i.getQuantitybyID(34);
        System.out.println(count);
    }
}
