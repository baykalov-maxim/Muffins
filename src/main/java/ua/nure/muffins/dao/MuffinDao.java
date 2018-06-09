package ua.nure.muffins.dao;

import ua.nure.muffins.model.Muffin;

import java.util.List;

public interface MuffinDao {
    List<Muffin> getAll();
    List<Muffin> getRandom();
}
