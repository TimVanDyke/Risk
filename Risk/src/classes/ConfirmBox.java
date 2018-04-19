package classes;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/****************************************************************************
 * A class for the confirm box.
 ***************************************************************************/
public class ConfirmBox {
	
	/** answer. */
	static boolean answer;
	
	/****************************************************************************
	 * Displays the confirm box
	 ***************************************************************************/
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);
		
		//setting the label for the confirmation
		Label label = new Label();
		label.setText(message);
		
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}