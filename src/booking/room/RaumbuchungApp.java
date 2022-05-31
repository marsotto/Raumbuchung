package booking.room;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RaumbuchungApp extends Application {
	static private final String PACKAGE_PATH = RaumbuchungApp.class.getPackage().getName().replace('.', '/');
	static private final String ICON_PATH = PACKAGE_PATH + "/raumbuchung.png";
	static private final String CSS_PATH = PACKAGE_PATH + "/raumbuchung.css";
	static private final int WINDOW_WIDTH = 800;
	static private final int WINDOW_HEIGHT = 600;
	
	private RaumbuchungController raumbuchungController;

	public void start (Stage window) throws Exception {
		
		final BorderPane rootPane = newRootPane();
		this.raumbuchungController = new RaumbuchungController(rootPane);

		final Scene sceneGraph = new Scene(rootPane, WINDOW_WIDTH, WINDOW_HEIGHT);
		// sceneGraph.getStylesheets().add(CSS_PATH);

		window.setScene(sceneGraph);
		window.setTitle("Raumbuchung");
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
	
	private BorderPane newRootPane() {
		BorderPane rootPane = new BorderPane();
		VBox rowBox = new VBox();
		VBox topVBox = new VBox();
		//rowBox.setPrefWidth(Integer.MAX_VALUE);
		//rowBox.setStyle("-fx-alignment: center");
		HBox topPane = new HBox();
		HBox controlPane = new HBox();
		topPane.setPrefSize(WINDOW_WIDTH, 80);
		topPane.setPadding(new Insets(15, 12, 15, 12));
		topPane.setSpacing(10);
		topPane.setStyle("-fx-background-color: #000000");
		ImageView logo = new ImageView(new Image(RaumbuchungApp.class.getResourceAsStream("damago_logo.png")));
		topPane.getChildren().add(logo);
		Label raumbuchung = new Label("Raumbuchung");
		raumbuchung.setStyle("-color: #FFFFFF");
		topPane.getChildren().add(raumbuchung);
		
		Button zeigeButton = new Button("Zeige Buchungen");
		zeigeButton.setPrefWidth(Integer.MAX_VALUE);
		zeigeButton.setPrefHeight(40);
		Button bucheButton = new Button("Buchen");
		bucheButton.setPrefWidth(Integer.MAX_VALUE);
		bucheButton.setPrefHeight(40);
		Button aendernButton = new Button("Ändern");
		aendernButton.setPrefWidth(Integer.MAX_VALUE);
		aendernButton.setPrefHeight(40);
		Button loescheButton = new Button("Löschen");
		loescheButton.setPrefWidth(Integer.MAX_VALUE);
		loescheButton.setPrefHeight(40);
		controlPane.getChildren().addAll(zeigeButton, bucheButton, aendernButton, loescheButton);
		
		topVBox.getChildren().addAll(topPane, controlPane);
		
		Button refreshButton = new Button("refresh");
		refreshButton.setPrefWidth(Integer.MAX_VALUE);
		refreshButton.setPrefHeight(40);
		
		HBox bottomPane = new HBox(refreshButton);
		
		rootPane.setTop(topVBox);
		rootPane.setCenter(rowBox);
		rootPane.setBottom(bottomPane);

		return rootPane;
	}

	

}
