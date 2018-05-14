package application;
	
import java.awt.Desktop;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/** �׽���--> ���� ��¼���� **/
public class Main extends Application {
	
	public static String WhichUseSettingScene; //  ��¼���ĸ����������ó��������ڷ���
	public static String WhichUseAppMarketScene; //  ��¼���ĸ�������app�г����������ڷ���
	public static String WhichUseAppScene; //  ��¼���ĸ�������app�г����������ڷ���
	public static Stage myStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1080,720,Color.BEIGE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			myStage = primaryStage;
			myStage.setScene(scene);
			myStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
