package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dao.MuffinDao;
import ua.nure.muffins.dto.MuffinDto;

import java.util.List;

@Service("muffinJDBC")
public class MuffinJdbcService implements MuffinService {

    private MuffinDao muffinDao;

    @Autowired
    public MuffinJdbcService(MuffinDao muffinDao) {
        this.muffinDao = muffinDao;
    }

    @Override
    public List<MuffinDto> getRandomMuffins() {
        return muffinDao.getRandom();
    }

    @Override
    public List<MuffinDto> getAll() {
        return muffinDao.getAll();
    }
}