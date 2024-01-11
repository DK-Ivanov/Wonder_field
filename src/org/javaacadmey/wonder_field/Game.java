package org.javaacadmey.wonder_field;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.javaacadmey.wonder_field.player.Player;

public class Game {
    private final int playerCount = 3;
    private final int roundCount = 4;
    private final int groupRoundCount = 3;
    private final int indexOfTheFinalRound = 4;
    public static Scanner scan = new Scanner(System.in);
    private String[] questions = new String[4];
    private String[] answers = new String[4];
    private Player[] winners = new Player[3];
    private Tableau tableau = new Tableau();
    private Yakubovich yakubovich = new Yakubovich();

    public void init() {
        System.out.println("Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.");
        for (int i = 0; i < questions.length; i++) {
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

    public Player[] playersInit() {
        Player[] players = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Игрок №" + (i + 1) + " представьтесь: имя, город. Например: Иван, Москва");
            String playerInfo = new Scanner(System.in).nextLine();
            String name = playerInfo.split("\\,")[0];
            String city = playerInfo.split("\\,")[1];
            if (city.substring(0, 1).equals(" ")) {
                city = playerInfo.split("\\,")[1].substring(1);
            }
            players[i] = new Player(name, city);
        }
        return players;
    }

    public String[] recordingOfPlayers(Player[] players) {
        return new String[] {players[0].getName(), players[1].getName(), players[2].getName()};
    }

    public boolean tablueaIsFull() {
        return !tableau.containsUnknownLetters();
    }

    public boolean playerMove(String question, Player movingPlayer) {
        boolean win = false;
        boolean endOfMove = false;
        yakubovich.askQuestion(question);
        end:
        while (true) {
            movingPlayer.move();
            boolean wrong = yakubovich.checkPlayerAnswer(movingPlayer.getAnswer(), tableau.getAnswer(), tableau);
            if (!wrong) {
                if (tablueaIsFull()) {
                    win = true;
                    break end;
                }
            } else if (wrong) {
                win = false;
                break end;
            }
        }
        return win;
    }

    public Player playRound(int roundNumber) {
        Player[] players;
        if (roundNumber == indexOfTheFinalRound) {
            players = winners;
        } else {
            players = playersInit();
        }
        yakubovich.invitePlayers(recordingOfPlayers(players), roundNumber);
        Player winner = null;
        end:
        while (!tablueaIsFull()) {
            boolean win = playerMove(questions[roundNumber - 1], players[0]);
            if (win) {
                yakubovich.winShout(players[0].getName(), players[0].getCity(), roundNumber);
                winner = players[0];
                break end;
            }
            win = playerMove(questions[roundNumber - 1], players[1]);
            if (win) {
                yakubovich.winShout(players[1].getName(), players[1].getCity(), roundNumber);
                winner = players[1];
                break end;
            }
            win = playerMove(questions[roundNumber - 1], players[2]);
            if (win) {
                yakubovich.winShout(players[2].getName(), players[2].getCity(), roundNumber);
                winner = players[2];
                break end;
            }
        }
        return winner;
    }

    public Player[] playAllGroupRounds() {
        Player[] winners = new Player[3];
        for (int i = 0; i < groupRoundCount; i++) {
            tableau.tableauInit(this.answers[i]);
            winners[i] = playRound(i + 1);
        }
        return winners;
    }

    public void playFinalRound() {
        tableau.tableauInit(this.answers[3]);
        Player winner = playRound(4);
    }

    public void start() {
        yakubovich.startShow();
        Player[] players = playAllGroupRounds();
        this.winners = players;
        playFinalRound();
        yakubovich.endShow();
    }

}
