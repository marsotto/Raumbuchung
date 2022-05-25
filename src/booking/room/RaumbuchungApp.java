package booking.room;

import edu.damago.java.fx.article.RootPaneController;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RaumbuchungApp extends Application {
	static private final int WINDOW_WIDTH = 800;
	static private final int WINDOW_HEIGHT = 600;
	
	private RaumbuchungController raumbuchungController;

	public void start (Stage primaryStage) throws Exception {
		final BorderPane rootPane = new BorderPane();
		this.raumbuchungController = new RaumbuchungController(rootPane);
		
	}
	
	@Override
	public void stop () throws Exception {
		// close resources
		this.RaumbuchungController.getJdbcConnection().close();
	}
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub

	}

	

}
