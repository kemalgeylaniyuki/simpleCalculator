package com.kemalgeylani.mycalculator;

public class Singleton {

    private static Singleton singleton = new Singleton();
    private int sentNumber1;
    private int SentNumber2;

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }

    public int getSentNumber1() {
        return sentNumber1;
    }

    public void setSentNumber1(int sentNumber1) {
        this.sentNumber1 = sentNumber1;
    }

    public int getSentNumber2() {
        return SentNumber2;
    }

    public void setSentNumber2(int sentNumber2) {
        SentNumber2 = sentNumber2;
    }
}
