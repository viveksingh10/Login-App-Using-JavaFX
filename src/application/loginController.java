package application;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

public class loginController implements Initializable {
	
    public loginmodel loginModel = new loginmodel();
    
    
    @FXML
    private Label isConnected;
    
    @FXML
    private TextField txtusername;
    
    @FXML
    private TextField txtpassword;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(loginModel.isDbConnected()) {
			isConnected.setText("Enter Username & Password");
		}else {
			isConnected.setText("DB Not Connected");
		}
		
	}
	
	public void NewUser(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/NewUser.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle(" Welcome to the Company");
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
	public void Error(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/Error.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle(" Forgot Password ");
			primaryStage.show();
			
		} catch (Exception e) {
			
		}
	}
	
	
	
	public void Login (ActionEvent event) {
		try {
			if(loginModel.isLogin(txtusername.getText(), txtpassword.getText())) {
			isConnected.setText("Login Sussesful");
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/User.fxml").openStream());
			UserController userController = (UserController)loader.getController();
			userController.GetUser(txtusername.getText());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
	 		
			
			
		}else {
			isConnected.setText("Enter valid Username and Password");
		}
			
		} catch (SQLException e) {
			isConnected.setText("Enter valid Username and Password");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
