package com.company;

public class Token {
    private int initial;
    private int finall;
    private int value;

    public Token() {
        this.initial = 0;
        this.finall = 0;
        this.value = 0;
    }

    public Token(int initial, int finall, int value) {
        this.initial = initial;
        this.finall = finall;
        this.value = value;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public void setFinall(int finall) {
        this.finall = finall;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getInitial() {
        return initial;
    }

    public int getFinall() {
        return finall;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "initial=" + initial +
                ", finall=" + finall +
                ", value=" + value +
                '}';
    }
}
