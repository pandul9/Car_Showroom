package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Client_contract extends connect {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button accept;

    @FXML
    private TextArea inf_con;

    @FXML
    private Button details;
    
    @FXML
    private Button decline;
    
    @FXML
    private Button exit;

    @FXML
    void initialize() {
    	decline.setDisable(false);
    	details.setDisable(true);
    	DataBaseHandler dbHandler = new DataBaseHandler();
    	details.setOnAction(event ->{    		
        	ResultSet result = dbHandler.getTable("client_has_car");
        	try {
				inf_con.setText(showData(result));
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	});
    	
    	decline.setOnAction(event ->{
    		Stage stage = (Stage) decline.getScene().getWindow();
    	    stage.close();
    	});
    	DataBaseHandler dbHandler2=new DataBaseHandler();
    	DataBaseHandler dbHandler1 = new DataBaseHandler();
    	accept.setOnAction(event ->{
    		sum=car_price+adds_price;
        	dbHandler1.chsIns();
    		dbHandler2.minusStock();
        	decline.setDisable(true);
        	details.setDisable(false);
    	});
    	
    	exit.setOnAction(event ->{
    		try {
				menu();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    }
    
    private String showData(ResultSet result) throws SQLException {
        ResultSetMetaData rsmd = result.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        String text  = "";
        for (int i = 1; i < numberOfColumns + 1; i++) { //�������� �������� ��������
            String columnName = rsmd.getColumnName(i);
            text = text + columnName + ", ";
        }
        text = text + "\n";
        while(result.next()) { //�������� ������ �� ����� �������

            for(int i =0; i<numberOfColumns; i++) {
                if(i+1 == numberOfColumns) {;
                    text = text + result.getString(i+1) + "\n";
                }
                else {
                    text += result.getString(i+1) + ", ";
                }
            }
        }
        return text;
    }
    
    public void menu () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("First_in.fxml"));
        Stage window=(Stage) exit.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
