package com.company;

import java.util.List;
import java.util.Locale;

public class PlayCommand extends Command{

    @Override
    public void executeCommand(Catalog catalog, List<String> arguments) throws InvalidCatalogException {
        System.out.println("Playing an Item!");
        int lenght = arguments.size();
        Item aux = null;
        System.out.println(catalog.getItems().size());

        if(lenght >= 1){
            if(arguments.get(0).toLowerCase(Locale.ROOT).equals("song"))
            {
                aux = new Song();
            }
            if(arguments.get(0).toLowerCase(Locale.ROOT).equals("image"))
            {
                aux = new Image();
            }

            if(lenght >= 2){
                aux.setId(arguments.get(1));
            }
            if(lenght >= 3){
                aux.setName(arguments.get(2));
            }
            if(lenght >= 4){
                aux.setPath(arguments.get(3));
            }
        }else{
            System.out.println("You should give some arguments!");
        }

        if(lenght>0) {
            catalog.play(catalog,aux);
            System.out.println("Play done!");
        }
    }
}
