package com.company;

import java.util.List;

public class ListCommand extends Command{
    @Override
    public void executeCommand(Catalog catalog, List<String> arguments) {
        System.out.println("Printing the content of catalog...");
        catalog.list();
    }
}
