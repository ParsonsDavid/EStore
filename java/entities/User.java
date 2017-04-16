package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@NamedQueries( {
        @NamedQuery(name = "User.findAllUsers", query = "select o from User o"),
        @NamedQuery(name = "User.findByUsername", query = "select o from User o where o.username=:username"),
        @NamedQuery(name = "User.findByUsernameAndPassword", query = "select o from User o where o.username=:username and o.password=:password"),
})

@Entity
@XmlRootElement
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    String username;
    String password;
    String email;

    public User( ) {

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}