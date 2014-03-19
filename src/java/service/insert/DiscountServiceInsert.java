package service.insert;

import entity.simple.Discount;
import generic.IdObject;
import java.util.ArrayList;
import service.ServiceInsert;

/**
 *
 * @author Horacio Perez
 */
public abstract class DiscountServiceInsert extends ServiceInsert {

    @Override
    protected IdObject getEntity(ArrayList<String> parameters) {   
        Discount entity = new Discount(
                parameters.get(0), //name
                parameters.get(1), //sumary
                Integer.parseInt(parameters.get(2)), //percentage
                true); //active
        return entity;
    }
   
}
