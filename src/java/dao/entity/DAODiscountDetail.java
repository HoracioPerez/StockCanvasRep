package dao.entity;

import dao.DAOObject;
import entity.DiscountDetail;
import entity.User;
import entity.simple.Discount;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public abstract class DAODiscountDetail extends DAOObject{
     

    public DAODiscountDetail(User user) {
        super(user);
        this.field = new String[]{
            "id",
            "id_order",
            "amount",
            "id_discount"};
    }   

    public ArrayList<DiscountDetail> getLikeList(String id, String amount,String idDiscount, String idOrder) throws SQLException {
        String[] data = {id, amount, idDiscount,idOrder};
        ArrayList<DiscountDetail> discountDetails = this.queryObjectList(this.likeQuery(data));
        return discountDetails;
    }
    
    public ArrayList<DiscountDetail> getByOrder(String orderId) throws SQLException{
        ArrayList<DiscountDetail> paymentDetails= this.queryObjectList("SELECT * FROM "+this.table+" WHERE id_order="+orderId);
        return paymentDetails;
    }
    
    @Override
    public DiscountDetail getById(String id) throws SQLException {
        return (DiscountDetail) super.getById(id);
    }

    @Override
    public ArrayList<DiscountDetail> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    protected DiscountDetail buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String idOrder = resultSet.getString(this.field[1]);
        double amount = resultSet.getDouble(this.field[2]);
        String idDiscount = resultSet.getString(this.field[3]);
        Discount discount = this.getDiscount(idDiscount);
        DiscountDetail paymentDetail = new DiscountDetail(id,idOrder,amount, discount);
        return paymentDetail;
    }
    
    protected abstract Discount getDiscount(String idDiscount)throws SQLException;
    
    @Override
    protected String getIUAtr(IdObject object) {
        DiscountDetail discountDetail = (DiscountDetail) object;
        return this.sqlText(discountDetail.getAmount()) + ","
                + this.sqlTextID(discountDetail.getDiscount().getId()) + ")";
    }
}
