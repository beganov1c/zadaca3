package ba.unsa.etf.rpr;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static ba.unsa.etf.rpr.StudentiModel.dodajStudentaIme;


public class Novi {
    public ProgressBar progressBar;
    public TextField fldIme;
    public Button cancelBtn;
    private String student;
    private boolean validacija = false;



    @FXML
    public void initialize() {
        fldIme.textProperty().addListener((observableValue, o, n) -> {

            progressBar.setProgress(n.length()/10.);
            if ((n.length()/10.)<1) {
                progressBar.getStyleClass().removeAll("greenProgress");
                progressBar.getStyleClass().add("redProgress");
            } else {
                progressBar.getStyleClass().removeAll("redProgress");
                progressBar.getStyleClass().add("greenProgress");

            }
        });
    }


    public void cancelClick(ActionEvent actionEvent){
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    private boolean provjeri(String ime) {return ime.trim().length()>=10;}

    public void okClick(ActionEvent actionEvent) {
        if (!provjeri(fldIme.getText())) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Neispravno ime");
            alert.setHeaderText("Neispravno ime studenta");
            alert.setContentText("Ime studenta treba biti najmanje 10 karaktera dugačko");
            alert.show();

        }
        else {

            student=fldIme.getText();
            dodajStudentaIme(student);
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.close();

        }

    }
}
