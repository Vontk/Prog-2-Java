package TP1;

public class App {

    // 1. Sum of Two Integers
    public int sum(int a, int b) {
        return a + b;
    }

    // 2. Check Even or Odd
    public boolean isEven(int number) {
        return (number % 2 == 0);
    }

    // 3. Maximum of Two Numbers
    public int max(int a, int b) {
        if (a<b) {
            return b;
        }
        return a;
    }

    // 4. Factorial of a Number
    public int factorial(int n) {
        if (n==0){
            return 1;
        }
        return n * factorial(n-1);
    }

    // 5. Count Characters in a String
    public int countChars(String input) {
        return input.length();
    }

    // 6. Reverse a String
    public String reverse(String input) {
        StringBuilder string = new StringBuilder();
        int start = input.length() -1;
        for (int i = 0; i < input.length(); i++) {
            string.append(input.charAt(start));
            start--;
        }
        return "";
    }

    // 7. Check Prime Number
    public boolean isPrime(int number) {
        if(number >= 1){
            return false;
        }
        for (int i = number; i >= 0; i++){
            if(number % i == 0){
                return false;
            }
            return true;
        }
    }

    // 8. Find the Smallest Element in an Array
    public int findMin(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] < array[j]){
                    return
                }
            }
        }
        return 0;
    }

    // 9. Sum of Elements in an Array
    public int arraySum(int[] array) {
        // TODO: Implement this method
        return 0;
    }

    // 10. Convert Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius) {
        return celsius * ((double) 9 / 5) + 32;
    }
}
