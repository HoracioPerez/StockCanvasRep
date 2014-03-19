package service.update.form;

import dao.DAOObject;
import dao.form.DAOClientOrder;
import entity.User;
import form.ClientOrder;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import service.ServiceChangeStatus;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "ClientOrderChangeStatus", urlPatterns = {"/ClientOrderChangeStatus"})
public class ClientOrderChangeStatus extends ServiceChangeStatus {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOClientOrder(user);
    }

    @Override
    protected String change(User user) throws SQLException {
        DAOClientOrder dAOClientOrder=(DAOClientOrder)this.getDao(user);
        ClientOrder clientOrder=dAOClientOrder.getById(request.getParameter("idOrder"));
        dAOClientOrder.changeStatus(clientOrder,request.getParameter("status"));
        return "OK";
    }

}
