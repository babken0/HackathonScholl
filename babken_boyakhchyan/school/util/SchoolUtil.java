package babken_boyakhchyan.school.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchoolUtil {
    private static final String URL = "jdbc:sqlserver://localhost;database=schools";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
   public static Connection getConnection() throws ClassNotFoundException, SQLException {
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       return DriverManager.getConnection(URL,USERNAME,PASSWORD);

   }
}
