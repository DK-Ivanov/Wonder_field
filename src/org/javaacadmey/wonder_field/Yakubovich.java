package org.javaacadmey.wonder_field;

public class Yakubovich {
    public void startShow() {
        System.out.println("Якубович: Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void endShow() {
        System.out.println(" Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    public void invitePlayers(String[] players, int roundNumber) {
        if (roundNumber < 4) {
            System.out.print("Якубович: приглашаю" + roundNumber + "тройку игроков: " + Tools.combiningLines(players));
        }
        if (roundNumber == 4) {
            System.out.println("Якубович: приглашаю победителей групповых этапов: " + Tools.combiningLines(players));
        }
    }

    public void askQuestion(String question) {
        System.out.println("Якубович: Внимание вопрос!\n" + question);
    }

    public static void winShout(String name, String city, boolean finalRound) {
        if (!finalRound) {
            System.out.println("Якубович: Молодец! " + name + " из " + city + " проходит в финал!");
        } else {
            System.out.println("Якубович: И перед нами победитель Капитал шоу поле чудес! Это" + name + " из " + city);
        }
    }


}
