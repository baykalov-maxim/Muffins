package ua.nure.muffins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.muffins.service.CartServiceJpa;

@RestController
public class Test {

    private CartServiceJpa cartServiceJpa;

    @Autowired
    public Test(CartServiceJpa cartServiceJpa) {
        this.cartServiceJpa = cartServiceJpa;
    }

    @RequestMapping("/test")
    public void test() {
        cartServiceJpa.remove(1528537816481L, 2);
        cartServiceJpa.add(1528537816481L, 3);
    }
}
