package service.update;

import form.Bill;
import generic.IdObject;
import java.sql.SQLException;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class BillServiceUpdate extends ServiceUpdate {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) throws SQLException {
        Bill bill = new Bill(
                parameters.get(0), //Order id
                "", //type
                "", //cuit
                "pending", //state
                new java.sql.Date(new java.util.Date().getTime()), //date
                this.user); //user
        return bill;
    }
}
