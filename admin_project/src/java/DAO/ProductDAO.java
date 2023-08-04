/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUntils.DBUtils;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.ProductTop;

/**
 *
 * @author DELL
 */
public class ProductDAO {

    public static List<Product> listProduct() throws Exception {
        List<Product> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select id, name, description, price, imagePath, categoryID, status from items where status=1 and deleted=1";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Product item = new Product(r.getInt("id"), r.getString("name"), r.getString("description"), r.getString("imagePath"), r.getDouble("price"), r.getInt("categoryID"), r.getInt("status"));
                a.add(item);
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static boolean updateProduct(int id, String name, String imagepath, double price, String des, int status, int categoryID) throws Exception {
        List<Product> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "UPDATE items\n"
                + " SET name=?, imagePath=?, price=?, description=?,status=?, categoryID=?\n"
                + " WHERE id = ?";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, imagepath);
        st.setDouble(3, price);
        st.setString(4, des);
        st.setInt(5, status);
        st.setInt(6, categoryID);
        st.setInt(7, id);
        int row = 0;
        try {
            row = st.executeUpdate();

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return row > 0;
    }

    public static Product getProduct(int sid) throws Exception {
        Product a = null;
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select id, name, description, price, imagePath, categoryID, status\n"
                + "from items\n"
                + "where id=?";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, sid);
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                a = new Product(r.getInt("id"), r.getString("name"), r.getString("description"), r.getString("imagePath"), r.getDouble("price"), r.getInt("categoryID"), r.getInt("status"));
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static List<Product> listOutStock() throws Exception {
        List<Product> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select id, name, description, price, imagePath, categoryID, status from items where status=0 and deleted=1";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Product item = new Product(r.getInt("id"), r.getString("name"), r.getString("description"), r.getString("imagePath"), r.getDouble("price"), r.getInt("categoryID"), r.getInt("status"));
                a.add(item);
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static void toOutStock(int id) throws Exception {

        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "Update items \n"
                + "set status=0\n"
                + "where id=? ";
        PreparedStatement st = cn.prepareStatement(sql);

        st.setInt(1, id);

        try {
            st.executeUpdate();

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }

    public static void toStock(int id) throws Exception {

        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "Update items \n"
                + "set status=1\n"
                + "where id=? ";
        PreparedStatement st = cn.prepareStatement(sql);

        st.setInt(1, id);

        try {
            st.executeUpdate();

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }

    public static List<ProductTop> getTopProduct() throws Exception {
        List<ProductTop> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "SELECT TOP 5\n" +
"    i.name,\n" +
"    i.imagePath,\n" +
"    i.price,\n" +
"    o.itemID,\n" +
"    totalquantity.totalquantity,\n" +
"    ROUND(AVG(CAST(r.star AS FLOAT)), 1) AS star\n" +
"FROM\n" +
"    items i\n" +
"    INNER JOIN (\n" +
"        SELECT\n" +
"            itemID,\n" +
"            SUM(quantity) AS totalquantity\n" +
"        FROM\n" +
"            orderProperties\n" +
"        WHERE\n" +
"            orderID IN (\n" +
"                SELECT\n" +
"                    orderID\n" +
"                FROM\n" +
"                    orders\n" +
"                WHERE\n" +
"                    status = 2\n" +
"            )\n" +
"        GROUP BY\n" +
"            itemID\n" +
"    ) totalquantity ON i.id = totalquantity.itemID\n" +
"    INNER JOIN orderProperties o ON i.id = o.itemID\n" +
"    LEFT JOIN rating r ON o.itemID = r.productID\n" +
"WHERE\n" +
"    i.deleted = 1 AND i.status = 1 and i.categoryID!=1005\n" +
"GROUP BY\n" +
"    i.name,\n" +
"    i.imagePath,\n" +
"    i.price,\n" +
"    o.itemID,\n" +
"    totalquantity.totalquantity\n" +
"ORDER BY\n" +
"    totalquantity.totalquantity DESC;";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                ProductTop p = new ProductTop(r.getString("name"), r.getInt("totalquantity"), r.getDouble("price"));
                a.add(p);
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static void insertProduct(Product a) throws Exception {

        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "insert into items(name, description, price, imagePath, categoryID, status, deleted) \n"
                + "values (?,?,?,?,?,1,1)";
        PreparedStatement st = cn.prepareStatement(sql);

        st.setString(1, a.getName());
        st.setString(2, a.getDescription());
        st.setDouble(3, a.getPrice());
        st.setString(4, a.getImagepath());
        st.setInt(5, a.getIdCategory());

        try {
            st.executeUpdate();

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }

    public static List<Product> searchProduct(String search) throws Exception {
        List<Product> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String sql = "select items.id, items.name, description, price, imagePath, categoryID, status \n"
                + "from items \n"
                + "left join categorys \n"
                + "on categorys.id=items.categoryID \n"
                + "where ((items.name like '%" + search + "%') or (categorys.name like '" + search + "')) and deleted=1 and status=1";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Product item = new Product(r.getInt("id"), r.getString("name"), r.getString("description"), r.getString("imagePath"), r.getDouble("price"), r.getInt("categoryID"), r.getInt("status"));
                a.add(item);
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;

    }

    public static List<Product> searchProductOut(String search) throws Exception {
        List<Product> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String sql = "select items.id, items.name, description, price, imagePath, categoryID, status \n"
                + "from items \n"
                + "left join categorys \n"
                + "on categorys.id=items.categoryID \n"
                + "where ((items.name like '%" + search + "%') or (categorys.name like '" + search + "')) and deleted=1 and status=0";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Product item = new Product(r.getInt("id"), r.getString("name"), r.getString("description"), r.getString("imagePath"), r.getDouble("price"), r.getInt("categoryID"), r.getInt("status"));
                a.add(item);
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;

    }

    public static void deleteProduct(int id) throws Exception {

        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "Update items \n"
                + "set deleted=0\n"
                + "where id=? ";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, id);

        try {
            st.executeUpdate();

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }
}
