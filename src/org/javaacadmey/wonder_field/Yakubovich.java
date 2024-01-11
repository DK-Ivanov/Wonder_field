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
            System.out.println("Якубович: приглашаю " + roundNumber + " тройку игроков: " + Tools.combiningLines(players));
        } else if (roundNumber == 4) {
            System.out.println("Якубович: приглашаю победителей групповых этапов: " + Tools.combiningLines(players));
        }
    }

    public void askQuestion(String question) {
        System.out.println("Якубович: Внимание вопрос!\n" + question);
    }

    public void winShout(String name, String city, int roundNumber) {
        if (roundNumber <= 3) {
            System.out.println("Якубович: Молодец! " + name + " из города " + city + " проходит в финал!\n");
        } else {
            System.out.println("Якубович: И перед нами победитель Капитал шоу поле чудес! Это " + name + " из города " + city);
        }
    }

    public boolean checkPlayerAnswer(String playerAnswer, String answer, Tableau tableau) {
        boolean wrong = false;
        if (playerAnswer.length() == 1) {
            if (answer.contains(playerAnswer)) {
                System.out.println("Якубович: Есть такая буква, откройте ее!");
                System.out.println("__________________________________");
                tableau.openLetter(playerAnswer.charAt(0));
                System.out.println("__________________________________");
            } else {
                System.out.println("Якубович: Нет такой буквы! Следующий игрок, крутите барабан!");
                System.out.println("__________________________________\n");
                wrong = true;
            }
        } else if (playerAnswer.length() > 1) {
            if (answer.equals(playerAnswer)) {
                System.out.println("Якубович: " + playerAnswer + "!" + " Абсолютно верно!");
                System.out.println("__________________________________");
                tableau.openWord();
                System.out.println("\n__________________________________");
            } else {
                System.out.println("Якубович: Неверно! Следующий игрок!");
                System.out.println("__________________________________\n");
                wrong = true;
            }
        }
        return wrong;
    }

}
