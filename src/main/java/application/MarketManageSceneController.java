package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class MarketManageSceneController {
	@FXML
	private Labeled name1;
	@FXML
	private Labeled date1;
	@FXML
	private Labeled developer1;
	@FXML
	private Labeled name2;
	@FXML
	private Labeled date2;
	@FXML
	private Labeled developer2;
	@FXML
	private Labeled name3;
	@FXML
	private Labeled date3;
	@FXML
	private Labeled developer3;
	@FXML
	private Labeled name4;
	@FXML
	private Labeled date4;
	@FXML
	private Labeled developer4;
	@FXML
	private Labeled name5;
	@FXML
	private Labeled date5;
	@FXML
	private Labeled developer5;
	
	private int next_tras;
	
	@FXML
	void initialize() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		Storage.next_tras = MarketModel.getAppPointer(Storage.market.addr);
		next_tras = Storage.next_tras;
		update();
	}
	
	void update() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		Storage.t[1] = TransactionModel.getNextUntreatedTras(next_tras);
		name1.setText(Storage.t[1].name);
		date1.setText(Storage.t[1].tratime+"");
		if(Storage.t[1].ID != 0)
			developer1.setText(UserModel.getUserByAddress(Storage.t[1].developer).name);
		else developer1.setText("");
		next_tras = Storage.t[1].appPointer;
		Storage.t[2] = TransactionModel.getNextUntreatedTras(next_tras);
		name2.setText(Storage.t[2].name);
		date2.setText(Storage.t[2].tratime+"");
		if(Storage.t[2].ID != 0)
			developer2.setText(UserModel.getUserByAddress(Storage.t[2].developer).name);
		else developer2.setText("");
		next_tras = Storage.t[2].appPointer;
		Storage.t[3] = TransactionModel.getNextUntreatedTras(next_tras);
		name3.setText(Storage.t[3].name);
		date3.setText(Storage.t[3].tratime+"");
		if(Storage.t[3].ID != 0)
			developer3.setText(UserModel.getUserByAddress(Storage.t[3].developer).name);
		else developer3.setText("");
		next_tras = Storage.t[3].appPointer;
		Storage.t[4] = TransactionModel.getNextUntreatedTras(next_tras);
		name4.setText(Storage.t[4].name);
		date4.setText(Storage.t[4].tratime+"");
		if(Storage.t[4].ID != 0)
			developer4.setText(UserModel.getUserByAddress(Storage.t[4].developer).name);
		else developer4.setText("");
		next_tras = Storage.t[4].appPointer;
		Storage.t[5] = TransactionModel.getNextUntreatedTras(next_tras);
		name5.setText(Storage.t[5].name);
		date5.setText(Storage.t[5].tratime+"");
		if(Storage.t[5].ID != 0)
			developer5.setText(UserModel.getUserByAddress(Storage.t[5].developer).name);
		else developer5.setText("");
		next_tras = Storage.t[5].appPointer;
	}
	
	@FXML
	public void next(MouseEvent event) throws Exception {
		if(next_tras != 0)
			update();
	}

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnMarketScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("MarketScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("MarketManageScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageOkScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("MarketManageOkScene.fxml");
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageApp1Scene(MouseEvent event) throws IOException {
		Storage.t[0] = Storage.t[1];
		new ChangeSceneFunction("MarketManageAppScene.fxml");
	}	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageApp2Scene(MouseEvent event) throws IOException {
		Storage.t[0] = Storage.t[2];
		new ChangeSceneFunction("MarketManageAppScene.fxml");
	}	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageApp3Scene(MouseEvent event) throws IOException {
		Storage.t[0] = Storage.t[3];
		new ChangeSceneFunction("MarketManageAppScene.fxml");
	}	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageApp4Scene(MouseEvent event) throws IOException {
		Storage.t[0] = Storage.t[4];
		new ChangeSceneFunction("MarketManageAppScene.fxml");
	}	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenMarketManageApp5Scene(MouseEvent event) throws IOException {
		Storage.t[0] = Storage.t[5];
		new ChangeSceneFunction("MarketManageAppScene.fxml");
	}
}
