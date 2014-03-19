package service.update.form;

import dao.DAOObject;
import dao.form.DAODeliveryNote;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.RequestServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "DeliveryNoteServiceUpdate", urlPatterns = {"/DeliveryNoteServiceUpdate"})
public class DeliveryNoteService extends RequestServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAODeliveryNote(user);
    }

}
