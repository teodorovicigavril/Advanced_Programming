package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board{
    private int n;
    private ArrayList<Token> tokens;

    public synchronized Token getToken() throws InterruptedException {
        // METODA MAI SIMPLA DE A RETURNA UN TOKEN(NU STIU DACA SI LA FEL DE CORECTA)
//        Main.flag =1;
//        Random random = new Random();
//        Token token = Main.board.getTokens().get(random.nextInt(Main.board.getTokens().size()));
//        Main.board.getTokens().remove(token);
//        Main.flag = 0;

        //return token;

        while(Main.flag == 0 && Main.board.getTokens().size()>0){
            wait();
        }
        Random random = new Random();

        Token token = Main.board.getTokens().get(random.nextInt(Main.board.getTokens().size()));
        Main.board.getTokens().remove(token);
        Main.flag = 0;
        notifyAll();
        //System.out.println("---- " + token.toString());
        return token;
    }

    public Board(){
        this.n = 0;
        this.tokens = new ArrayList<Token>();

    }

    public Board(int n){
        Random random = new Random();
        this.tokens = new ArrayList<>();
        this.n = n;
        for(int i = 0; i <n; i++)
            for(int j = 0; j <n; j++){
                if(i!=j)
                    tokens.add(new Token(i,j,(int)random.nextInt(10)+1));
            }
    }

    public Board(int n, ArrayList<Token> tokens){
        if(n != tokens.size()){
            System.out.println("Size of tokens different than n!");
            return;
        }
        this.n = tokens.size();
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
        this.tokens = tokens; n = tokens.size();
    }

    @Override
    public String toString() {
        return "Board{" +
                "n=" + n +
                ", tokens=" + tokens +
                '}';
    }


}
