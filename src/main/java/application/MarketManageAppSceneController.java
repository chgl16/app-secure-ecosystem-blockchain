package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class MarketManageAppSceneController {
	@FXML
	private Labeled name;
	@FXML
	private Text date;
	@FXML
	private Text developer;
	@FXML
	private Text reputation;
	
	@FXML
	void initialize() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		name.setText(Storage.t[0].name);
		date.setText(Storage.t[0].tratime+"");
		UserModel u = UserModel.getUserByAddress(Storage.t[0].developer);
		developer.setText(u.name);
		reputation.setText(u.reputation+"");
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnMarketManageScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("MarketManageScene.fxml");
	}
	
	@FXML
	public void Pass(MouseEvent event) throws IOException, InterruptedException, ExecutionException, ModelException {
		TransactionModel.deal(Storage.t[0].ID,Storage.market.credentials,true);
	}
	
	@FXML
	public void Refuse(MouseEvent event) throws IOException, InterruptedException, ExecutionException, ModelException {
		TransactionModel.deal(Storage.t[0].ID,Storage.market.credentials,false);
	}
}
