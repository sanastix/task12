package com.stepanyan;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    /*
    1) Написать метод `String reverse(String s) {...}`.
    Входящий параметр: s - строка которая состоит из слов через пробел.
    Метод должен вернуть слова в обратном порядке.
     */

    public static void main(String[] args) {
        String s = "man has dog";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        for (char c : arr) {
            if (c == ' ') {
                deque.addFirst(String.valueOf(sb));
                sb.setLength(0);
                continue;
            }
            sb.append(c);
        }
        deque.addFirst(String.valueOf(sb));
        return String.valueOf(deque);
    }

}
