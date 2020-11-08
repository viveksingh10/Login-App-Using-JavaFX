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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserController implements Initializable {

	@FXML
	private Label userLBL;
	@FXML
	private CheckBox cb1;
	@FXML
	private CheckBox cb2;
	@FXML
	private CheckBox cb3;
	@FXML
	private CheckBox cb4;
	@FXML
	private CheckBox cb5;
	@FXML
	private Label lbllist;
	@FXML
	private Label lblcount;
	@FXML
	private Label myy;
	@FXML
	private Button button12;
	@FXML
	private Button button11;
	@FXML
	private Button button10;
	
	
	
	public void checkevent(ActionEvent event) {
		String message = "";
		int count = 0;
		if (cb1.isSelected()){
			count ++;
			message += cb1.getText() + "\n";
		}
		if (cb2.isSelected()){ 
			count++;
			message += cb2.getText() + "\n";
		} 
		if (cb3.isSelected()){
			count ++;
			message += cb3.getText() + "\n";
		}
		if (cb4.isSelected()){
			count ++;
			message += cb4.getText() + "\n";
		}
		if (cb5.isSelected()){
			count ++;
			message += cb5.getText() + "\n";
		}
		lblcount.setStyle
		(
				 "-fx-background-color:#1aff1a ;"
							+"-fx-font-family: \"Berlin Sans FB\";"
			                + "-fx-font-size: 24px;"	
						+ "-fx-text-fill: black;"
		);
		lblcount.setText("Completed : " + count);
		lbllist.setStyle(
				"-fx-background-color:#1aff1a ;"
				+"-fx-font-family: \"Berlin Sans FB\";"
                + "-fx-font-size: 17px;"	
			    + "-fx-text-fill: black;"
               );
		lbllist.setText(message);
	}
	
	
	
	
	public void GetUser(String user) {
		// TODO Auto-generated method stub
		userLBL.setText(user);
		
	}
	public void SignOut(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/login.fxml").openStream());
			Scene scene = new Scene(root);
			/*scene.getStylesheets().add(getClass().getResource("application/application.css").toExternalForm());*/
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
public void exxit(ActionEvent event) {
		System.exit(0);
}

public void submit(ActionEvent event) {

	if(lbllist.getText().trim().isEmpty()){
		myy.setStyle
		(
			 "-fx-background-color: white;"
			+ "-fx-text-fill: red;"
		);
		myy.setText("Nothing completed yet");
	}
	else{
		myy.setStyle
		(
			 "-fx-background-color: #1aff1a;"
			+ "-fx-text-fill: black;"
		);
	myy.setText("Updates Saved");
	}
	
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
