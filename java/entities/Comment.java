package entities;



        import javax.persistence.*;
        import javax.xml.bind.annotation.XmlElement;
        import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
        @NamedQuery(name = "comment.findAll", query = "select o from Comment o")
})

@XmlRootElement
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;
    private String address;
    private String pay;

    public Comment() {

    }

    public Comment(String userName, String address, String pay) {
        this.userName = userName;
        this.address = address;
        this.pay = pay;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public String getPay() {
        return pay;
    }

    public void setPay(String paymentMethod) {
        this.pay= paymentMethod;
    }
}