package dao.entity;

import DB.DB;
import dao.DAOObject;
import dao.simple.DAOCategory;
import entity.Product;
import entity.Stock;
import entity.User;
import entity.simple.Category;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOProduct extends DAOObject {

    private DAOStock daoStock;
    private DAOCategory daoCategory;

    public DAOProduct(User user) {
        super(user);
        this.daoStock = new DAOStock(user);
        this.daoCategory=new DAOCategory(user);
        this.table = "PRODUCT";
        this.field = new String[]{
            "id",
            "name",
            "price",
            "detail",
            "id_category",
            "active"};
    }

    @Override
    public Product getById(String id) throws SQLException {
        return (Product) super.getById(id);
    }

    public ArrayList<Product> getLikeList(String id, String name, String price, String detail, String idCategory, String active) throws SQLException {
        String[] data = {id, name, price, detail, idCategory, active};
        ArrayList<Product> products = this.queryObjectList(this.likeQuery(data));
        return products;
    }

    @Override
    public ArrayList<Product> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected Product buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String name = resultSet.getString(this.field[1]);
        double price = resultSet.getDouble(this.field[2]);
        String detail = resultSet.getString(this.field[3]);
        String idCategory = resultSet.getString(this.field[4]);
        boolean active = (resultSet.getInt(this.field[5]) == 1);
        Stock stock = this.daoStock.getById(id);
        Category category=this.daoCategory.getById(idCategory);
        Product product = new Product(id, name, price, detail, category, stock, active);
        return product;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        Product product = (Product) object;
        return this.sqlText(product.getName()) + ","
                + this.sqlText(product.getPrice()) + ","
                + this.sqlText(product.getDetail()) + ","
                + this.sqlTextID(product.getCategory().getId()) + ","
                + this.sqlText(product.isActive()) + ")";
    }
    @Override
    public void insert(IdObject object) throws SQLException {
       Product product= (Product)object;
       Stock stock=new Stock("", 0, 0, 0);
        String query = this.getInsertSQL(product);
        DB db=new DB(this.connection);
        ResultSet resultSet = db.executeQ(query);
        if (resultSet.next()) {
            String id = resultSet.getString("id");            
            object.setId(id); 
            stock.setId(id);
        }        
        db.close();        
        this.daoStock.insert(stock);
        
    }
}
