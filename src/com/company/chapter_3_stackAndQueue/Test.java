package com.company.chapter_3_stackAndQueue;

import com.company.chapter_3_stackAndQueue.queue.ArrayQueue;
import com.company.chapter_3_stackAndQueue.stack.ArrayStack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

//        System.out.println(stack.toString());

        stack.pop();

//        System.out.println(stack.toString());
//        System.out.println(isValid("({}})"));
//        System.out.println(isValid2("({})"));


        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }

        System.out.println(queue.toString());
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c=='(' || c =='[' || c=='{') {
                stack.push(c);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }
                Character character = stack.pop();

                if(character=='(' && c!=')') return false;
                if(character=='[' && c!=']') return false;
                if(character=='{' && c!='}') return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s){

        ArrayStack<Character> arrayStack = new ArrayStack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c=='('|| c=='{'||c=='[') {
                arrayStack.push(c);
            }else{
                if (arrayStack.isEmpty())
                    return false;

                Character character = arrayStack.pop();

                if (character=='(' && c!=')') {
                    return false;
                }
                if (character=='{'&& c!='}') {
                    return false;
                }
                if (character=='['&&c!=']') {
                    return false;
                }
            }
        }
        return true;
    }


}











