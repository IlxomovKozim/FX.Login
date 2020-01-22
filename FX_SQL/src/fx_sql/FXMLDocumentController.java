package fx_sql;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

 /*
 * @author KOZIM
 */
public class FXMLDocumentController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    
    @FXML
    private Label label;
    @FXML
    private TextField tf;
    @FXML
    private PasswordField pf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(loginModel.isDbConnected()){
            label.setText("Connected");
        }else{
            label.setText("Not Connected");
        }
    }    
    public void Login(ActionEvent event) throws Exception{
        try {
            if(loginModel.isLogin(tf.getText(), pf.getText())){
                label.setText("Correct");}
            else{
                label.setText("Not Correct");
            }
                } catch (SQLException e) {
            label.setText("Username or password is not correct");
            e.printStackTrace();
        }
    }
}
