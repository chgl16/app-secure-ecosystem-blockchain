package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class UserMessageSceneController {
	@FXML
	private Text name;
	@FXML
	private Text addr;
	@FXML
	private Text date;
	@FXML
	private Text desc;
	
	@FXML
	void initialize(){
		name.setText(Storage.user.name);
		desc.setText(Storage.user.desc);
		date.setText(Storage.user.registerTime+"");
		addr.setText(Storage.user.addr);
	}
	

	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenUserMessageScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("UserMessageScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnUserScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("UserScene.fxml");
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void OpenUserFeedbackNoteScene(MouseEvent event) throws Exception {
		new ChangeSceneFunction("UserFeedbackNoteScene.fxml");
	}
    
}
