

package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainClass extends Application {
	
	private Stage primaryStage;
	
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage; 


		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setHgap(20);
		gridpane.setVgap(10);
		gridpane.setPadding(new Insets(30, 30, 30, 30));

		TextField usernameInput = new TextField();
		usernameInput.setPromptText("Please enter username");
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("Please enter password");

		Label username = new Label("Email/account: ");
		Label password = new Label("Password: ");
		Label title = new Label("Administrator Login: ");
		Label reminderLabel = new Label();
		Button loginButton = new Button("Login");
		
	
		/*
		 * set positions
		 */
		GridPane.setColumnSpan(title, 2);
		gridpane.add(title, 0, 0, 2, 1); // (column 0, row 0, colspan 2, rowspan 1)
		gridpane.add(username, 0, 2); // (column 0, row 1)
		gridpane.add(usernameInput, 1, 2); // (column 1, row 1)
		gridpane.add(password, 0, 3); // (column 0, row 2)
		gridpane.add(passwordInput, 1, 3); // (column 1, row 2)
		gridpane.add(loginButton, 1, 7, 2, 1); // (column 0, row 6, colspan 2, rowspan 1)
		gridpane.add(reminderLabel, 1, 8,2,1);
		
		
		/*
		 * methods
		 */
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				String username = usernameInput.getText();
				String password = passwordInput.getText();
				String validUsername = "111";
				String validPassword = "111";
				
				if (username.equals(validUsername) && password.equals(validPassword)) {
					reminderLabel.setText("Successfully log in!");
					administratorProfileScene();
					
				} else {
					reminderLabel.setText("Error! Please try again!");
				}
			}
		});
		
		
		gridpane.setStyle("-fx-background-image: url('dog.jpg');" +
                "-fx-background-size: cover;" +
                "-fx-background-repeat: no-repeat;");
		Scene scene = new Scene(gridpane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Animal Adoption System");
		primaryStage.show();

	}
	
	
	private void administratorProfileScene() {
        // create a new scene
        BorderPane borderPane = new BorderPane();
        Label profile = new Label("Welcome to administrator profile!");
        
        VBox settingButton = new VBox();
        Button addAnimalButton = new Button("Add - Animal    ");
        Button displayAnimalButton = new Button("Display - Animal");  
        
        Label imageLabel = new Label();
        Image imageweb = new Image(getClass().getResourceAsStream("logo.PNG"));
		ImageView imageView = new ImageView(imageweb);
		imageLabel.setGraphic(imageView);
		
		imageView.setFitWidth(140);
		imageView.setFitHeight(100);
		
		
		settingButton.setMinWidth(150);
		
        
        settingButton.getChildren().addAll(addAnimalButton,displayAnimalButton);
        imageLabel.setTranslateX(7);
        imageLabel.setTranslateY(10);
        addAnimalButton.setTranslateX(20);
		addAnimalButton.setTranslateY(130);
		displayAnimalButton.setTranslateX(20);
		displayAnimalButton.setTranslateY(210);
        
        
		borderPane.setLeft(settingButton);
        borderPane.getChildren().add(imageLabel);
      
        
        Scene newScene = new Scene(borderPane,600, 400);
        primaryStage.setScene(newScene);
        
        BackgroundFill backgroundFill2 = new BackgroundFill(Color.valueOf("#E6E6FA"), new CornerRadii(10),
				new Insets(10));
		Background background2 = new Background(backgroundFill2);
		settingButton.setBackground(background2);
    }

	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
