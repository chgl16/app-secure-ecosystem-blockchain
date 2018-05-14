package application;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

public class VersionUpdateSceneController {

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnPreviousScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("SettingScene.fxml");
	}
}
