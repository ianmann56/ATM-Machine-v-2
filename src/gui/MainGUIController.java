package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class MainGUIController implements Initializable{

	public AnchorPane head;
	public Button btnActivity;
	public Button btnTransfer;
	public Button btnSettings;
	public Button btnLogout;
	public AnchorPane mainDisplay;
	public ScrollPane mainScrollPane;
	public Node loginPane;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void activityPressed(){
		System.out.println("activity");
	}
	
	public void transferPressed(){
		System.out.println("transfer");
	}
	
	public void settingsPressed(){
		System.out.println("settings");
	}
	
	public void logoutPressed(){
		System.out.println("logout");
	}
	
	public void showLoginPane(){
		loginPane = LoginPane.getDesign();
		mainDisplay.getChildren().add(loginPane);
		loginPane.setLayoutX(545);
		loginPane.setLayoutY(225);
		loginPane.setId("loginPane");
		mainScrollPane.setFitToWidth(true);
		mainScrollPane.setFitToHeight(true);
	}
}
