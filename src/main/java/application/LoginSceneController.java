package application;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**   ��¼�����Ŀؼ�   **/
public class LoginSceneController {
	@FXML
	private ToggleGroup group = new ToggleGroup();
	@FXML
	private RadioButton market;
	@FXML
	private RadioButton developer;
	@FXML
	private RadioButton user;
	@FXML
	private TextField FilePath;
	@FXML
	private Pane sPane;
	@FXML
	private TextField Account;
	@FXML
	private PasswordField Password;
	@FXML
	private Text sregister;
	@FXML
	private Button mlogin;
	
	@FXML
	private TextField mSearchTextField;
	
	@FXML
	void initialize() throws IOException{
		market.setUserData("market");
		developer.setUserData("developer");
		user.setUserData("user");
	}
	// Event Listener on Text[#sregister].onMouseClicked
	@FXML
	public void Register(MouseEvent event) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("RegisterScene.fxml"));
		//BorderPane root = new BorderPane();
		Scene scene = new Scene(root,1080,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Main.myStage.setScene(scene);
		Main.myStage.show();
	}
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReadFile(MouseEvent event) {
		FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("(*.*)",  "*.*");  //�ڶ������������ļ�����
        fileChooser.getExtensionFilters().add(extFilter);
       
        Storage.file = fileChooser.showOpenDialog(Main.myStage);
        if(Storage.file != null) { 
        	Account.setText(Storage.file.getName());
        }
	}
	
	@FXML
	public void Login(InputEvent event) throws Exception {
		System.out.println("Account :" + Account.getText() + "  Password :" + Password.getText());
		/*
		 *  Ĭ�����õ����ֶ����˺����루�˺�����һ����    
		 *  �г� ��123       ������ ��456       �û��� 789
		 */
		Storage.m_num = 0;
		Storage.next_tras = 0;
		String type = group.getSelectedToggle().getUserData().toString();
		if(Account.getText().equals("123") && Password.getText().equals("123")) {
			// enter MarketScene
			new ChangeSceneFunction("MarketScene.fxml");
			 //mSearchTextField.setVisible(false);
		}else if(Account.getText().equals("456") && Password.getText().equals("456")) {
			// enter DeveloperScene
			new ChangeSceneFunction("DeveloperScene.fxml");
		}else if(Account.getText().equals("789") && Password.getText().equals("789")) {
			// enter UserScene
			new ChangeSceneFunction("UserScene.fxml");
		}
		else if(Account.getText().equals("owner") && Password.getText().equals("owner")){
			// enter Market1
			Storage.credentials = Resourse.owner;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.owner);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.owner);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.owner);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if(Account.getText().equals("1") && Password.getText().equals("1")){
			// enter Market1
			Storage.credentials = Resourse.market1;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.market1);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.market1);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.market1);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if(Account.getText().equals("2") && Password.getText().equals("2")){
			// enter Market1
			Storage.credentials = Resourse.market2;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.market2);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.market2);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.market2);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if(Account.getText().equals("3") && Password.getText().equals("3")){
			// enter Market1
			Storage.credentials = Resourse.market3;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.market3);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.market3);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.market3);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if(Account.getText().equals("4") && Password.getText().equals("4")){
			// enter Market1
			Storage.credentials = Resourse.market4;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.market4);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.market4);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.market4);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if(Account.getText().equals("5") && Password.getText().equals("5")){
			// enter Market1
			Storage.credentials = Resourse.market5;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.market5);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.market5);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.market5);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if(Account.getText().equals("6") && Password.getText().equals("6")){
			// enter Market1
			Storage.credentials = Resourse.market6;
			if(type.equals("market")){
				Storage.market = MarketModel.login(Resourse.market6);
				new ChangeSceneFunction("MarketScene.fxml");
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Resourse.market6);
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else{
				Storage.user = UserModel.login(Resourse.market6);
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
		else if (!Password.getText().equals("") && !Account.getText().equals("")) {
			if(type.equals("market")){
				Storage.market = MarketModel.login(Password.getText(),Storage.file.getParent()+"\\"+Account.getText());
				Storage.credentials = Storage.market.credentials;
				if (Account.getText() != null ) {
					new ChangeSceneFunction("MarketScene.fxml");
				}
			}
			else if(type.equals("developer")){
				Storage.user = UserModel.login(Password.getText(),Storage.file.getParent()+"\\"+Account.getText());
				Storage.credentials = Storage.user.credentials;
				new ChangeSceneFunction("DeveloperScene.fxml");
			}
			else if(type.equals("user")){
				Storage.user = UserModel.login(Password.getText(),Storage.file.getParent()+"\\"+Account.getText());
				Storage.credentials = Storage.user.credentials;
				new ChangeSceneFunction("UserScene.fxml");
			}
		}
	}

	@FXML
	public void Close(MouseEvent event) throws Exception {
		
		
		Main.myStage.close();
	}
}
