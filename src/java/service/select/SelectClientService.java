
package service.select;

import dao.DAOObject;
import dao.form.DAOClientOrder;
import entity.User;
import form.ClientOrder;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import service.SelectService;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "SelectClientService", urlPatterns = {"/SelectClientService"})
public class SelectClientService extends SelectService{

    @Override
    protected DAOObject getDao(User user) {
        return new DAOClientOrder(user);
    }

    @Override
    public String select(User user) throws SQLException {
        DAOClientOrder dAOClientOrder=(DAOClientOrder)this.getDao(user);
        ClientOrder clientOrder=dAOClientOrder.getById(request.getParameter("idOrder"));
        dAOClientOrder.selectClient(clientOrder,request.getParameter("idClient"));
        return "OK";
        
    }

}
