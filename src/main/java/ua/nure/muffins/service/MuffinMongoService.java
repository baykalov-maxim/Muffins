package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.MuffinMongoRepository;
import ua.nure.muffins.service.MuffinService;

import java.util.List;

@Service
@Qualifier("mongoMuffin")
public class MuffinMongoService implements MuffinService {

    private MuffinMongoRepository muffinMongoRepository;

    @Autowired
    public MuffinMongoService(MuffinMongoRepository muffinMongoRepository) {
        this.muffinMongoRepository = muffinMongoRepository;
    }

    @Override
    public List<Muffin> getRandomMuffins() {
        List<Muffin> muffins = muffinMongoRepository.findAll();
        muffins.sort((o1, o2) -> (Math.random() > 0.5 ? -1 : 1));
        return muffins.subList(0, 3);
    }

    @Override
    public List<Muffin> getAll() {
        return muffinMongoRepository.findAll();
    }
}
