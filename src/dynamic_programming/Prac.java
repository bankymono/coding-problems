package dynamic_programming;

import java.util.*;

public class Prac {
    public static void main(String[] args) {
       /* Q. How do you find frequency of each character in a string using Java 8 streams?

                Input: Java Concept Of The Day
        Output:{ =4, a=3, c=1, C=1, D=1, e=2, f=1, h=1, J=1, n=1, O=1, o=1, p=1, T=1, t=1, v=1, y=1}
        */

        String input = "Java Concept Of The Day";
        Map<Character, Integer> charMap = new HashMap<>();

        char[] arrs = input.toCharArray();
        List<Character> listChar = new ArrayList<>();
        for(char cha : arrs) {
            listChar.add(cha);
        }

        System.out.println(listChar);
        listChar = listChar.stream().peek(cha -> charMap.put(cha, charMap.getOrDefault(cha, 0) + 1)).toList();

        System.out.println(charMap);

    }
}
