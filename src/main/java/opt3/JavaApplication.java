package opt3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import opt3.Model.Item;
import opt3.Model.User;

import java.io.IOException;

public class JavaApplication extends Application{

    @Override
    public void start(Stage stage) throws Exception
    {
        User user = new User("q", "q", "test@live.nl",false);
        User.users.add(user);
        Item item = new Item("Auto", "Heeft een motor", 1200, false);
        Item item2 = new Item("Boor", "Alleen voor hout", 1200, false);
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
