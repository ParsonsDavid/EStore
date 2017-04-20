package dao;

import entity.User;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class UserDao {

    public void createUser(User u) {
        PersistenceUtil.persist(u);
        System.out.println("User registered");
    }

    public List<User> findAllUsers() {
        EntityManager em = PersistenceUtil.createEM();
        List<User> users = (List<User>)
                em.createNamedQuery("User.findAllUsers").getResultList();
        em.close();

        return users;

    }

    public User findUserByUsername(String username) {

        EntityManager em = PersistenceUtil.createEM();
        List<User> users = (List<User>)
                em.createNamedQuery("User.findByUsername").
                        setParameter("username", username).getResultList();
        em.close();

        System.out.println("Successfull");
        if (users.size() == 0)
            return null;
        else
            return users.get(0);


    }

    public User findUserByUsernameAndPassword(String username, String password) {

        EntityManager em = PersistenceUtil.createEM();
        List<User> users = (List<User>)
                em.createNamedQuery("User.findByUsernameAndPassword").
                        setParameter("username", username).
                        setParameter("password", password).getResultList();
        em.close();

        if (users.size() == 0)
            return null;
        else
            return users.get(0);
    }
}
