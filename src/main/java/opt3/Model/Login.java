package opt3.Model;

import java.util.ArrayList;

public class Login {

    public static final ArrayList<Account> users = new ArrayList<Account>();

    // The login method ask the username and password and checks if they exist
    public static Account login(String username, String password){
        AuthenticationNormal Auth = new AuthenticationNormal();
        if(!Auth.Authentication(username, password)){
            return null;
        };
        for (Account user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
