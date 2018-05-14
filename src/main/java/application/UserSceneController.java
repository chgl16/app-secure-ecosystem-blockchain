package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class UserSceneController {
	@FXML
	private Text Market1;
	@FXML
	private Text Market2;
	@FXML
	private Text Market3;
	@FXML
	private Text App1;
	@FXML
	private Text App2;
	@FXML
	private Text App3;
	@FXML
	private Text App4;
	@FXML
	private Text App5;
	@FXML
	private Text App6;
	@FXML
	private Text App7;
	@FXML
	private Text App8;
	@FXML
	private Text App9;
	@FXML
	private Text App10;
	@FXML
	private Text App11;
	@FXML
	private Text App12;
	
	@FXML
	private TextField mSearchTextField;

	@FXML
	void initialize() throws InterruptedException, ExecutionException{
		Storage.m = new MarketModel[5];
		Storage.t = new TransactionModel[13];
		update();
	}

	void update() throws InterruptedException, ExecutionException{
		for(int i=0;i<3;i++){
			try {
				Storage.m[i] = MarketModel.getMarket(Storage.m_num+i+1);
			} catch (ModelException e) {
				Storage.m[i] = new MarketModel();
			}
			Storage.next_tras = MarketModel.getAppPointer(Storage.m[i].addr);
			
			for(int j=1;j<5;j++){
				try {
					Storage.t[i*4+j] = TransactionModel.getNextApp(Storage.next_tras);
				} catch (ModelException e) {
					// TODO Auto-generated catch block
					Storage.t[i*4+j] = new TransactionModel();
				}
				Storage.next_tras = Storage.t[i*4+j].appPointer;
			}
		}
		Market1.setText(Storage.m[0].name);
		Market2.setText(Storage.m[1].name);
		Market3.setText(Storage.m[2].name);
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
		
	@FXML
	public void previous(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
		if(Storage.m_num>2){
			Storage.m_num -= 3;
			update();
		}
	}
	
	@FXML
	public void next(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
		if(Storage.m_num+3<MarketModel.numMarkets()){
			Storage.m_num += 3;
			update();
		}
	}

	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenUserMessageScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("UserMessageScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenSettingScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("SettingScene.fxml");
		Main.WhichUseSettingScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked // ��app�г�
	@FXML
	public void OpenAppMarket1Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[0];
		new ChangeSceneFunction("AppMarketScene.fxml");
		Main.WhichUseAppMarketScene = "UserScene.fxml";
		
	}
	
	// Event Listener on Button.onMouseClicked // ��app�г�
	@FXML
	public void OpenAppMarket2Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[1];
		new ChangeSceneFunction("AppMarketScene.fxml");
		Main.WhichUseAppMarketScene = "UserScene.fxml";
		
	}
	
	// Event Listener on Button.onMouseClicked // ��app�г�
	@FXML
	public void OpenAppMarket3Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[2];
		new ChangeSceneFunction("AppMarketScene.fxml");
		Main.WhichUseAppMarketScene = "UserScene.fxml";
		
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp1Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[0];
		Storage.t[0] = Storage.t[1];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp2Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[0];
		Storage.t[0] = Storage.t[2];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp3Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[0];
		Storage.t[0] = Storage.t[3];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp4Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[0];
		Storage.t[0] = Storage.t[4];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp5Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[1];
		Storage.t[0] = Storage.t[5];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp6Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[1];
		Storage.t[0] = Storage.t[6];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp7Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[1];
		Storage.t[0] = Storage.t[7];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp8Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[1];
		Storage.t[0] = Storage.t[8];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp9Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[2];
		Storage.t[0] = Storage.t[9];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp10Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[2];
		Storage.t[0] = Storage.t[10];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp11Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[2];
		Storage.t[0] = Storage.t[11];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
	
	// Event Listener on Button.onMouseClicked   // ���ش�app�ĳ���
	@FXML
	public void OpenApp12Scene(MouseEvent event) throws IOException {
		Storage.m[3] = Storage.m[2];
		Storage.t[0] = Storage.t[12];
		new ChangeSceneFunction("AppScene.fxml");
		Main.WhichUseAppScene = "UserScene.fxml";
	}
}
