package org.example;



import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class exception {


    public static void execute1(){
        try{
            FileInputStream fs = new FileInputStream("C:/a.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error no such fire");
            e.printStackTrace();
        }
    }

    public static void execute2() throws FileNotFoundException{
        FileInputStream fs = new FileInputStream("C:/a.txt");
        throw new FileNotFoundException();
    }
    static class TestException extends Exception{

    }
    public static void main(String[] args) {

        int a = 0;
        int b = 1;
        int c = b/a;

    }
}
