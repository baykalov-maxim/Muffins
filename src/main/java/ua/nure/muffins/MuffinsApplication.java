package ua.nure.muffins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.MuffinMongoRepository;

@SpringBootApplication

@Configuration
@EnableJpaRepositories
public class MuffinsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MuffinsApplication.class, args);
    }
}
