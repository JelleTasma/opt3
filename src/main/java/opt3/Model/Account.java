package opt3.Model;

// Account class for creating users
public class Account {
    private boolean logedIn;
    private String username;
    private String password;
    private String email;
    private Boolean admin;

    // make a new user in the constructor
    public Account(String username, String password, String email, Boolean admin){
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
    public boolean getLogedIn(){return logedIn;}
    public void setLogedIn(){this.logedIn = true;}
    public void setLogedOut(){this.logedIn = false;}
}
