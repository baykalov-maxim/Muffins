package ua.nure.muffins.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_cart")
public class Cart {
    @Id
    @Column(name = "id_cart")
    private long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "t_muffin_cart",
            joinColumns = { @JoinColumn(name = "id_cart") },
            inverseJoinColumns = { @JoinColumn(name = "id_muffin") }
    )
    private List<Muffin> muffins;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Muffin> getMuffins() {
        return muffins;
    }

    public void setMuffins(List<Muffin> muffins) {
        this.muffins = muffins;
    }

    public boolean contain(long idMuffin) {
        for (Muffin m : muffins)
            if (m.getId() == idMuffin)
                return true;

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id &&
                Objects.equals(muffins, cart.muffins);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, muffins);
    }
}
