package service.update.entity;

import dao.DAOObject;
import dao.entity.DAOProduct;
import dao.simple.DAOCategory;
import entity.Product;
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
@WebServlet(name = "ProductServiceUpdate", urlPatterns = {"/ProductServiceUpdate"})
public class ProductService extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        DAOCategory daoCategory = new DAOCategory(this.user);
       
        Product entity = new Product(
                parameters.get(0), // String name, 
                Double.parseDouble(parameters.get(1)),// Double price,
                parameters.get(2), // String detail,
                daoCategory.getById(parameters.get(3)), // Category category,
                null, // Stock stock, 
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProduct(user);
    }
}
