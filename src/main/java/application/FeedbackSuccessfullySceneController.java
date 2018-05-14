package application;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

public class FeedbackSuccessfullySceneController {

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnAppFeedbackScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}
}
