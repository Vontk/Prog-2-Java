package TP2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Sets {
    public static void main(String[] args) {
        //verificando que efetivamente el codigo proporcionado cree una variable del tipo set
        System.out.println(ALCOHOLS);
    }
    private static final Set<String> ALCOHOLS = new HashSet<>(Arrays.asList("whiskey", "whisky", "white rum",
            "dark rum", "bourbon", "rye", "scotch", "vodka", "tequila", "gin", "dry vermouth", "sweet vermouth",
            "prosecco","aperol", "brandy", "mezcal", "triple sec", "coffee liqueur", "almond liqueur", "champagne",
            "orange curacao", "rum"));

    String checkDrinks(String item, ArrayList<String> list) {
        String reformat;
        for (int i = 0; i < list.size(); i++) {
            if (ALCOHOLS.contains(list.get(i))) {
                reformat = "%s Cocktail";
                return String.format(reformat, item);
            }
        }
        reformat = "%s Mocktail";
        return String.format(reformat, item);
    }
}
