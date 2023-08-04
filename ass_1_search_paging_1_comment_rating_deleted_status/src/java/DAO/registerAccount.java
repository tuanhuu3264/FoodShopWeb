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
public class registerAccount {
    public void registerAccount(String user, String pass, String email,String phone,String name, String address) throws Exception{
        String sql = "insert into accounts(username, password,email, phone,name,address) values (?,?,?,?,?,?)";
        Connection con = DBUtils.DBUtils.makeConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setString(3, email);
            st.setString(4, phone);
            st.setString(5, name);
            st.setString(6, address);
          
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Account checkUser(String user){
        String sql = "select * from accounts where username = ?";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Account i = new Account();
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
