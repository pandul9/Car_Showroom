package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class In_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button client_in;

    @FXML
    private Button admin_in;
    
    @FXML
    private Button client_date;
    
    @FXML
    private Button client_adds;
    
    @FXML
    private Button accept;
    
    @FXML
    private Button client_car;
    
    @FXML
    private Button client_cat;
    
    @FXML
    private Button client_choose_car;
    
    @FXML
    private Button admin_stat;
    
    @FXML
    private Button exit;

    @FXML
    void initialize() {
    	admin_in.setOnAction(event -> {
    		try {
				admin_in();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    	
    	exit.setOnAction(event ->{
    		Stage stage = (Stage) exit.getScene().getWindow();
    	    stage.close();
    	});
    }
    
    public void admin_in () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Administrator_in.fxml"));
        Stage window=(Stage) admin_in.getScene().getWindow();
        window.setScene(new Scene(root));
    }
 
    public void client_in () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_in.fxml"));
        Stage window=(Stage) client_in.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
}
