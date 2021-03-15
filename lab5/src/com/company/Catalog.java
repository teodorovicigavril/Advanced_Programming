package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    private ArrayList<Entry> items;

    public Catalog(ArrayList<Entry> items) {
        this.items = new ArrayList<>();
        this.items = items;
    }

    public Catalog() {
        this.items = new ArrayList<>();
    }


    public void add(Entry item){
        this.items.add(item);
    }

    public void list(){
        for(int i =0; i< this.items.size(); i++){
            System.out.println(this.items.get(i).getName());
        }
    }

    public void play(Entry item){
        File file = null;
        for(int i =0; i< this.items.size(); i++)
            if(this.items.get(i) == item)
                file = new File(items.get(i).getPath());


            if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) desktop.open(file);

        } catch( IOException e){
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void save(String fileToWriteTo){
        if(fileToWriteTo == null)
            fileToWriteTo = "output.txt";
        try {
            //FileWriter myWriter = new FileWriter(fileToWriteTo);
            FileWriter myWriter = new FileWriter("C:\\Users\\40756\\Desktop\\gabii\\iasi\\ANUL 2\\sem 2\\ap\\lab5\\src\\com\\company\\output.txt");
            for(int i =0; i< items.size(); i++){
                myWriter.write(items.get(i).getName());
                myWriter.write("\n");
                myWriter.write(items.get(i).getPath());
                myWriter.write("\n");
               // myWriter.write(items.get(i).getType());
               // myWriter.write("\n");

                //myWriter.write("\n");
            }
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void load(String file){
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                String path = myReader.nextLine();
                //String typeAux = myReader.nextLine();
               /*
                Integer type = Integer.parseInt(typeAux);

                if(type == 1){
                    Song aux = new Song(name, path);
                    this.items.add(aux);
                }
                if(type == 2){
                    Book aux = new Book(name, path);
                    this.items.add(aux);
                }

                */
                Entry aux = new Entry(name, path);
                this.items.add(aux);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setItems(ArrayList<Entry> items) {
        this.items = items;
    }

    public ArrayList<Entry> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "items=" + items +
                '}';
    }
}
