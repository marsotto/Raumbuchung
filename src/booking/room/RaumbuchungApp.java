package booking.room;

import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	static private final int WINDOW_WIDTH = 850;
	static private final int WINDOW_HEIGHT = 650;
	
	private RaumbuchungController raumbuchungController;
	

	public void start (Stage window) throws Exception {
		Locale.setDefault(Locale.Category.FORMAT, Locale.GERMAN);
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
		VBox tableViewBox = new VBox();
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
		
		raumbuchung.setStyle("-fx-text-background-color: white;" + "-fx-font-size: 20;");
		topPane.getChildren().add(raumbuchung);
		
		Button bucheButton = new Button("Buchen");
		bucheButton.setPrefWidth(Integer.MAX_VALUE);
		bucheButton.setPrefHeight(40);
		Button aendernButton = new Button("Ändern");
		aendernButton.setPrefWidth(Integer.MAX_VALUE);
		aendernButton.setPrefHeight(40);
		Button loescheButton = new Button("Löschen");
		loescheButton.setPrefWidth(Integer.MAX_VALUE);
		loescheButton.setPrefHeight(40);
		
		DatePicker von = new DatePicker();
		von.setShowWeekNumbers(true);
		von.setPrefWidth(Integer.MAX_VALUE);
		von.setPrefHeight(40);
		DatePicker bis = new DatePicker();
		bis.setPrefWidth(Integer.MAX_VALUE);
		bis.setPrefHeight(40);
		
		controlPane.getChildren().addAll(bucheButton, aendernButton, loescheButton, von, bis);
		
		topVBox.getChildren().addAll(topPane, controlPane);
		
		Button refreshButton = new Button("refresh");
		refreshButton.setPrefWidth(Integer.MAX_VALUE);
		refreshButton.setPrefHeight(40);
		
		HBox bottomPane = new HBox(refreshButton);
		
		TableView buTabelle = new TableView();
		buTabelle.setEditable(true);
		TableColumn id_buchung = new TableColumn("ID Buchung");
		TableColumn id_klasse = new TableColumn("ID Klasse");
		TableColumn id_raum = new TableColumn("ID Raum");
		TableColumn datum_von = new TableColumn("Von");
		TableColumn datum_bis = new TableColumn("Bis");
		buTabelle.getColumns().addAll(id_buchung, id_klasse, id_raum, datum_von, datum_bis);
		
		tableViewBox.getChildren().add(buTabelle);
		
		rootPane.setTop(topVBox);
		rootPane.setCenter(tableViewBox);
		rootPane.setBottom(bottomPane);

		return rootPane;
	}

	

}
