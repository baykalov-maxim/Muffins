package ua.nure.muffins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.nure.muffins.model.Muffin;

import java.util.List;

public interface MuffinJpaRepository extends JpaRepository<Muffin, Long> {
    @Query(nativeQuery = true, value = "call p_get_random_muffins()")
    List<Muffin> getRandomMuffins();
}
