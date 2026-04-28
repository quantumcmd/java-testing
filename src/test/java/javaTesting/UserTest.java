package javaTesting;

import DomainEntities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void userConstructed(){
        User user = new User("Thomas", "secret");
        assertTrue(user != null);
        assertEquals(user.getName(), "Thomas");
        // assertEquals(user.getPassword(), "secret");
        assertTrue(user.verifyPassword("secret"));
    }
}
