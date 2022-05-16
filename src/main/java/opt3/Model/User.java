package opt3.Model;

import java.util.ArrayList;

public class User {

    private boolean logedIn;
    private String username;
    private String password;
    private String email;
    private Boolean admin;
    public static final ArrayList<User> users = new ArrayList<>();

    // make a new user in the constructor
    public User(String username, String password, String email, Boolean admin){
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
        this.logedIn = false;
    }

    // add the get and set methods
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public String getEmail(){return email;}
    public static ArrayList getUsers(){return users;}
    public boolean getLogedIn(){return logedIn;}
    public void setLogedIn(){this.logedIn = true;}
    public void setLogedOut(){this.logedIn = false;}
}

// interface for the type of users
interface userTypes{
    public void generate();
}

// the class for normal users
class normalUser implements userTypes{
    @Override
    public void generate(){
        User user1 = new User("q", "q", "test@test.nl", false);
    }
}

// the class for admins
class admin implements userTypes{
    @Override
    public void generate(){
        User user1 = new User("p", "p","test@test.nl",  true);
    }
}

// the interface for the factory (abstract factory)
interface AbstractFactory<T> {
    T create(String userType) ;
}

// the user factory that will make users
class userFactory implements AbstractFactory<userTypes> {
    @Override
    public userTypes create(String userType) {
        if ("admin".equalsIgnoreCase(userType)) {
            userTypes admin = new admin();
            admin.generate();
            return admin;
        } else if ("user".equalsIgnoreCase(userType)) {
            userTypes user = new normalUser();
            user.generate();
            return user;
        }

        return null;
    }
}
