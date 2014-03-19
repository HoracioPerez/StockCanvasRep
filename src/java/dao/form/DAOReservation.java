/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.form;

import dao.DAORequest;
import entity.User;
import form.Reservation;
import generic.IdObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOReservation extends DAORequest {

    public DAOReservation(User user) {
        super(user);
        this.table="RESERVATION";
        this.field = new String[]{
            "id",
            "state",
            "date",
            "id_user"};
    }    

    @Override
    public Reservation getById(String id) throws SQLException {
        return (Reservation) super.getById(id);
    }

    @Override
    public ArrayList<Reservation> getAll() throws SQLException {
        return super.getAll();
    }

    public ArrayList<Reservation> getLikeList(String id, String state, String date, String idUser) throws SQLException {
        String[] data = {id, state, date, idUser};
        ArrayList<Reservation> reservations = this.queryObjectList(this.likeQuery(data));
        return reservations;
    }

    @Override
    protected Reservation buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        String state = resultSet.getString(this.field[1]);
        Date date = resultSet.getDate(this.field[2]);
        String userId = resultSet.getString(this.field[3]);
        User user = this.daoUser.getById(userId);
        Reservation reservation = new Reservation(id, state, date, user);
        return reservation;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        Reservation reservation = (Reservation) object;
        return this.sqlText(reservation.getState()) + ","
                + this.sqlText(reservation.getDate()) + ","
                + this.sqlText(reservation.getUser().getId()) + ")";
    }
}
