package service.insert.form;

import dao.DAOObject;
import dao.form.DAODeliveryNote;
import entity.User;
import form.DeliveryNote;
import generic.IdObject;
import generic.Request;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import service.insert.RequestServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DeliveryNoteServiceInsert", urlPatterns = {"/DeliveryNoteServiceInsert"})
public class DeliveryNoteService extends RequestServiceInsert {

    @Override
    protected DAOObject getDao(User user) {
        return new DAODeliveryNote(user);
    }
    
    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        
        DeliveryNote request1 = new DeliveryNote(
                this.request.getParameter("idOrder"),  //String id,
                this.user, // User user,
                "Pendiente", // String state,
                new java.sql.Date(new java.util.Date().getTime())); // Date date
        return request1;
    }

}
