package vista;


import Modelo.Alumno;
import application.Controller;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControladorVista2 extends Controller{
	
	//ATRIBUTOS

	private int indice;
	protected double fol = 0;
	protected double bbdd = 0;
	protected double ssii = 0;
	protected double prog = 0;
	protected double ends = 0;
	protected double lmsg = 0;

	private Main mainApp;
	private Alumno alumno;
	
	@FXML
	private Alert alerta = new Alert(AlertType.ERROR);
	@FXML
	private ImageView img;
	
	@FXML
	private Label nameLbl;
	@FXML
	private Label lastNameLbl;
	@FXML
	private Label mediaLbl;
	@FXML
	private Label LMLbl;
	@FXML
	private Label bbddLbl;
	@FXML
	private Label ssiiLbl;
	@FXML
	private Label progLbl;
	@FXML
	private CheckBox folaCheckBox;
	@FXML
	private Label endsLbl;

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtMedia;
	@FXML
	private TextField txtLM;
	@FXML
	private TextField txtBBDD;
	@FXML
	private TextField txtSSII;
	@FXML
	private TextField txtPROG;
	@FXML
	private TextField txtFOLA;
	@FXML
	private TextField txtENDS;
	
	
	@FXML
	private Button btnOk;
	@FXML
	private Button btnCancel;
	
	//METODOS
	
	
	public void initialize() {

	}

	public void setPerson(String image, String name, String apellido, Double media, int index) {

		img.setImage(new Image(image));
		txtName.setText(name);
		txtLastName.setText(apellido);
		txtMedia.setText(Double.toString(media));
		indice = index;

	}
	
	public void actionOK() {
		if (txtName.getText().equals("") || txtLastName.getText().equals("") || txtLM.getText().equals("") || txtBBDD.getText().equals("") || 
			txtPROG.getText().equals("") || txtSSII.getText().equals("") || txtENDS.getText().equals("")) {  
			
			alerta.setTitle("Campos incompletos");
			alerta.setContentText("Porfavor rellena todos los campos");
			alerta.showAndWait();
			
		} else {
			if (indice != -1) {
				getAlumnodata().set(indice, new Alumno("", txtName.getText(), txtLastName.getText(), calcularNotaMEdia()));
			
			} else {
				getAlumnodata().add(indice, new Alumno("", txtName.getText(), txtLastName.getText(), calcularNotaMEdia()));
			}
			cambioVista(btnOk, "../vista/vista1.fxml");
		}
	}
	
	public void hacerFOLEditable() {
		
		if (folaCheckBox.isSelected()) 
			txtFOLA.setDisable(false);
		else
			txtFOLA.setDisable(true);
			
		 }
	
	
	//Calculo nota media
	public Double calcularNotaMEdia() {
		if (folaCheckBox.isSelected()) {
			double array[] = { Double.parseDouble(txtFOLA.getText()), Double.parseDouble(txtSSII.getText()),
					Double.parseDouble(txtPROG.getText()), Double.parseDouble(txtENDS.getText()),
					Double.parseDouble(txtLM.getText()), Double.parseDouble(txtBBDD.getText()) };
			double media = 0.0;
			if (Double.parseDouble(txtFOLA.getText()) > 10 || Double.parseDouble(txtFOLA.getText()) < 0
					|| Double.parseDouble(txtSSII.getText()) < 0 || Double.parseDouble(txtPROG.getText()) < 0
					|| Double.parseDouble(txtENDS.getText()) < 0 || Double.parseDouble(txtLM.getText()) < 0
					|| Double.parseDouble(txtBBDD.getText()) < 0 || Double.parseDouble(txtSSII.getText()) > 10
					|| Double.parseDouble(txtPROG.getText()) > 10 || Double.parseDouble(txtENDS.getText()) > 10
					|| Double.parseDouble(txtLM.getText()) > 10
					|| Double.parseDouble(txtBBDD.getText()) > 10) {
				return (double) -1;
			} else {
				for (int i = 0; i < array.length; i++) {
					media = media + array[i];
				}
				media = media / array.length;
				return ((double) Math.round(media * 10d) / 10d);
			}
		} else {
			double array[] = {Double.parseDouble(txtSSII.getText()),
					Double.parseDouble(txtPROG.getText()), Double.parseDouble(txtENDS.getText()),
					Double.parseDouble(txtLM.getText()), Double.parseDouble(txtBBDD.getText()) };
			double media = 0.0;
			if ( Double.parseDouble(txtSSII.getText()) < 0 || Double.parseDouble(txtPROG.getText()) < 0
					|| Double.parseDouble(txtENDS.getText()) < 0 || Double.parseDouble(txtLM.getText()) < 0
					|| Double.parseDouble(txtBBDD.getText()) < 0 || Double.parseDouble(txtSSII.getText()) > 10
					|| Double.parseDouble(txtPROG.getText()) > 10 || Double.parseDouble(txtENDS.getText()) > 10
					|| Double.parseDouble(txtLM.getText()) > 10
					|| Double.parseDouble(txtBBDD.getText()) > 10) {
				return (double) -1;
			} else {
				for (int i = 0; i < array.length; i++) {
					media = media + array[i];
				}
				media = media / array.length;
				return ((double) Math.round(media * 10d) / 10d);
			}
		}
		
	}
	
	//metodo que lleva a la pantalla principal al pulsar cancel
	@FXML
	private void actionCancel() {
		cambioVista(btnCancel, "../vista/vista1.fxml");
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
	 * @return the img
	 */
	public ImageView getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(ImageView img) {
		this.img = img;
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
	 * @return the lMLbl
	 */
	public Label getLMLbl() {
		return LMLbl;
	}

	/**
	 * @param lMLbl the lMLbl to set
	 */
	public void setLMLbl(Label lMLbl) {
		LMLbl = lMLbl;
	}

	/**
	 * @return the bbddLbl
	 */
	public Label getBbddLbl() {
		return bbddLbl;
	}

	/**
	 * @param bbddLbl the bbddLbl to set
	 */
	public void setBbddLbl(Label bbddLbl) {
		this.bbddLbl = bbddLbl;
	}

	/**
	 * @return the ssiiLbl
	 */
	public Label getSsiiLbl() {
		return ssiiLbl;
	}

	/**
	 * @param ssiiLbl the ssiiLbl to set
	 */
	public void setSsiiLbl(Label ssiiLbl) {
		this.ssiiLbl = ssiiLbl;
	}

	/**
	 * @return the progLbl
	 */
	public Label getProgLbl() {
		return progLbl;
	}

	/**
	 * @param progLbl the progLbl to set
	 */
	public void setProgLbl(Label progLbl) {
		this.progLbl = progLbl;
	}

	/**
	 * @return the folaCheckBox
	 */
	public CheckBox getFolaCheckBox() {
		return folaCheckBox;
	}

	/**
	 * @param folaCheckBox the folaCheckBox to set
	 */
	public void setFolaCheckBox(CheckBox folaCheckBox) {
		this.folaCheckBox = folaCheckBox;
	}

	/**
	 * @return the endsLbl
	 */
	public Label getEndsLbl() {
		return endsLbl;
	}

	/**
	 * @param endsLbl the endsLbl to set
	 */
	public void setEndsLbl(Label endsLbl) {
		this.endsLbl = endsLbl;
	}

	/**
	 * @return the txtName
	 */
	public TextField getTxtName() {
		return txtName;
	}

	/**
	 * @param txtName the txtName to set
	 */
	public void setTxtName(TextField txtName) {
		this.txtName = txtName;
	}

	/**
	 * @return the txtLastName
	 */
	public TextField getTxtLastName() {
		return txtLastName;
	}

	/**
	 * @param txtLastName the txtLastName to set
	 */
	public void setTxtLastName(TextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	/**
	 * @return the txtMedia
	 */
	public TextField getTxtMedia() {
		return txtMedia;
	}

	/**
	 * @param txtMedia the txtMedia to set
	 */
	public void setTxtMedia(TextField txtMedia) {
		this.txtMedia = txtMedia;
	}

	/**
	 * @return the txtLM
	 */
	public TextField getTxtLM() {
		return txtLM;
	}

	/**
	 * @param txtLM the txtLM to set
	 */
	public void setTxtLM(TextField txtLM) {
		this.txtLM = txtLM;
	}

	/**
	 * @return the txtBBDD
	 */
	public TextField getTxtBBDD() {
		return txtBBDD;
	}

	/**
	 * @param txtBBDD the txtBBDD to set
	 */
	public void setTxtBBDD(TextField txtBBDD) {
		this.txtBBDD = txtBBDD;
	}

	/**
	 * @return the txtSSII
	 */
	public TextField getTxtSSII() {
		return txtSSII;
	}

	/**
	 * @param txtSSII the txtSSII to set
	 */
	public void setTxtSSII(TextField txtSSII) {
		this.txtSSII = txtSSII;
	}

	/**
	 * @return the txtPROG
	 */
	public TextField getTxtPROG() {
		return txtPROG;
	}

	/**
	 * @param txtPROG the txtPROG to set
	 */
	public void setTxtPROG(TextField txtPROG) {
		this.txtPROG = txtPROG;
	}

	/**
	 * @return the txtFOLA
	 */
	public TextField getTxtFOLA() {
		return txtFOLA;
	}

	/**
	 * @param txtFOLA the txtFOLA to set
	 */
	public void setTxtFOLA(TextField txtFOLA) {
		this.txtFOLA = txtFOLA;
	}

	/**
	 * @return the txtENDS
	 */
	public TextField getTxtENDS() {
		return txtENDS;
	}

	/**
	 * @param txtENDS the txtENDS to set
	 */
	public void setTxtENDS(TextField txtENDS) {
		this.txtENDS = txtENDS;
	}

	/**
	 * @return the btnOk
	 */
	public Button getBtnOk() {
		return btnOk;
	}

	/**
	 * @param btnOk the btnOk to set
	 */
	public void setBtnOk(Button btnOk) {
		this.btnOk = btnOk;
	}

	/**
	 * @return the btnCancel
	 */
	public Button getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel the btnCancel to set
	 */
	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}
	
	//GETTERS Y SETTERS

}

