package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.MuffinMongoRepository;
import ua.nure.muffins.service.MuffinService;

import java.util.List;

@Service("muffinMongo")
public class MuffinMongoService implements MuffinService {

    private MuffinMongoRepository muffinMongoRepository;

    @Autowired
    public MuffinMongoService(MuffinMongoRepository muffinMongoRepository) {
        this.muffinMongoRepository = muffinMongoRepository;
    }

    @Override
    public List<MuffinDto> getRandomMuffins() {
        List<MuffinDto> muffins = muffinMongoRepository.findAll();
        muffins.sort((o1, o2) -> (Math.random() > 0.5 ? -1 : 1));
        return muffins.subList(0, 3);
    }

    @Override
    public List<MuffinDto> getAll() {
        return muffinMongoRepository.findAll();
    }
}
