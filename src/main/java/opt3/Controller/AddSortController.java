package opt3.Controller;

import opt3.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;

public class AddSortController {
    @FXML
    public TextField NameField;
    @FXML
    public CheckBox BrandField;
    @FXML
    public CheckBox WeightField;
    @FXML
    public CheckBox LoadField;
    @FXML
    public CheckBox TypeField;
    @FXML
    public TextField dayPrice;
    @FXML
    public TextField DL;
    @FXML
    public TextField IV;
    @FXML
    public TextField IW;

    public void Add(ActionEvent event) throws IOException {
        if (dayPrice.getText().trim().isEmpty())
            dayPrice = new TextField("0");
        if (DL.getText().trim().isEmpty())
            DL = new TextField("0");
        if (IV.getText().trim().isEmpty())
            IV = new TextField("0");
        if (IW.getText().trim().isEmpty())
            IW = new TextField("0");
        ItemSort sort = new ItemSort(NameField.getText(), BrandField.isSelected(), WeightField.isSelected(), LoadField.isSelected(), TypeField.isSelected(), Double.parseDouble(dayPrice.getText()), Double.parseDouble(DL.getText()), Double.parseDouble(IV.getText()), Double.parseDouble(IW.getText()));
        ItemSort.sorts.add(sort);
        ManageController.start(event);
    }
}
