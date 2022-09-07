module project {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires java.xml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
