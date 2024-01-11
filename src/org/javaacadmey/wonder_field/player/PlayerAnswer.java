package org.javaacadmey.wonder_field.player;

public class PlayerAnswer {
    private String typeOfAnswer = new String();
    private String answer = new String();

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setTypeOfAnswer(String type) {
        typeOfAnswer = type;
    }

    public String getTypeOfAnswer() {
        return typeOfAnswer;
    }
}
