package Martyrs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class MainWindow extends Pane{
	
	Pane basePane = new Pane();
	Button btnView ;
	Button btnSammary;
	Label lblWelcom;
	GUI g;
	Font font = Font.font("Bernard MT Condensed", FontPosture.REGULAR, 45);

	
	public MainWindow() {
		
		lblWelcom = new Label("Welcome to Martyrs Info App");
		lblWelcom.setStyle("-fx-text-fill:white");
		lblWelcom.setFont(font);
		lblWelcom.setLayoutX(120);
		lblWelcom.setLayoutY(28);
		
		basePane.setLayoutX(-2);
		basePane.setLayoutY(-1);
		basePane.setPrefHeight(550);
		basePane.setPrefWidth(750);
		basePane.setStyle("-fx-background-color:black");
		
		btnView = new Button("View");
		btnView.setStyle(
				"-fx-background-color:black;-fx-border-color:white;-fx-text-fill:f2bd12;-fx-border-radius:15;-fx-background-radius:15");
		btnView.setPrefHeight(50);
		btnView.setPrefWidth(110);
		btnView.setLayoutX(300);
		btnView.setLayoutY(200);
		
		btnSammary = new Button("Sammary");
		btnSammary.setStyle(
				"-fx-background-color:black;-fx-border-color:white;-fx-text-fill:f2bd12;-fx-border-radius:15;-fx-background-radius:15");
		btnSammary.setPrefHeight(50);
		btnSammary.setPrefWidth(110);
		btnSammary.setLayoutX(300);
		btnSammary.setLayoutY(300);
		
		
		
		btnView.setOnAction(e->{
			Scene newScene = new Scene(new MainVeiw(), 750, 500);//return fist window 
			Stage newStage = new Stage();
			newStage.setScene(newScene);
			newStage.setTitle("Martyrs Info");
			newStage.getIcons().add(new Image("map.png"));
			newStage.setResizable(false);
			newStage.show();
		});
		
		
		btnSammary.setOnAction(e->{
			new SammaryView(); // return scene summary
		});
		
		
		basePane.getChildren().addAll(lblWelcom,btnView,btnSammary);
		this.getChildren().addAll(basePane);

	}
}
