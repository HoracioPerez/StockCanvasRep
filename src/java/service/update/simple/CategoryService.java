/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.update.simple;

import dao.DAOObject;
import dao.simple.DAOCategory;
import entity.User;
import entity.simple.Category;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "CategoryServiceUpdate", urlPatterns = {"/CategoryServiceUpdate"})
public class CategoryService extends ServiceUpdate {

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
