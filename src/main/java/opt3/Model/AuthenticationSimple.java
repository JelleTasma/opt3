package opt3.Model;

import java.util.ArrayList;

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
