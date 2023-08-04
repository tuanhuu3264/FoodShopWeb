/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Tuan
 */
public class updateAccount {
    public void updateAccount(String user, String pass, int id){
        String sql = "UPDATE accounts SET username = ?, password = ? WHERE id = ?";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
}
