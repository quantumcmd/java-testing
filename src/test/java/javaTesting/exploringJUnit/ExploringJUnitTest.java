package javaTesting.exploringJUnit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class ExploringJUnitTest {

    @Test
    public void testejantIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });
    }

    @Disabled // A JUnit 5, @Ignore passa a ser @Disabled
    @Test
    public void illegalParametersTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });
    }

    @Test
    public void missatgeExcepcioTest(){
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("the message");
        });

        assertTrue(thrown.getMessage().contains("the"));
    }

    @BeforeAll // A JUnit 5, @BeforeClass passa a ser @BeforeAll
    public static void executaUnCopPerClasseAbansDeQualsevoltest(){
        System.out.println("Abans d'executar qualsevol test, un cop per classe");
    }

    @AfterAll // A JUnit 5, @AfterClass passa a ser @AfterAll
    public static void executaUnCopDespresDeQualsevolTest(){
        System.out.println("Després d'executar qualsevol test, un cop per classe");
    }

    @BeforeEach // A JUnit 5, @Before passa a ser @BeforeEach
    public void executaAbansDeCadaTest(){
        System.out.println("Abans d'executar qualsevol test, per a cada test");
    }

    @AfterEach // A JUnit 5, @After passa a ser @AfterEach
    public void executaDespresDeCadaTest(){
        System.out.println("Després d'executar qualsevol test, per a cada test");
    }

    @Test
    public void asercionsDeJUnit(){
        assertEquals(5, 2+3);

        // Atenció: A JUnit 5, el missatge personalitzat va al FINAL de l'asert, no al principi.
        assertFalse(false, "fals es fals");
        assertFalse((3 > 5));
        assertTrue((5 > 3));

        int[] finsA10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] primers10 = {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(primers10);
        assertArrayEquals(finsA10, primers10);

        assertNotNull("", "Un String buit no es null");
        assertNotNull("");

        assertNotSame("", null, "Un String buit no es null");
        assertNotSame("", null);

        assertNull(null, "Nomes null es considerat null");

        Object obj = null;
        assertSame(obj, null);
    }

    @Test
    public void assertThatAmbHamCrest(){
        // Hamcrest funciona exactament igual a JUnit 5 un cop has fet els imports correctes
        assertThat("Testejant que 4+5 son 9", 4+5, is (9));

        assertThat("fals es fals", false, equalTo(false));

        assertThat(false, is (false));

        assertThat("true es true", true, equalTo(true));

        assertThat(true, is (true));

        assertThat("Un String buit no es null", is(not(nullValue())));

        assertThat("Aixo es un text", containsString("un"));

        assertThat("Aixo es un text", endsWith("xt"));

        assertThat("Aixo es un text", startsWith("Ai"));
    }
}