package ua.nure.muffins.model;

//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.util.List;

@Entity
@Table(name = "t_muffin")
public class Muffin {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_muffin")
    private Long id;

    @Column(name = "name_muffin")
    private String name;

    @Column(name = "desc_muffin")
    private String desc;

    @Column(name = "price_muffin")
    private int price;

    @Column(name = "img_muffin")
    private String img;

    @ManyToMany(mappedBy = "muffins")
    private List<Cart> carts;


    public Muffin(long id, String name, String desc, int price, String img) {
        this.setId(id);
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Cart> getCart() {
        return carts;
    }

    public void setCart(List<Cart> carts) {
        this.carts = carts;
    }
}
