package service.insert.form;

import dao.DAOObject;
import dao.form.DAOBillClientOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.BillServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "BillClientOrderServiceInsert", urlPatterns = {"/BillClientOrderServiceInsert"})
public class BillClientOrderService extends BillServiceInsert{  

    @Override
    protected DAOObject getDao(User user) {
        return new DAOBillClientOrder(user);
    }
    
}
