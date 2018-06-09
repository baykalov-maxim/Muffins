package ua.nure.muffins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nure.muffins.model.Cart;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Long> { }
