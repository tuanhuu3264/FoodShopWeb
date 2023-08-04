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
import model.Items;

/**
 *
 * @author Tuan
 */
public class AccountDAO extends DBUtils.DBUtils{
    public Account getAccount(String user, String pass){
        String sql = "select * from accounts where username = ? and password = ? and role = 'US'";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
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
               i.setAddress(rs.getString("address"));
               i.setRole(rs.getString("role"));
               i.setName(rs.getString("name"));
            
              
                 return i;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
