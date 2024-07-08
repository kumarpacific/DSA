package com.dsa.phase1.stack;

import java.util.*;


/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward)
 * for which the stock price was less than or equal to the price of that day.
 * <p>
 * For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2,
 * then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
 * Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8,
 * then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
 * <p>
 * ==> Kind of variation of Next Greater to Left, keep the greatest element's index to right in stack and subtract it with the current day price index.
 * we will get the span.
 */
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
//                     { 1, 1, 1, 2, 1, 4, 6 }
//        List<Integer> sol = solve(prices, prices.length);
        List<Integer> sol = calculateSpan(prices);
        System.out.println(sol);
    }

    private static List<Integer> calculateSpan(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> spans = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans.set(i, stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }
        return spans;
    }


    private static List<Integer> solve(int[] prices, int length) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> solution = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                list.add(stack.peek());
            } else if (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            solution.add(i - list.get(i));
        }
        return solution;
    }




}


/**
 * More cleaner code from chat GPT
 */
/*
import java.util.*;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        List<Integer> spans = calculateSpan(prices);
        System.out.println(spans);
    }

    private static List<Integer> calculateSpan(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> spans = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans.set(i, stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }

        return spans;
    }
}


Explanation of the improvements:
Method Naming: Changed the method name to calculateSpan to make its purpose clearer.
Remove Unnecessary Lists: Removed the intermediate list as it was redundant. We can calculate spans directly.
Use of ArrayList: Replaced LinkedList with ArrayList initialized with the required size and default values using Collections.nCopies.
Concise Logic: Combined conditions inside a single while loop to make the code more concise and readable.
Variable Naming: Improved variable names for better readability (length to n, solution to spans).
The updated code maintains the same logic but is cleaner and more efficient.

 */