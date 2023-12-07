package org.javaacadmey.wonder_field;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.javaacadmey.wonder_field.player.Player;



public class Game {
    private final int playerCount = 3;
    private final int roundCount = 4;
    private final int groupRoundCount = 3;
    private final int indexOfTheFinalRound = 3;
    public static Scanner scan = new Scanner(System.in);
    private String[] questions = new String[4];
    private String[] answers = new String[4];
    private Player[] winners = new Player[4];
    Tableau tableau;
    Yakubovich yakubovich;

    public void init() {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        for (int i = 0; i < questions.length; i++)  {
            System.out.println("Введите вопрос #" + (i + 1));
            questions[i] = scan.nextLine();
            System.out.println("Введите ответ вопрос #" + (i + 1));
            answers[i] = scan.nextLine();
        }
        System.out.println("Иницализация закончена, игра начнется через 5 секунд");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("задержка неудалась");
        }
        System.out.print("\n".repeat(50));
    }
}
