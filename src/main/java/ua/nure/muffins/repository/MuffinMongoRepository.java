package ua.nure.muffins.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.nure.muffins.dto.MuffinDto;

@Repository
public interface MuffinMongoRepository extends MongoRepository<MuffinDto, Long> { }
