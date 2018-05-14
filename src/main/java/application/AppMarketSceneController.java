package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/** app�г������ؼ�  **/
public class AppMarketSceneController {
	@FXML
	private Labeled Market1;
	@FXML
	private Labeled App1;
	@FXML
	private Labeled App2;
	@FXML
	private Labeled App3;
	@FXML
	private Labeled App4;
	@FXML
	private Labeled App5;
	@FXML
	private Labeled App6;
	@FXML
	private Labeled App7;
	@FXML
	private Labeled App8;
	@FXML
	private Labeled App9;
	@FXML
	private Labeled App10;
	@FXML
	private Labeled App11;
	@FXML
	private Labeled App12;
	
	@FXML
	private TextField mSearchTextField;

	@FXML
	void initialize() throws InterruptedException, ExecutionException{
		Storage.next_tras = MarketModel.getAppPointer(Storage.m[3].addr);
		update();
	}

	void update() throws InterruptedException, ExecutionException{
		for(int j=1;j<13;j++){
			try {
				Storage.t[j] = TransactionModel.getNextApp(Storage.next_tras);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				Storage.t[j] = new TransactionModel();
			}
			Storage.next_tras = Storage.t[j].appPointer;
		}
		
		Market1.setText(Storage.m[3].name);
		App1.setText(Storage.t[1].name);
		App2.setText(Storage.t[2].name);
		App3.setText(Storage.t[3].name);
		App4.setText(Storage.t[4].name);
		App5.setText(Storage.t[5].name);
		App6.setText(Storage.t[6].name);
		App7.setText(Storage.t[7].name);
		App8.setText(Storage.t[8].name);
		App9.setText(Storage.t[9].name);
		App10.setText(Storage.t[10].name);
		App11.setText(Storage.t[11].name);
		App12.setText(Storage.t[12].name);
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app-�г��ĳ���
	@FXML
	public void next(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
		if(Storage.next_tras != 0)
			update();
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app-�г��ĳ���
	@FXML
	public void ReturnWhichUseAppMarketScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction(Main.WhichUseAppMarketScene);
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp1Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[1];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp2Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[2];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp3Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[3];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp4Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[4];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp5Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[5];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp6Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[6];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp7Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[7];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp8Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[8];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp9Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[9];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp10Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[10];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp11Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[11];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp12Scene(MouseEvent event) throws IOException {
		Storage.t[0] =Storage.t[12];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "AppMarketScene.fxml";
	}
}
