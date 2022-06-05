import opt3.Model.Item;
import opt3.Model.Login;
import opt3.Model.User;
import opt3.Model.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaFXAppTest {
    // User Model Test
    @Test
    void User_getUsernameTest() {
        Account test = new User("Test", "test", "Test@hotmail.com");
        assertEquals("Test", test.getUsername());
        assertNotEquals("wrong", test.getUsername());
    }

    @Test
    void User_getPasswordTest() {
        Account test = new User("Test", "test", "Test@hotmail.com");
        assertEquals("test", test.getPassword());
        assertNotEquals("wrong", test.getPassword());
    }

    @Test
    void User_getEmailTest() {
        Account test = new User("Test", "test", "Test@hotmail.com");
        assertEquals("Test@hotmail.com", test.getEmail());
        assertNotEquals("wrong@live.nl", test.getEmail());
    }

    @Test
    void User_getLogedInTest() {
        Account test = new User("Test", "test", "Test@hotmail.com");
        test.setLogedIn();
        assertTrue(test.getLogedIn());
        test.setLogedOut();
        assertFalse(test.getLogedIn());
    }

    // Login Model test
    @Test
    void Login_loginTest() {
        Account test = new User("Test", "test", "Test@hotmail.com");
        Login.users.add(test);
        assertEquals(test, Login.login("Test", "test"));
        assertNotEquals(test, Login.login("wrong", "wrong"));
    }

    // Item Model test
    @Test
    void Item_getNameTest() {
        Item test = new Item("Auto", "Test", "Test", 40000,  false, "Test", 4000, 0, null);
        assertEquals("test", test.getName());
        assertNotEquals("wrong", test.getName());
    }

    @Test
    void Item_getDescriptionTest() {
        Item test = new Item("Auto", "Test", "Test", 40000,  false, "Test", 4000, 0, null);
        assertEquals("test", test.getDescription());
        assertNotEquals("wrong", test.getDescription());
    }

    @Test
    void Item_getPriceTest() {
        Item test = new Item("Auto", "Test", "Test", 40000,  false, "Test", 4000, 0, null);
        assertEquals(1200, test.getPrice());
        assertNotEquals(0, test.getPrice());
    }

    @Test
    void Item_getInRentTest() {
        User user = new User("Test", "test", "Test@hotmail.com");
        Item test = new Item("Auto", "Test", "Test", 40000,  false, "Test", 4000, 0, null);
        assertEquals(false, test.getInRent());
        assertNotEquals(true, test.getInRent());
        test.startRent(user, "test");
        assertEquals(true, test.getInRent());
        assertNotEquals(false, test.getInRent());
    }

    @Test
    void Item_getInSockTest() {
        User user = new User("Test", "test", "Test@hotmail.com");
        Item test = new Item("Auto", "Test", "Test", 40000,  false, "Test", 4000, 0, null);
        assertEquals("Ja", test.getStock());
        assertNotEquals("Nee", test.getStock());
        test.startRent(user, "test");
        assertEquals("Nee", test.getStock());
        assertNotEquals("Ja", test.getStock());
    }
}