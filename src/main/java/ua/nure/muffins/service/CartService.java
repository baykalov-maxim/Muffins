package ua.nure.muffins.service;

import ua.nure.muffins.dto.MuffinDto;

import java.util.List;

public interface CartService {
    void add(long idCart, long idMuffin);
    void remove(long idCart, long idMuffin);
    void addCart(long id);
    boolean isPresent(long id);
    void setInCart(long id, List<MuffinDto> muffins);
    List<MuffinDto> getMuffinsInCart(long id);
}
