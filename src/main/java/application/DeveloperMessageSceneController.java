package application;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DeveloperMessageSceneController {
	@FXML
	private Text name;
	@FXML
	private Text rep;
	@FXML
	private Text addr;
	@FXML
	private Text date;
	
	@FXML
	void initialize(){
		name.setText(Storage.user.name);
		rep.setText(Storage.user.reputation+"");
		date.setText(Storage.user.registerTime+"");
		addr.setText(Storage.user.addr);
	}
	
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenDeveloperMessageScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("DeveloperMessageScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnDeveloperScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("DeveloperScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenUploadNoteScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("UploadNoteScene.fxml");
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenDeveloperFeedbackNoteScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("DeveloperFeedbackNoteScene.fxml");
	}
	
}
