package application;

import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

/**  ���ó����ؼ�   **/
public class SettingSceneController {

	// Event Listener on Button.onMouseClicked
	@FXML   //  �˳�
	public void Exit(MouseEvent event) {
		Event.fireEvent(Main.myStage, new WindowEvent(Main.myStage, WindowEvent.WINDOW_CLOSE_REQUEST ));
	}
	// Event Listener on Button.onMouseClicked
	@FXML   // ����ǰһҳ
	public void ReturnWhichUseSettingScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction(Main.WhichUseSettingScene);
	}
	// Event Listener on Label.onMouseClicked
	@FXML   // ע��
	public void LogOff(MouseEvent event) throws Exception {
		new ChangeSceneFunction("LoginScene.fxml");
	}
	@FXML 
	public void OpenVersionUpdateScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("VersionUpdateScene.fxml");
	}
}
