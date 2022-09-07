package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Client_category extends connect {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> menu_cat;

    @FXML
    private Button client_car;

    @FXML
    void client_car(ActionEvent event) {

    }

    ObservableList<String> langs = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
    	DataBaseHandler dbh = new DataBaseHandler();
    	ResultSet rs = dbh.getTableCategory(null);
    	try {
			while(rs.next()) {
				langs.add(rs.getString(1));
			}
			menu_cat.setItems(langs);
			menu_cat.setPromptText("Category");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	client_car.setOnAction(event ->{
			try {
				//System.out.println(menu_cat.getValue());
				switch (menu_cat.getValue()) {
					case("Economy"):
						client_carEc();
						car_category_name="Economy";
						//System.out.println("бомж");
						break;
					case("Comfort"):
						client_carCom();
						car_category_name="Comfort";
						//System.out.println("хорош");
						break;
					case("Premium"):
						client_carPrem();
						car_category_name="Premium";
						//System.out.println("владик");
						break;
					default:
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
    }
    
    public void client_carEc () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_car(economy).fxml"));
    	Stage window=(Stage) client_car.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    public void client_carCom () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_car(comfort).fxml"));
    	Stage window=(Stage) client_car.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    public void client_carPrem () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_car(premium).fxml"));
    	Stage window=(Stage) client_car.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
}
