package opt3.Model;

import java.util.ArrayList;

// The simple class checks the username, but returns always true by password;
abstract class Authentication{
    // create the methods, but make them abstract
    public abstract Boolean checkUsername(String username);
    public abstract Boolean checkPassword(String password);

    // Authentication splits the username and password to two functions
    public Boolean Authentication(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            return true;
        }
        return false;
    }
}