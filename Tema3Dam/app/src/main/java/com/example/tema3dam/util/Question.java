package com.example.tema3dam.util;

import java.util.Arrays;

public class Question {
    private String question;
    private String[] answers;
    private String answerCorrect;

    public Question(String question, String[] answers, String answerCorrect) {
        this.question = question;
        this.answers=answers;
        this.answerCorrect = answerCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {

        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    @Override
    public String toString() {
         String afisare= "Question{" +
                "question='" + question + '\'' +
                ", answerCorrect='" + answerCorrect + '\'';
         for(int i=0;i< answers.length;i++)
             afisare+=answers[i]+" ";
        return afisare;
    }
}
