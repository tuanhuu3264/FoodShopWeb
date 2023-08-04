/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.dishes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.top4;

/**
 *
 * @author Tuan
 */
public class top4DAO {

    public List<top4> getTop4() {
        List<top4> list = new ArrayList<>();
        String sql = "SELECT TOP 4\n"
                + "    i.name,\n"
                + "    i.imagePath,\n"
                + "    i.price,\n"
                + "    o.itemID,\n"
                + "    totalquantity.totalquantity,\n"
                + "    ROUND(AVG(CAST(r.star AS FLOAT)), 1) AS star\n"
                + "FROM\n"
                + "    items i\n"
                + "    INNER JOIN (\n"
                + "        SELECT\n"
                + "            itemID,\n"
                + "            SUM(quantity) AS totalquantity\n"
                + "        FROM\n"
                + "            orderProperties\n"
                + "        WHERE\n"
                + "            orderID IN (\n"
                + "                SELECT\n"
                + "                    orderID\n"
                + "                FROM\n"
                + "                    orders\n"
                + "                WHERE\n"
                + "                    status = 2\n"
                + "            )\n"
                + "        GROUP BY\n"
                + "            itemID\n"
                + "    ) totalquantity ON i.id = totalquantity.itemID\n"
                + "    INNER JOIN orderProperties o ON i.id = o.itemID\n"
                + "    LEFT JOIN rating r ON o.itemID = r.productID\n"
                + "WHERE\n"
                + "    i.deleted = 1 AND i.status = 1 and i.categoryID!=1005\n"
                + "GROUP BY\n"
                + "    i.name,\n"
                + "    i.imagePath,\n"
                + "    i.price,\n"
                + "    o.itemID,\n"
                + "    totalquantity.totalquantity\n"
                + "ORDER BY\n"
                + "    totalquantity.totalquantity DESC;";
        try {
            Connection con = DBUtils.DBUtils.makeConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                top4 t = new top4();
                t.setName(rs.getString("name"));
                t.setImagePath(rs.getString("imagePath"));
                t.setPrice(rs.getDouble("price"));
                t.setItemID(rs.getInt("itemID"));
                t.setTotalquantity(rs.getInt("totalquantity"));
                t.setStar(rs.getInt("star"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println("sai");
        }
        return list;
    }

    public static void main(String[] args) {
        List<top4> list = new ArrayList<>();
        top4DAO top = new top4DAO();
        list = top.getTop4();
        for (top4 object : list) {
            System.out.println(object.getName());
        }
    }
}
