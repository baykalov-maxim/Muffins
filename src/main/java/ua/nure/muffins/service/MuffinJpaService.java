package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.MuffinJpaRepository;

import java.util.List;

@Service("muffinJPA")
public class MuffinJpaService implements MuffinService {

    private MuffinJpaRepository muffinJpaRepository;

    @Autowired
    public MuffinJpaService(MuffinJpaRepository muffinJpaRepository) {
        this.muffinJpaRepository = muffinJpaRepository;
    }

    @Override
    public List<MuffinDto> getRandomMuffins() {
        return MuffinDto.convertToDto(muffinJpaRepository.getRandomMuffins());
    }

    @Override
    public List<MuffinDto> getAll() {
        return MuffinDto.convertToDto(muffinJpaRepository.findAll());
    }

    @Override
    public void deleteAll() {
        muffinJpaRepository.deleteAll();
    }

    @Override
    public void saveAll(List<MuffinDto> muffins) {
        List<Muffin> muffinList = MuffinDto.convertToEntity(muffins);
        muffinJpaRepository.saveAll(muffinList);
    }
}
