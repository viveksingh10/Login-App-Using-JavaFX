package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ErrorController implements Initializable {
	
	@FXML
	private Label laa;
	@FXML
	private Label mymessage;
	@FXML
	private TextField txterroruser;
	@FXML
	private TextField txterrorpass;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;
	

	public void submit(ActionEvent event) {

		if(txterroruser.getText().trim().isEmpty() || txterrorpass.getText().trim().isEmpty()) {
			mymessage.setStyle
			(
				 "-fx-background-color: white;"
				+ "-fx-text-fill: red;"
			);
			mymessage.setText("Invalid Username and Password");
			
		}else {
			mymessage.setStyle
			(
					
					 "-fx-background-color: #1aff1a;"
					+ "-fx-text-fill: black;"
			);
		mymessage.setText("Problem registed, will tune you soon on your mail");
		
		}
		
		
	}
	
	public void exxit(ActionEvent event) {
	System.exit(0);
		
	}
	
	
	public void out(ActionEvent event) {
		try {
			
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/login.fxml").openStream());
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
		} catch (Exception e) {
			
		}
	}

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
