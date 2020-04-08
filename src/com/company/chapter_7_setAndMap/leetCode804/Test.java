package com.company.chapter_7_setAndMap.leetCode804;

import java.util.TreeSet;

public class Test {

    static String  code[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


    public static void main(String[] args) {

//        String words[] = {"abc"
////                ,"bac"
//        };


String words[] = {"gin", "zen", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(words));
    }


    public static int uniqueMorseRepresentations(String[] words) {
        TreeSet<String> treeSet = new TreeSet<>();


        for (String word : words) {
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                String s = code[word.charAt(i) - 'a'];
                String str = s;
                res.append(str);
            }

            treeSet.add(res.toString());
        }


        for (String s : treeSet) {
            System.out.println(s);
        }

        return treeSet.size();
    }
}
