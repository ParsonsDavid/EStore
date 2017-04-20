package dao;

import entity.Admin;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class AdminDAO {
    public static List<Admin> findAllAdmins() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Admin> ads = (List<Admin>)
                em.createNamedQuery("Admin.findAll").getResultList();
        em.close();
        return ads;
    }

    public void createAdmin(Admin admin) {
        PersistenceUtil.persist(admin);
    }

    public Admin findByUserName(String username) {
        EntityManager em = PersistenceUtil.createEM();
        List<Admin> admins = (List<Admin>)
                em.createNamedQuery("Admin.findByUsername").setParameter("username", username).getResultList();

        em.close();
        if (admins.size() > 0) {
            return admins.get(0);
        } else {
            return null;
        }

    }
}