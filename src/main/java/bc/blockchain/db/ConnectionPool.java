package bc.blockchain.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

public class ConnectionPool {
	private static ConnectionPool cp = null;
    private JdbcConnectionPool jdbcCP = null;

    private ConnectionPool() {
        String dbPath ="./config/h2bc";
        jdbcCP = JdbcConnectionPool.create("jdbc:h2:" + dbPath, "sa", "");
        jdbcCP.setMaxConnections(50);
    }

    public static ConnectionPool getInstance() {
        if (cp == null) {
            cp = new ConnectionPool();
        }
        return cp;
    }

    public Connection getConnection() throws SQLException {
        return jdbcCP.getConnection();
    }
}
