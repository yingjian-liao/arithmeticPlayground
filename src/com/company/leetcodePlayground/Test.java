package com.company.leetcodePlayground;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String[] array = {"5", "2", "C", "D", "+"};
        String[] array2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(array2));
    }


    public static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {

            switch (op) {
                case "C":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                case "D":
                    if (!stack.isEmpty())
                        stack.push(stack.peek() * 2);

                    break;
                case "+":
                    int top = stack.pop();
                    int newtop = top + stack.peek();
                    stack.push(top);
                    stack.push(newtop);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
                    break;
            }
        }
        int sum = 0;

        for (Integer integer : stack) {
            sum += integer;
        }

        return sum;
    }
}
