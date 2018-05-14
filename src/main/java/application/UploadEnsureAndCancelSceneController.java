package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class UploadEnsureAndCancelSceneController {

	// Event Listener on Button.onMouseClicked
	@FXML
	public void Cancel(MouseEvent event) throws IOException{
		new ChangeSceneFunction("UploadReadFileScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void Ensure(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
		TransactionModel.Upload(Storage.file.getName(),Storage.file.getName().replaceAll("[.][^.]+$", ""),
			Storage.m[4].addr,Storage.credentials);
		new ChangeSceneFunction("UploadSuccessfullyScene.fxml");
	}
}
