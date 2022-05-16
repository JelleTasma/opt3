package opt3.Controller;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import opt3.JavaApplication;
import opt3.Model.Login;
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

public class MenuController {

    @FXML
    public void OnOverviewClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Overview.fxml"));
        Scene scene = new Scene( root );
        scene.getStylesheets().add(getClass().getResource("/opt3/application.css").toExternalForm());
        stage.setScene(scene);
        Object obj = stage.getUserData();
        User user = (User)obj;
        stage.setUserData(user);
        Label text = new Label("welkom " + user.getUsername());
        text.setFont(Font.font("Arial"));
        text.setPadding(new Insets(20));
        root.getChildren().addAll(text);
        stage.show();
    }

    @FXML
    public void OnManageClick(ActionEvent event) throws IOException {
        ManageController.start(event);
    }

    @FXML
    public void OnLogoutClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Login.fxml"));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.show();
        Object obj = stage.getUserData();
        User user = (User)obj;
        user.setLogedOut();
    }
}