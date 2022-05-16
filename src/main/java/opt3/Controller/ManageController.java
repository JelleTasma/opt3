package opt3.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import opt3.JavaApplication;
import opt3.Model.Item;
import opt3.Model.Login;
import opt3.Model.User;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ManageController {

    @FXML
    public static void start(ActionEvent e) throws IOException{
        VBox vbox = new VBox();
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Manage.fxml"));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        Object obj = stage.getUserData();
        User user = (User)obj;
        stage.setUserData(user);
        Label text = new Label("welkom " + user.getUsername());
        text.setFont(Font.font("Arial"));
        text.setPadding(new Insets(20));
        root.getChildren().add(text);
        ListView<String> listView = new ListView();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Personenauto's", "Vrachtwagen", "Boormachines");
        listView.setItems(items);
        {
            listView.setOnMouseClicked(ef -> {

                try {
                    AddController.start(e, stage);
                    AddController.setAdd(e, listView.getSelectionModel().getSelectedItem(), stage);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        vbox.getChildren().add(listView);
        vbox.setPadding(new Insets(100,0,0,200));
        root.getChildren().add(vbox);
    }

    @FXML
    public void onBackButtonClick(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Menu.fxml"));
        Scene scene = new Scene( root );
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
}
