package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewUserController implements Initializable {

	@FXML
	private Label laable;
	
	@FXML
	private Label message;
	@FXML
    private TextField id;
	@FXML
    private TextField name;
	@FXML
    private TextField age;
	@FXML
    private TextField desig;
	@FXML
    private TextField cont;
	@FXML
    private TextField address;
	@FXML
    private TextField email;
	@FXML
    private TextField uname;
	@FXML
    private TextField upass;	

	public void submit(ActionEvent event) {
		if(id.getText().trim().isEmpty()  || name.getText().trim().isEmpty()   || email.getText().trim().isEmpty() ||
		   age.getText().trim().isEmpty() || desig.getText().trim().isEmpty()  || uname.getText().trim().isEmpty() ||
		   cont.getText().trim().isEmpty()|| address.getText().trim().isEmpty()|| upass.getText().trim().isEmpty()) 
		{
			message.setText("Enter all details corrrectly");
		}else {
		
		message.setText("Registered, you will receive confirmation on your mail then you can login");
		}
		
	}
	
	public void exxit(ActionEvent event) {
	System.exit(0);
		
	}
	
	public void Out(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/login.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
