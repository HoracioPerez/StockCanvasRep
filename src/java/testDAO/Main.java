/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.a
 */
package testDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Horacio Perez
 */
public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        //User user = new User("Horacio", "1234", true);
        //user.setConnection(DB.getConnection());
        //DAOClientOrder dAOClientOrder = new DAOClientOrder(user);
        /* ClientOrder clientOrder=new ClientOrder(user, "pending", new Date(100), 
                new ArrayList<ProductDetail>(), new ArrayList<PaymentDetail>(), new ArrayList<PaymentDetail>()
                , new ArrayList<DiscountDetail>()
                , new Bill("", "", "", "", new Date(100), user)
                , new Client("", "", "", "", "", "", true,new ArrayList())
                , new DeliveryNote("", "", new Date(100), user, null, null)
                , new Reservation("", "", new Date(100), user));*/
       /* ClientOrder clientOrder=new ClientOrder(user,  "pending", new Date(100), null, null, null, null, null, null, null, null);
        DAOClientOrder dAOClientOrder = new DAOClientOrder(user);
        dAOClientOrder.insert(clientOrder);
       Gson gson = new Gson();*/
        // convert java object to JSON format,
        // and returned as JSON formatted string
      // String json = gson.toJson(clientOrder);
        //write converted json data to a file named "file.json"
        //FileWriter writer = new FileWriter("c:\\file.json");
        //writer.write(json);
        //writer.close();
        String json = "{ \n"
           + "\"aaData\": [\n"
           + "[\n"
           + "\"1\",\n"
           + "\"Horacio\",\n"
           + "\"Perez\",\n"
           + "\"hhhh\",\n"
           + "\"aaaaa\",\n"
           + "\"000000\"]\n"
           + "]\n"
           + "}";
       System.out.println(json);
    }
}