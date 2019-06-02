package vista;

import Modelo.Alumno;
import application.Controller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ControladorVista1 extends Controller{
	//
	private Main mainApp;
	private Alumno alumno;
	@FXML
	private Alert alerta = new Alert(AlertType.ERROR);

	@FXML
	private TableView<Alumno> table;
	@FXML
	private TableColumn<Alumno, String> nameColumn;
	@FXML
	private TableColumn<Alumno, String> lastNameColumn;
	@FXML
	private TableColumn<Alumno, String> mediaColumn;
	
	@FXML
	private AnchorPane anchor;
	@FXML
	private Label nameLbl;
	@FXML
	private Label lastNameLbl;
	@FXML
	private Label mediaLbl;

	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnBorrar;
	@FXML
	private Button btnEditar;

	@FXML
	private void initialize() {
		table.setItems(getAlumnodata());
		nameColumn.setCellValueFactory(new PropertyValueFactory<Alumno, String>("name"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Alumno, String>("lastName"));
		mediaColumn.setCellValueFactory(new PropertyValueFactory<Alumno, String>("media"));

	}

	@FXML
	private void actionNuevo() {
		
		cambioVista(btnNuevo, "../vista/vista2.fxml");
	}

	@FXML
	private void actionBorrar() {
		Alumno itemSelected = table.getSelectionModel().getSelectedItem();

		if (itemSelected != null) {
			table.getItems().remove(itemSelected);

		} else {
			alerta.setTitle("WARNING");
			alerta.setContentText("No se ha seleccionado ninguna fila");
			alerta.showAndWait();
		}
	}
	
	@FXML
	public void editarceldas(ActionEvent event) {
		if (!table.getSelectionModel().isEmpty()) {
			cambioVista(btnEditar, "../vista/vista2.fxml");
			
		} else {
			alerta.setTitle("WARNING");
			alerta.setContentText("No se ha seleccionado ninguna fila");
			alerta.showAndWait();
		}

	}

	/**
	 * @return the mainApp
	 */
	public Main getMainApp() {
		return mainApp;
	}

	/**
	 * @param mainApp the mainApp to set
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	 * @return the alerta
	 */
	public Alert getAlerta() {
		return alerta;
	}

	/**
	 * @param alerta the alerta to set
	 */
	public void setAlerta(Alert alerta) {
		this.alerta = alerta;
	}

	/**
	 * @return the table
	 */
	public TableView<Alumno> getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(TableView<Alumno> table) {
		this.table = table;
	}

	/**
	 * @return the nameColumn
	 */
	public TableColumn<Alumno, String> getNameColumn() {
		return nameColumn;
	}

	/**
	 * @param nameColumn the nameColumn to set
	 */
	public void setNameColumn(TableColumn<Alumno, String> nameColumn) {
		this.nameColumn = nameColumn;
	}

	/**
	 * @return the lastNameColumn
	 */
	public TableColumn<Alumno, String> getLastNameColumn() {
		return lastNameColumn;
	}

	/**
	 * @param lastNameColumn the lastNameColumn to set
	 */
	public void setLastNameColumn(TableColumn<Alumno, String> lastNameColumn) {
		this.lastNameColumn = lastNameColumn;
	}

	/**
	 * @return the mediaColumn
	 */
	public TableColumn<Alumno, String> getMediaColumn() {
		return mediaColumn;
	}

	/**
	 * @param mediaColumn the mediaColumn to set
	 */
	public void setMediaColumn(TableColumn<Alumno, String> mediaColumn) {
		this.mediaColumn = mediaColumn;
	}

	/**
	 * @return the nameLbl
	 */
	public Label getNameLbl() {
		return nameLbl;
	}

	/**
	 * @param nameLbl the nameLbl to set
	 */
	public void setNameLbl(Label nameLbl) {
		this.nameLbl = nameLbl;
	}

	/**
	 * @return the lastNameLbl
	 */
	public Label getLastNameLbl() {
		return lastNameLbl;
	}

	/**
	 * @param lastNameLbl the lastNameLbl to set
	 */
	public void setLastNameLbl(Label lastNameLbl) {
		this.lastNameLbl = lastNameLbl;
	}

	/**
	 * @return the mediaLbl
	 */
	public Label getMediaLbl() {
		return mediaLbl;
	}

	/**
	 * @param mediaLbl the mediaLbl to set
	 */
	public void setMediaLbl(Label mediaLbl) {
		this.mediaLbl = mediaLbl;
	}

	/**
	 * @return the btnAdd
	 */
	public Button getBtnNuevo() {
		return btnNuevo;
	}

	/**
	 * @param btnAdd the btnAdd to set
	 */
	public void setBtnNuevo(Button btnAdd) {
		this.btnNuevo = btnAdd;
	}

	/**
	 * @return the btnBorrar
	 */
	public Button getBtnBorrar() {
		return btnBorrar;
	}

	/**
	 * @param btnBorrar the btnBorrar to set
	 */
	public void setBtnBorrar(Button btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	

	
}
