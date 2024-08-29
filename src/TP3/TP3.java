package TP3;
import java.util.List;

public class TP3 {
    public static int recursiveIndexOf(String target, List<String> list) {
        return recursiveIndexOfByIndex(target, list, 0);
    }

    public static int recursiveIndexOfByIndex(String target, List<String> list, int index) {
        if (list.get(index).equals(target)) {
            return index;
        } else if (list.size() == index) {
            return -1;
        } else {
            return recursiveIndexOfByIndex(target, list, index + 1);
        }
    }

    public static int recursiveIndexOfEmptyHelper(List<String> list, int index) {
        if (list.get(index).isEmpty()) {
            return index;
        }
        if (list.size() == index) {
            return -1;
        } else {
            return recursiveIndexOfEmptyHelper(list, index + 1);
        }
    }
    public static int recursiveIndexOfEmpty(List<String> list){
        return recursiveIndexOfEmptyHelper(list, 1);
    }
    public static int recursivePut(String target, List<String> list, int index) {
        if (recursiveIndexOfEmpty(list) == -1) {
            return -1;
        } else {
            list.set(index, target);
            return index;
        }
    }
    public static int recursiveRemoveHelper(String target, List<String> list, int count) {
        if (recursiveIndexOf(target, list) != -1) {
            list.remove(recursiveIndexOf(target, list));
            return recursiveRemoveHelper(target, list, count + 1);
        }
        else {
            return count;
        }
    }
    public static int recursiveRemove(String target, List<String> list) {
        return recursiveRemoveHelper(target, list, 0);
    }
    public static int recursiveSum(int n) {
        if (n > 0) {
            return n + recursiveSum(n -1);
        }
        else {
            return n;
        }
    }
    public static int recursiveFactorial(int n) {
        if (n > 0) {
            return n * recursiveFactorial(n - 1);
        }
        else {
            return n;
        }
    }
    public static int recursivePow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return base * recursivePow(base, exponent - 1);
        }
        else {
            return base;
        }
    }
    public static int recursiveFibonacci(int n) {
        if (n > 0) {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
        else {
            return n;
        }
    }
    public static boolean recursivePalindrome(String word){
        return recursivePalindromeHelper(word, 0);
    }
    public static boolean recursivePalindromeHelper(String word, int index){
        if (index == (word.length())/2 && word.charAt(index) == word.charAt(0)) {
            return true;
        } else if (word.charAt(index) == word.charAt(word.length() - 1)) {

        }
        return false;
    }
}

