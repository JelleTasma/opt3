package opt3.Model;

public class AccountFactory implements AbstractFactory<Account>{
    @Override
    public Account create(String accountType){
        if(accountType.equals("User")) {
            Account user = new User("q", "q", "test@test.nl");
            Login.users.add(user);
            return user;
        } else if (accountType.equals("Admin")) {
            Account admin = new Admin("p", "p", "p@test.nl");
            Login.users.add(admin);
            return admin;
        }
        return null;
    }
}