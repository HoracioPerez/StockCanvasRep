package dao.form;

import dao.entity.DAOProductDetail;
import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOProductDetailClientOrder extends DAOProductDetail {

    public DAOProductDetailClientOrder(User usuario) {
        super(usuario);
        this.table = "DETAIL_CLIENT_ORDER";
    }
}
