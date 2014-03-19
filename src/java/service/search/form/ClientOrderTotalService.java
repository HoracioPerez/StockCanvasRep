package service.search.form;

import dao.DAOObject;
import dao.form.DAOClientOrder;
import entity.User;
import form.ClientOrder;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import service.ServiceSearchInfo;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ClientOrderTotalService", urlPatterns = {"/ClientOrderTotalService"})
public class ClientOrderTotalService extends ServiceSearchInfo {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOClientOrder(user);
    }

    @Override
    public String get(User user) throws SQLException {
        DAOClientOrder dAOClientOrder = (DAOClientOrder) this.getDao(user);
        ClientOrder clientOrder = dAOClientOrder.getById(request.getParameter("idOrder"));
        return clientOrder.getTotal()+"";
    }
}
