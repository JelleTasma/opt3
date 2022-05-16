package opt3.Controller;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import java.util.Comparator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DetailController {

    private static AnchorPane field;

    @FXML
    public static void start(ActionEvent e) throws IOException{
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Detail.fxml"));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        Object obj = stage.getUserData();
        User user = (User)obj;
        stage.setUserData(user);
        Label text = new Label("welkom " + user.getUsername());
        text.setFont(Font.font("Arial"));
        text.setPadding(new Insets(20));
        root.getChildren().addAll(text);
        field = root;
    }

    @FXML
    public static void getDetails(ActionEvent event, Item item){
        Button back = new Button("Terug");
        back.setFont(Font.font("Arial"));
        back.setOnAction(e -> {
            try {
                endFunction(event);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        VBox vbox = new VBox();

        HBox nameBox = new HBox();
        Label nameLabel = new Label("Naam");
        nameLabel.setFont(Font.font("Arial"));
        TextField name = new TextField(item.getName());
        name.setFont(Font.font("Arial"));
        name.setDisable(true);
        nameBox.getChildren().setAll(nameLabel, name);
        nameBox.setSpacing(10);

        HBox descriptionBox = new HBox();
        Label descriptionLabel = new Label("Beschrijving");
        descriptionLabel.setFont(Font.font("Arial"));
        TextField description = new TextField(item.getDescription());
        description.setFont(Font.font("Arial"));
        description.setDisable(true);
        descriptionBox.getChildren().setAll(descriptionLabel, description);
        descriptionBox.setSpacing(10);

        HBox priceBox = new HBox();
        Label priceLabel = new Label("Prijs");
        priceLabel.setFont(Font.font("Arial"));
        TextField price = new TextField("" + item.getPrice());
        price.setFont(Font.font("Arial"));
        price.setDisable(true);
        priceBox.getChildren().setAll(priceLabel, price);
        priceBox.setSpacing(10);

        HBox rentBox = new HBox();
        Label rentLabel = new Label("Verhuurd");
        rentLabel.setFont(Font.font("Arial"));
        TextField rent = new TextField("Niet verhuurd");
        if (item.getInRent()) {
            rent = new TextField("Verhuurd");
        }
        rent.setFont(Font.font("Arial"));
        rent.setDisable(true);
        rentBox.getChildren().setAll(rentLabel, rent);
        rentBox.setSpacing(10);

        HBox userBox = new HBox();
        Label userLabel = new Label("Medewerker");
        userLabel.setFont(Font.font("Arial"));
        TextField user = new TextField("Geen klant gevonden!");
        if (item.getUser() != null) {
            user = new TextField(item.getUser().getUsername());
        }
        user.setFont(Font.font("Arial"));
        user.setDisable(true);
        userBox.getChildren().setAll(userLabel, user);
        userBox.setSpacing(10);

        HBox customerBox = new HBox();
        Label customerLabel = new Label("Klant");
        customerLabel.setFont(Font.font("Arial"));
        TextField customer = new TextField(item.getCustomer());
        customer.setFont(Font.font("Arial"));
        customer.setDisable(true);
        customerBox.getChildren().setAll(customerLabel, customer);
        customerBox.setSpacing(10);

        HBox retourBox = new HBox();
        Label retourLabel = new Label("Retourneren");
        retourLabel.setFont(Font.font("Arial"));
        Button button = new Button("Retour");
        button.setFont(Font.font("Arial"));
        button.setOnAction(e -> {
            item.endRent();
            try {
                endFunction(event);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        retourBox.getChildren().setAll(retourLabel, button);
        retourBox.setSpacing(10);

        HBox dayPriceBox = new HBox();
        Label dayPriceLabel = new Label("Dag Prijs");
        dayPriceLabel.setFont(Font.font("Arial"));
        Text priceDay = new Text("" + (item.getPrice() / 30));
        priceDay.setFont(Font.font("Arial"));
        priceDay.setDisable(true);
        dayPriceBox.getChildren().setAll(dayPriceLabel, priceDay);
        dayPriceBox.setSpacing(10);

        HBox insuranceBox = new HBox();
        Label insuranceLabel = new Label("Verzekering");
        insuranceLabel.setFont(Font.font("Arial"));
        CheckBox insurance = new CheckBox();
        insurance.setOnAction(e -> {
            if(insurance.isSelected()){
                priceDay.setText("" + ((item.getPrice() / 30) + 5));
            } else {
                priceDay.setText("" + (item.getPrice() / 30));
            }
        });
        insuranceBox.getChildren().setAll(insuranceLabel, insurance);
        insuranceBox.setSpacing(10);

        HBox customerNameBox = new HBox();
        Label customerNameLabel = new Label("Voer klant naam in:");
        customerNameLabel.setFont(Font.font("Arial"));
        TextField customerName = new TextField();
        customerName.setFont(Font.font("Arial"));
        customerNameBox.getChildren().setAll(customerNameLabel, customerName);
        customerNameBox.setSpacing(10);

        HBox makeRentBox = new HBox();
        Label makeRentLabel = new Label("Verhuren");
        makeRentLabel.setFont(Font.font("Arial"));
        Button makeRent = new Button("Verhuur");
        makeRent.setFont(Font.font("Arial"));

        Stage stage = (Stage) field.getScene().getWindow();
        Object obj = stage.getUserData();
        User us = (User)obj;
        makeRent.setOnAction(e -> {
            item.startRent(us, customerName.getText());
            try {
                endFunction(event);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        makeRentBox.getChildren().setAll(makeRentLabel, makeRent);
        makeRentBox.setSpacing(10);

        vbox.setPadding(new Insets(90, 100 , 100, 170));
        if(item.getInRent()) {
            vbox.getChildren().addAll(back,nameBox, descriptionBox, priceBox, rentBox, userBox, customerBox, retourBox);
        } else {
            vbox.getChildren().addAll(back,nameBox, descriptionBox, priceBox, rentBox, dayPriceBox, insuranceBox, customerNameBox, makeRentBox);
        }
        vbox.setSpacing(10);
        field.getChildren().addAll(vbox);
    }

    public static void endFunction(ActionEvent event) throws IOException {
        Stage stage = (Stage) field.getScene().getWindow();
        AnchorPane root = FXMLLoader.load(JavaApplication.class.getResource("/opt3/Overview.fxml"));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        Object obj = stage.getUserData();
        User user = (User)obj;
        stage.setUserData(user);
        Label text = new Label("welkom " + user.getUsername());
        text.setFont(Font.font("Arial"));
        text.setPadding(new Insets(20));
        root.getChildren().addAll(text);
        field = root;
    }
}
