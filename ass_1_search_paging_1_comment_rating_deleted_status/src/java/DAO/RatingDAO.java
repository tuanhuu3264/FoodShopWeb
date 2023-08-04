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
import model.Rating;

/**
 *
 * @author DELL
 */
public class RatingDAO {

    public static List<Rating> getRatingByProduct(int sid) {
        List<Rating> list = new ArrayList();
        String sql = "select r.*, a.username\n"
                + "from rating as r\n"
                + "inner join accounts as a\n"
                + "on r.accountID=a.id \n"
                + "where r.productID=?";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, sid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Rating i = new Rating(rs.getInt("accountID"), rs.getInt("productID"), rs.getInt("star"), rs.getString("username"), rs.getString("content"), rs.getString("dateComment"));
                // private int id;
                // private String username, password, email, phone, address, role, name, sex;
                list.add(i);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean insertComment(Rating a) throws Exception {
        String sql = "Insert into rating(accountID, productID, star,content, dateComment)\n"
                + "values(?,?,?,?,getdate())";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, a.getAccountID());
            st.setInt(2, a.getProductID());
            st.setInt(3, a.getStar());
            st.setString(4, a.getContent());
            int result = st.executeUpdate();
            if (result == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkCommentRating(int sid, int accountid) throws Exception {
        String sql = "SELECT * FROM rating WHERE productID = ? AND accountID = ?";
        try (Connection con = DBUtils.DBUtils.makeConnection();
                PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, sid);
            st.setInt(2, accountid);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            // Handle the exception appropriately
        }
        return false;
    }

    public static boolean checkBought(int sid, int accountid) throws Exception {
        String sql = "SELECT * FROM orderProperties "
                + "INNER JOIN orders ON orders.orderID = orderProperties.orderID "
                + "WHERE orders.accountID = ? AND orderProperties.itemID = ? and orders.status=2";
        try (Connection con = DBUtils.DBUtils.makeConnection();
                PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, accountid);
            st.setInt(2, sid);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            // Handle the exception appropriately
        }
        return false;
    }

    public static Rating getRatingWithAcc(int sid, int accountid) throws Exception {

        String sql = "select r.*, a.username\n"
                + "from rating as r\n"
                + "inner join accounts as a\n"
                + "on r.accountID=a.id \n"
                + "where r.productID=? and r.accountID=?";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, sid);
            st.setInt(2, accountid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Rating(rs.getInt("accountID"), rs.getInt("productID"), rs.getInt("star"), rs.getString("username"), rs.getString("content"), rs.getString("dateComment"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static double arrageStar(int sid) {
        String sql = "select r.productID ,ROUND(AVG(CAST(star AS FLOAT)), 1) as 'AVG'\n"
                + "from rating as r\n"
                + "where r.productID=?\n"
                + "group by r.productID";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, sid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getDouble("AVG");
            }
        } catch (Exception e) {
        }
        return 0;
    }

}
