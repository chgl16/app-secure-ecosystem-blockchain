package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;

public class MarketManageOkSceneController {
	@FXML
	private Labeled name1;
	@FXML
	private Labeled date1;
	@FXML
	private Labeled developer1;
	@FXML
	private Labeled deal1;
	
	@FXML
	private Labeled name2;
	@FXML
	private Labeled date2;
	@FXML
	private Labeled developer2;
	@FXML
	private Labeled deal2;
	
	@FXML
	private Labeled name3;
	@FXML
	private Labeled date3;
	@FXML
	private Labeled developer3;
	@FXML
	private Labeled deal3;
	
	@FXML
	private Labeled name4;
	@FXML
	private Labeled date4;
	@FXML
	private Labeled developer4;
	@FXML
	private Labeled deal4;
	
	@FXML
	private Labeled name5;
	@FXML
	private Labeled date5;
	@FXML
	private Labeled developer5;
	@FXML
	private Labeled deal5;
	
	@FXML
	void initialize() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		Storage.next_tras = MarketModel.getAppPointer(Storage.market.addr);
		update();
	}
	
	void update() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		Storage.t[1] = TransactionModel.getNextIsdealTras(Storage.next_tras);
		name1.setText(Storage.t[1].name);
		date1.setText(Storage.t[1].tratime+"");
		if(Storage.t[1].ID != 0)
			developer1.setText(UserModel.getUserByAddress(Storage.t[1].developer).name);
		else developer1.setText("");
		deal1.setText(Storage.t[1].accept+"");
		Storage.next_tras = Storage.t[1].appPointer;
		Storage.t[2] = TransactionModel.getNextIsdealTras(Storage.next_tras);
		name2.setText(Storage.t[2].name);
		date2.setText(Storage.t[2].tratime+"");
		if(Storage.t[2].ID != 0)
			developer2.setText(UserModel.getUserByAddress(Storage.t[2].developer).name);
		else developer2.setText("");
		deal2.setText(Storage.t[2].accept+"");
		Storage.next_tras = Storage.t[2].appPointer;
		Storage.t[3] = TransactionModel.getNextIsdealTras(Storage.next_tras);
		name3.setText(Storage.t[3].name);
		date3.setText(Storage.t[3].tratime+"");
		if(Storage.t[3].ID != 0)
			developer3.setText(UserModel.getUserByAddress(Storage.t[3].developer).name);
		else developer3.setText("");
		deal3.setText(Storage.t[3].accept+"");
		Storage.next_tras = Storage.t[3].appPointer;
		Storage.t[4] = TransactionModel.getNextIsdealTras(Storage.next_tras);
		name4.setText(Storage.t[4].name);
		date4.setText(Storage.t[4].tratime+"");
		if(Storage.t[4].ID != 0)
			developer4.setText(UserModel.getUserByAddress(Storage.t[4].developer).name);
		else developer4.setText("");
		deal4.setText(Storage.t[4].accept+"");
		Storage.next_tras = Storage.t[4].appPointer;
		Storage.t[5] = TransactionModel.getNextIsdealTras(Storage.next_tras);
		name5.setText(Storage.t[5].name);
		date5.setText(Storage.t[5].tratime+"");
		if(Storage.t[5].ID != 0)
			developer5.setText(UserModel.getUserByAddress(Storage.t[5].developer).name);
		else developer5.setText("");
		deal5.setText(Storage.t[5].accept+"");
		Storage.next_tras = Storage.t[5].appPointer;
	}
	
	@FXML
	public void next(MouseEvent event) throws Exception {
		if(Storage.next_tras != 0)
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
}
