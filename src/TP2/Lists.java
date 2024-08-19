package TP2;

import java.util.ArrayList;

public class Lists {
    public static int index_of(String search_item, ArrayList<String> list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(search_item)) {
                index = i;
            }
        }
        return index;
    }
    public static int index_of_by_index(String search_item, ArrayList<String> list, int search_index) {
        int index = -1;
        for (int i = search_index; i < list.size(); i++) {
            if (list.get(i).equals(search_item)) {
                index = i;
            }
        }
        return index;
    }
    int index_of_empty(ArrayList<String> list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            // aca habia puesto .equals("") pero el ide me lo quiso remplazar por .isEmpty()
            if (list.get(i).isEmpty()) {
                index = i;
            }
        }
        return index;
    }
    int put(String item, ArrayList<String> list) {
        int index = index_of_empty(list);
        if (index != -1) {
            list.set(index, item);
        }
        return index;
    }
    int remove(String item, ArrayList<String> list) {
        int numberOfEliminations = 0;
        while (index_of(item, list) != -1) {
            list.set(index_of(item, list), "");
            numberOfEliminations++;
        }
        return numberOfEliminations;
    }
}
