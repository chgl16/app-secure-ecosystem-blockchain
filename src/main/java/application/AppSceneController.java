package application;


import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;

/**  APP �����ؼ�  **/
public class AppSceneController {
	@FXML
	private Labeled name;
	@FXML
	private Text market;
	@FXML
	private Text market_rep;
	@FXML
	private Text developer;
	@FXML
	private Text developer_rep;
	@FXML
	private Text date;
	
	@FXML
	void initialize() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		name.setText(Storage.t[0].name);
		date.setText(Storage.t[0].tratime+"");
		market.setText(Storage.m[3].name);
		market_rep.setText(Storage.m[3].reputation+"");
		UserModel u = UserModel.getUserByAddress(Storage.t[0].developer);
		developer.setText(u.name);
		developer_rep.setText(u.reputation+"");
		
	}
	
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnWhichOpenAppScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction(Main.WhichUseAppScene);
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenFeedbackMarketSelectScene(MouseEvent event) throws IOException {
		Storage.m_num = 0;
		new ChangeSceneFunction("FeedbackMarketSelectScene.fxml");
	}
	
}
