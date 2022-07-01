package opt3.Model;

// Account factory is the factory for the accounts and creating a user or admin depending on the accountType variable
public class AdminFactory extends AbstractFactory<Admin>{
    @Override
    public Admin create(String accountType){
        if(accountType.equals("Admin")) {
            Account admin = new User("q", "q", "test@test.nl");
            Login.users.add(admin);
            return admin;
        }
        return null;
    }
}