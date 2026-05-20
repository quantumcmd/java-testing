package javaTesting.exceptionsTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionsTest {

    // Note this is JUnit 5, in which
    // @Test(expected=NullPointerException.class) is outdated
    @Test
    public void nullPointerTest(){
        Integer edat = null;

        assertThrows(NullPointerException.class, () -> {
            edat.toString();
        });

        // String edatEnLletres = edat.toString();
        // assertEquals("" + 18, edatEnLletres);
    }

    @Test
    public void catchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres;

        try{
            edatEnLletres  = edat.toString();
        } catch (NullPointerException e){
            edat = 18;
            edatEnLletres = edat.toString();
        }

        assertEquals("" + 18, edatEnLletres);
    }

    @Test
    public void tryCatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres = "";
        String text;

        try{
            edatEnLletres  = edat.toString();
        } catch (NullPointerException e){
            edat = 18;
            edatEnLletres = edat.toString();
        } finally{
            text = "Edat == " + edatEnLletres;
        }

        assertEquals("Edat == 18", text);
    }

    @Test
    public void throwingIllegalArgumentExceptionTryCatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres = "";
        String text;

        try{
            System.out.println("Passa 1 - Generam NullPointerException");
            edatEnLletres = edat.toString();
        } catch(NullPointerException npe){
            System.out.println("Passa 2 - Capturam la NullPointerException");
            System.out.println("Passa 3 - Anam a llançar una excepció");
        } finally {
            System.out.println("Passa final - Codi de tanament");
        }

        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Excepcio creada i llançada per mi");
        });

    }

    @Test
    public void excepcioErroneaTest(){
        assertThrows(NullPointerException.class, () -> {
            Integer edat = null;
            String edatEnLletres = "";
            String text;

            try{
                System.out.println("Passa 1 - Generam NullPointerException");
                edatEnLletres = edat.toString();
                throw new IllegalArgumentException("Excepcio creada i llançada per mi");
            } catch(IllegalArgumentException e){
                System.out.println("Passa 2 - Capturam la IllegalArgumentException");
            } finally {
                System.out.println("Passa final - Codi de tanament");
            }
        });
    }

//    @Test (expected = NullPointerException.class)
//    public void exceppp(){
//        Integer edat = null;
//        String edatEnLletres = "";
//        String text;
//
//        try{
//            System.out.println("Passa 1 - Generam NullPointerException");
//            edatEnLletres = edat.toString();
//
//            throw new IllegalArgumentException("Excepcio creada i llançada per mi");
//        } catch(IllegalArgumentException e){
//            System.out.println("Passa 2 - Capturam la NullPointerException");
//        } finally {
//            System.out.println("Passa final - Codi de tanament");
//        }
//    }

    @Test
    public void jugantAmbObjectExceptionTest(){
        Integer edat = null;
        String edatEnLletres;

        try{
            edatEnLletres  = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
            System.out.println("Anem a jugar amb l'objecte excepció !!!");

            System.out.println(npe.getMessage());
            System.out.println(npe.getStackTrace());
            npe.printStackTrace();
        }

        assertEquals("" + 18, edatEnLletres);
    }
}
