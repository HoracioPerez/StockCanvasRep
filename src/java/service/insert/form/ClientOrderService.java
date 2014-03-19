package service.insert.form;

import dao.DAOObject;
import dao.form.DAOClientOrder;
import entity.DiscountDetail;
import entity.PaymentDetail;
import entity.ProductDetail;
import entity.User;
import form.ClientOrder;
import generic.IdObject;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ClientOrderServiceInsert", urlPatterns = {"/ClientOrderServiceInsert"})
public class ClientOrderService extends ServiceInsert {
    @Override
       protected String okResponse(IdObject entity) {        
        return entity.getId();
    }
    @Override
    protected IdObject getEntity(ArrayList<String> parameters){
        
        ClientOrder clientOrder = new ClientOrder(
                user, // User user, 
                "Pendiente", // String state,
                new java.sql.Date(new java.util.Date().getTime()), // Date date,
                new ArrayList<ProductDetail>(), // ArrayList<ProductDetail> details,
                new ArrayList<PaymentDetail>(), // ArrayList<PaymentDetail> paymentDetails,
                new ArrayList<PaymentDetail>(), // ArrayList<PaymentDetail> paymentDetailsAdvance,
                new ArrayList<DiscountDetail>(), // ArrayList<DiscountDetail> discountDetails, 
                null, // Bill bill, 
                null, // Client client, 
                null, // DeliveryNote deliveryNote,
                null); // Reservation reservation
        return clientOrder;
    }

    @Override
    protected DAOObject getDao(User user) {
        return new DAOClientOrder(user);
    }

}
