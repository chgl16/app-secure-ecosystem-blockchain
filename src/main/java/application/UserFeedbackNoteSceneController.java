package application;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

public class UserFeedbackNoteSceneController {

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnUserMessageScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("UserMessageScene.fxml");
	}
}
