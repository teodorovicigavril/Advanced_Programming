package com.company;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Shell {
    private Catalog catalog;

    public Shell(Catalog catalog){
        this.catalog = catalog;
    }

    public void run(){
            try(BufferedReader reader= new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("\nChoose a command with specific parameters!\n" +
                        "\t- add [type id name path]\n" +
                        "\t- list \n" +
                        "\t- play type id name path\n" +
                        "\t- save \n" +
                        "\t- load path\n" +
                        "\t- exit\n");
                String line = reader.readLine();

                while (line != null) {
                    String command;
                    List<String> arguments = new ArrayList<>();

                    if(line.toLowerCase(Locale.ROOT).equals("exit"))
                        break;

                    StringTokenizer st = new StringTokenizer(line);
                    command = st.nextToken();
                    while (st.hasMoreTokens()) {
                        arguments.add(st.nextToken());
                    }

                    if(command.toLowerCase(Locale.ROOT).equals("add")){
                        new AddCommand().executeCommand(this.catalog,arguments);
                    }
                    if(command.toLowerCase(Locale.ROOT).equals("list")){
                        new ListCommand().executeCommand(this.catalog,arguments);
                    }
                    if(command.toLowerCase(Locale.ROOT).equals("save")){
                        new SaveCommand().executeCommand(this.catalog,arguments);
                    }
                    if(command.toLowerCase(Locale.ROOT).equals("load")){
                        LoadCommand aux = new LoadCommand();
                        System.out.println("Size first: " + this.catalog.getItems().size());
                        this.catalog = aux.executeCommandL(this.catalog,arguments);
                        System.out.println("Size after: " + this.catalog.getItems().size());
                    }
                    if(command.toLowerCase(Locale.ROOT).equals("play")){
                        new PlayCommand().executeCommand(this.catalog,arguments);
                    }
                    if(!command.toLowerCase(Locale.ROOT).equals("play") || !command.toLowerCase(Locale.ROOT).equals("load") ||
                    !command.toLowerCase(Locale.ROOT).equals("save") || !command.toLowerCase(Locale.ROOT).equals("list") || !command.toLowerCase(Locale.ROOT).equals("add")){
                        throw new InvalidCatalogException("Command: " + command + " unknown!!!");
                    }
                    System.out.println("\nChoose a command with specific parameters!\n" +
                            "\t- add [type id name path]\n" +
                            "\t- list \n" +
                            "\t- play type id name path\n" +
                            "\t- save \n" +
                            "\t- load path\n" +
                            "\t- exit\n");
                    line = reader.readLine();

                }
            } catch (IOException | InvalidCatalogException | ClassNotFoundException e) {
                e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Shell{" +
                "catalog=" + catalog +
                '}';
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }
}
