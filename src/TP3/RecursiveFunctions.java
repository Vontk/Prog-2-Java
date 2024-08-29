package TP3;
import java.util.ArrayList;
import java.util.List;

import static TP3.RecursiveFunctions.recursiveFibonacci;

public class RecursiveFunctions {
    public static int recursiveIndexOf(List<String> list, String target) {
        return recursiveIndexOfByIndex(list, target, 0);
    }

    public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
        if (list.size() == index) {
            return -1;
        } else if (list.get(index).equals(target)) {
            return index;
        } else {
            return recursiveIndexOfByIndex(list, target, index + 1);
        }
    }

    public static int recursiveIndexOfEmptyHelper(List<String> list, int index) {
        if (list.size() == index) {
            return -1;
        }
        else if (list.get(index).isEmpty()) {
            return index;
        }
        else {
            return recursiveIndexOfEmptyHelper(list, index + 1);
        }
    }
    public static int recursiveIndexOfEmpty(List<String> list){
        return recursiveIndexOfEmptyHelper(list, 1);
    }
    public static int recursivePutHelper(String target, List<String> list, int index) {
        if (recursiveIndexOfEmpty(list) == -1) {
            return -1;
        } else {
            list.set(recursiveIndexOfEmpty(list), target);
            return recursiveIndexOfEmpty(list);
        }
    }
    public static int recursivePut(String target, List<String> list) {
        return recursivePutHelper(target, list, 0);
    }
    public static int recursiveRemoveHelper(String target, List<String> list, int count) {
        if (recursiveIndexOf(list, target) != -1) {
            list.remove(recursiveIndexOf(list, target));
            return recursiveRemoveHelper(target, list, count + 1);
        }
        else {
            return count;
        }
    }
    public static int recursiveRemove(List<String> list, String target) {
        return recursiveRemoveHelper(target, list, 0);
    }
    public static int recursiveSumHelper(List<Integer> list, int index, int sum) {
        if (list.size() == index) {
            return sum;
        }
        else {
            return recursiveSumHelper(list, index + 1, sum + list.get(index));
        }
    }
    public static int recursiveSum(List<Integer> list) {
        return recursiveSumHelper(list, 0, 0);
    }
    public static int recursiveFactorial(int n) {
        if ((n == 1)||(n==0)) {
            return 1;
        }
        if (n > 1) {
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
        if (n > 1) {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
        if (n == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static boolean recursivePalindrome(String word){
        return recursivePalindromeHelper(word, 0);
    }
    public static boolean recursivePalindromeHelper(String word, int index){
        boolean currentIndexMatchesPalindrome = word.charAt(index) == word.charAt(word.length() - index - 1);
        boolean reachedHalfOfWord = index >= word.length() / 2;
        if (currentIndexMatchesPalindrome && !reachedHalfOfWord) {
            return recursivePalindromeHelper(word, index + 1);
        } else if (currentIndexMatchesPalindrome && reachedHalfOfWord) {
            return true;
        }
        return false;
    }
}

