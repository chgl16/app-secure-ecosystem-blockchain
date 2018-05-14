package application;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import javax.swing.JFileChooser;

import org.web3j.crypto.CipherException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.FileChooser;

public class RegisterSceneController {
	@FXML
	private Button RSregister;
	@FXML
	private Button RSreturn;
	@FXML
	private RadioButton market;
	@FXML
	private RadioButton developer;
	@FXML
	private RadioButton user;
	@FXML
	private ToggleGroup group = new ToggleGroup();
	@FXML
	private TextField path;
	@FXML
	private TextField name;
	@FXML
	private TextField password;
	@FXML
	private TextField desc;

	@FXML
	void initialize(){
		developer.setUserData("developer");
		market.setUserData("market");
		
		user.setUserData("user");
	}
	// Event Listener on Button.onMouseClicked //���ص�¼����
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ReadFile(MouseEvent event) {
		 DirectoryChooserBuilder builder = DirectoryChooserBuilder.create();
         builder.title("Hello World");
         String cwd = System.getProperty("user.dir");
         File file = new File(cwd);
         builder.initialDirectory(file);
         DirectoryChooser chooser = builder.build();
         File chosenDir = chooser.showDialog(Main.myStage);
         if (chosenDir != null) {
           System.out.println(chosenDir.getAbsolutePath());
           Storage.file=chosenDir.getAbsoluteFile();
		   path.setText(Storage.file.getPath());
         } else {
          System.out.print("no directory chosen");
         }
	}
	
	@FXML
	public void Regist(MouseEvent event) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, ModelException, InterruptedException, ExecutionException, CipherException {
		String type = group.getSelectedToggle().getUserData().toString();
		if (!password.getText().equals("")) {
			if(type.equals("market"))
				MarketModel.Register(password.getText(),name.getText(),desc.getText(),Storage.file);
			else if(type.equals("developer"))
				UserModel.Register(password.getText(),1,name.getText(),desc.getText(),Storage.file);
			else if(type.equals("user"))
				UserModel.Register(password.getText(),0,name.getText(),desc.getText(),Storage.file);
			new ChangeSceneFunction("LoginScene.fxml");
		}
	}
	// Event Listener on Button.onMouseClicked //���ص�¼����
	@FXML
	public void ReturnLoginScene(MouseEvent event) throws IOException {
		new ChangeSceneFunction("LoginScene.fxml");
	}
}
