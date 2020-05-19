import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
     final static String Database_Url = "jdbc:mysql://localhost/Books?user=sevaak&password=qwerty13&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection myConnection() throws SQLException {
        return DriverManager.getConnection(Database_Url);
}
}
