package DBUtils;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection makeConnection() throws Exception {
        String IP = "localhost";
        String instanceName = "SA";
        String port = "1433";
        String uid = "sa";
        String pwd = "12345";
        String db = "foodShop";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port + ";databaseName=" + db + ";user=" + uid + ";password=" + pwd;

        Class.forName(driver);
        Connection cn = DriverManager.getConnection(url);
        return cn;
    }
}
