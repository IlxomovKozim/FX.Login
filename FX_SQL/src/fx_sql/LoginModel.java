package fx_sql;
import java.sql.*;
import java.util.logging.*;
public class LoginModel {
    Connection connection;
    public LoginModel(){
        try {
            connection = SQLConnection.Connector();
            if(connection == null)
                System.exit(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isDbConnected(){
        try{
            return !connection.isClosed();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean isLogin(String Command, String Goals) throws Exception{
        PreparedStatement preperedStatment = null;
                ResultSet resultSet = null; 
        String query = "SELECT * FROM APL WHERE Command = ? and Goals = ?";
        try{
           preperedStatment = connection.prepareStatement(query);
           preperedStatment.setString(1, Command);
           preperedStatment.setString(2, Goals);
           
           resultSet = preperedStatment.executeQuery();
           if(resultSet.next()){
               return true;
           }
           else{
            return false;
        }
        }catch(Exception e){
            return false;
        }
        finally{
            preperedStatment.close();
            resultSet.close();
        }
    }    
}
