package ba.unsa.etf.rpr;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller  {
    public TextField fldText;
    public Slider sliderStudents;
    public ChoiceBox choiceColor;
    public ListView lvStudents;
    public GridPane gridPane;

    private Novi noviController;
    private String color = "Default";


    private StudentiModel studentiModel = new StudentiModel();


    @FXML
    public void initialize() {
        lvStudents.setItems(StudentiModel.expandTo(((int)sliderStudents.getValue()),fldText.getText()));
        choiceColor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.equals("Crvena")) {
                    for(Node but:gridPane.getChildren()) {
                        but.getStyleClass().removeAll("plava");
                        but.getStyleClass().removeAll("zelena");
                        but.getStyleClass().add("crvena");
                    }
                } else if(n.equals("Zelena")){
                    for(Node but:gridPane.getChildren()) {
                        but.getStyleClass().removeAll("plava");
                        but.getStyleClass().removeAll("crvena");
                        but.getStyleClass().add("zelena");
                    }

                } else if(n.equals("Plava")){
                    for(Node but:gridPane.getChildren()) {
                        but.getStyleClass().removeAll("crvena");
                        but.getStyleClass().removeAll("zelena");
                        but.getStyleClass().add("plava");
                    }
                }else{
                    for(Node but:gridPane.getChildren()) {
                        but.getStyleClass().removeAll("plava");
                        but.getStyleClass().removeAll("zelena");
                        but.getStyleClass().removeAll("crvena");
                    }
                }
            }
        });

        sliderStudents.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number  wasChanging,
                    Number changing) {
                lvStudents.setItems(StudentiModel.expandTo((int) sliderStudents.getValue(),fldText.getText())); //tad je released

            }

        });
        //da bi radilo i na klik(osim drag-a)
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

        noviController = loader.getController();
        novi.setTitle("Unos studenta");
        novi.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        novi.setResizable(false);
        novi.show();

    }
}
