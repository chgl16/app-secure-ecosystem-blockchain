package application;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class UploadReadFileSceneController {
	@FXML
	private TextField FilePath;
	@FXML
	private Text market;
	@FXML
	private Text market_rep;
	@FXML
	private Text date;
	
	@FXML
	void initialize() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException{
		date.setText(Storage.m[4].registerTime+"");
		market.setText(Storage.m[4].name);
		market_rep.setText(Storage.m[4].reputation+"");
	}

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReadFile(MouseEvent event) {
		FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("(*.*)",  "*.*");  //�ڶ������������ļ�����
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(Main.myStage);
        FilePath.setText(file.toString());
        Storage.file = file;
        //System.out.println(file);
          
        
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void EnsureUpload(MouseEvent event) throws IOException {
		new ChangeSceneFunction("UploadEnsureAndCancelScene.fxml");
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnUploadMarketSelectScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("UploadMarketSelectScene.fxml");
	}
	
}
