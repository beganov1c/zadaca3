package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentiModel {

    private static ObservableList<String> studenti = FXCollections.observableArrayList();
    private static int trenutni=1;

    public static void dodajStudenta(String broj) {
        if(trenutni!=15) studenti.add("Student"+trenutni++);
        else studenti.add("Student"+broj);
    }

    public static void dodajStudentaIme(String ime) {
        studenti.add(ime);
        trenutni++;
    }


    public static ObservableList<String> expandTo(int broj, String zadnji) {

        if(broj<studenti.size()) return shrinkTo(broj);
        for(int i=trenutni; i<=broj; i++) {
            if(studenti.size()==broj)
                break;
            dodajStudenta(zadnji);
        }

        return studenti;
    }

    public static ObservableList<String> shrinkTo(int broj) {
        ObservableList<String> skraceni = FXCollections.observableArrayList();
        int brojac=0;

        for(String student : studenti) {
            skraceni.add(student);
            brojac++;
            if(brojac==broj) break;
        }

        return skraceni;
    }

    public ObservableList<String> getStudenti() {
        return studenti;
    }

    public void setStudenti(ObservableList<String> studenti) {
        this.studenti = studenti;
    }

    public int getTrenutni() {
        return trenutni;
    }

    public void setTrenutni(int trenutni) {
        this.trenutni = trenutni;
    }
}
