package com.bytingbuilldogs.motiondeploy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application
{
	public static List<File> files; 
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception
	{
		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Deploy.fxml"));
		Scene primary = new Scene(loader1.load());
		primary.getStylesheets().add("Test.css");
		arg0.setScene(primary);

		FileChooser fileChooser = new FileChooser();
		files = fileChooser.showOpenMultipleDialog(arg0);

		arg0.getIcons().add(new Image(getClass().getResourceAsStream("download.png")));
		

		arg0.show();

	}

}
