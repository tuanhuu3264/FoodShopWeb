/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import model.Account;
import model.Cart;
import model.CartBuynow;
import model.Products;
import model.Productsbuynow;

/**
 *
 * @author Tuan
 */
public class OrderDAO {
    public void addOrder(Account a, Cart cart, String address, String phone){
        LocalDate curDate = java.time.LocalDate.now();
    String date = curDate.toString();
    try {
        String sql = "insert into orders(accountID, total, dateBuy, address, phone) values(?,?,?,?,?)";
        Connection con = DBUtils.DBUtils.makeConnection();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, a.getId());
        st.setDouble(2, cart.getTotalMoney());
        st.setString(3, date);
        st.setString(4, address);
        st.setString(5, phone);
        st.executeUpdate();
        String sql1 = "SELECT top 1 orderID FROM orders ORDER BY orderID DESC ";
        PreparedStatement st1 = con.prepareStatement(sql1);
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            int orderId = rs.getInt(1);
            for (Products i : cart.getProduct()) {
                String sql2 = "insert into orderProperties values(?,?,?,?,?)";
                PreparedStatement st2 = con.prepareStatement(sql2);
                st2.setInt(1, orderId);
                st2.setInt(2, i.getItem().getId());
                st2.setInt(3, i.getQuantity());
                st2.setDouble(4, i.getItem().getPrice()*i.getQuantity());
                st2.setDouble(5, i.getItem().getPrice());
                st2.executeUpdate();
            }
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace(); 
    }
    
    }
    public void addOrder1(Account a, CartBuynow cart1, String address, String phone) {
         LocalDate curDate = java.time.LocalDate.now();
    String date = curDate.toString();
    try {
        String sql = "insert into orders(accountID, total, dateBuy, address, phone) values(?,?,?,?,?)";
        Connection con = DBUtils.DBUtils.makeConnection();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, a.getId());
        st.setDouble(2, cart1.getTotalMoney());
        st.setString(3, date);
        st.setString(4, address);
        st.setString(5, phone);
        st.executeUpdate();
        String sql1 = "SELECT top 1 orderID FROM orders ORDER BY orderID DESC ";
        PreparedStatement st1 = con.prepareStatement(sql1);
        ResultSet rs = st1.executeQuery();
        if (rs.next()) {
            int orderId = rs.getInt(1);
            for (Productsbuynow i : cart1.getProduct()) {
                String sql2 = "insert into orderProperties values(?,?,?,?,?)";
                PreparedStatement st2 = con.prepareStatement(sql2);
                st2.setInt(1, orderId);
                st2.setInt(2, i.getItem().getId());
                st2.setInt(3, i.getQuantity());
                st2.setDouble(4, i.getPrice()*i.getQuantity());
                st2.setDouble(5, i.getItem().getPrice());
                st2.executeUpdate();
            }
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace(); 
    }
    }
    
}
