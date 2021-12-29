package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller  {
    public TextField fldText;
    public Slider sliderStudents;
    public ChoiceBox choiceColor;
    public ListView lvStudents;
    public GridPane gridPane;


    private StudentiModel studentiModel = new StudentiModel();


    @FXML
    public void initialize() {

        lvStudents.setItems(studentiModel.expandTo(((int)sliderStudents.getValue()),fldText.getText()));
        choiceColor.getSelectionModel().selectedItemProperty().addListener( (observableValue, o, n) -> {
            if (n.equals("Crvena")) {
                for(Node but:gridPane.getChildren()) {
                    but.getStyleClass().removeAll("blueClass");
                    but.getStyleClass().removeAll("greenClass");
                    but.getStyleClass().add("redClass");
                }
            }
            else if(n.equals("Plava")) {
                for(Node but:gridPane.getChildren()) {
                    but.getStyleClass().removeAll("redClass");
                    but.getStyleClass().removeAll("greenClass");
                    but.getStyleClass().add("blueClass");
                }
            }
            else if(n.equals("Zelena")){
                for(Node but:gridPane.getChildren()) {
                    but.getStyleClass().removeAll("blueClass");
                    but.getStyleClass().removeAll("redClass");
                    but.getStyleClass().add("greenClass");
                }

            }
            else {
                for(Node but:gridPane.getChildren()) {
                    but.getStyleClass().removeAll("blueClass");
                    but.getStyleClass().removeAll("greenClass");
                    but.getStyleClass().removeAll("redClass");
                }
            }
        });

        sliderStudents.valueProperty().addListener((observableValue, wasChanging, changing) ->
                lvStudents.setItems(studentiModel.expandTo((int) sliderStudents.getValue(),fldText.getText())));

        sliderStudents.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> sliderStudents.setValueChanging(true));
        sliderStudents.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> sliderStudents.setValueChanging(false));

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
        lvStudents.setItems(studentiModel.getStudenti());

    }
}
