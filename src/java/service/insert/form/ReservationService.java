package service.insert.form;

import dao.DAOObject;
import dao.form.DAOReservation;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.RequestServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ReservationServiceInsert", urlPatterns = {"/ReservationServiceInsert"})
public class ReservationService extends RequestServiceInsert{
    
    @Override
    protected DAOObject getDao(User user) {
        return new DAOReservation(user);
    }
}
