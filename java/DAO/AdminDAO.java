package DAO;

import entities.*;
import persistance.*;

import javax.persistence.EntityManager;
import java.util.List;


public class AdminDAO {
    public void createAdmin(Admin admin){
        PersistenceUtil.persist(admin);
    }

    public static List<Admin> findAllAdmins() {
        EntityManager em = PersistenceUtil.createEM();
        List<Admin> admins = (List<Admin>)
                em.createNamedQuery("Admin.findAll").getResultList();
        em.close();

        return admins;
    }

    public Admin findByUserName(String username) {
        EntityManager em = PersistenceUtil.createEM();
        List<Admin> admins = (List<Admin>)
                em.createNamedQuery("Admin.findByUsername").setParameter("username", username).getResultList();

        em.close();
        if(admins.size() > 0 ){
            return admins.get(0);
        }
        else{
            return null;
        }

    }
}