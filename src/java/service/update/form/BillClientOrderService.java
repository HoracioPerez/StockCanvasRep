package service.update.form;

import dao.DAOObject;
import dao.form.DAOBillClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.BillServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "BillClientOrderServiceUpdate", urlPatterns = {"/BillClientOrderServiceUpdate"})
public class BillClientOrderService extends BillServiceUpdate{  

    @Override
    protected DAOObject getDao(User user) {
        return new DAOBillClientOrder(user);
    }
    
}
