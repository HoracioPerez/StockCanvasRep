/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.update.entity;

import dao.DAOObject;
import dao.entity.DAOShippingLocation;
import entity.ShippingLocation;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ShippingLocationServiceUpdate", urlPatterns = {"/ShippingLocationServiceUpdate"})
public class ShippingLocationService extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {

        ShippingLocation entity = new ShippingLocation(
                parameters.get(0),// String idClient,
                parameters.get(1),// String contactName, 
                parameters.get(2),// String street,
                parameters.get(3),// String cp,
                parameters.get(4),// String province,
                parameters.get(5),// String Country,
                parameters.get(6),// String time,
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOShippingLocation(user);
    }
}
