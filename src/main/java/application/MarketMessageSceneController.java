package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/***  �г�������Ϣ����Ŀؼ�  ***/
public class MarketMessageSceneController {
	@FXML
	private Text name;
	@FXML
	private Text reputation;
	@FXML
	private Text registerTime;
	@FXML
	private Text desc;
	
	@FXML
	void initialize() throws InterruptedException, ExecutionException{
		System.out.println(Storage.market.name);
		name.setText(Storage.market.name);
		reputation.setText(Storage.market.reputation+"");
		registerTime.setText(Storage.market.registerTime+"");
		desc.setText(Storage.market.desc);
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML   /*  ���ڼ���������ʾ������Ϣ��   */
	public void OpenMarketMessageScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("MarketMessageScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnMarketScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("MarketScene.fxml");
	}
	
	
}
