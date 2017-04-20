package dao;

import entity.Purchase;
import entity.User;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class PurchaseDao {

    public void createPurchase(Purchase p) {
        PersistenceUtil.persist(p);
        System.out.println("Purchase registered");
    }

    public void updatePurchase(Purchase p) {
        PersistenceUtil.merge(p);
        System.out.println("Purchase updated");
    }

    public List<Purchase> findAllPurchases() {
        EntityManager em = PersistenceUtil.createEM();
        List<Purchase> products = (List<Purchase>)
                em.createNamedQuery("Purchase.findAll").getResultList();
        em.close();

        return products;

    }

    public List<Purchase> getCartUser(User user) {
        EntityManager em = PersistenceUtil.createEM();
        List<Purchase> purchases = (List<Purchase>)
                em.createNamedQuery("Purchase.findUser").
                        setParameter("user", user).getResultList();
        em.close();

        if (purchases.size() == 0) {
            return null;
        } else {
            List<Purchase> paid = new ArrayList<>();
            for (Purchase p : purchases) {
                if (p.isPaid()) {
                    paid.add(p);
                }
            }
            return paid;

        }
    }

    public void removePurchase(Purchase purchase) {
        PersistenceUtil.remove(purchase);
    }

    public List<Purchase> getCartById(int id) {
        EntityManager em = PersistenceUtil.createEM();
        List<Purchase> purchases = (List<Purchase>)
                em.createNamedQuery("Purchase.findById").
                        setParameter("id", id).getResultList();
        em.close();

        if (purchases.size() == 0) {
            return null;
        } else
            return purchases;
    }
}



