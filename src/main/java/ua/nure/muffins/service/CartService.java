package ua.nure.muffins.service;

public interface CartService {
    void add(long idCart, long idMuffin);
    void remove(long idCart, long idMuffin);
    void addCart(long id);
    boolean isPresent(long id);
}
