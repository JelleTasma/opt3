package opt3.Model;

import java.util.ArrayList;

// the normal class checks the username and password for real;
class AuthenticationNormal extends Authentication{
    @Override
    public Boolean checkUsername(String username){
        for (Account user : Login.users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean checkPassword(String password){
        for (Account user : Login.users){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

