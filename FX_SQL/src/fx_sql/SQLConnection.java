package fx_sql;
import java.sql.*;
public class SQLConnection {
    public static Connection Connector() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/APL", 
                    "postgres", "6784348");
            return c;
        }catch (Exception e){
            return null;
        }
    }
}
