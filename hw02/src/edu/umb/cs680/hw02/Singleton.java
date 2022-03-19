package edu.umb.cs680.hw02;

public class Singleton {
    private static Singleton single_instance = null;
    public String s;
 
    private Singleton()
    {
        
    }

    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}
 
