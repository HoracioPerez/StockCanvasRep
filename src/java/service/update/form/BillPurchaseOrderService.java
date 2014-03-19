package service.update.form;

import dao.DAOObject;
import dao.form.DAOBillPurchaseOrder;
import entity.User;
import javax.servlet.annotation.WebServlet;
import service.update.BillServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "BillPurchaseOrderServiceUpdate", urlPatterns = {"/BillPurchaseOrderServiceUpdate"})
public class BillPurchaseOrderService extends BillServiceUpdate {

    @Override
    protected DAOObject getDao(User user) {
        return new DAOBillPurchaseOrder(user);
    }
}
