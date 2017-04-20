package RestAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import entity.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;


@Path("/hello")
public class LoginApi {

    UserDao userDao = new UserDao();


    @POST
    @Path(value = "/loginUser")
    @Produces(value = {"application/json"})
    public User loginCustomer(String userString) {
        User user = null;
        try {
            user = mapUsers(userString);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assert user != null;
        User u = userDao.findUserByUsername(user.getUsername());
        if (user.getPassword().equals(u.getPassword()))
            return user;
        else
            return null;
    }


    private User mapUsers(String customerString) throws IOException {
        User user = null;
        user = new ObjectMapper().readValue(customerString, User.class);

        return user;

    }

}
