package service.update.form;

import dao.DAOObject;
import dao.form.DAOPurchaseOrder;
import entity.DiscountDetail;
import entity.PaymentDetail;
import entity.ProductDetail;
import entity.User;
import form.PurchaseOrder;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "PurchaseOrderServiceUpdate", urlPatterns = {"/PurchaseOrderServiceUpdate"})
public class PurchaseOrderService extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        //(User , String , Date , ArrayList<ProductDetail> details, ArrayList<PaymentDetail> paymentDetails, ArrayList<DiscountDetail> discountDetails, Bill bill, Provider provider) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(
                user, // User user, 
                "peding", // String state,
                new java.sql.Date(new java.util.Date().getTime()), // Date date,
                new ArrayList<ProductDetail>(), // ArrayList<ProductDetail> details,
                new ArrayList<PaymentDetail>(), // ArrayList<PaymentDetail> paymentDetails,
                new ArrayList<DiscountDetail>(), // ArrayList<DiscountDetail> discountDetails, 
                null, // Bill bill,                
                null); //Provider provider,     
        return purchaseOrder;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOPurchaseOrder(user);
    }
}
