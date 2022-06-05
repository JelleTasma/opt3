package opt3.Model;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public interface Observer {
    ArrayList<Stage> stages = new ArrayList<Stage>();

    void update(ActionEvent e, String info);
}