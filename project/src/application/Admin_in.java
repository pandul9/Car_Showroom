package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import animations.Shake;

public class Admin_in extends connect {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button admin_stat;

    @FXML
    private PasswordField pass_adm;

    @FXML
    private TextField login_adm;
    
    @FXML
    private Button main_menu;

    @FXML
    void initialize() {
        admin_stat.setOnAction(event ->{
        	String loginText = login_adm.getText().trim();
        	String loginPass = pass_adm.getText().trim();
        	String pos = Const.EMPLOYEE_POSITION;
        	if (!loginText.equals("") && !loginPass.equals(""))
				try {
					loginAdm(loginText, loginPass);
					admin_id = loginText;
					DataBaseHandler dbHandler2 = new DataBaseHandler();
			    	dbHandler2.contractIns();
					//System.out.println("Good!!!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			else {
				Shake userLogAnim = new Shake(login_adm);
				Shake userPassAnim = new Shake(pass_adm);
				userLogAnim.playAnim();
				userPassAnim.playAnim();
				//System.out.println("Empty!");
			}
        });
        
        main_menu.setOnAction(event ->{
    		try {
				menu();
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
    }
    
    private void loginAdm(String loginText, String loginPass) throws Exception {
		DataBaseHandler dbHandler = new DataBaseHandler();
		Employee employee = new Employee();
		employee.setId(loginText);
		employee.setPassword(loginPass);
		ResultSet resultSet= dbHandler.getAdm(employee);
		
		int counter = 0;
		
		try {
			while(resultSet.next()) {
				counter++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (counter >=1) {
			admin_statistic();
			//System.out.println("Succes!");
		}
		else {
			
		}
	 }
    
	  public void admin_statistic () throws Exception {
		  Parent root = FXMLLoader.load(getClass().getResource("Administrator_statistic.fxml"));
		  Stage window=(Stage) admin_stat.getScene().getWindow();
		  window.setScene(new Scene(root));
	  }
	  
	  public void menu () throws Exception {
	    	Parent root = FXMLLoader.load(getClass().getResource("First_in.fxml"));
	        Stage window=(Stage) main_menu.getScene().getWindow();
	        window.setScene(new Scene(root));
	    }
}
