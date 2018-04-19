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
	 * @param : primary stage
	 ***************************************************************************/
	public void start(final Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		primaryStage.setTitle("Risk!");
		primaryStage.setScene(new Scene(root, 1466, 650));
		primaryStage.show();
	}
	
	/****************************************************************************
	 * Launches the program.
	 * @param args 
	 ***************************************************************************/
	public static void main(final String[] args) {
		launch(args);
	}
}
