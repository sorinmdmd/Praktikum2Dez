package main;

import gui.Teppichen.TeppichControl;
import gui.Teppichen.TeppichenView;
import gui.guiBodenbelaege.BodenbelaegeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeppichControl(primaryStage);
		Stage belag = new Stage();
		new BodenbelaegeControl(belag);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
