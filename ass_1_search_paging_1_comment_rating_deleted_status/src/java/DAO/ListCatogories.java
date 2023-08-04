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
import model.Catogories;
import model.Items;
import DBUtils.DBUtils;

/**
 *
 * @author Tuan
 */
public class ListCatogories {
    public List<Catogories> listAll(){
        String sql = "select * from categorys ";
        List<Catogories> list = new ArrayList<>();
        try {
            Connection con = DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Catogories c = new Catogories();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
   
    public List<Items> listItemsBycid(String c){
        List<Items> list = new ArrayList<>();
        String sql = "select * from items where categoryID = ? and deleted = 1";
        try {
            Connection con = DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c);
            ResultSet rs = st.executeQuery();
              while(rs.next()){
             Items i = new Items();
             i.setId(rs.getInt("id"));
              i.setName(rs.getString("name"));
               i.setDesciption(rs.getString("desciption"));
                i.setPrice(rs.getDouble("price"));
                 i.setImagePath(rs.getString("imagePath"));
                 i.setCategoryID(rs.getInt("categoryID"));
                 i.setStatus(rs.getInt("status"));
                 list.add(i);              
           }
        } catch (Exception e) {
        }
        return list;
    }
     public int getTotalItems(int c) throws Exception{
        String sql = " select count(*) from items where categoryID = ? and deleted = 1";
        Connection con = DBUtils.makeConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, c);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
