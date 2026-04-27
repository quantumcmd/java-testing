package javaTesting;

import org.junit.jupiter.api.Test;
import resources.AppParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppParametersTest {
    public static final String EXPECTED_DOMAIN = "127.0.0.1";
    public static final String EXPECTED_PORT = "80";
    public static final String EXPECTED_URL = "https://" + EXPECTED_DOMAIN + ":" + EXPECTED_PORT;

    @Test
    public void correctDomain(){
        assertEquals(EXPECTED_DOMAIN, AppParameters.DOMAIN, "Returns correct FQDN");
    }

    @Test
    public void correctPort(){
        assertEquals(EXPECTED_PORT, AppParameters.PORT, "Returns correct port");
    }

    @Test
    public void correctUrl(){
        assertEquals(EXPECTED_URL, AppParameters.deployedURL(), "Returns correct URL");
    }

    @Test
    public void singletonCorrectness(){
        AppParameters inst1 = AppParameters.getInstance();
        AppParameters inst2 = AppParameters.getInstance();

        assertTrue(inst1 == inst2, "There exists one and only one instance of AppParameters");
    }

}
