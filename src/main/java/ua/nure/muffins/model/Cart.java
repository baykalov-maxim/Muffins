package ua.nure.muffins.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_cart")
    private long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "t_muffin_cart",
            joinColumns = { @JoinColumn(name = "id_cart") },
            inverseJoinColumns = { @JoinColumn(name = "id_muffin") }
    )
    private List<Muffin> muffins;
}
