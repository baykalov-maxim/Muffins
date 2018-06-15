package ua.nure.muffins.dao;

import ua.nure.muffins.dto.MuffinDto;

import java.util.List;

public interface MuffinDao {
    List<MuffinDto> getAll();
    List<MuffinDto> getRandom();
    void deleteAll();
}
