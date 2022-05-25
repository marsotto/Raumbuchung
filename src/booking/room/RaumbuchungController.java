package booking.room;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import javafx.scene.layout.BorderPane;

public class RaumbuchungController {
	
	private final Connection jdbcConnection;
	
	public RaumbuchungController (final BorderPane rootPane) throws SQLException {
		this.jdbcConnection = newDbConfig().getConnection();
	}
	
	public Connection getJdbcConnection () {
		return this.jdbcConnection;
	}
	
	protected void registerEventHandlers () {
		
	}
	
	
	
	
	
	static private DataSource newDbConfig () {
		final MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/rabu?characterEncoding=UTF-8");
		dataSource.setUser("root");
		dataSource.setPassword("Passw0rd");
		return dataSource;
	}
}

