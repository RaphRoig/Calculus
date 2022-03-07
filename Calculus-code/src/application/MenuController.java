package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController implements Initializable{

	//Controls GameMenu
	@FXML
	Label lbl_calc;
	@FXML
	Label lbl_true;
	@FXML
	Label lbl_false;
	@FXML 
	Label lbl_nb;
	@FXML
	Label lbl_name;
	@FXML 
	Label lbl_difficulty;
	@FXML
	Label lbl_nameError;
	
	@FXML
	TextField txtF_name;
	
	@FXML
	Button btn_true;
	@FXML
	Button btn_false;
	@FXML
	Button btn_easy;
	@FXML
	Button btn_medium;
	@FXML
	Button btn_hard;
	
	@FXML
	RadioButton rbtn_nb5;
	@FXML
	RadioButton rbtn_nb10;
	@FXML
	RadioButton rbtn_nb15;
	ToggleGroup rbtn_group = new ToggleGroup();
	
	@FXML
	ImageView img_dynseo;
	
	public void groupRbtn() {
	rbtn_nb5.setToggleGroup(rbtn_group);
	rbtn_nb10.setToggleGroup(rbtn_group);
	rbtn_nb15.setToggleGroup(rbtn_group);
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		groupRbtn();
		
	}
	
	public void fetchNameError() {
		lbl_nameError.setVisible(true);
	}
	
	public void onTrueBtn() {
		btn_true.setStyle("-fx-background-color: #00ff00");
	}
	public void onFalseBtn() {
		btn_false.setStyle("-fx-background-color: #ff0000");
	}
	
	public void onClickEasy(ActionEvent event) throws IOException {
		if (!(txtF_name.getText().isEmpty())) {
			Player player = new Player(txtF_name.getText());
			Game game = new Game(1,Integer.parseInt(((RadioButton) rbtn_group.getSelectedToggle()).getText()),player);
			switchToCalc(event, game);
		}
		else {
			fetchNameError();
		}
	}
	public void onClickMedium(ActionEvent event) throws IOException {
		if (!(txtF_name.getText().isEmpty())) {
			Player player = new Player(txtF_name.getText());
			Game game = new Game(2,Integer.parseInt(((RadioButton) rbtn_group.getSelectedToggle()).getText()),player);
			switchToCalc(event, game);
		}
		else {
			fetchNameError();
		}
	}
	public void onClickHard(ActionEvent event) throws IOException {
		if (!(txtF_name.getText().isEmpty())) {
			Player player = new Player(txtF_name.getText());
			Game game = new Game(3,Integer.parseInt(((RadioButton) rbtn_group.getSelectedToggle()).getText()),player);
			switchToCalc(event, game);
		}
		else {
			fetchNameError();
		}
	}
	
	public void switchToCalc(ActionEvent event, Game game) throws IOException {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/GameCalculus.fxml"));
		CalculusController calculusController = new CalculusController();
		calculusController.setGame(game);
		loader.setController(calculusController);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	

}
