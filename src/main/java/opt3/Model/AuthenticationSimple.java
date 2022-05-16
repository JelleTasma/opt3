package opt3.Model;

import java.util.ArrayList;

class AuthenticationSimple extends Authentication{
    private final ArrayList<User> users = User.getUsers();
    @Override
    public Boolean checkUsername(String username){
        for (User user : users){
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
