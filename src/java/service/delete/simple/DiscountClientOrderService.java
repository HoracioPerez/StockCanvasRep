/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.delete.simple;

import dao.DAOObject;
import dao.simple.DAODiscountClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountClientOrderServiceDelete", urlPatterns = {"/DiscountClientOrderServiceDelete"})
public class DiscountClientOrderService extends ServiceDelete{
    
    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountClientOrder(user);
    }
    
}
