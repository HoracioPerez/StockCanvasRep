package service.update.entity;

import dao.entity.DAOProduct;
import entity.ProductDetail;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class ProductDetailServiceUpdate extends ServiceUpdate {

      @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {     
        ProductDetail productDetail = new ProductDetail(
                parameters.get(0), // String idOrder,
                Double.parseDouble(parameters.get(1)), // double amount,
                this.getDAOProduct().getById(parameters.get(2))); // Product product
        return productDetail;
    }

    protected DAOProduct getDAOProduct(){
        return new DAOProduct(user);
    }
}
