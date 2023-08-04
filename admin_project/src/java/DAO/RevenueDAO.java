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
import model.Revenue;
import java.util.Calendar;
/**
 *
 * @author DELL
 */
public class RevenueDAO {
    

public static List<Revenue> getMonth() throws Exception {
    List<Revenue> list = new ArrayList();
    Connection cn = DBUtils.makeConnection();

    Calendar calendar = Calendar.getInstance();
    int currentMonth = calendar.get(Calendar.MONTH) + 1; // Adding 1 as Calendar months are zero-indexed

    String sql = "WITH AllMonths AS (\n"
            + "    SELECT 1 AS 'Month'\n"
            + "    UNION SELECT 2\n"
            + "    UNION SELECT 3\n"
            + "    UNION SELECT 4\n"
            + "    UNION SELECT 5\n"
            + "    UNION SELECT 6\n"
            + "    UNION SELECT 7\n"
            + "    UNION SELECT 8\n"
            + "    UNION SELECT 9\n"
            + "    UNION SELECT 10\n"
            + "    UNION SELECT 11\n"
            + "    UNION SELECT 12\n"
            + ")\n"
            + "SELECT \n"
            + "    AM.Month,\n"
            + "    ISNULL(SUM(O.total), 0) AS 'sum'\n"
            + "FROM AllMonths AM\n"
            + "LEFT JOIN orders O ON AM.Month = MONTH(O.datebuy) AND YEAR(Getdate()) = YEAR(O.datebuy) AND O.status = 2\n"
            + "WHERE AM.Month <= ?\n"  // Add a parameter to filter months up to the current month
            + "GROUP BY AM.Month\n"
            + "ORDER BY AM.Month ASC";

    try (PreparedStatement st = cn.prepareStatement(sql)) {
        st.setInt(1, currentMonth);
        ResultSet r = st.executeQuery();
        while (r.next()) {
            int i = r.getInt("Month");
            double money = r.getDouble("sum");
            String month = null;
            switch (i) {
                case 1:
                    month = "January";
                    break;
                case 2:
                    month = "February";
                    break;
                case 3:
                    month = "March";
                    break;
                case 4:
                    month = "April";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "June";
                    break;
                case 7:
                    month = "July";
                    break;
                case 8:
                    month = "August";
                    break;
                case 9:
                    month = "September";
                    break;
                case 10:
                    month = "October";
                    break;
                case 11:
                    month = "November";
                    break;
                case 12:
                    month = "December";
                    break;
            }
            Revenue a = new Revenue(money, month);
            list.add(a);
        }
    } catch (Exception e) {
        out.println("Error: " + e);
    } finally {
        cn.close();
    }
    return list;
}
public static List<Revenue> getDay() throws Exception {
List<Revenue> list = new ArrayList();
Connection cn = DBUtils.makeConnection();

Calendar calendar = Calendar.getInstance();
int currentDay = calendar.get(Calendar.DAY_OF_MONTH); // Use DAY_OF_MONTH instead of DAY

String con = "";
for (int i = 2; i <= currentDay; i++) {
    con += "UNION SELECT " + i + "\n";
}

String sql = "WITH AllDays AS (\n"
        + "    SELECT 1 AS 'Day'\n"
        + con
        + ")\n"
        + "SELECT \n"
        + "    AM.Day,\n"
        + "    ISNULL(SUM(O.total), 0) AS 'sum'\n"
        + "FROM AllDays AM\n" // Use AllDays instead of AllMonths
        + "LEFT JOIN orders O ON AM.Day = DAY(O.datebuy) AND MONTH(Getdate()) = MONTH(O.datebuy) AND YEAR(Getdate()) = YEAR(O.datebuy) AND O.status = 2\n"
        + "WHERE AM.Day <= ?\n"
        + "GROUP BY AM.Day\n"
        + "ORDER BY AM.Day ASC";

try (PreparedStatement st = cn.prepareStatement(sql)) {
    st.setInt(1, currentDay);
    ResultSet r = st.executeQuery();
    while (r.next()) {
        int i = r.getInt("Day");
        double money = r.getDouble("sum");
        String day = "Day " + i;
       
        Revenue a = new Revenue(money, day);
        list.add(a);
    }
} catch (Exception e) {
    out.println("Error: " + e);
} finally {
    cn.close();
}
return list;

}

    
}
