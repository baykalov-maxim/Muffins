package ua.nure.muffins.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import ua.nure.muffins.model.Muffin;

import java.util.ArrayList;
import java.util.List;

@Document
public class MuffinDto {
    private Long id;
    private String name;
    private String desc;
    private int price;
    private String img;
    private boolean inCart;

    public MuffinDto(Long id, String name, String desc, int price, String img) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.img = img;
    }

    public MuffinDto(Muffin muffin) {
        id = muffin.getId();
        name = muffin.getName();
        desc = muffin.getDesc();
        price = muffin.getPrice();
        img = muffin.getImg();
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

    public static List<MuffinDto> convert(List<Muffin> list) {
        List<MuffinDto> muffins = new ArrayList<>();
        list.forEach(m -> muffins.add(new MuffinDto(m)));
        return muffins;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }
}
