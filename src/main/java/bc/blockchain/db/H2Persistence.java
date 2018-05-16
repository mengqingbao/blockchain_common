package bc.blockchain.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Persistence {
	 public static void crateTable() throws SQLException {
	        Connection conn = null;
	        Statement stmt = null;
	        try {
	            conn = ConnectionPool.getInstance().getConnection();
	            DatabaseMetaData meta = conn.getMetaData();

	            ResultSet rsTables = meta.getTables(null, null, "ASSET",
	                    new String[] { "TABLE" });
	            if (!rsTables.next()) {
	                stmt = conn.createStatement();
	                stmt.execute("CREATE TABLE ASSET(MAC VARCHAR(1024),PREMAC VARCHAR(1024),SOURCE VARCHAR(124),TARGET VARCHAR(124),NUM INT(4),CREATED_DATE DATE,PRIMARY KEY(MAC))");
	            }
	            rsTables.close();
	        } finally {
	            releaseConnection(conn, stmt, null);
	        }
	    }

	    public static void addInfo(String str, long lastModifyTime,
	            String status) throws SQLException {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        try {
	            conn = ConnectionPool.getInstance().getConnection();

	            stmt = conn
	                    .prepareStatement("INSERT INTO WEATHERINFO VALUES(?,?,?)");
	            stmt.setString(1, str);
	            stmt.setString(2, String.valueOf(lastModifyTime));
	            stmt.setString(3, status);
	            stmt.execute();

	        } finally {
	            releaseConnection(conn, stmt, null);
	        }
	    }

	    public static boolean isInfoExits(String filePath, long lastModifyTime)
	            throws SQLException {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            conn = ConnectionPool.getInstance().getConnection();
	            stmt = conn
	                    .prepareStatement("SELECT WEATHERSTR FROM WEATHERINFO WHERE STATUS=? AND LASTMODIFYTIME=?");
	            stmt.setString(1, filePath);
	            stmt.setString(2, String.valueOf(lastModifyTime));
	            rs = stmt.executeQuery();
	            return rs.next();
	        } finally {
	            releaseConnection(conn, stmt, rs);
	        }
	    }

	    private static void releaseConnection(Connection conn, Statement stmt,
	            ResultSet rs) throws SQLException {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
}
