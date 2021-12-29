package ba.unsa.etf.rpr;

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



    @FXML
    public void initialize() {
        fldIme.textProperty().addListener((observableValue, o, n) -> {

            progressBar.setProgress(n.length()/10.);
            if ((n.length()/10.)<1) {
                progressBar.getStyleClass().removeAll("zeleniProgress");
                progressBar.getStyleClass().add("crveniProgress");
            } else {
                progressBar.getStyleClass().removeAll("crveniProgress");
                progressBar.getStyleClass().add("zeleniProgress");

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

            dodajStudentaIme(fldIme.getText());
            Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.close();

        }

    }
}
