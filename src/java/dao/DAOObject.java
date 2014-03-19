package dao;

import DB.DB;
import entity.User;
import generic.IdObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Horacio Perez
 */
public abstract class DAOObject {

    protected String table;
    protected String[] field;
    protected Connection connection;
    
    public DAOObject(User user) {
        this.connection=user.getConnection();
    }        

    protected String getInsertSQL(IdObject object) {
        String query = "CALL " + this.table + "_insert(" + this.getIUAtr(object);
        return query;
    }

    protected String getUpdateSQL(IdObject object) {
        String query = "CALL " + this.table + "_update(" + object.getId() + "," + this.getIUAtr(object);
        return query;
    }

    protected String getDeleteSQL(String id) {
        String query = "CALL " + this.table + "_delete(" + id + ")";
        return query;
    }

    protected abstract Object buildObject(ResultSet resultSet) throws SQLException;
    
    protected abstract String getIUAtr(IdObject object);
    
    public Object getById(String id) throws SQLException {
        return this.queryObject("SELECT * FROM " + this.table + " WHERE " + this.field[0] + "=" + id);
    }
    
    public ArrayList getAll() throws SQLException{
        ArrayList<Object> list=this.queryObjectList("SELECT * FROM "+ this.table);
        return list;
    } 
    
    public void insert(IdObject object) throws SQLException {
        String query = this.getInsertSQL(object);
        DB db=new DB(this.connection);
        ResultSet resultSet = db.executeQ(query);
        if (resultSet.next()) {
            String id = resultSet.getString("id");            
            object.setId(id);
        }
        db.close();
    }
    
    public void delete(String objId) throws SQLException {
        String query = this.getDeleteSQL(objId);
        DB db=new DB(this.connection);
        db.execute(query);
    }        
      
    public void update(IdObject object) throws SQLException {
        String query = this.getUpdateSQL(object);
        DB db=new DB(this.connection);
        db.execute(query);
    }
    
    protected String likeQuery(String[] data){
        String query = "SELECT * FROM " + this.table + " WHERE " + this.field[0] + " LIKE '" + data[0] + "' ";
         for (int i = 1; i < data.length; i++) {
            query += "AND " + this.field[i] + " LIKE '" + data[i]+"' ";
        }
         return query;
    }        
    
    protected Object queryObject(String query) throws SQLException {
        DB db=new DB(this.connection);
        ResultSet resultSet = db.executeQ(query);
        if (resultSet.next()) {
            Object object = this.buildObject(resultSet);
            db.close();
            return object;
        } else {
            db.close();
            return null;
        }
        
    }

    protected ArrayList queryObjectList(String query) throws SQLException {
        ArrayList<Object> objectList = new ArrayList<>(); 
        DB db=new DB(this.connection);
        ResultSet resultSet = db.executeQ(query);
        while (resultSet.next()) {
            Object object = this.buildObject(resultSet);
            objectList.add(object);
        }
        db.close();
        return objectList;
    }
    
    protected String sqlText(String string){
        return "'"+string+"'";
    }
    
    protected String sqlTextID(String string){
        return ""+string+"";
    }
    
    protected String sqlText(long string){
        return ""+string+"";
    }
    
    protected String sqlText(double string){
        return ""+string+"";
    }
    
    protected String sqlText(boolean string){
        if (string) {
            return "1";
        } else {
            return "0";
        }
    }
    
    protected String sqlText(Date date){
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String string = format.format(date);
        return "'"+string+"'";
    }
    
    public String[] getCampos() {
        return field;
    }

    public void setCampos(String[] campos) {
        this.field = campos;
    }
    
    public String getTabla() {
        return table;
    }

    public void setTabla(String tabla) {
        this.table = tabla;
    }
}
