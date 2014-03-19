package service.insert.entity;

import dao.DAOObject;
import dao.entity.DAOProduct;
import dao.simple.DAOCategory;
import entity.Product;
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
@WebServlet(name = "ProductServiceInsert", urlPatterns = {"/ProductServiceInsert"})
public class ProductService extends ServiceInsert {
    
    @Override
    protected String okResponse(IdObject entity) {
        String id = entity.getId();
        return id;
    }
    
    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        DAOCategory daoCategory = new DAOCategory(this.user);
       
        Product entity = new Product(
                this.request.getParameter("name"), // String name, 
                Double.parseDouble(this.request.getParameter("price")),// Double price,
                this.request.getParameter("summary"), // String summary,
                daoCategory.getById(this.request.getParameter("category")), // Category category,
                null, // Stock stock, 
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOProduct(user);
    }
}
