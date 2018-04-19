package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/****************************************************************************
 * This class launches the app.
 ***************************************************************************/
public class Run extends Application {

	@Override
	/****************************************************************************
	 * Loads the stage.
	 ***************************************************************************/
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		primaryStage.setTitle("Risk!");
		primaryStage.setScene(new Scene(root, 1466, 650));
		primaryStage.show();
	}
	
	/****************************************************************************
	 * Launches the program.
	 ***************************************************************************/
	public static void main(String[] args) {
		launch(args);
	}
}
