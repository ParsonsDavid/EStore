package APIs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import DAO.*
import entities.*

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by marym on 16/04/2017.
 */

@Path("/purchases")
public class PurchasesApi {
  PurchaseDao purchaseDao = new PurchaseDao();
  UserDao userDao = new UserDao();

    @GET
    @Path(value="/hello")
    @Produces(value={"application/json"})
    public String Hello(){
        return "Hello World";
    }


  @POST
  @Path(value="/createPurchases")
  @Produces(value={"application/json"})
  public Purchase createProduct(String jsonProduct){
    Purchase purchase = null;
    try {
      purchase = mapPurchase(jsonProduct);
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

  @POST
  @Path(value="/getCartByUser/{paid}")
  @Produces(value={"application/json"})
  public List<Purchase> getCartByUser(
          @PathParam("paid") boolean paid,
          String productJson){
    User user = null;
    User newUser = null;
    try {
      user = mapUser(productJson);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (user != null) {
      newUser =  userDao.findUserByUsername(user.getUsername());
    }
    if(newUser != null){


      return purchaseDao.getCartUser(newUser);
    }else{
      return null;
    }
  }

  private User mapUser(String jsonItem) throws IOException {
    User user = null;
    user = new ObjectMapper().readValue(jsonItem, User.class);

    return user;
  }

  @POST
  @Path(value="/updatePaid")
  @Produces(value={"application/json"})
  public List<Purchase> updatePurchase(String purchasesJson){
    List<Purchase> purchases = null;

    try {
      purchases = mapPurchases(purchasesJson);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (purchases != null) {
      for(Purchase p: purchases){
        p.setPaid(true);
        purchaseDao.updatePurchase(p);
      }
    } else{
      return null;
    }
    return purchases;
  }

  private List<Purchase> mapPurchases(String purchasesJson) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    List<Purchase> purchases = mapper.readValue(purchasesJson, new TypeReference<List<Purchase>>(){});

    return purchases;
  }

  @POST
  @Path(value="/addProductToPurchases")
  @Produces(value={"application/json"})
  public Purchase addItemToCart(String productJson){
    Purchase purchase = null;

    try {
      purchase = mapPurchase(productJson);
    } catch (IOException e) {
      e.printStackTrace();
    }
    purchaseDao.createPurchase(purchase);
    return purchase;
  }






}
