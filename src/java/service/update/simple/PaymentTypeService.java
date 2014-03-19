/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.update.simple;

import dao.DAOObject;
import dao.simple.DAOPaymentType;
import entity.User;
import entity.simple.PaymentType;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentTypeServiceUpdate", urlPatterns = {"/PaymentTypeServiceUpdate"})
public class PaymentTypeService extends ServiceUpdate{

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        PaymentType entity = new PaymentType(
                parameters.get(0), //String name,
                parameters.get(1), //String sumary, 
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentType(user);
    }
    
}
