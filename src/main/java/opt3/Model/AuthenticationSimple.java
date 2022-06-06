package opt3.Model;

import java.util.ArrayList;

// The simple class checks the username, but returns always true by password;
class AuthenticationSimple extends Authentication{
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
        return true;
    }
}
