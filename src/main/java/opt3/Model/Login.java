package opt3.Model;

import java.util.ArrayList;

public class Login {

    private static final ArrayList<User> users = User.getUsers();

    // The login method ask the username and password and checks if they exist
    public static User login(String username, String password){
        AuthenticationNormal Auth = new AuthenticationNormal();
        if(!Auth.Authentication(username, password)){
            return null;
        };
        for (User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // The register method collects all the data that's needed to create a new user
    public static User register(String username, String password, String email){
        User user = new User(username, password, email ,false);
        User.users.add(user);
        return user;
    }
}
