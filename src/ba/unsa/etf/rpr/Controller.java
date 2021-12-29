package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller implements Initializable {
    public TextField fldText;
    public Slider sliderStudents;
    public ChoiceBox choiceColor;
    public ListView lvStudents;
    public GridPane gridPane;

    private String color = "Default";

    private StudentiModel studentiModel = new StudentiModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void initialize() {
        lvStudents.setItems(StudentiModel.expandTo((int)sliderStudents.getValue(),fldText.getText()));

    }

    public void numberClick(ActionEvent actionEvent) {

        Button broj = (Button) actionEvent.getSource();
        fldText.appendText(broj.getText());

    }

    public void unosClick (ActionEvent actionEvent) throws IOException {

        Stage novi = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/novi.fxml"));
        loader.load();
        novi.setTitle("Unos studenta");
        novi.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        novi.setResizable(false);
        novi.show();

    }
}
