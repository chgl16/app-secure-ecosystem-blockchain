package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class FeedbackEnsureAndCancelSceneController {

	// Event Listener on Button.onMouseClicked
	@FXML
	public void EnsureFeedback(MouseEvent event) throws IOException, InterruptedException, ExecutionException, ModelException {
		TransactionModel.feedback(Storage.t[0].ID,Storage.m[4].addr,Storage.credentials);
		new ChangeSceneFunction("FeedbackSuccessfullyScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void CancelFeedback(MouseEvent event) throws IOException {
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}
}
