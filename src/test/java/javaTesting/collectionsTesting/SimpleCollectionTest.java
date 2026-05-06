package javaTesting.collectionsTesting;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCollectionTest {

    @Test
    public void firstCollectionTest(){
        String[] numbers = {"zero", "one", "two", "three"};
        List<String> numerals = new ArrayList<>();

        for(String i : numbers){
            numerals.add(i);
        }

        assertTrue(numerals.size() == 4);

        List<String> numberList = Arrays.asList(numbers);
        // Note that Arrays.asList() returns a fixed array as a list, and as such cannot be increased (.add() throws an exception))

        assertTrue(numberList.size() == 4);

    }

    @Test
    public void diesSetmana(){
        List<String> diesSetmana = new ArrayList<>();
        List<String> diesFeiners = new ArrayList<>();
        List<String> diesCapDeSetmana = new ArrayList<>();
        List<String> diesSenars = new ArrayList<>();
        List<String> diesFeinersSenars = new ArrayList<>();
        List<String> calculDies = new ArrayList<>();

        initDiesFeiners(diesFeiners);

        assertTrue(diesFeiners.size() == 5);
        assertEquals(0, diesSetmana.size());
        assertFalse(diesSetmana.containsAll(diesFeiners));

        diesSetmana.addAll(diesFeiners);

        assertEquals(5, diesSetmana.size());
        assertTrue(diesSetmana.containsAll(diesFeiners));

        diesCapDeSetmana.add("Dissabte");
        diesCapDeSetmana.add("Diumenge");

        diesSetmana.addAll(diesCapDeSetmana);

        assertEquals(7, diesSetmana.size());
        assertTrue(diesSetmana.containsAll(diesCapDeSetmana));

        diesSenars.addAll(diesSetmana);

        assertTrue(diesSenars.contains("Dimarts"));

        diesSenars.remove(1);
        assertFalse(diesSenars.contains("Dimarts"));

        diesSenars.remove("Dijous");
        assertFalse(diesSenars.contains("Dijous"));

        diesFeinersSenars.addAll(diesSenars);
        diesFeinersSenars.removeAll(diesCapDeSetmana);

        assertTrue(diesFeinersSenars.size() == 3);
        assertFalse(diesFeiners.contains("Dissabte"));

        calculDies.addAll(diesSetmana);

        assertTrue(calculDies.containsAll(diesFeiners));
        assertTrue(calculDies.containsAll(diesCapDeSetmana));
        calculDies.clear();

        assertTrue(calculDies.isEmpty());

        calculDies.addAll(diesSetmana);
        calculDies.removeAll(diesCapDeSetmana);

        assertEquals(5, calculDies.size());
    }

    private void initDiesFeiners(List<String> dies) {
        dies.add("Dilluns");
        dies.add("Dimarts");
        dies.add("Dimecres");
        dies.add("Dijous");
        dies.add("Divendres");
    }

    @Test
    public void provesAmbMapsTest(){
        Map<String, String> map = new HashMap<>();

        map.put("fons", "negre");
        map.put("menus", "blau");
        map.put("dialeg", "verd");

        assertEquals(3, map.size());
        assertTrue(map.containsKey("menus"));
        assertTrue(map.containsValue("negre"));

        map.remove("dialeg");

        assertEquals(2, map.size());

        map.remove("clauInexistent");

        assertEquals(2, map.size());
        assertEquals(map.get("fons"), "negre");
    }

    @Test
    public void provesSetTest(){
        Set<String> dies = new HashSet<>();

        // Set doesn't duplicate
        dies.add("Dilluns");
        dies.add("Dilluns");
        dies.add("Dilluns");
        dies.add("Dilluns");

        assertEquals(1, dies.size());
    }
}
