package service.insert.form;

import dao.DAOObject;
import dao.form.DAOBillPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.insert.BillServiceInsert;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "BillPurchaseOrderServiceInsert", urlPatterns = {"/BillPurchaseOrderServiceInsert"})
public class BillPurchaseOrderService extends BillServiceInsert {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOBillPurchaseOrder(user);
    }
}
