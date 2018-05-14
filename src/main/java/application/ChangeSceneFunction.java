package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


/* ��Ϊ�����Զ����࣬Ŀ�����õ����л������򵥣�д����һ������
 *  ����Ϊ���Ϊ  new ChangeSceneFunction("***.fxml").Change();   
 */
public class ChangeSceneFunction {
	
	ChangeSceneFunction(String FxmlFile) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(FxmlFile));
		Scene scene = new Scene(root,1080,720,Color.BEIGE);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							
		Main.myStage.setScene(scene);
		Main.myStage.show();
	}

}
