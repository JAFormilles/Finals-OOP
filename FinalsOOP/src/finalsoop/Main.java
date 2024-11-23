/*
League of Legends Team Manager Program

Made by:
Basit, Brian Joseph
Formilles, Julius Andrei
Makayan III, Amorsolo
Pitargue, Linus Abel
*/
package finalsoop;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList <Team> teams;
    public static ArrayList <Player> players;
        
    public static void main(String[] args) {
        System.out.println("""
                           [1] Create Team
                           [2] Create Person
                           [3] Search Team
                           [4] Search Person
                           """);
        System.out.print("Choice: ");
    }
    
}
 