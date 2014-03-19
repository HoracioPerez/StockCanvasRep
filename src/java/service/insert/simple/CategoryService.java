package service.insert.simple;

import dao.DAOObject;
import dao.simple.DAOCategory;
import entity.User;
import entity.simple.Category;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "CategoryServiceInsert", urlPatterns = {"/CategoryServiceInsert"})
public class CategoryService extends ServiceInsert {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        
        Category entity = new Category(
                parameters.get(0), //String name,
                parameters.get(1), //String sumary, 
                true); // boolean active
        return entity;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOCategory(user);
    }
}
