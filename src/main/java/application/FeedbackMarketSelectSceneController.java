package application;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FeedbackMarketSelectSceneController {
	@FXML
	private Labeled Market1;
	@FXML
	private Labeled Market2;
	@FXML
	private Labeled Market3;
	@FXML
	private Labeled Market4;
	@FXML
	private Labeled Market5;
	@FXML
	private Labeled Market6;
	@FXML
	private Labeled Market7;
	@FXML
	private Labeled Market8;
	@FXML
	private Labeled Market9;
	@FXML
	private Labeled Market10;
	@FXML
	private Labeled Market11;
	@FXML
	private Labeled Market12;
	@FXML
	private Labeled ID1;
	@FXML
	private Labeled ID2;
	@FXML
	private Labeled ID3;
	@FXML
	private Labeled ID4;
	@FXML
	private Labeled ID5;
	@FXML
	private Labeled ID6;
	@FXML
	private Labeled ID7;
	@FXML
	private Labeled ID8;
	@FXML
	private Labeled ID9;
	@FXML
	private Labeled ID10;
	@FXML
	private Labeled ID11;
	@FXML
	private Labeled ID12;
	
	@FXML
	private TextField mSearchTextField;
	
	private MarketModel[] m;

	@FXML
	void initialize() throws InterruptedException, ExecutionException{
		m = new MarketModel[13];
		update();
	}
	
	void update() throws InterruptedException, ExecutionException{
		for(int j=1;j<13;j++){
			try {
				m[j] = MarketModel.getMarket(Storage.m_num+j);
			} catch (ModelException e) {
				// TODO Auto-generated catch block
				m[j] = new MarketModel();
			}
		}
		Market1.setText(m[1].name);
		Market2.setText(m[2].name);
		Market3.setText(m[3].name);
		Market4.setText(m[4].name);
		Market5.setText(m[5].name);
		Market6.setText(m[6].name);
		Market7.setText(m[7].name);
		Market8.setText(m[8].name);
		Market9.setText(m[9].name);
		Market10.setText(m[10].name);
		Market11.setText(m[11].name);
		Market12.setText(m[12].name);
		ID1.setText(Storage.m_num+1+"");
		ID2.setText(Storage.m_num+2+"");
		ID3.setText(Storage.m_num+3+"");
		ID4.setText(Storage.m_num+4+"");
		ID5.setText(Storage.m_num+5+"");
		ID6.setText(Storage.m_num+6+"");
		ID7.setText(Storage.m_num+7+"");
		ID8.setText(Storage.m_num+8+"");
		ID9.setText(Storage.m_num+9+"");
		ID10.setText(Storage.m_num+10+"");
		ID11.setText(Storage.m_num+11+"");
		ID12.setText(Storage.m_num+12+"");
	}
	
	@FXML
	public void previous(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
		if(Storage.m_num-12>=0){
			Storage.m_num -= 12;
			update();
		}
	}
	
	@FXML
	public void next(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
		if(Storage.m_num+12<MarketModel.numMarkets()){
			Storage.m_num += 12;
			update();
		}
	}
	
	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene1(MouseEvent event) throws IOException {
		Storage.m[4] = m[1];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene2(MouseEvent event) throws IOException {
		Storage.m[4] = m[2];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene3(MouseEvent event) throws IOException {
		Storage.m[4] = m[3];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene4(MouseEvent event) throws IOException {
		Storage.m[4] = m[4];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene5(MouseEvent event) throws IOException {
		Storage.m[4] = m[5];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene6(MouseEvent event) throws IOException {
		Storage.m[4] = m[6];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene7(MouseEvent event) throws IOException {
		Storage.m[4] = m[7];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene8(MouseEvent event) throws IOException {
		Storage.m[4] = m[8];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene9(MouseEvent event) throws IOException {
		Storage.m[4] = m[9];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene10(MouseEvent event) throws IOException {
		Storage.m[4] = m[10];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene11(MouseEvent event) throws IOException {
		Storage.m[4] = m[11];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Label.onMouseClicked
	@FXML
	public void OpenAppFeedbackScene12(MouseEvent event) throws IOException {
		Storage.m[4] = m[12];
		new ChangeSceneFunction("AppFeedbackScene.fxml");
	}

	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReturnAppScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("AppScene.fxml");
	}
}
