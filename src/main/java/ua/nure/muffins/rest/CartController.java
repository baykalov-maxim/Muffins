package ua.nure.muffins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.muffins.service.CartService;
import ua.nure.muffins.service.CartServiceJpa;

@RestController
public class CartController {

    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(path = "/cart/add", method = RequestMethod.POST)
    public void add(@RequestBody CartItem cartItem) {
        cartService.add(cartItem.id_cart, cartItem.id_muffin);
    }

    @RequestMapping(path = "/cart/remove", method = RequestMethod.POST)
    public void remove(@RequestBody CartItem cartItem) {
        cartService.remove(cartItem.id_cart, cartItem.id_muffin);
    }
}

class CartItem {
    public long id_cart;
    public long id_muffin;
}