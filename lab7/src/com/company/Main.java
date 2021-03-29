package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int n = 6;
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

        Board board = new Board(n,tokens);

        Player player1 = new Player();
        player1.setName("");
        Player player2 = new Player();
        Player player3 = new Player();
        System.out.println();
    }
}
