package ua.nure.muffins.service;

import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Muffin;

import java.util.List;

public interface MuffinService {
    List<MuffinDto> getRandomMuffins();
    List<MuffinDto> getAll();
}
