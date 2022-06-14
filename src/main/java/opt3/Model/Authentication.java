package opt3.Model;

import java.util.ArrayList;

// Autentication is the abstract class for the two authentication classes that both returns some else
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