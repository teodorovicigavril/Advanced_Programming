package com.company;


import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        Class cls = null;
        try {
            cls = Class.forName("com.company.Testing");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File f = new File("C:\\Users\\40756\\Desktop\\gabii\\iasi\\ANUL 2\\sem 2\\ap\\lab4\\out\\production\\lab4\\com\\company\\Student.class");
        URL urls[] = new URL[1];
        urls[0]= f.toURI().toURL();
        ClassLoader cl = new URLClassLoader(urls);
        cl.loadClass("com.company.Testing");


        for (Method m : cls.getMethods()) {
            System.out.println(m.getName());
        }

    }
}