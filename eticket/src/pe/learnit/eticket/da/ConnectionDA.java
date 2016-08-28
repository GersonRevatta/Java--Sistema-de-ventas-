package pe.learnit.eticket.da;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;


public class ConnectionDA {
    public static Connection getConexion() throws SQLException{
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:dem/123456@localhost");
        Connection conn = ods.getConnection();
        return conn;
    }
}
