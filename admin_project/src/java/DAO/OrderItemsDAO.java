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
import model.Order_Items;
import model.Product;

/**
 *
 * @author DELL
 */
public class OrderItemsDAO {
    public static List<Order_Items> getListItems(int id) throws SQLException, Exception{ 
           List<Order_Items> a= new ArrayList(); 
       Connection cn=DBUtils.makeConnection();
         String PreparedStatement;
       String sql="select o.orderID, o.itemID, o.quantity, i.id, i.imagePath, i.name, i.price, i.price\n" +
  "from orderProperties as o\n" +
"left join items as i\n" +
"on i.id=o.itemID\n" +
"where orderID=?" ;
       PreparedStatement st = cn.prepareStatement(sql); 
       st.setInt(1, id);
       try{ 
           ResultSet r=st.executeQuery(); 
           while(r.next()){
                Product o= new Product(r.getInt("id"),r.getString("name"),r.getString("imagepath"),r.getDouble("price"));
                Order_Items oi = new Order_Items(r.getInt("orderID"), o, r.getInt("quantity"));
                a.add(oi);
               }
           
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
       return a;
    }
}
