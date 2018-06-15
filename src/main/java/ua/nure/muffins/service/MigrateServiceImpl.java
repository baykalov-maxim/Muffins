package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dto.MuffinDto;

import java.util.List;

@Service
public class MigrateServiceImpl implements MigrateService {

    private MuffinService muffinJpaService;
    private MuffinService muffinMongoService;

    public MigrateServiceImpl(
            @Qualifier("muffinJPA") MuffinService muffinJpaService,
            @Qualifier("muffinMongo") MuffinService muffinMongoService) {

        this.muffinJpaService = muffinJpaService;
        this.muffinMongoService = muffinMongoService;
    }

    @Override
    public void migrateJpaToMongo() {
        muffinMongoService.deleteAll();
        List<MuffinDto> muffins = muffinJpaService.getAll();
        muffinMongoService.saveAll(muffins);
    }
}
