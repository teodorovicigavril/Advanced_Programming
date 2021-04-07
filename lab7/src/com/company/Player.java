package com.company;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private ArrayList<Token> tokens;

    @Override
    public synchronized void run(){
        // METODA MAI SIMPLA DE A EXTRAGE TOKENS(NU STIU DACA SI LA FEL DE CORECTA)
//        if(Main.board.getTokens().size() > 0 && Main.flag == 0) {
//            try {
//                tokens.add(Main.board.getToken());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while(Main.flag == 1 && Main.board.getTokens().size()>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Main.flag = 1;
            if(Main.board.getTokens().size() != 0)
            tokens.add(Main.board.getToken());
            else
                this.
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
