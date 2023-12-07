package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.Tools;

public class Player {
    private String name;
    private String city;
    PlayerAnswer answer;

    public char shoutLetter() {
        String letter = Tools.checkLetter();
        System.out.println("Игрок " + name + ": буква " + letter);
        return letter.charAt(0);
    }

    public void sayWord() {
        String word = Game.scan.nextLine().toUpperCase();
        System.out.println("Игрок " + name + ": слово " + word);
    }

    public String go() {
        System.out.println("Ход игрока " + name + ", " + city);
        System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
        String typeOfAnswer = Tools.checkTypeOfAnswer();
        answer.setTypeOfAnswer(typeOfAnswer);
        return typeOfAnswer;
    }

    public String playerInit() {
        String name = Game.scan.nextLine();
        String city = Game.scan.nextLine();
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.city = city.substring(0, 1).toUpperCase() + city.substring(1);
        return name + ", " + city;
    }
}
