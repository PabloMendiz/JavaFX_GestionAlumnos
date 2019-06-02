package application;

import Modelo.Alumno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

	public void cambioVista(Button btn, String rsc) {

		try {

			Stage stage;
			Parent change = null;
			stage = (Stage) btn.getScene().getWindow();
			change = FXMLLoader.load(getClass().getResource(rsc));

			Scene vista = new Scene(change);

			stage.setScene(vista);
			stage.show();

		} catch (Exception e) {

		}

	}

	public static ObservableList<Alumno> getAlumnodata() {
		return alumnoData;
	}

	private final static ObservableList<Alumno> alumnoData = FXCollections.observableArrayList(
			new Alumno("", "Pablo", "Mendi", 8.0), new Alumno("", "Pablo", "Mendi", 8.0),
			new Alumno("", "Pablo", "Mendi", 8.0), new Alumno("", "Pablo", "Mendi", 8.0), 
			new Alumno("", "Pablo", "Mendi", 8.0), new Alumno("", "Pablo", "Mendi", 8.0),
			new Alumno("", "Pablo", "Mendi", 8.0), new Alumno("", "Pablo", "Mendi", 8.0),
			new Alumno("", "Pablo", "Mendi", 8.0), new Alumno("", "Pablo", "Mendi", 8.0),
			new Alumno("", "Pablo", "Mendi", 8.0), new Alumno("", "Pablo", "Mendi", 8.0));

}
