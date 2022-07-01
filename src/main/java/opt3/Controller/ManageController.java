package opt3.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import opt3.JavaApplication;
import opt3.Model.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ManageController {

    @FXML
    public static void start(ActionEvent e) throws IOException {
        VBox vbox = new VBox();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Manage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Object obj = stage.getUserData();
        User user = (User) obj;
        stage.setUserData(user);
        Label text = new Label("welkom " + user.getUsername());
        text.setFont(Font.font("Arial"));
        text.setPadding(new Insets(20));
        root.getChildren().add(text);
        ListView<String> listView = new ListView();
        listView.setPrefHeight(100);
        ObservableList<String> items = FXCollections.observableArrayList();
        for(ItemSort sort : ItemSort.sorts) {
            items.add(sort.getName());
        }
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
        Button back = new Button("Terug");
        back.setFont(Font.font("Arial"));
        back.setOnAction(e1 -> {
                Observer.stages.add(stage);
                AnchorPane root1 = null;
            try {
                root1 = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Menu.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Scene scene1 = new Scene(root1);
                stage.setUserData(user);
                stage.setScene(scene1);
                Label text1 = new Label("welkom " + user.getUsername());
                text1.setFont(Font.font("Arial"));
                text1.setPadding(new Insets(20));
                root1.getChildren().addAll(text1);
                stage.show();
        });

        Button add = new Button("Voeg toe");
        add.setFont(Font.font("Arial"));
        add.setOnAction(e1 -> {
            Observer.stages.add(stage);
            AnchorPane root2 = null;
            try {
                root2 = FXMLLoader.load(JavaApplication.class.getResource("/opt3/AddSort.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Scene scene1 = new Scene(root2);
            stage.setUserData(user);
            stage.setScene(scene1);
            Label text1 = new Label("welkom " + user.getUsername());
            text1.setFont(Font.font("Arial"));
            text1.setPadding(new Insets(20));
            root2.getChildren().addAll(text1);
            stage.show();
        });
        vbox.getChildren().addAll(back, listView, add);
        vbox.setPadding(new Insets(100, 0, 0, 200));
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
