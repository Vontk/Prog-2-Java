package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListsTest {

    // Tests for index_of
    @Test
    public void testIndexOf() {
        List<String> colors = List.of("Red", "Green", "White", "Black", "Pink", "Yellow", "Black");

        assertEquals(3, Lists.indexOf("Black", colors));
        assertEquals(-1, Lists.indexOf("Blue", colors));
    }

    // Tests for index_of_by_index
    @Test
    public void testIndexOfByIndex() {
        List<String> colors = List.of("Red", "Green", "White", "Black", "Pink", "Yellow", "Black");

        assertEquals(3, Lists.indexOfByIndex("Black", colors, 1));
        assertEquals(6, Lists.indexOfByIndex("Black", colors, 4));
        assertEquals(-1, Lists.indexOfByIndex("Green", colors, 2));
    }

    // Tests for index_of_empty
    @Test
    public void testIndexOfEmpty() {
        List<String> colors1 = List.of("Red", "Green", "White", "Black", "Pink", "Yellow", "Black");
        List<String> colors2 = List.of("Red", "Green", "", "", "Pink", "", "Black");

        assertEquals(-1, Lists.indexOfEmpty(colors1));
        assertEquals(2, Lists.indexOfEmpty(colors2));
    }

    // Tests for put
    @Test
    public void testPut() {
        List<String> colors1 = new ArrayList<>(List.of("Red", "Green", "", "", "Pink", "", "Black"));
        List<String> colors2 = new ArrayList<>(List.of("Red", "Green", "White", "Black", "Pink", "Yellow", "Black"));

        assertEquals(2, Lists.put("Blue", colors1));
        assertEquals(-1, Lists.put("Blue", colors2));
    }

    // Tests for remove
    @Test
    public void testRemove() {
        List<String> colors1 = new ArrayList<>(List.of("Red", "Green", "White", "Black", "Pink", "Yellow", "Black"));
        List<String> colors2 = new ArrayList<>(List.of("Red", "Green", "White", "Black", "Pink", "Yellow", "Black"));
        List<String> colors3 = new ArrayList<>(List.of("Red", "Green", "White", "Blue", "Pink", "Blue", "Black"));

        assertEquals(2, Lists.remove("Black", colors1));
        assertEquals(0, Lists.remove("Blue", colors2));
        assertEquals(2, Lists.remove("Blue", colors3));
    }
}
