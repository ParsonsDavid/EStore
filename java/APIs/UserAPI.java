package APIs;

import DAO.AdminDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.*;
import entities.*;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.List;


@Path("/api")
public class UserAPI {


  private UserDao userDao = new UserDao();
  private productDao productDao = new productDao();
  private AdminDAO adminDAO = new AdminDAO();



    @GET
    @Path(value="/hello")
    @Produces(value={"application/json"})
    public String Hello(){
        return "Hello World";
    }



    @GET
    @Path(value="/getAllUsers")
    @Produces(value={"application/json"})
    public List<User> getUsers() {

        List<User> resultList = userDao.findAllUsers();
       return resultList;
    }

    @POST
    @Path(value="/createUser")
    public void createUser(String userInfoInJson){
        User user = null;
        try {
            user = mapUser(userInfoInJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userDao.createUser(user);
    }

    public User mapUser(String userInfoInJson) throws Exception{
        User user = null;

        user = new ObjectMapper().readValue(userInfoInJson, User.class);

        return  user;
    }

    @POST
    @Path(value="/createProduct")
    public void createProduct(String productJson){
        Product product = null;
        try {
            product = mapProduct(productJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        productDao.createProduct(product);
    }

    public Product mapProduct(String productInfoInJson) throws Exception{
        Product product = null;

        product = new ObjectMapper().readValue(productInfoInJson, Product.class);

        return  product;
    }

    @GET
    @Path(value="/getAllProducts")
    @Produces(value={"application/json"})
    public List<Product> getProducts() {

        List<Product> resultList = productDao.findAllProducts();
        return resultList;
    }

    @GET
    @Path(value="/getAllAdmin")
    @Produces(value={"application/json"})
    public List<Admin> findAllAdmins(){
        return AdminDAO.findAllAdmins();
    }

    @POST
    @Path(value="/addAdmin")
    @Produces(value={"application/json"})
    public Admin addAdmin(String adminJson) {
        Admin admin = null;
        try {
            admin = mapAdmin(adminJson);
        } catch (IOException e) {
            e.printStackTrace();
        }


        adminDAO.createAdmin(admin);
        return admin;
    }

    @POST
    @Path(value="/loginAdmin")
    @Produces(value={"application/json"})
    public Admin loginAdmin(String adminJson){
        Admin admin = null;
        try {
            admin = mapAdmin(adminJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert admin != null;
        Admin a =adminDAO.findByUserName(admin.getUsername());
        if(admin.getPassword().equals(a.getPassword()))
            return admin;
        else
            return null;
    }


    private Admin mapAdmin(String adminJson) throws IOException {
        Admin admin = null;
        admin = new ObjectMapper().readValue(adminJson, Admin.class);

        return admin;

    }


}
