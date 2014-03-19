/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.update.simple;

import dao.DAOObject;
import dao.simple.DAODiscountPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.DiscountServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DiscountPurchaseOrderServiceUpdate", urlPatterns = {"/DiscountPurchaseOrderServiceUpdate"})
public class DiscountPurchaseOrderService extends DiscountServiceUpdate{
    
    @Override
    protected DAOObject getDao(User user) {
        return new DAODiscountPurchaseOrder(user);
    }
    
}