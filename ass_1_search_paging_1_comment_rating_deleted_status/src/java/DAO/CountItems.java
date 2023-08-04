/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static java.lang.System.out;
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
public class CountItems {
    public int getTotalItems() throws Exception{
        String sql = "select count(*) from items where deleted = 1";
        Connection con = DBUtils.DBUtils.makeConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            out.println("not sess"+e);
        }
        return 0;
    }
   
    public List<Items> getItemByPaging(int i, int cid){
        List<Items> list = new ArrayList<>();
      String sql ="select * from items where categoryID = ? and deleted = 1 order by id offset ? rows fetch next 12 rows only";
//        if(cid!=null){
//               sql = "select * from items where categoryID = ? order by id offset ? rows fetch next 12 rows only";
//               
//        }
//        else{
//               sql = "select * from items order by id offset ? rows fetch next 12 rows only";
//        }
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
//            if(cid!=null){
                st.setInt(1, cid);
                st.setInt(2, (i-1)*12);
//            }
////            else{
//            st.setInt(1, (i-1)*12);
//            }
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Items l = new Items();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setDesciption(rs.getString("description"));
                l.setPrice(rs.getDouble("price"));
                 l.setImagePath(rs.getString("imagePath"));
                 l.setCategoryID(rs.getInt("categoryID"));
                 l.setStatus(rs.getInt("status"));
                 list.add(l);        
            }
        } catch (Exception e) {
        }
        return list;
    }
     public List<Items> getItemByPagingBy(int i){
        List<Items> list = new ArrayList<>();
      String sql ="select * from items where deleted = 1 order by id offset ? rows fetch next 12 rows only";;

        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, (i-1)*12);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Items l = new Items();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setDesciption(rs.getString("description"));
                l.setPrice(rs.getDouble("price"));
                 l.setImagePath(rs.getString("imagePath"));
                 l.setCategoryID(rs.getInt("categoryID"));
                 l.setStatus(rs.getInt("status"));
                 list.add(l);        
            }
        } catch (Exception e) {
        }
        return list;
    }
     public List<Items> getItemBySearch(int i, String txt){
        List<Items> list = new ArrayList<>();
      String sql ="select * from items where name like ? and deleted = 1 order by id offset ? rows fetch next 12 rows only";;
//        if(cid!=null){
//               sql = "select * from items where categoryID = ? order by id offset ? rows fetch next 12 rows only";
//               
//        }
//        else{
//               sql = "select * from items order by id offset ? rows fetch next 12 rows only";
//        }
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
//            if(cid!=null){
                st.setString(1, "%" +txt+ "%");
                st.setInt(2, (i-1)*12);
//            }
////            else{
//            st.setInt(1, (i-1)*12);
//            }
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Items l = new Items();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setDesciption(rs.getString("description"));
                l.setPrice(rs.getDouble("price"));
                 l.setImagePath(rs.getString("imagePath"));
                 l.setCategoryID(rs.getInt("categoryID"));
                 l.setStatus(rs.getInt("status"));
                 list.add(l);        
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        CountItems dao = new CountItems();
        List<Items> t=dao.getItemByPaging(1,1005); 
        t.forEach((i) -> {
            out.println(i.getId()+", "+i.getName()+"");
        });
    }
}
