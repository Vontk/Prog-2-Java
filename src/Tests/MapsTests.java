package Tests;

import TP2.Maps;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class MapsTests {

    @Test
    public void testCreateInventory() {
        Maps manager = new Maps();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("wood", 1);
        expected.put("iron", 2);
        expected.put("diamond", 2);

        assertEquals(expected, manager.createInventory(List.of("wood", "iron", "iron", "diamond", "diamond")));
    }

    @Test
    public void testAddOneItem() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("wood", 4);
        initial.put("iron", 2);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("wood", 4);
        expected.put("iron", 4);

        assertEquals(expected, manager.addItems(initial, List.of("iron", "iron")));
    }

    @Test
    public void testAddMultipleItems() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("wood", 2);
        initial.put("gold", 1);
        initial.put("diamond", 3);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("wood", 3);
        expected.put("gold", 3);
        expected.put("diamond", 3);

        assertEquals(expected, manager.addItems(initial, List.of("wood", "gold", "gold")));
    }

    @Test
    public void testAddNewItem() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("iron", 1);
        initial.put("diamond", 2);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("iron", 2);
        expected.put("diamond", 2);
        expected.put("wood", 2);

        assertEquals(expected, manager.addItems(initial, List.of("iron", "wood", "wood")));
    }

    @Test
    public void testAddFromEmptyDict() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("iron", 2);
        expected.put("diamond", 1);

        assertEquals(expected, manager.addItems(initial, List.of("iron", "iron", "diamond")));
    }

    @Test
    public void testDecrementItems() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("iron", 3);
        initial.put("diamond", 4);
        initial.put("gold", 2);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("iron", 1);
        expected.put("diamond", 3);
        expected.put("gold", 0);

        assertEquals(expected, manager.decrementItems(initial, List.of("iron", "iron", "diamond", "gold", "gold")));
    }

    @Test
    public void testNotBelowZero() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("wood", 2);
        initial.put("iron", 3);
        initial.put("diamond", 1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("wood", 0);
        expected.put("iron", 2);
        expected.put("diamond", 0);

        assertEquals(expected, manager.decrementItems(initial, List.of("wood", "wood", "wood", "iron", "diamond", "diamond")));
    }

    @Test
    public void testRemoveItem() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("iron", 1);
        initial.put("diamond", 2);
        initial.put("gold", 1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("iron", 1);
        expected.put("gold", 1);

        assertEquals(expected, manager.removeItem(initial, "diamond"));
    }

    @Test
    public void testRemoveItemNotInInventory() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("iron", 1);
        initial.put("diamond", 2);
        initial.put("gold", 1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("iron", 1);
        expected.put("gold", 1);
        expected.put("diamond", 2);

        assertEquals(expected, manager.removeItem(initial, "wood"));
    }

    @Test
    public void testListInventory() {
        Maps manager = new Maps();
        Map<String, Integer> initial = new HashMap<>();
        initial.put("coal", 15);
        initial.put("diamond", 3);
        initial.put("wood", 67);
        initial.put("silver", 0);

        List<Map.Entry<String, Integer>> expected = new ArrayList<>(List.of(
                Map.entry("coal", 15),
                Map.entry("diamond", 3),
                Map.entry("wood", 67)
        ));

        expected.sort(Comparator.comparing(Map.Entry::getKey));
        List<Map.Entry<String, Integer>> actual = manager.listInventory(initial);
        actual.sort(Comparator.comparing(Map.Entry::getKey));
        assertEquals(expected,actual);
    }
}