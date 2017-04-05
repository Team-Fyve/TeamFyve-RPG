package dev.whiting.javatilegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LauncherJavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Team-Fyve JavaFX Game Launcher");
		stage.setWidth(800);
		stage.setHeight(600);
		stage.setResizable(true);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 10, 10, 10));

		GridPane login = new GridPane();
		login.setAlignment(Pos.CENTER);
		login.setVgap(25);
		login.setHgap(25);
		
		TextField user = new TextField();
		TextField pass = new TextField();
		Label userlb = new Label("Please Enter Your Username: ");
		Label passlb = new Label("Please Enter Your Password: ");
		
		login.add(userlb, 0, 0);
		login.add(user, 1, 0);
		login.add(passlb, 0, 1);
		login.add(pass, 1, 1);
		
		root.setCenter(login);
		
		HBox options = new HBox();
		options.setAlignment(Pos.CENTER);
		Button start = new Button("Start Game");
		start.setOnAction(e -> {
			//Add an if statement to check the user input and verify their status.
			Game game = new Game("TeamFyve JavaFX Game", 800, 600);
			game.start();
			stage.close();
		});
		options.getChildren().add(start);
		root.setBottom(options);

		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
