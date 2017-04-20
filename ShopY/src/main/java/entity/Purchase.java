package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "Purchase.findAll", query = "select o from Purchase o"),
        @NamedQuery(name = "Purchase.findUser", query = "select o from Purchase o where o.user=:user"),
        @NamedQuery(name = "Purchase.findById", query = "select o from Purchase o where o.id=:id")
})

@Entity
@XmlRootElement
public class Purchase {

    public boolean paid;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;

    public Purchase(Product product, User user, boolean paid) {
        this.product = product;
        this.user = user;
        this.paid = paid;
    }

    public Purchase() {
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @XmlElement
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlElement
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
