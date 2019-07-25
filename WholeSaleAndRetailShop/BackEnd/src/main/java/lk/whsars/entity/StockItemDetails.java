package lk.whsars.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class StockItemDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockDetailId;
    private double quantity;
    private double buyingPrice;

    @ManyToOne
    private Item item;
    @ManyToOne
    private Stock stock;

    public int getStockDetailId() {
        return stockDetailId;
    }

    public void setStockDetailId(int stockDetailId) {
        this.stockDetailId = stockDetailId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
