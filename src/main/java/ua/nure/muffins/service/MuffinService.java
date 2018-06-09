package ua.nure.muffins.service;

import ua.nure.muffins.model.Muffin;

import java.util.List;

public interface MuffinService {
    List<Muffin> getRandomMuffins();
    List<Muffin> getAll();
}
