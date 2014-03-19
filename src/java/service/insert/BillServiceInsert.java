package service.insert;

import form.Bill;
import generic.IdObject;
import java.util.ArrayList;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
public abstract class BillServiceInsert extends ServiceInsert {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {
        
        Bill bill = new Bill(
                parameters.get(0), //Order id
                "", //type
                "", //cuit
                "Pendiente", //state
                new java.sql.Date(new java.util.Date().getTime()), //date
                this.user); //user
        return bill;
    }
}
