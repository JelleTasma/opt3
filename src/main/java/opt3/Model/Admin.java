package opt3.Model;

public class Admin extends Account {
    // make a new user in the constructor
    public Admin(String username, String password, String email){
        super(username, password, email, true);
    }
}
