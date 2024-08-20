package TP2;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        //verificando que efetivamente el codigo proporcionado cree una variable del tipo set
        System.out.println(ALCOHOLS);
    }
    private static final Set<String> ALCOHOLS = new HashSet<>(Arrays.asList("whiskey", "whisky", "white rum",
            "dark rum", "bourbon", "rye", "scotch", "vodka", "tequila", "gin", "dry vermouth", "sweet vermouth",
            "prosecco","aperol", "brandy", "mezcal", "triple sec", "coffee liqueur", "almond liqueur", "champagne",
            "orange curacao", "rum"));

    public static String checkDrinks(String item, List<String> list) {
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
