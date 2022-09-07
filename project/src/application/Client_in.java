package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import animations.Shake;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Client_in extends connect{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField middle_name;

    @FXML
    private TextField telephone;

    @FXML
    private TextField email;

    @FXML
    private Button client_cat;

    @FXML
    private TextField id;
    
    @FXML
    private Button client_accept;
    
    @FXML
    private Button back;

    @FXML
    void initialize() {
    	//������� �� ����� � ���������� �����
    	Pattern emailCheck = Pattern.compile("[A-Za-z]+@{1}[A-Za-z]+.{1}[A-Za-z]+");
    	Pattern telCheck = Pattern.compile("[0-9]{11}$");
    	Pattern idCheck = Pattern.compile("c{1}l{1}[0-9]+");
    	Pattern firCheck = Pattern.compile("[A-Za-z]+");
    	Pattern midCheck = Pattern.compile("[A-Za-z]+");
    	Pattern lstCheck = Pattern.compile("[A-Za-z]+");
    	client_cat.setDisable(true);
        DataBaseHandler dbHandler = new DataBaseHandler();
        Shake clientId = new Shake(id);
		Shake tel = new Shake(telephone);
		Shake firName = new Shake(first_name);
		Shake midName = new Shake(middle_name);
		Shake lstName = new Shake(last_name);
		Shake mail = new Shake(email);
        	client_accept.setOnAction(event ->{
        		String idText = id.getText().trim();
        		String telText = telephone.getText().trim();
        		String firstName = first_name.getText().trim();
        		String middleName = middle_name.getText().trim();
        		String lastName = last_name.getText().trim();
        		String emailText = email.getText().trim();
        		Matcher telMatcher = telCheck.matcher(telText);
        		Matcher emailMatcher = emailCheck.matcher(emailText);
        		Matcher idMatcher = idCheck.matcher(idText);
        		Matcher firMatcher = firCheck.matcher(firstName);
        		Matcher midMatcher = midCheck.matcher(middleName);
        		Matcher lstMatcher = lstCheck.matcher(lastName);
        		if (!(idText.length()==0) && !(telText.length()==0) && !(firstName.length()==0)
        				&& !(middleName.length()==0) &&!(lastName.length()==0) && !(emailText.length()==0) && telMatcher.matches()
        				&& emailMatcher.matches() && idMatcher.matches() && firMatcher.matches() && midMatcher.matches() 
        				&& lstMatcher.matches()) {
        			dbHandler.signUpClient(idText, telText, firstName, middleName, lastName, emailText);
        			client_id = idText;
        			client_cat.setDisable(false);
    			}else {
					clientId.playAnim();
					tel.playAnim();
					firName.playAnim();
					midName.playAnim();
					lstName.playAnim();
					mail.playAnim();
    			}	
        	});
        client_cat.setOnAction(event ->{
        	try {
				client_category();
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        back.setOnAction(event ->{
    		try {
				back();
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
    }
    
    public void client_category () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Client_category.fxml"));
    	Stage window=(Stage) client_cat.getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    public void back () throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("First_in.fxml"));
        Stage window=(Stage) back.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
