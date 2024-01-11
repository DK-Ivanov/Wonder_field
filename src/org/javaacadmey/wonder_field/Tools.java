package org.javaacadmey.wonder_field;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Tools {
    public static int[] getIndexes(String word, char letter) {
        int countIndex = 0; // кол-во индексов
        char[] split = new char[word.length()];
        for (int i = 0; i < split.length; i++) {
            split[i] = word.charAt(i);
            if (split[i] == letter) {
                countIndex++;
            }
        }
        int[] index = new int[countIndex];
        int a = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i] == letter) {
                index[a] = i;
                a++;
            }
        }
        return index;
    }

    public static String checkLetter() {
        String letter = new Scanner(System.in).nextLine().toUpperCase();
        if (!Pattern.matches(".*\\p{InCyrillic}.*", letter)) {
            System.out.println("Ошибка! Это не русская буква, введите русскую букву");
            letter = checkLetter();
        } else if (letter.length() > 1) {
            System.out.println("Ошибка! Введите одну букву");
            letter = checkLetter();
        }
        return letter;
    }

    public static String checkTypeOfAnswer() {
        String typeOfAnswer = new Scanner(System.in).nextLine();
        if (!Pattern.matches("[бс]", typeOfAnswer) || typeOfAnswer.length() > 1 || typeOfAnswer.length() < 1) {
            System.out.println("Некорректное значение, введите 'б' или 'с'");
            typeOfAnswer = checkTypeOfAnswer();
        }
        return typeOfAnswer;
    }

    public static String combiningLines(String[] lines) {
        String combinedLines = new String();
        for (int i = 0; i < lines.length; i++) {
            combinedLines += lines[i] + ", ";
        }
        return combinedLines.substring(0, combinedLines.length() - 2);
    }

}

