package APIs;

import javax.ws.rs.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import DAO.*;
import entities.*;

import javax.ws.rs.*;
import java.io.IOException;



@Path("/hello")
public class LoginApi {

    UserDao userDao = new UserDao();



    @POST
    @Path( value = "/loginUser")
    @Produces(value={"application/json"})
    public User loginCustomer(String userJson){
        User user = null;
        try {
            user = mapUsers(userJson);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert user != null;
        User u =userDao.findUserByUsername(user.getUsername());
        if(user.getPassword().equals(u.getPassword()))
            return user;
        else
            return null;
    }


    private User mapUsers(String customerJson) throws IOException {
        User u = null;
        u = new ObjectMapper().readValue(customerJson, User.class);

        return u;

    }

}
