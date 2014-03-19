package entity;

import generic.IdObject;

/**
 *
 * @author Horacio Perez
 */
public class Stock extends IdObject {

    private long existStock;
    private long traficStock;
    private long reserveStock;

    public Stock(long existStock, long traficStock, long reserveStock) {
        this.existStock = existStock;
        this.traficStock = traficStock;
        this.reserveStock = reserveStock;
    }

    public Stock(String id, long existStock, long traficStock, long reserveStock) {
        super(id);
        this.existStock = existStock;
        this.traficStock = traficStock;
        this.reserveStock = reserveStock;
    }

    public long getExistStock() {
        return existStock;
    }

    public void setExistStock(long existStock) {
        this.existStock = existStock;
    }

    public long getReserveStock() {
        return reserveStock;
    }

    public void setReserveStock(long reserveStock) {
        this.reserveStock = reserveStock;
    }

    public long getTraficStock() {
        return traficStock;
    }

    public void setTraficStock(long traficStock) {
        this.traficStock = traficStock;
    }

    public long getAvailableStock() {
        return this.existStock - (this.reserveStock + this.traficStock);
    }
}
