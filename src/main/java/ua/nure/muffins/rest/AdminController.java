package ua.nure.muffins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.muffins.service.MigrateService;

@RestController
public class AdminController {

    private MigrateService migrateService;

    @Autowired
    public AdminController(MigrateService migrateService) {
        this.migrateService = migrateService;
    }

    @RequestMapping("/migrate")
    public String migrateToMongo() {
        migrateService.migrateJpaToMongo();
        return "mySQL has migrated to MongoDB";
    }
}
