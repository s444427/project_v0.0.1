import org.junit.Test;

import static org.junit.Assert.*;


public class PasswordTest {

    @Test
    public void password_too_short() {
        Password testPass = new Password("aA1!aaaa");
        assertTrue(testPass.check());
    }

    @Test
    public void password_without_special() {
        Password testPass = new Password("aA1aaaaaaaaa");
        assertFalse(testPass.check());
    }


}