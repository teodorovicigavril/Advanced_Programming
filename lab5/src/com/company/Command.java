package com.company;

import java.io.IOException;
import java.util.List;

abstract public class Command {

    public abstract void executeCommand(Catalog catalog, List<String> arguments) throws InvalidCatalogException, IOException, ClassNotFoundException;
}
