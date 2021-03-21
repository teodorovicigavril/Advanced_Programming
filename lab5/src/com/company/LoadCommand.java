package com.company;

import java.io.IOException;
import java.util.List;

public class LoadCommand extends Command{

    public Catalog executeCommandL(Catalog catalog, List<String> arguments) throws IOException, ClassNotFoundException {
        return CatalogUtil.load(arguments.get(0));
    }

    @Override
    public void executeCommand(Catalog catalog, List<String> arguments) throws IOException, ClassNotFoundException {
        catalog = CatalogUtil.load(arguments.get(0));
        System.out.println("Catalog size din load1: " + catalog.getItems().size());
    }
}
