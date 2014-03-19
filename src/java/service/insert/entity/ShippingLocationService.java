/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.insert.entity;

import dao.DAOObject;
import dao.entity.DAOShippingLocation;
import entity.ShippingLocation;
import entity.User;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ShippingLocationServiceInsert", urlPatterns = {"/ShippingLocationServiceInsert"})
public class ShippingLocationService extends ServiceInsert {

    @Override
    protected String okResponse(IdObject entity) {
        return entity.getId();
    }

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        String idClient = this.request.getParameter("client_id");
        String contactName = this.request.getParameter("contact_name");
        String street = this.request.getParameter("street");
        String cp = this.request.getParameter("cp");
        String province = this.request.getParameter("province");
        String country = this.request.getParameter("country");
        String time = this.request.getParameter("time");
        ShippingLocation entity = new ShippingLocation(
                idClient,// String idClient,
                contactName,// String contactName, 
                street,// String street,
                cp,// String cp,
                province,// String province,
                country,// String Country,
                time,// String time,
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOShippingLocation(user);
    }
}
