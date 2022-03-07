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
import javafx.stage.Stage;

public class EndController implements Initializable {

	@FXML
	Label lbl_congrats;
	@FXML
	Label lbl_congratsName;
	@FXML
	Label lbl_markTxt;
	@FXML 
	Label lbl_markNb;
	@FXML
	Label lbl_replay;
	@FXML
	Label lbl_difficultyInfo;
	@FXML 
	Button btn_yes;
	@FXML
	Button btn_no;
	
	Game game;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fetchEnd();
	}
	
	
	public void fetchEnd() {
		lbl_congratsName.setText(game.getPlayer().getName());
		lbl_markNb.setText(game.markString());
		lbl_difficultyInfo.setText("Mode " + game.difficultyString());
	}
	
	public void onNo() {
		Stage stage = (Stage) btn_no.getScene().getWindow();
	    stage.close();
	}
	
	public void onYes(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/GameMenu.fxml"));
		MenuController menuController = new MenuController();
		loader.setController(menuController);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	
}
