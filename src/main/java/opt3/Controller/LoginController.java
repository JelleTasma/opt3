package opt3.Controller;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import opt3.JavaApplication;
import opt3.Model.Account;
import opt3.Model.Login;
import opt3.Model.Observer;
import opt3.Model.User;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Comparator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.scene.layout.VBox;


public class LoginController {
    @FXML
    public TextField usernameInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public Button loginButton;

    @FXML
    public void OnLoginButtonClick(ActionEvent event) throws IOException{
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        Account user = Login.login(username, password);
        if (user != null) {
            if(!user.getLogedIn()) {
                Stage stage = new Stage();
                Observer.stages.add(stage);
                AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Menu.fxml"));
                Scene scene = new Scene(root);
                stage.setUserData(user);
                stage.setScene(scene);
                Label text = new Label("welkom " + user.getUsername());
                text.setFont(Font.font("Arial"));
                text.setPadding(new Insets(20));
                root.getChildren().addAll(text);
                stage.show();
            }
            user.setLogedIn();
        }
    }

    @FXML
    public void OnRegisterButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Register.fxml"));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.show();
    }
}