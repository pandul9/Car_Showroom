package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Client_adds extends connect {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button tires;

    @FXML
    private Button camera;

    @FXML
    private Button interior;

    @FXML
    private Button color;

    @FXML
    private Button nothing;

    @FXML
    private Button next_scene;
    
    @FXML
    private Button back;

    @FXML
    void initialize() {
    	tires.setDisable(false);
    	camera.setDisable(false);
    	interior.setDisable(false);
    	color.setDisable(false);
    	nothing.setDisable(false);
    	
    	tires.setOnAction(event ->{
    		adds_name="Tires";
    		adds_price=80000;
    		camera.setDisable(true);
        	interior.setDisable(true);
        	color.setDisable(true);
        	nothing.setDisable(true);
        });
    	
    	camera.setOnAction(event ->{
    		adds_name="Camera";
    		adds_price=150000;
    		tires.setDisable(true);
        	interior.setDisable(true);
        	color.setDisable(true);
        	nothing.setDisable(true);
        });
    	
    	interior.setOnAction(event ->{
    		adds_name="Interior";
    		adds_price=350000;
    		tires.setDisable(true);
        	camera.setDisable(true);
        	color.setDisable(true);
        	nothing.setDisable(true);
        });
    	
    	color.setOnAction(event ->{
    		adds_name="Color";
    		adds_price=15000;
    		tires.setDisable(true);
        	interior.setDisable(true);
        	camera.setDisable(true);
        	nothing.setDisable(true);
        });
    	
    	nothing.setOnAction(event ->{
    		adds_name="Nothing";
    		adds_price=0;
    		tires.setDisable(true);
        	interior.setDisable(true);
        	color.setDisable(true);
        	camera.setDisable(true);
        });
    	next_scene.setOnAction(event ->{
    		try {
				client_adds();
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
    	
    	back.setOnAction(event ->{
    		try {
    			switch(car_category_name) {
    				case("Economy"):
    					back_eco();
    					break;
    				case("Comfort"):
        				back_com();
    					break;
        			case("Premium"):
        				back_prem();
        				break;
        			default:
						break;
    			}
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
    }
    
    public void client_adds () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_contract.fxml"));
    	Stage window=(Stage) next_scene.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    public void back_eco () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_car(economy).fxml"));
    	Stage window=(Stage) back.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    public void back_com () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_car(comfort).fxml"));
    	Stage window=(Stage) back.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    public void back_prem () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_car(premium).fxml"));
    	Stage window=(Stage) back.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
}
