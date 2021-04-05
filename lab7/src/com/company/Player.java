package com.company;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private ArrayList<Token> tokens;

    @Override
    public void run(){
        if(Main.board.getTokens().size() > 0 && Main.flag == 0)
            tokens.add(Main.board.getToken());
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
    }

    public Player(String name){
        this.name = name;
        this.tokens = new ArrayList<>();
    }

    public Player(String name, ArrayList<Token> tokens) {
        this.name = name;
        this.tokens = tokens;
    }

    public Player() {
        this.tokens = new ArrayList<Token>();
        this.name = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
