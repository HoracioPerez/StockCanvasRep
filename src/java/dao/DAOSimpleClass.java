package dao;

import entity.User;
import generic.IdObject;
import generic.SimpleClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class DAOSimpleClass extends DAOObject{

    public DAOSimpleClass(User usuario) {
        super(usuario);
        this.field = new String[]{
            "id",                
            "name",
            "summary",
            "active"};
    }
    
    public ArrayList getLikeList(String id, String name, String summary, String active) throws SQLException{       
        String[] data={id,name,summary,active};    
        ArrayList<SimpleClass> simpleClasses=this.queryObjectList(this.likeQuery(data));        
        return simpleClasses;
    }   
     
  

    @Override
    protected Object buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String name = resultSet.getString(this.field[1]);
        String summary = resultSet.getString(this.field[2]);
        boolean active=(resultSet.getInt(this.field[3])==1); 
        SimpleClass simpleClass=new SimpleClass(id, name, summary, active);       
        return simpleClass;
    }

    @Override
    protected String getIUAtr(IdObject object) {
       SimpleClass simpleClass=(SimpleClass) object;
       return  ""+this.sqlText(simpleClass.getName()) + "," 
                + this.sqlText(simpleClass.getSummary()) + "," 
                + this.sqlText(simpleClass.getActive() )+ ")";
    }
    
}
