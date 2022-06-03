package booking.room;

import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RaumbuchungController {
	static private final String SQL_QUERY_BUCHUNGEN = "select * from vtbBuchung";
	
	private final Connection jdbcConnection;
	private final VBox topVBox, rowBox;
	private final HBox controlPane, bottomPane;
	private final Button buchenButton, aendernButton, loescheButton, refreshButton;
	private final TableView<BuchungTabellenZeile> buAnsicht;
	private final List<Map<String,Object>> buchungen;
	private boolean buchenMenuShowing = false;
	
	public RaumbuchungController (final BorderPane rootPane) throws SQLException {
		this.buchungen = new ArrayList<>();
		this.jdbcConnection = newDbConfig().getConnection();
		this.topVBox = (VBox) rootPane.getTop();
		this.controlPane = (HBox) topVBox.getChildren().get(1);
		this.rowBox = (VBox) rootPane.getCenter();
		this.bottomPane = (HBox) rootPane.getBottom();
		this.buchenButton = (Button) this.controlPane.getChildren().get(0);
		this.aendernButton = (Button) this.controlPane.getChildren().get(1);
		this.loescheButton = (Button) this.controlPane.getChildren().get(2);
		this.refreshButton = (Button) this.bottomPane.getChildren().get(0);
		this.buAnsicht = (TableView) this.rowBox.getChildren().get(0);
		this.refresh();
	}
	
	public Connection getJdbcConnection () {
		return this.jdbcConnection;
	}
	
	protected void registerEventHandlers () {
		this.buchenButton.setOnAction(event -> this.showBuchenMenu());
		this.aendernButton.setOnAction(event -> this.aendern());
		this.loescheButton.setOnAction(event -> this.loeschen());
		this.refreshButton.setOnAction(event -> this.refresh());
	}
	
	private void loeschen () {
	
	}

	private void aendern () {
		
	}

	private void buchen () {
		buchenMenuShowing = false;
	}
	
	private void showBuchenMenu () {
		if (!buchenMenuShowing) {
			
			ObservableList<String> klasse = 
			    FXCollections.observableArrayList(
			        "FI6AE",
			    	"FI7AE",
			        "FI8AE"
			    );
			final ComboBox comboBox = new ComboBox(klasse);
			final HBox buchenMenu = new HBox(comboBox);
			this.topVBox.getChildren().addAll(buchenMenu);
			buchenMenuShowing = true;
		}
	}

	private void refresh () {
		
		try {
			final List<Map<String,Object>> buchungen = RelationalDatabases.executeQuery(this.getJdbcConnection(), SQL_QUERY_BUCHUNGEN);
			this.buchungen.clear();
			this.buchungen.addAll(buchungen);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.buAnsicht.getItems().clear();
		for (final Map<String,Object> buchung : this.buchungen) {
			final BuchungTabellenZeile buchungTabellenZeile = new BuchungTabellenZeile();
			buchungTabellenZeile.setID_Buchung((Integer) buchung.get("ID_Buchung"));
			buchungTabellenZeile.setID_Klasse((Integer) buchung.get("ID_Klasse"));
			buchungTabellenZeile.setID_Raum((Integer) buchung.get("ID_Raum"));
			buchungTabellenZeile.setDatum_von((Date) buchung.get("Datum_von"));
			buchungTabellenZeile.setDatum_bis((Date) buchung.get("Datum_bis"));
			this.buAnsicht.getItems().add(buchungTabellenZeile);
//			System.out.println(this.buchungen);
		}
		
	}
	
	static private DataSource newDbConfig () {
		final MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/rabu?characterEncoding=UTF-8");
		dataSource.setUser("root");
		dataSource.setPassword("Passw0rd");
		return dataSource;
	}

}

