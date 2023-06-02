package ltd.newimg.sessioncookie.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Exercisel.txt");
        if(file.exists()) {
            System.out.println("File already exists");
        }
        try(PrintWriter output = new PrintWriter(file)){
            String s="";
            for(int i = 0; i < 100; i++){
                s+=(int)(Math.random()*100)+" ";
            }
            output.print(s);
        }
        try (Scanner input = new Scanner(file)){
            String[] string = new String[100];
            int[] array = new int[100];
            for(int i = 0; i < 100; i++) {
                string[i] = input.next();
                System.out.print(string[i]);
                System.out.print(" ");
            }
            System.out.println();
            for(int i = 0; i < 100; i++) {
                array[i] = Integer.parseInt(string[i]);
            }
            Arrays.sort(array);
            for(int i = 0; i < 100; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }
    }
}
