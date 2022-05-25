package booking.room;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RaumbuchungApp extends Application {
	static private final String PACKAGE_PATH = RaumbuchungApp.class.getPackage().getName().replace('.', '/');
	static private final String ICON_PATH = PACKAGE_PATH + "/raumbuchung.png";
	static private final String CSS_PATH = PACKAGE_PATH + "/raumbuchung.css";
	static private final int WINDOW_WIDTH = 800;
	static private final int WINDOW_HEIGHT = 600;
	
	private RaumbuchungController raumbuchungController;

	public void start (Stage window) throws Exception {
		final BorderPane rootPane = new BorderPane();
		this.raumbuchungController = new RaumbuchungController(rootPane);
		
		final Scene sceneGraph = new Scene(rootPane, WINDOW_WIDTH, WINDOW_HEIGHT);
		// sceneGraph.getStylesheets().add(CSS_PATH);

		window.setScene(sceneGraph);
		window.setTitle("Article App");
		window.getIcons().add(new Image(ICON_PATH.toString()));
		window.show();

		this.raumbuchungController.registerEventHandlers();
	}
	
	@Override
	public void stop () throws Exception {
		// close resources
		this.raumbuchungController.getJdbcConnection().close();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
	

	

}
