/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testDAO;

import DB.DB;
import dao.entity.DAOClient;
import entity.Client;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio Perez
 */
public class TestDAOClient extends TestDAO{

    public TestDAOClient(User user) {
        super(user);
    }   
    
    @Override
    public void test() {
          try {
            User user = new User("Horacio", "1234", true);
            user.setConnection(DB.getConnection());
            DAOClient dAOClient=new DAOClient(user);
            ArrayList<Client> clients=dAOClient.getLikeList("%", "H%", "%", "%", "%", "%", "%");
            for (Client client : clients) {
                System.out.println(client);
            }

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected IdObject getById(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected ArrayList getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected ArrayList getLikeList(String[] string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void insert(IdObject idObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void update(IdObject idObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void delete(IdObject idObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
