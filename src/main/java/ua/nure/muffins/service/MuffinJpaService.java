package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.MuffinJpaRepository;
import ua.nure.muffins.service.MuffinService;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("jpaMuffin")
public class MuffinJpaService implements MuffinService {

    private MuffinJpaRepository muffinJpaRepository;

    @Autowired
    public MuffinJpaService(MuffinJpaRepository muffinJpaRepository) {
        this.muffinJpaRepository = muffinJpaRepository;
    }

    @Override
    public List<MuffinDto> getRandomMuffins() {
        return MuffinDto.convert(muffinJpaRepository.getRandomMuffins());
    }

    @Override
    public List<MuffinDto> getAll() {
        return MuffinDto.convert(muffinJpaRepository.findAll());
    }
}
