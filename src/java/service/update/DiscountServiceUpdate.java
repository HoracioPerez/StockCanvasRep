
package service.update;

import entity.simple.Discount;
import generic.IdObject;
import java.util.ArrayList;
import service.ServiceUpdate;

/**
 *
 * @author Horacio Perez
 */
public abstract class DiscountServiceUpdate extends ServiceUpdate{
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
