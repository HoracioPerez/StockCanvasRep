package dao.simple;

import dao.DAOSimpleClass;
import entity.User;
import entity.simple.Category;
import generic.SimpleClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOCategory extends DAOSimpleClass {

    public DAOCategory(User usuario) {
        super(usuario);
        this.table = "CATEGORY";
    }

    @Override
    public ArrayList<Category> getLikeList(String id, String name, String summary, String active) throws SQLException {
        ArrayList<Category> categorys = super.getLikeList(id, name, summary, active);
        return categorys;
    }

    @Override
    public Category getById(String id) throws SQLException {
        return (Category) super.getById(id);
    }

    @Override
    public ArrayList<Category> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected Category buildObject(ResultSet resultSet) throws SQLException {
       SimpleClass simpleClass=(SimpleClass) super.buildObject(resultSet);
       Category category=new Category(simpleClass.getId(), simpleClass.getName(), simpleClass.getSummary());
        return category;
    }
}
