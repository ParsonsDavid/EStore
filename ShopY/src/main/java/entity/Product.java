package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select o from Product o"),
        @NamedQuery(name = "Product.findByTitle", query = "select o from Product o where o.title=:title"),
})

@Entity
@XmlRootElement
public class Product {


    String title;
    String manafactuer;
    double price;
    String category;
    String image;
    int stockQuanity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Product() {

    }

    public Product(String title, String manafactuer, double price, String category, String image, int stockQuanity) {
        this.title = title;
        this.manafactuer = manafactuer;
        this.price = price;
        this.category = category;
        this.image = image;
        this.stockQuanity = stockQuanity;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getManafactuer() {
        return manafactuer;
    }

    public void setManafactuer(String manafactuer) {
        this.manafactuer = manafactuer;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public int getStockQuanity() {
        return stockQuanity;
    }

    public void setStockQuanityk(int stockQuanity) {
        this.stockQuanity = stockQuanity;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
