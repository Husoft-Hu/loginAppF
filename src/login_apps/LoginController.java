/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_apps;
import db.dbconnect;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;




public class LoginController  {

   @FXML
   private TextField usernameField;
    @FXML
   private PasswordField passwordField;
      
    

 @FXML
    private void onlogin() {
      if(!usernameField.getText().matches("[a-zA-Z0-9_]{4,}")){
          return;
      }
      if(passwordField.getText().isEmpty()){
          return;
      }
      int status = dbconnect.checklogin(usernameField.getText().trim().toLowerCase(), passwordField.getText());
      
      switch(status){
          case 0:  {
         Stage stage =(Stage)usernameField.getScene().getWindow();
         Parent root = null;
          try {
              root = FXMLLoader.load(getClass().getResource("/sys/dashbord.fxml"));
          } catch (IOException ex) {
              Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
          }
          stage.setScene(new Scene (root));
          }break ;
           case -1: {JOptionPane.showMessageDialog(null, "CONNECTION FAILED"); }break ;
            
           case 1:{ JOptionPane.showMessageDialog(null, "USERNAME OR PASSWORD WRONG"); }break ;
                    
           }
      }
      
      
      
      
    }       
    
   