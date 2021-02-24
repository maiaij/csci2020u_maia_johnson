package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text actiontarget;
    
    @FXML
    private TextField username, fullName, email, phoneNumber;

    @FXML
    private PasswordField passwordField;

    @FXML
    private DatePicker dob;
    
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println(username.getText());
        System.out.println(passwordField.getText());
        System.out.println(fullName.getText());
        System.out.println(email.getText());
        System.out.println(phoneNumber.getText());
        System.out.println(dob.getValue());
        actiontarget.setText("Register pressed");
    }
}