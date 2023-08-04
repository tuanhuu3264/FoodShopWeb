/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author Tuan
 */
public class inforAccount {
    public Account getInforAccount(){
        String sql = "select * from accounts";
         try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Account i = new Account();
                 // private int id;
   // private String username, password, email, phone, address, role, name, sex;
             i.setId(rs.getInt("id"));
              i.setUsername(rs.getString("username"));
               i.setPassword(rs.getString("password"));
               i.setEmail(rs.getString("email"));
               i.setPhone(rs.getString("phone"));
               i.setRole(rs.getString("role"));
               i.setName(rs.getString("name"));
               i.setAddress(rs.getString("address"));
              
                 return i;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
