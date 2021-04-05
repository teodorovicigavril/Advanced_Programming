package com.company;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {
    public static Board board = new Board(4);
    public static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        /*int n = 6;
        Token t12 = new Token(1,2,3);
        Token t13 = new Token(1,3,4);
        Token t21 = new Token(2,1,5);
        Token t23 = new Token(2,3,1);
        Token t31 = new Token(3,1,5);
        Token t32 = new Token(3,2,2);

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(t12);
        tokens.add(t13);
        tokens.add(t21);
        tokens.add(t23);
        tokens.add(t31);
        tokens.add(t32);

        Board board1 = new Board(n,tokens);

        Player player1 = new Player();
        player1.setName("");
        Player player2 = new Player();
        Player player3 = new Player();
        System.out.println();
        */

        Runnable r1 = new Player("r1");
        Runnable r2 = new Player("r2");
        Runnable r3 = new Player("r3");


        while(Main.board.getTokens().size() > 0){
            new Thread(r1).start();
            new Thread(r2).start();
            new Thread(r3).start();
        }

        sleep(1000);
        System.out.println(((Player)r1).getTokens().size());
        System.out.println(((Player)r2).getTokens().size());
        System.out.println(((Player)r3).getTokens().size());
    }
}
