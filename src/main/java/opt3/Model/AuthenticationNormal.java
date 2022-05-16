package opt3.Model;

import java.util.ArrayList;

// the normal class checks the username and password for real;
class AuthenticationNormal extends Authentication{
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
        for (User user : users){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

