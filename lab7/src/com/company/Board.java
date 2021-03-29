package com.company;

import java.util.ArrayList;

public class Board implements Runnable{
    private int n;
    private ArrayList<Token> tokens;

    @Override
    public void run() {
        // some code here...

    }

    public synchronized Token getToken(){
        int aux = (int)(Math.random()*10%n);
        Token auxToken = tokens.get(aux);
        tokens.removeIf(index -> index == auxToken);
        return auxToken;
    }

    public Board(){
        this.n = 0;
        this.tokens = new ArrayList<Token>();

    }

    public Board(int n, ArrayList<Token> tokens){
        this.n = n;
        this.tokens = tokens;
    }

    public int getN() {
        return n;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "Board{" +
                "n=" + n +
                ", tokens=" + tokens +
                '}';
    }


}
