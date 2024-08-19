package Tests;
import TP2.Sets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.Arrays;

public class SetsTest {

    private static final List<String[]> ALL_DRINKS = List.of(
            new String[]{"Amaretto Sour", "almond liqueur", "bourbon", "cherries", "egg white", "lemon juice", "lemon twist", "simple syrup"},
            new String[]{"Aperol Spritz", "aperol", "prosecco", "soda water"},
            new String[]{"Bannana Punch", "banana", "ginger ale", "lemonade", "orange juice", "pineapple juice", "sugar", "water"},
            new String[]{"Beet Sumac Soda", "beet", "club soda", "fresh lemon juice", "sugar", "sumac"},
            new String[]{"Better Than Celery Juice", "apple cider vinegar", "black pepper", "celery stalks", "club soda", "granny smith apples", "kosher salt", "parsley"},
            new String[]{"Black & Blue Berries", "blackberries", "blueberries", "honey", "lemon juice", "soda water"},
            new String[]{"Bloody Mary", "celery", "celery salt", "lemon juice", "pepper", "tomato juice", "vodka", "worcestershire sauce"},
            new String[]{"Bloody Shame", "V8 juice", "black pepper", "celery", "salt", "tabasco sauce"},
            new String[]{"Chai Blossom", "chai tea bags", "club soda", "fresh lime juice", "lemon twists", "star anise pods", "sugar"},
            new String[]{"Chile-lime Pineapple Soda", "chiles de árbol", "club soda", "fresh pineapple juice", "kosher salt", "lime juice", "lime wedges", "pink peppercorns", "sugar"},
            new String[]{"Citrus Fizz", "organic marmalade cordial", "seedlip grove 42", "sparkling water"},
            new String[]{"Dry Martini", "dry vermouth", "gin", "lemon twist", "olives"},
            new String[]{"Espresso Martini", "coffee liqueur", "espresso", "sugar syrup", "vodka"},
            new String[]{"Fermented Grape Soda", "red seedless grapes", "sugar", "washed organic ginger"},
            new String[]{"French 75", "champagne", "gin", "lemon juice", "sugar syrup"},
            new String[]{"Gimlet", "gin", "lime juice", "sugar syrup"},
            new String[]{"Gin Fizz", "gin", "lemon juice", "soda water", "sugar syrup"},
            new String[]{"Huckleberry Shrub", "club soda", "huckleberries", "sugar", "white wine vinegar"},
            new String[]{"Mai Tai", "cherries", "lime juice", "lime wedge", "mint leaves", "orange curacao", "orgeat syrup", "rum", "sugar syrup"},
            new String[]{"Mango Mule", "cucumber", "fresh lime juice", "ginger beer", "honey syrup", "ice", "mango puree"},
            new String[]{"Manhattan", "bitters", "cherry", "rye", "sweet vermouth"},
            new String[]{"Maple-Ginger Cider Switchel", "apple cider vinegar", "club soda", "fresh ginger", "fresh lime juice", "maple syrup", "mint sprigs"},
            new String[]{"Margarita", "lime juice", "salt", "simple syrup", "tequila", "triple sec"},
            new String[]{"Mojito", "lime", "mint leaves", "soda water", "sugar syrup", "white rum"},
            new String[]{"Moscow Mule", "ginger beer", "lime", "lime juice", "vodka"},
            new String[]{"Negroni", "bitters", "gin", "sweet vermouth"},
            new String[]{"Old Fashioned", "bitters", "bourbon", "orange juice", "orange slices", "sugar"},
            new String[]{"PG13 Singapore Sling", "fresh lime juice", "mango juice", "mint sprigs", "pineapple juice", "pomegranate juice", "tonic water"},
            new String[]{"Penicillin", "ginger", "honey simple syrup", "lemon juice", "scotch"},
            new String[]{"Pina Colada", "cherries", "coconut milk", "cream of coconut", "dark rum", "fresh pineapple", "lime juice", "white rum"},
            new String[]{"Raspberry Almond Soda", "almonds", "club soda", "kosher salt", "limes", "ripe raspberries", "sugar"},
            new String[]{"Salted Meyer Lemon and Sage Presse", "club soda meyer lemons", "kosher salt", "sage leaves", "simple syrup"},
            new String[]{"Salted Watermelon Juice", "cubed watermelon", "kosher salt", "lime wedges"},
            new String[]{"Shirley Tonic", "cinnamon sticks", "club soda", "ginger", "lemon twists", "pomegranate juice", "sugar", "whole cloves"},
            new String[]{"Shirley ginger", "brooklyn crafted lemon lime ginger beer", "club soda", "grenadine", "lime juice"},
            new String[]{"Spiced Hibiscus Tea", "cinnamon sticks", "dried hibiscus flowers", "ginger", "honey", "lemon juice", "lemon wheels", "whole allspice"},
            new String[]{"Turmeric Tonic", "agave syrup", "cayenne pepper", "lemon", "peeled ginger", "peeled turmeric", "sparkling water"},
            new String[]{"Virgin Cucumber Gimlet", "lime juice", "club soda", "muddled cucumber", "simple syrup"},
            new String[]{"Whiskey Sour", "cherry", "lemon juice", "lemon slices", "superfine sugar", "whiskey"}
    );

    private static final List<String> DRINK_NAMES = List.of(
            "Amaretto Sour Cocktail", "Aperol Spritz Cocktail", "Bannana Punch Mocktail", "Beet Sumac Soda Mocktail",
            "Better Than Celery Juice Mocktail", "Black & Blue Berries Mocktail", "Bloody Mary Cocktail",
            "Bloody Shame Mocktail", "Chai Blossom Mocktail", "Chile-lime Pineapple Soda Mocktail",
            "Citrus Fizz Mocktail", "Dry Martini Cocktail", "Espresso Martini Cocktail", "Fermented Grape Soda Mocktail",
            "French 75 Cocktail", "Gimlet Cocktail", "Gin Fizz Cocktail", "Huckleberry Shrub Mocktail",
            "Mai Tai Cocktail", "Mango Mule Mocktail", "Manhattan Cocktail", "Maple-Ginger Cider Switchel Mocktail",
            "Margarita Cocktail", "Mojito Cocktail", "Moscow Mule Cocktail", "Negroni Cocktail",
            "Old Fashioned Cocktail", "PG13 Singapore Sling Mocktail", "Penicillin Cocktail", "Pina Colada Cocktail",
            "Raspberry Almond Soda Mocktail", "Salted Meyer Lemon and Sage Presse Mocktail",
            "Salted Watermelon Juice Mocktail", "Shirley Tonic Mocktail", "Shirley ginger Mocktail",
            "Spiced Hibiscus Tea Mocktail", "Turmeric Tonic Mocktail", "Virgin Cucumber Gimlet Mocktail",
            "Whiskey Sour Cocktail"
    );

    @Test
    public void testCheckDrinks() {
        for (int i = 0; i < ALL_DRINKS.size(); i++) {
            String[] item = ALL_DRINKS.get(i);
            String expectedResult = DRINK_NAMES.get(i);

            String actualResult = Sets.checkDrinks(item[0], Arrays.asList(item).subList(1, item.length));
            Assertions.assertEquals(expectedResult, actualResult,
                    String.format("Expected %s for %s, but got something else instead.", expectedResult, item[0]));
        }
    }
}