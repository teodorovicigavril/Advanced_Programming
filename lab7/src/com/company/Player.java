package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Token> tokens;

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
}
