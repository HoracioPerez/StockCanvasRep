/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testDAO;

import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class TestDAO {
    
    protected User user;

    public TestDAO(User user) {
        this.user = user;
    }
    
    
    
    public abstract void test();    
    protected abstract IdObject getById(String id)throws SQLException;    
    protected abstract ArrayList getAll()throws SQLException;
    protected abstract ArrayList getLikeList(String[] string)throws SQLException;
    protected abstract void insert(IdObject idObject)throws SQLException;
    protected abstract void update(IdObject idObject)throws SQLException;
    protected abstract void delete(IdObject idObject)throws SQLException;
    
    
}
