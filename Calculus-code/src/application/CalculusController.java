package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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

public class CalculusController implements Initializable{
	//Controls
		@FXML
		Label lbl_equation;
		@FXML
		Label lbl_calcIndex;
		@FXML
		Label lbl_calcError;

		@FXML
		Button btn_answer1;
		@FXML
		Button btn_answer2;
		@FXML
		Button btn_answer3;
		@FXML
		Button btn_answer4;
		@FXML
		Button btn_previous;
		@FXML
		Button btn_next;
		@FXML
		Button btn_exit;
		
		Game game;
		int calcIndex;
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			calcIndex = 0;
			fetchCalc(calcIndex);
		}
		
		public void fetchPreviousCalc() {
			if (calcIndex!=0) {
				
					calcIndex--;
					fetchCalc(calcIndex);
					lbl_calcError.setVisible(false);
				}		
		}
		
		public void fetchNextCalc(ActionEvent event) throws IOException, InterruptedException {
			if (calcIndex!=(game.getNumberOfCalc())-1) {
					calcIndex++;
					fetchCalc(calcIndex);
				}
			else if (game.getNbOfSolved()==game.getNumberOfCalc()) {
					switchToEnd(event,game);
				}
			else {
				lbl_calcError.setVisible(true);
			}
			}
		
		
		public void fetchCalc(int index) {
			if(game.getCalculations().get(index).getSolved()) {
				removeColorButtons();
				lbl_equation.setText(game.getCalculations().get(index).getEquation());
				btn_answer1.setText(Integer.toString(game.getCalculations().get(index).getChoices()[0]));
				btn_answer2.setText(Integer.toString(game.getCalculations().get(index).getChoices()[1]));
				btn_answer3.setText(Integer.toString(game.getCalculations().get(index).getChoices()[2]));
				btn_answer4.setText(Integer.toString(game.getCalculations().get(index).getChoices()[3]));
				lbl_calcIndex.setText(Integer.toString(getCalcIndex()+1));
				fetchResult(index);
			}
			else {
				enableButtons();
				removeColorButtons();
				lbl_equation.setText(game.getCalculations().get(index).getEquation());
				btn_answer1.setText(Integer.toString(game.getCalculations().get(index).getChoices()[0]));
				btn_answer2.setText(Integer.toString(game.getCalculations().get(index).getChoices()[1]));
				btn_answer3.setText(Integer.toString(game.getCalculations().get(index).getChoices()[2]));
				btn_answer4.setText(Integer.toString(game.getCalculations().get(index).getChoices()[3]));
				lbl_calcIndex.setText(Integer.toString(getCalcIndex()+1));
			}
		}
		
		
		public void fetchResult(int index) {
			disableButtons();
			if (Integer.parseInt(btn_answer1.getText())==game.getCalculations().get(index).getPlayerChoice() && Integer.parseInt(btn_answer1.getText())!=game.getCalculations().get(index).getResult()) {
				btn_answer1.setStyle("-fx-background-color: #ff0000");
			}
			if (Integer.parseInt(btn_answer1.getText())==game.getCalculations().get(index).getResult()) {
				btn_answer1.setStyle("-fx-background-color: #00ff00");
			}
			if (Integer.parseInt(btn_answer2.getText())==game.getCalculations().get(index).getPlayerChoice() && Integer.parseInt(btn_answer2.getText())!=game.getCalculations().get(index).getResult()) {
				btn_answer2.setStyle("-fx-background-color: #ff0000");
			}
			if (Integer.parseInt(btn_answer2.getText())==game.getCalculations().get(index).getResult()) {
				btn_answer2.setStyle("-fx-background-color: #00ff00");
			}
			if (Integer.parseInt(btn_answer3.getText())==game.getCalculations().get(index).getPlayerChoice() && Integer.parseInt(btn_answer3.getText())!=game.getCalculations().get(index).getResult()) {
				btn_answer3.setStyle("-fx-background-color: #ff0000");
			}
			if (Integer.parseInt(btn_answer3.getText())==game.getCalculations().get(index).getResult()) {
				btn_answer3.setStyle("-fx-background-color: #00ff00");
			}
			if (Integer.parseInt(btn_answer4.getText())==game.getCalculations().get(index).getPlayerChoice() && Integer.parseInt(btn_answer4.getText())!=game.getCalculations().get(index).getResult()) {
				btn_answer4.setStyle("-fx-background-color: #ff0000");
			}
			if (Integer.parseInt(btn_answer4.getText())==game.getCalculations().get(index).getResult()) {
				btn_answer4.setStyle("-fx-background-color: #00ff00");
			}
		}
		
		public void onClickAns1() {
			game.getCalculations().get(calcIndex).setPlayerChoice(Integer.parseInt(btn_answer1.getText()));
			game.getCalculations().get(calcIndex).setSolved(true);
			if (game.getCalculations().get(calcIndex).getPlayerChoice()==game.getCalculations().get(calcIndex).getResult()) {
				game.getPlayer().setScore(game.getPlayer().getScore()+1);
			}
			game.setNbOfSolved(game.getNbOfSolved()+1);
			fetchResult(calcIndex);	
		}
		
		public void onClickAns2() {
			game.getCalculations().get(calcIndex).setPlayerChoice(Integer.parseInt(btn_answer2.getText()));
			game.getCalculations().get(calcIndex).setSolved(true);
			if (game.getCalculations().get(calcIndex).getPlayerChoice()==game.getCalculations().get(calcIndex).getResult()) {
				game.getPlayer().setScore(game.getPlayer().getScore()+1);
			}
			game.setNbOfSolved(game.getNbOfSolved()+1);
			fetchResult(calcIndex);		
		}
		
		public void onClickAn3() {
			game.getCalculations().get(calcIndex).setPlayerChoice(Integer.parseInt(btn_answer3.getText()));
			game.getCalculations().get(calcIndex).setSolved(true);
			if (game.getCalculations().get(calcIndex).getPlayerChoice()==game.getCalculations().get(calcIndex).getResult()) {
				game.getPlayer().setScore(game.getPlayer().getScore()+1);
			}
			game.setNbOfSolved(game.getNbOfSolved()+1);
			fetchResult(calcIndex);
		}
		
		public void onClickAns4() {
			game.getCalculations().get(calcIndex).setPlayerChoice(Integer.parseInt(btn_answer4.getText()));
			game.getCalculations().get(calcIndex).setSolved(true);
			if (game.getCalculations().get(calcIndex).getPlayerChoice()==game.getCalculations().get(calcIndex).getResult()) {
				game.getPlayer().setScore(game.getPlayer().getScore()+1);
			}
			game.setNbOfSolved(game.getNbOfSolved()+1);
			fetchResult(calcIndex);
		}
		
		public void disableButtons() {
			btn_answer1.disableProperty().set(true);
			btn_answer2.disableProperty().set(true);
			btn_answer3.disableProperty().set(true);
			btn_answer4.disableProperty().set(true);
		}
		public void enableButtons() {
			btn_answer1.disableProperty().set(false);
			btn_answer2.disableProperty().set(false);
			btn_answer3.disableProperty().set(false);
			btn_answer4.disableProperty().set(false);
		}
		public void removeColorButtons() {
			btn_answer1.setStyle(null);
			btn_answer2.setStyle(null);
			btn_answer3.setStyle(null);
			btn_answer4.setStyle(null);
		}
		
		public Game getGame() {
			return game;
		}

		public void setGame(Game game) {
			this.game = game;
		}
		public int getCalcIndex() {
			return calcIndex;
		}

		public void setCalcIndex(int calcIndex) {
			this.calcIndex = calcIndex;
		}
		
		public void onExit() {
			Stage stage = (Stage) btn_exit.getScene().getWindow();
		    stage.close();
		}
		
		public void switchToEnd(ActionEvent event, Game game) throws IOException {
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.close();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/GameEnd.fxml"));
			EndController endController = new EndController();
			endController.setGame(game);
			loader.setController(endController);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
}
