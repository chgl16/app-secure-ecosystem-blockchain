package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AppFeedbackSceneController {
	@FXML
	private Text app;
	@FXML
	private Text Market;
	@FXML
	private Text Market_rep;
	@FXML
	private Text registTime;
	
	@FXML
	void initialize(){
		app.setText(Storage.t[0].name);
		Market.setText(Storage.m[4].name);
		Market_rep.setText(Storage.m[4].reputation+"");
		registTime.setText(Storage.m[4].registerTime);
	}
	
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void EnsureFeedback(MouseEvent event) throws IOException {
		new ChangeSceneFunction("FeedbackEnsureAndCancelScene.fxml");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnFeedbackMarketSelectScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("FeedbackMarketSelectScene.fxml");
	}
}
