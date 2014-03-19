package DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio Perez
 */
public class DB {

    private Connection connection;
    private Statement statement;

    public DB(Connection connection) throws SQLException {
        this.connection=DB.getConnection();
        this.statement = this.connection.createStatement();
    }

    public void execute(String query) throws SQLException {
        System.out.println(query);
        Statement statement = this.connection.createStatement();
        statement.execute(query);
    }

    public ResultSet executeQ(String query) throws SQLException {
        System.out.println(query);
        this.statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }

    public void close() throws SQLException {
        this.statement.close();
    }

    public static Connection getConnection() {
        // Establece el nombre del driver a utilizar
        String dbDriver = "com.mysql.jdbc.Driver";
        // Establece la conexion a utilizar contra la base de datos
        String dbConnString = "jdbc:mysql://localhost/stock_canvas";
        // Establece el usuario de la base de datos
        String dbUser = "patagonia";
        // Establece la contrase�a de la base de datos
        String dbPassword = "PataTec01?1+db";
        Connection con = null;
        try {
            // Establece el driver de conexion
            Class.forName(dbDriver).newInstance();
            con = DriverManager.getConnection(dbConnString, dbUser, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retorna la conexion
        return con;
    }
}
