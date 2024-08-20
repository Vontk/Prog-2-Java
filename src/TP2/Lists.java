package TP2;

import java.util.List;

public class Lists {
    public static int indexOf(String search_item, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(search_item)) {
                return i;
            }
        }
        return -1;
    }
    public static int indexOfByIndex(String search_item, List<String> list, int search_index) {
        for (int i = search_index; i < list.size(); i++) {
            if (list.get(i).equals(search_item)) {
                return i;
            }
        }
        return -1;
    }
    public static int indexOfEmpty(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            // aca habia puesto .equals("") pero el ide me lo quiso remplazar por .isEmpty()
            if (list.get(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }
    public static int put(String item, List<String> list) {
        int index = indexOfEmpty(list);
        if (index != -1) {
            list.set(index, item);
        }
        return index;
    }
    public static int remove(String item, List<String> list) {
        int numberOfEliminations = 0;
        while (indexOf(item, list) != -1) {
            list.set(indexOf(item, list), "");
            numberOfEliminations++;
        }
        return numberOfEliminations;
    }
}
