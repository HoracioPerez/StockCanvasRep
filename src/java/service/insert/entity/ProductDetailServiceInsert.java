package service.insert.entity;

import dao.entity.DAOProduct;
import entity.ProductDetail;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
public abstract class ProductDetailServiceInsert extends ServiceInsert {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        String idProducto = this.request.getParameter("idProduct");
        String idOrder = this.request.getParameter("idOrder");
        double amount = Double.parseDouble(this.request.getParameter("amount"));
        ProductDetail productDetail = new ProductDetail(
                idOrder, // String idOrder,
                amount, // double amount,
                this.getDAOProduct().getById(idProducto)); // Product product
        return productDetail;
    }

    protected DAOProduct getDAOProduct() {
        return new DAOProduct(user);
    }
}
