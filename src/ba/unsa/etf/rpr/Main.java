package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/zadaca3.fxml"));
        stage.setTitle("Studenti");
        stage.setScene(new Scene(root));
        stage.setMinHeight(370);
        stage.setMinWidth(470);
        stage.toFront();
        stage.show();
    }
}
