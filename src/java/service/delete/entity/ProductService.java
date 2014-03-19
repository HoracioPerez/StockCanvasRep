package service.delete.entity;

import dao.DAOObject;
import dao.entity.DAOProduct;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.ServiceDelete;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ProductServiceDelete", urlPatterns = {"/ProductServiceDelete"})
public class ProductService extends ServiceDelete{
    
    @Override
    protected DAOObject getDao(User user) {
        return new DAOProduct(user);
    }
}
