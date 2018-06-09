package ua.nure.muffins.model;

public class MuffinInOrder {
    private long id;
    private Muffin muffin;
    private Order order;
    private int count;
    private int currentPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Muffin getMuffin() {
        return muffin;
    }

    public void setMuffin(Muffin muffin) {
        this.muffin = muffin;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
