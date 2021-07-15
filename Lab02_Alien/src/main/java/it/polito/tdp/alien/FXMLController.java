package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField field;

    @FXML
    private Button Transalte;

    @FXML
    private TextArea area;

    @FXML
    private Button Reset;

    @FXML
    void doReset(ActionEvent event) {
      	field.clear();
    	area.clear();
    	model.resetDictionary();
    }

    @FXML
    void doTransalte(ActionEvent event) {
    	area.clear();
		String riga = field.getText().toLowerCase();

		if (riga == null || riga.length() == 0) {
			area.setText("Inserire una o due parole.");
			return;
		}

		StringTokenizer st = new StringTokenizer(riga, " ");

		if (!st.hasMoreElements()) {
			area.setText("Inserire una o due parole.");
			return;
		}

		String alienWord = st.nextToken();

		if (st.hasMoreTokens()) {

			String translation = st.nextToken();

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				area.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			
			model.addWord(alienWord, translation);

			area.setText("La parola: \"" + alienWord + "\", con traduzione: \"" + translation + "\", è stata inserita nel dizionario.");

		} else {

			if (!alienWord.matches("[a-zA-Z]*")) {
				area.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation = model.translateWord(alienWord);

			if (translation != null) {
				area.setText(translation);
			} else {
				area.setText("La parola cercata non esiste nel dizionario.");
			}
		}
    	
    }

    @FXML
    void initialize() {
        assert field != null : "fx:id=\"field\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Transalte != null : "fx:id=\"Transalte\" was not injected: check your FXML file 'Scene.fxml'.";
        assert area != null : "fx:id=\"area\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Reset != null : "fx:id=\"Reset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
	public void setModel(Model model) {
		this.model=model;
	}
}
