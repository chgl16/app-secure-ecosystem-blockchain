package application;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

public class UploadNoteSceneController {

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnDeveloperMessageScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("DeveloperMessageScene.fxml");
	}
}
