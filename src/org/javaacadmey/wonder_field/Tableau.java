package org.javaacadmey.wonder_field;

public class Tableau {
    private String answer = new String();
    private char[] wordOnTableau;

    public String getAnswer() {
        return answer;
    }



    public void tableauInit(String answer) {
        this.answer = answer.toUpperCase();
        wordOnTableau = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            wordOnTableau[i] = '_';
        }
    }

    public void openLetter(char letter) {
        int[] letterIndexes = Tools.getIndexes(this.answer, Character.toUpperCase(letter));
        for (int i : letterIndexes) {
            wordOnTableau[i] = Character.toUpperCase(letter);
        }
        for (int i = 0; i < this.answer.length(); i++) {
            System.out.print(wordOnTableau[i]);
        }
        System.out.println("");
    }

    public void openWord() {
        System.out.print(answer);
        for (int i = 0; i < answer.length(); i++) {
            wordOnTableau[i] = answer.charAt(i);
        }
    }

    public boolean containsUnknownLetters() {
        for (int i = 0; i < wordOnTableau.length; i++) {
            if (wordOnTableau[i] == '_') {
                return true;
            }
        }
        return false;
    }

    public boolean attributesAreEmpty() {
        String wordOnTableau = null;
        String emptyAtribut = null;
        for (int i = 0; i < this.wordOnTableau.length; i++) {
            wordOnTableau += String.valueOf(this.wordOnTableau[i]);
            emptyAtribut += "_";
        }
        if (wordOnTableau.equals(emptyAtribut) || answer.isEmpty()) {
            return true;
        }
        return false;
    }
}
