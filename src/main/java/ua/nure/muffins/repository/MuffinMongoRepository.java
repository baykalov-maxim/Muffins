package ua.nure.muffins.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ua.nure.muffins.model.Muffin;

import java.util.List;

@Repository
public interface MuffinMongoRepository extends MongoRepository<Muffin, Long> { }
