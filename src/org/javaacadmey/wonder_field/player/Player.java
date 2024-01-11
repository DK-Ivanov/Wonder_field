package org.javaacadmey.wonder_field.player;

import java.util.Scanner;
import org.javaacadmey.wonder_field.Tools;

public class Player {
    private String name;
    private String city;
    private PlayerAnswer answer = new PlayerAnswer();

    public String getAnswer() {
        return answer.getAnswer();
    }

    public String getCity() {
        return city;
    }

    public String getTypeOfAnswer() {
        return answer.getTypeOfAnswer();
    }

    public String getName() {
        return name;
    }

    public Player(String name, String city) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
    }

    public char shoutLetter() {
        String letter = Tools.checkLetter();
        System.out.println("Игрок " + name + ": буква " + letter);
        this.answer.setAnswer(letter);
        return letter.charAt(0);
    }

    public void sayWord() {
        String word = new Scanner(System.in).nextLine().toUpperCase();
        System.out.println("Игрок " + name + ": слово " + word);
        this.answer.setAnswer(word);
    }

    public String move() {
        System.out.println("Ход игрока " + name + ", " + city);
        System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
        String typeOfAnswer = Tools.checkTypeOfAnswer();
        answer.setTypeOfAnswer(typeOfAnswer);
        switch (typeOfAnswer) {
            case "с":
                System.out.println("Введите слово!");
                sayWord();
                break;
            case "б":
                System.out.println("Ведите букву!");
                shoutLetter();
                break;
            default:
                break;
        }
        return typeOfAnswer;
    }

}
