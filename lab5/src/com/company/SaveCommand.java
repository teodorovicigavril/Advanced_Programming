package com.company;

import java.io.IOException;
import java.util.List;

public class SaveCommand extends Command{
    @Override
    public void executeCommand(Catalog catalog, List<String> arguments) throws IOException {
        CatalogUtil.save(catalog);
    }
}
