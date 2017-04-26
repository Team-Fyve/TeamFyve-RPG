package dev.whiting.javatilegame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LauncherJavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Team-Fyve JavaFX Game Launcher");
		stage.setWidth(960);
		stage.setHeight(720);
		stage.setResizable(false);
		
		BorderPane root = new BorderPane();

		GridPane login = new GridPane();
		login.setAlignment(Pos.CENTER);
		login.setVgap(25);
		login.setHgap(25);
		
		TextField user = new TextField();
		TextField pass = new TextField();
		Label userlb = new Label("Enter Your Username: ");
		Label passlb = new Label("Enter Your Password: ");
		
		userlb.setStyle("-fx-font-size: 20px;");
		passlb.setStyle("-fx-font-size: 20px;");
		
		user.setPrefSize(200, 30);
		pass.setPrefSize(200, 30);
		
		login.add(userlb, 0, 0);
		login.add(user, 1, 0);
		login.add(passlb, 0, 1);
		login.add(pass, 1, 1);
		
		root.setCenter(login);
		
		HBox control = new HBox();
		control.setAlignment(Pos.CENTER);
		Button start = new Button("Start Game");
		start.setOnAction(e -> {
			//Add an if statement to check the user input and verify their status.
			Game game = new Game("TeamFyve JavaFX Game", 720, 600);
			game.start();
			stage.close();
		});
		control.setPadding(new Insets(10, 10, 10, 10));
		control.getChildren().add(start);
		root.setBottom(control);
		
		MenuBar options = new MenuBar();
		Menu file = new Menu("File");
		Menu games = new Menu("Games");
		Menu help = new Menu("Help");
		Menu about = new Menu("About");
		
		MenuItem load = new MenuItem("Load");
		MenuItem save = new MenuItem("Save");
		MenuItem newGame = new MenuItem("New");
		MenuItem list = new MenuItem("List All");
		
		file.getItems().addAll(load, save, newGame, list);
		
		MenuItem redForest = new MenuItem("Red Forest");
		MenuItem pong = new MenuItem("Pong");
		MenuItem tetris = new MenuItem("Tetris");
		MenuItem snake = new MenuItem("Snake");
		MenuItem atom = new MenuItem("Atom Smasher");
		MenuItem space = new MenuItem("Space Invaders");
		
		games.getItems().addAll(redForest, pong, tetris, snake, atom, space);
		
		MenuItem gameHelp = new MenuItem("Help: Game");
		MenuItem launcher = new MenuItem("Help: Launcher");
		MenuItem contact = new MenuItem("Contact Support");
		MenuItem report = new MenuItem("Report Issue");
		
		help.getItems().addAll(gameHelp, launcher, contact, report);
		
		options.setPadding(new Insets(10, 10, 10, 10));
		options.getMenus().addAll(file, games, help, about);
		
		root.setTop(options);
		
		root.getCenter().setStyle("-fx-background-color: #F69861;");
		root.getTop().setStyle("-fx-background-color: #F57F39;");
		root.getBottom().setStyle("-fx-background-color: #F57F39;");

		Scene scene = new Scene(root, 720, 600);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
