package dao.entity;

import dao.DAOObject;
import entity.ProductDetail;
import entity.Product;
import entity.User;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class DAOProductDetail extends DAOObject {

    private DAOProduct daoProduct;

    public DAOProductDetail(User usuario) {
        super(usuario);
        this.daoProduct = new DAOProduct(usuario);
        this.field = new String[]{
            "id",
            "amount",
            "price",
            "id_product",
            "id_order"};
    }

    public ArrayList<ProductDetail> getByOrder(String orderId) throws SQLException {
        ArrayList<ProductDetail> details = this.queryObjectList("SELECT * FROM " + this.table + " WHERE id_order=" + orderId);
        return details;
    }

    @Override
    public ProductDetail getById(String id) throws SQLException {
        return (ProductDetail) super.getById(id);
    }

    @Override
    public ArrayList<ProductDetail> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected String getIUAtr(IdObject object) {
        ProductDetail detail = (ProductDetail) object;
        return this.sqlText(detail.getAmount()) + ","
                + this.sqlText(detail.getPrice()) + ","
                + this.sqlTextID(detail.getProduct().getId()) + ","
                + this.sqlTextID(detail.getIdOrder()) + ")";
    }

    @Override
    protected ProductDetail buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        double amount = resultSet.getDouble(this.field[1]);
        double price = resultSet.getDouble(this.field[2]);
        Product product = this.daoProduct.getById(resultSet.getString(this.field[3]));
        String idOrder = resultSet.getString(this.field[4]);
        ProductDetail detail = new ProductDetail(id, idOrder, amount, price, product);
        return detail;
    }
}
