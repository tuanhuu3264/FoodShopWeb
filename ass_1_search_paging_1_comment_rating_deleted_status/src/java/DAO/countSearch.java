/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Items;

/**
 *
 * @author Tuan
 */
public class countSearch {
    public int countItemsbySearch(String txt){
       
        String sql = "select count(*) from items where name like ? and deleted = 1";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,"%" + txt + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public static void main(String[] args) {
        countSearch c = new countSearch();
        int count = c.countItemsbySearch("chi");
        System.out.println(count);
    }
}
