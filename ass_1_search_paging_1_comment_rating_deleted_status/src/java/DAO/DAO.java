/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Catogories;
import model.Items;

/**
 *
 * @author Tuan
 */
public class DAO {
    public List<Catogories> listAll(){
        String sql = "select * from categorys";
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
    public List<Items> listItemsBycid(int c){
        List<Items> list = new ArrayList<>();
        String sql = "select * from items where categoryID = ? and deleted = 1";
        try {
            Connection con = DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, c);
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
    public List<Items> searchByCheck(int[] cid){
        List<Items> list = new ArrayList<>();
        String sql = "select * from items where 1=1 and deleted = 1";
        if(cid!=null && cid[0]!=0){
            sql+=" and categoryID in(";
            for(int i = 0; i < cid.length; i++){
                sql+= cid[i] + ",";
            }
            if(sql.endsWith(",")){
                sql+= sql.substring(0, sql.length()-1);
            }
            sql+=")";
        }
        try {
            Connection con = DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
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
    public List<Items> getItemsByPrice(double from, double to){
        List<Items> list = new ArrayList<>();
        String sql = "select * from items where price between ? and ? and deleted = 1";
        
        try {
            Connection con = DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setDouble(1, from);
             st.setDouble(2, to);
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
    public List<Items> getAllitems() throws Exception{        
        Connection cn=DBUtils.makeConnection();
       String sql="select * from items where deleted = 1";
       PreparedStatement st=cn.prepareStatement(sql); 
       List<Items> list= new ArrayList<>();
       ResultSet rs=st.executeQuery(); 
       try{    
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
           
       } catch(Exception e){ 
           out.println("Error: "+e);
       }finally{ 
            cn.close();
       }
      return list;
    }
    public static void main(String[] args) throws Exception {
        DAO d = new DAO();
        double t = 1;
        double b = 5;
        List<Items> list = d.getItemsByPrice(t, b);
        for (Items items : list) {
            System.out.println(items.getName());
        }
    }
}
