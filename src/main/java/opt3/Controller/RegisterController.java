package opt3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import opt3.JavaApplication;
import opt3.Model.User;

import java.io.IOException;

public class RegisterController {
    @FXML
    public TextField usernameInput;

    @FXML
    public PasswordField passwordInput;

    @FXML
    public TextField emailInput;

    @FXML
    public void OnBackClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Login.fxml"));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.show();
    }

    public void OnRegisterButtonClick() {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        String email = emailInput.getText();
        User user = new User(username, password, email, false);
        User.users.add(user);
    }
}
