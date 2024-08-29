package TP3;

import java.util.ArrayList;
import java.util.List;

import static TP3.RecursiveFunctions.recursiveFibonacci;
import static TP3.RecursiveFunctions.recursiveIndexOfEmpty;

public class Run {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("a", "", "c"));
        System.out.println(recursiveIndexOfEmpty(list1));
    }
}
