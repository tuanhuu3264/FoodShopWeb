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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 *
 * @author DELL
 */
public class OrderDAO {

    public static List<Order> getAll() throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "SELECT o.orderID, o.address, o.dateBuy, o.phone, a.username, o.total, o.status, a.name\n"
                + "FROM orders AS o\n"
                + "LEFT JOIN accounts AS a\n"
                + "ON o.accountID = a.id\n"
                + "ORDER BY CASE o.status\n"
                + "    WHEN 1 THEN 1\n"
                + "    WHEN 0 THEN 2\n"
                + "    WHEN 2 THEN 3\n"
                + "    WHEN -1 THEN 4\n"
                + "    ELSE 5\n"
                + "END;";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Order o = new Order(r.getInt("orderID"), r.getString("username"), r.getString("dateBuy"), r.getString("address"), r.getString("phone"), r.getDouble("total"), r.getInt("status"));
                o.setName(r.getString("name"));
                a.add(o);
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static List<Order> getPendingOrder() throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select o.orderID, o.address, o.dateBuy, o.phone, a.username,o.total,o.status,a.name\n"
                + "                  from orders as o \n"
                + "                  left join accounts as a\n"
                + "                  on o.accountID=a.id \n"
                + "               where status=0";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Order o = new Order(r.getInt("orderID"), r.getString("username"), r.getString("dateBuy"), r.getString("address"), r.getString("phone"), r.getDouble("total"), r.getInt("status"));
                o.setName(r.getString("name"));
                a.add(o);
                
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static Order getIndexOrder(int id) throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select o.orderID, o.address, o.dateBuy, o.phone, a.username, o.total, o.status, a.name\n"
                + "                  from orders as o \n"
                + "                  left join accounts as a\n"
                + "                  on o.accountID=a.id \n"
                + "               where o.orderID=?";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, id);
        Order o = new Order();
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                o = new Order(r.getInt("orderID"), r.getString("username"), r.getString("dateBuy"), r.getString("address"), r.getString("phone"), r.getDouble("total"), r.getInt("status"));
                o.setName(r.getString("name"));
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return o;
    }

    public static void setAccept(int id) throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "update orders\n"
                + "set status =1 \n"
                + "where orderID=?";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, id);
        Order o = new Order();
        try {
            st.executeUpdate();
        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }

    public static void setCompleted(int id) throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "update orders\n"
                + "set status =2 \n"
                + "where orderID=?";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, id);
        Order o = new Order();
        try {
            st.executeUpdate();
        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }

    public static void setDecline(int id) throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "update orders\n"
                + "set status =-1 \n"
                + "where orderID=?";
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, id);
        Order o = new Order();
        try {
            st.executeUpdate();
        } catch (Exception e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
    }

    public static List<Order> orderSearch(String search) throws Exception {
        List<Order> a = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "SELECT o.orderID, o.address, o.dateBuy, o.phone, a.username, o.total, o.status,a.name\n"
                + "FROM orders AS o\n"
                + "LEFT JOIN accounts AS a ON o.accountID = a.id\n"
                + "WHERE o.address LIKE '%" + search + "%' OR a.username LIKE '%" + search + "%' OR o.phone LIKE '%" + search + "%'\n"
                + "order by case o.status\n"
                + "        WHEN 1 THEN 1\n"
                + "        WHEN 0 THEN 2\n"
                + "        WHEN 2 THEN 3\n"
                + "        WHEN -1 THEN 4\n"
                + "		else 5 \n"
                + "		end";
        PreparedStatement st = cn.prepareStatement(sql);

        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                Order o = new Order(r.getInt("orderID"), r.getString("username"), r.getString("dateBuy"), r.getString("address"), r.getString("phone"), r.getDouble("total"), r.getInt("status"));
                o.setName(r.getString("name"));
                a.add(o);
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return a;
    }

    public static int numberRefusedOrder() throws SQLException, Exception {
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select o.orderID \n"
                + "                  from orders as o \n"
                + "                  where o.status=-1 and Month(o.datebuy)=Month(getdate()) and Year(o.datebuy)=Year(getdate())";
        PreparedStatement st = cn.prepareStatement(sql);
        int dem = 0;
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                dem++;
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return dem;
    }

    public static int PendingOrder() throws SQLException, Exception {
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select o.orderID \n"
                + "                  from orders as o \n"
                + "                  where o.status=0 and Month(o.datebuy)=Month(getdate()) and Year(o.datebuy)=Year(getdate())";
        PreparedStatement st = cn.prepareStatement(sql);
        int dem = 0;
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                dem++;
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return dem;
    }

    public static double RevenueMonth() throws SQLException, Exception {
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select Month(datebuy) as 'Month' , sum( total) as 'total' \n"
                + "from orders\n"
                + "where status=2 and Month(datebuy)=Month(getdate()) and Year(datebuy)= year(getdate())\n"
                + "group by Month(datebuy)";
        PreparedStatement st = cn.prepareStatement(sql);
        double money = 0;
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                money = r.getDouble("total");
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return money;
    }

    public static double RevenueYear() throws SQLException, Exception {
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "select Year(datebuy) as 'Year' , sum( total) as 'total' \n"
                + "from orders\n"
                + "where status=2 and Year(datebuy)= year(getdate())\n"
                + "group by Year(datebuy)";
        PreparedStatement st = cn.prepareStatement(sql);
        double money = 0;
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                money = r.getDouble("total");
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return money;
    }

    public static double RevenueDay() throws Exception {
        Connection cn = DBUtils.makeConnection();
        String PreparedStatement;
        String sql = "SELECT SUM(orders.total) AS 'total'\n" +
"FROM orders\n" +
" where Day(dateBuy) = Day(GETDATE()) and MONTH(dateBuy) = MONTH(GETDATE()) and Year(dateBuy) = Year(GETDATE())and status=2";
        PreparedStatement st = cn.prepareStatement(sql);
        double money = 0;
        try {
            ResultSet r = st.executeQuery();
            while (r.next()) {
                if(r==null) return 0; 
                return r.getDouble("total");
            }

        } catch (SQLException e) {
            out.println("Error: " + e);
        } finally {
            cn.close();
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        double money= OrderDAO.RevenueDay(); 
        out.println(money);
    }

}
