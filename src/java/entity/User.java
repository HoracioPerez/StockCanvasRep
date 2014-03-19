package entity;

import DB.DB;
import generic.IdObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Horacio Perez
 */
public class User extends IdObject {

    private String pass;
    private boolean active;
    private Connection connection;

    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;
        this.active = true;
    }

    public User(String id, String pass, boolean active) {
        this.id = id;
        this.pass = pass;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public boolean validate() throws SQLException{
        Connection newConnection=DB.getConnection();
        Statement statement=newConnection.createStatement();
        String query= "SELECT * FROM USER WHERE id='"+this.id+"' AND pass='"+this.pass+"'";
        ResultSet resultSet=statement.executeQuery(query);
        if(resultSet.next()){
            this.connection=newConnection;
            statement.close();
            return true;
        }else{
           statement.close();
           newConnection.close();
           return false;      
        }
          
    }
}
