/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Items;
import model.OrderProperties;
import model.Orders;
import model.statusItem;

/**
 *
 * @author Tuan
 */
public class statusDAO {

    public List<Orders> listItemByStatus(int status, int accountID){
        List<Orders> list = new ArrayList<>();
        String sql = " select * from orders where status = ? and accountID = ? ORDER BY dateBuy asc";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, accountID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               Orders sta = new Orders();
                sta.setOrderID(rs.getInt("orderID"));
                sta.setAccountID(rs.getInt("accountID"));
                sta.setDateBuy(rs.getString("dateBuy"));
                sta.setTotal(rs.getDouble("total"));
                sta.setAddress(rs.getString("address"));
                 sta.setPhone(rs.getString("phone"));
                 sta.setStatus(rs.getBoolean("status"));
                list.add(sta);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<statusItem> listItemPending( int orderID){
        List<statusItem> list = new ArrayList<>();
        String sql = "  select o.orderID, i.id, i.name, i.imagePath, i.price, op.quantity, op.total from orderProperties op\n" +
"  join orders o on op.orderID = o.orderID\n" +
"  join items i on op.itemID = i.id\n" +
"  where o.orderID = ?  ORDER BY o.dateBuy asc";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, orderID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                statusItem sta = new statusItem();
                sta.setOrderID(rs.getInt("orderID"));
                sta.setId(rs.getInt("id"));
                sta.setName(rs.getString("name"));
                sta.setImagePath(rs.getString("imagePath"));
                sta.setPrice(rs.getDouble("price"));
                sta.setQuantity(rs.getInt("quantity"));
                sta.setTotal(rs.getDouble("total"));
                list.add(sta);
            }
        } catch (Exception e) {
        }
        return list;
    }
      public List<Orders> listsizeItem(int status, int accountID){
        List<Orders> list = new ArrayList<>();
        String sql = "select * from orders o\n" +
"  where o.status = ? and o.accountID = ? ORDER BY o.dateBuy DESC";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, accountID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
              Orders sta = new Orders();
                sta.setOrderID(rs.getInt("orderID"));
                sta.setAccountID(rs.getInt("accountID"));
                sta.setDateBuy(rs.getString("dateBuy"));
                sta.setTotal(rs.getDouble("total"));
                sta.setAddress(rs.getString("address"));
                 sta.setPhone(rs.getString("phone"));
                 sta.setStatus(rs.getBoolean("status"));
                list.add(sta);
            }
        } catch (Exception e) {
        }
        return list;
    }

      public void cancelUser(int orderID) throws Exception{
          String sql = "update orders\n"
                + "set status =-1 \n"
                + "where orderID=?";
          Connection con = DBUtils.DBUtils.makeConnection();
          try {
              PreparedStatement st = con.prepareStatement(sql);
              st.setInt(1, orderID);
              st.executeUpdate();
              
          } catch (Exception e) {
          }
      }
//      public void buyagainUser(int orderID) throws Exception{
//          String sql = "update orders\n"
//                + "set status =0 \n"
//                + "where orderID=?";
//          Connection con = DBUtils.DBUtils.makeConnection();
//          try {
//              PreparedStatement st = con.prepareStatement(sql);
//              st.setInt(1, orderID);
//              st.executeUpdate();
//              
//          } catch (Exception e) {
//          }
//      }
      public int getStatusItem(int id){
         String sql = "select status from items where id = ?";
          try {
              Connection con = DBUtils.DBUtils.makeConnection();
              PreparedStatement st = con.prepareStatement(sql);
              st.setInt(1, id);
              ResultSet rs = st.executeQuery();
              while(rs.next()){
                  return rs.getInt(1);
              }
          } catch (Exception e) {
          }
          return 0;
      }
      public int getSizeStatus(String status, int accountID){
          String sql="select count(*) as'Number'  from orders left join accounts on accounts.id=orders.accountID\n" +
                     "where status=? and accountID=?";
          int statusN=0; 
          switch(status){
              case "Pending": statusN=0; break;
              case "In Progress": statusN=1; break;
              case "Completed": statusN=2; break;
              case "Cancel": statusN=-1; break;
          }
          try {
              Connection con = DBUtils.DBUtils.makeConnection();
              PreparedStatement st = con.prepareStatement(sql);
              st.setInt(1, statusN);
              st.setInt(2, accountID);
              ResultSet rs = st.executeQuery();
              while(rs.next()){
                  return rs.getInt("Number"); 
              }
          } catch (Exception e) {
          }
          return 0;
      }
    
    public static void main(String[] args) {
        statusDAO dao = new statusDAO() ; 
        int it= dao.getSizeStatus("In Progress", 48); 
        System.out.println(it);
    }
}
