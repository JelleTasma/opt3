package opt3.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import opt3.JavaApplication;
import opt3.Model.Item;
import opt3.Model.User;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import javafx.util.Callback;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class OverviewController {

    @FXML
    TableView<Item> TableView;

    @FXML
    public void initialize(){
        ObservableList<Item> list = FXCollections.observableList(Item.items);

        TableColumn<Item, String> naamColumn = new TableColumn<>("Naam");
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Item, Integer> prijsColumn = new TableColumn<>("Prijs");
        prijsColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> voorraadColumn = new TableColumn<>("Voorraad");
        voorraadColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        TableView.getColumns().addAll(naamColumn, prijsColumn, voorraadColumn);
        TableView.setItems(list);

        addButtonToTable();
    }

    private void addButtonToTable() {
        TableColumn<Item, Void> colBtn = new TableColumn("Details");

        Callback<TableColumn<Item, Void>, TableCell<Item, Void>> cellFactory = new Callback<TableColumn<Item, Void>, TableCell<Item, Void>>() {

            public TableCell<Item, Void> call(final TableColumn<Item, Void> param) {
                final TableCell<Item, Void> cell = new TableCell<Item, Void>() {

                    private final Button btn = new Button("Details");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Item item = getTableView().getItems().get(getIndex());

                            try {
                                DetailController.start(event);
                                DetailController.getDetails(event, item);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        TableView.getColumns().add(colBtn);

    }

    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
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
