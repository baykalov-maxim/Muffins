package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dao.MuffinDao;
import ua.nure.muffins.model.Muffin;

import java.util.List;

@Service
@Qualifier("jdbcMuffin")
public class MuffinJdbcService implements MuffinService {

    private MuffinDao muffinDao;

    @Autowired
    public MuffinJdbcService(MuffinDao muffinDao) {
        this.muffinDao = muffinDao;
    }

    @Override
    public List<Muffin> getRandomMuffins() {
        return muffinDao.getRandom();
    }

    @Override
    public List<Muffin> getAll() {
        return muffinDao.getAll();
    }
}