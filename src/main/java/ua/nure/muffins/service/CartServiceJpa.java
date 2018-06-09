package ua.nure.muffins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Cart;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.CartJpaRepository;
import ua.nure.muffins.repository.MuffinJpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpaCart")
public class CartServiceJpa implements CartService {

    private CartJpaRepository cartJpaRepository;
    private MuffinJpaRepository muffinJpaRepository;

    @Autowired
    public CartServiceJpa(CartJpaRepository cartJpaRepository, MuffinJpaRepository muffinJpaRepository) {
        this.cartJpaRepository = cartJpaRepository;
        this.muffinJpaRepository = muffinJpaRepository;
    }

    @Override
    public void add(long idCart, long idMuffin) {
        Optional<Cart> cart = cartJpaRepository.findById(idCart);
        if (!cart.isPresent())
            return;

        if (cart.get().contain(idMuffin))
            return;

        List<Muffin> muffins = cart.get().getMuffins();
        Optional<Muffin> muffin = muffinJpaRepository.findById(idMuffin);
        if (!muffin.isPresent())
            return;

        muffins.add(muffin.get());
        cart.get().setMuffins(muffins);
        cartJpaRepository.save(cart.get());
    }

    @Override
    public void remove(long idCart, long idMuffin) {
        Optional<Cart> cart = cartJpaRepository.findById(idCart);
        if (!cart.isPresent())
            return;

        List<Muffin> muffins = cart.get().getMuffins();
        Muffin muffin = null;
        for (Muffin m : muffins) {
            if (m.getId() == idMuffin)
                muffin = m;
        }

        if (muffin == null)
            return;

        muffins.remove(muffin);
        cart.get().setMuffins(muffins);
        cartJpaRepository.save(cart.get());
    }

    @Override
    public void addCart(long id) {
        Cart cart = new Cart();
        cart.setId(id);

        cartJpaRepository.save(cart);
    }

    @Override
    public boolean isPresent(long id) {
        return cartJpaRepository.existsById(id);
    }

    @Override
    public void setInCart(long id, List<MuffinDto> muffins) {
        Cart cart = cartJpaRepository.getOne(id);
        for (MuffinDto muffin : MuffinDto.convert(cart.getMuffins())) {
            muffins.forEach(m -> {
                if (m.getId().equals(muffin.getId()))
                    m.setInCart(true);
            });
        }
    }

    @Override
    public List<MuffinDto> getMuffinsInCart(long id) {
        return MuffinDto.convert(cartJpaRepository.getOne(id).getMuffins());
    }
}
