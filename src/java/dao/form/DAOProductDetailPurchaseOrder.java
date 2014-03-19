package dao.form;

import dao.entity.DAOProductDetail;
import entity.User;

/**
 *
 * @author Horacio Perez
 */
public class DAOProductDetailPurchaseOrder  extends DAOProductDetail{

    public DAOProductDetailPurchaseOrder(User usuario) {        
        super(usuario);
        this.table = "DETAIL_PURCHASE_ORDER";
    }
    
}
