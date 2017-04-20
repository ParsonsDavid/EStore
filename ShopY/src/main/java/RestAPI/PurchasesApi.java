package RestAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PurchaseDao;
import dao.UserDao;
import entity.Purchase;
import entity.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.List;


@Path("/purchases")
public class PurchasesApi {
    PurchaseDao purchaseDao = new PurchaseDao();
    UserDao userDao = new UserDao();


    @POST
    @Path(value = "/createPurchase")
    @Produces(value = {"application/json"})
    public void createPurchase(String purchaseString) throws IOException {
        Purchase p = mapPurchase1(purchaseString);
        p.paid = false;
        purchaseDao.createPurchase(p);
    }


    public Purchase mapPurchase1(String purchaseString) throws IOException {
        Purchase p = null;
        p = new ObjectMapper().readValue(purchaseString, Purchase.class);
        return p;
    }


    @POST
    @Path(value = "/getCartByUser/{paid}")
    @Produces(value = {"application/json"})
    public List<Purchase> getCartByUser(
            @PathParam("paid") boolean paid,
            String productString) {
        User user = null;
        User newUser = null;
        try {
            user = mapUser(productString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (user != null) {
            newUser = userDao.findUserByUsername(user.getUsername());
        }
        if (newUser != null) {


            return purchaseDao.getCartUser(newUser);
        } else {
            return null;
        }
    }

    private User mapUser(String itemString) throws IOException {
        User user = null;
        user = new ObjectMapper().readValue(itemString, User.class);

        return user;
    }

    @POST
    @Path(value = "/updatePaid")
    @Produces(value = {"application/json"})
    public List<Purchase> updatePurchase(String purchasesString) {
        List<Purchase> purchases = null;

        try {
            purchases = mapPurchases(purchasesString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (purchases != null) {
            for (Purchase p : purchases) {
                p.setPaid(true);
                purchaseDao.updatePurchase(p);
            }
        } else {
            return null;
        }
        return purchases;
    }

    private List<Purchase> mapPurchases(String purchasesString) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Purchase> purchases = mapper.readValue(purchasesString, new TypeReference<List<Purchase>>() {
        });

        return purchases;
    }

    @POST
    @Path(value = "/addProductToPurchases")
    @Produces(value = {"application/json"})
    public Purchase addItemToCart(String productJson) {
        Purchase purchase = null;

        try {
            purchase = mapPurchase(productJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        purchaseDao.createPurchase(purchase);
        return purchase;
    }

    private Purchase mapPurchase(String jsonItem) throws IOException {
        Purchase purchase = null;
        purchase = new ObjectMapper().readValue(jsonItem, Purchase.class);

        return purchase;
    }


}
