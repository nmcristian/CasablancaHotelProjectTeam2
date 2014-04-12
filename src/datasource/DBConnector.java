package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cristian
 */
public class DBConnector
{

    private String id, pw, host;
    
    public DBConnector(String dbHost, String dbUsername, String dbPassword)
    {
        this.host = dbHost;
        this.id = dbUsername;
        this.pw = dbPassword;
    }

    public Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(host, id, pw);
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con)
    {
        try
        {
            con.close();
        } catch (SQLException e)
        {
            System.err.println(e);
        }
    }
}
