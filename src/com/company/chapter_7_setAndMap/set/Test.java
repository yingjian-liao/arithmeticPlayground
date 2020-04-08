package com.company.chapter_7_setAndMap.set;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words);

        System.out.println("Total words："+words.size());

        BSTSet<String> word2 = new BSTSet<>();
        for (String word:
             words) {
            word2.add(word);
        }


        System.out.println("Total different words: "+word2.getSize());

    }
}