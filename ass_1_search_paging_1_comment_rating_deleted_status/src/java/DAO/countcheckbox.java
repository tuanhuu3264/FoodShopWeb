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
public class countcheckbox {
    public int countCheckBox(double a, double b) throws Exception{
        String sql = "select count(*) from items where price between ? and ? and deleted = 1 ";
        Connection con = DBUtils.DBUtils.makeConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setDouble(1, a);
            st.setDouble(2, b);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public List<Items> getItemByPaging(double a, double b, int i){
        List<Items> list = new ArrayList<>();
      String sql ="select * from items where price between ? and ? and deleted = 1 order by id offset ? rows fetch next 12 rows only";;

        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);

                st.setDouble(1, a);
                 st.setDouble(2, b);
             
                st.setInt(3, (i-1)*12);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Items l = new Items();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setDesciption(rs.getString("description"));
                l.setPrice(rs.getDouble("price"));
                 l.setImagePath(rs.getString("imagePath"));
                 l.setCategoryID(rs.getInt("categoryID"));
                 l.setDeleted(rs.getInt("deleted"));
                 l.setStatus(rs.getInt("status"));
                 list.add(l);        
            }
        } catch (Exception e) {
        }
        return list;
    }
}
