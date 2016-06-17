/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employeetrackingsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ek
 */
public class SigninController implements Initializable {
    @FXML
    private Hyperlink forgetPass;
    @FXML
    private TextField usernameSignIn;
    @FXML
    private PasswordField passwordSignIn;
    @FXML
    private Button loginbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void forgetPassword(ActionEvent event) {
    }

    @FXML
    private void login(ActionEvent event) {
    }
    
}
