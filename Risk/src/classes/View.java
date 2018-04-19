package classes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/****************************************************************************
 * Class to create the view.
 ***************************************************************************/
public class View extends Application {

	/****************************************************************************
	 * Launches the view.
	 * @param args : the args
	 ***************************************************************************/
	public static void main(final String[] args) {
		launch(args);
	}
	
	/** the stage.*/
	private Stage window;
	
	@Override
	/****************************************************************************
	 * Creates the view.
	 * @param primaryStage : the stage
	 ***************************************************************************/
	public void start(final Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("coolthings");
		
		GridPane grid = new GridPane();
		int value = 10;
		grid.setPadding(new Insets(value, value, value, value));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//Name label
		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		//Name Input
		TextField nameInput = new TextField("Username");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//Pass label
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel, 0, 1);
		
		//Pass Input
		TextField passInput = new TextField("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Scene scene = new Scene(grid, 250, 250);
		window.setScene(scene);
		window.show();
	}
	
	
	
	
	
	
	
	
	/*
	//embedding layouts:
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("coolthings");
		
		HBox topMenu = new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
		
		VBox leftMenu = new VBox();
		Button buttonD = new Button("D");
		Button buttonE = new Button("E");
		Button buttonF = new Button("F");
		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		
		Scene scene = new Scene(borderPane, 300, 250);
		window.setScene(scene);
		window.show();
	}
	*/
	
	
	
	/*
	//Scene gameSetup, playing;
	//kind of the Constructor for JavaFX
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		//test buttons and labels
		Label label1 = new Label("Welcome to scene 1");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> window.setScene(playing));
//		Button button2 = new Button("Leave");
//		button2.setOnAction(e -> window.setScene(gameSetup));
		Button button3 = new Button("show box");
		button3.setOnAction(e -> {
			closeProgram();
		});
		
		//test layouts
		//layout 1 - children are laid out in vertical column
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		gameSetup = new Scene(layout1, 200, 200);
		
		//layout 2
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(button3); //, button2
		playing = new Scene(layout2, 200, 200);
		
		window.setScene(gameSetup);
		window.setTitle("something creative");
		window.show();
	}
	
	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Title", "Do you really want to exit?");
		if (answer)
			window.close();
	}
	*/
}