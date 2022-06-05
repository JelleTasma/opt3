package opt3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import opt3.Model.*;

import java.io.IOException;

public class JavaApplication extends Application{

    @Override
    public void start(Stage stage) throws Exception
    {
        ItemSort sort = new ItemSort("Auto", true, true, false, false, 50, 0, 0,0.01);
        ItemSort sort1 = new ItemSort("Vrachtwagen", false, true ,true, false, 0, 0.10,0, 0.01);
        ItemSort sort2 = new ItemSort("Boormachine", true, false, false, true, 5, 0 ,1, 0);
        ItemSort.sorts.add(sort);
        ItemSort.sorts.add(sort1);
        ItemSort.sorts.add(sort2);
        new AccountFactory().create("User");
        Item item = new Item("Auto", "Benz", "Een hele snelle auto", 40000,  false, "Mercedes", 4000, 0, null);
        Item item2 = new Item("Boormachine", "Turbo 2000", "Kan heel goed boren", 500,  false, "Marcito", 200, 0, "Speed");
        Item.items.add(item);
        Item.items.add(item2);

        Parent root = FXMLLoader.load(getClass().getResource( "/opt3/Login.fxml" ));
        Scene scene = new Scene( root );
        stage.setScene(scene);
        stage.setTitle( "Verhuur" );
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
