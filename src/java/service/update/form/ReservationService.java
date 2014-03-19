package service.update.form;

import dao.DAOObject;
import dao.form.DAOReservation;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.RequestServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ReservationServiceUpdate", urlPatterns = {"/ReservationServiceUpdate"})
public class ReservationService extends RequestServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOReservation(user);
    }
}
