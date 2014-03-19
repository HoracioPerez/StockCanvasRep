/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.delete.simple;

import dao.DAOObject;
import dao.simple.DAOPaymentType;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PaymentTypeServiceDelete", urlPatterns = {"/PaymentTypeServiceDelete"})
public class PaymentTypeService extends ServiceDelete{

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPaymentType(user);
    }
    
}
