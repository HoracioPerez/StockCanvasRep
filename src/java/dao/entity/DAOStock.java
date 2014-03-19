package dao.entity;

import dao.DAOObject;
import entity.Stock;
import entity.User;
import generic.IdObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Horacio Perez
 */
public class DAOStock extends DAOObject {

    public DAOStock(User user) {
        super(user);
        this.table="STOCK";
        this.field = new String[]{
            "id",
            "exist_stock",
            "trafic_stock",
            "reserve_stock"};
    }

    public Stock getByProduct(String id) throws SQLException {
        Stock stock = (Stock) this.queryObject("SELECT * FROM " + this.table + " WHERE id=" + id);
        return stock;
    }

    @Override
    public Stock getById(String id) throws SQLException {
        return (Stock) super.getById(id);
    }

    @Override
    public ArrayList<Stock> getAll() throws SQLException {
        return super.getAll();
    }

    public ArrayList<Stock> getLikeList(String id, String existStock, String traficStock, String reserveStock) throws SQLException {
        String[] data = {id, existStock, traficStock, reserveStock};
        ArrayList<Stock> stocks = this.queryObjectList(this.likeQuery(data));
        return stocks;
    }

    @Override
    protected Stock buildObject(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString(this.field[0]);
        long existStock = resultSet.getLong(this.field[1]);
        long traficStock = resultSet.getLong(this.field[2]);
        long reserveStock = resultSet.getLong(this.field[3]);
        Stock stock = new Stock(id, existStock, traficStock, reserveStock);
        return stock;
    }

    @Override
    protected String getIUAtr(IdObject object) {
        Stock stock = (Stock) object;
        return  this.sqlTextID(stock.getId()) + ","
                + this.sqlText(stock.getExistStock()) + ","
                + this.sqlText(stock.getTraficStock()) + ","                
                + this.sqlText(stock.getReserveStock()) + ")";        
    }    
}
