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
    public static ArrayList <Team> Teams = new ArrayList<>();
    public static ArrayList <Player> Players = new ArrayList<>();
        
    public static void main(String[] args) {
        while(true){
        System.out.println("");
        System.out.println("""
                           [1] Create Team
                           [2] Create Person
                           [3] Search Team
                           [4] Search Person
                           [5] Exit
                           """);
        System.out.print("Choice: ");
        int choice = input.nextInt();
        switch(choice){
            case 1->{ //Create Team
                // TODO: Prevent Creation if Team Already Exists
                Team tempTeam = new Team();
                String teamNameInput = null;
                Region userRegion = null;
                
                System.out.print("Enter Team Name: ");
                input.nextLine();
                teamNameInput = input.nextLine();
                tempTeam.setTeamName(teamNameInput);
                
                System.out.println("(LCK LPL LEC LTA LCP)");
                System.out.print("Enter Region choice: ");
                String regionChoice = input.nextLine().toUpperCase();
                userRegion = Region.valueOf(regionChoice);
                tempTeam.setRegion(userRegion);
                
                Teams.add(tempTeam);
                System.out.println("Team Created Successfully.");
                
                
            }
            case 2->{ //Create Person/Player/Coach
                System.out.println("Choose what type to create:");
                System.out.println("[1] Player");
                System.out.println("[2] Coach");
                System.out.print("Choice: ");
                int personChoice = input.nextInt();
                if(personChoice == 1){
                    Player tempPlayer = new Player();

                    System.out.print("Enter Player's Username: ");
                    String usernameInput = input.nextLine();
                    tempPlayer.setUsername(usernameInput);
                    
                    System.out.println("(Top, Jungle, Middle, Bottom, Support)");
                    System.out.print("Enter Region choice: ");
                    String roleInput = input.nextLine().toUpperCase();
                    Role roleChoice = Role.valueOf(roleInput);
                    tempPlayer.setRole(roleChoice);
                    
                }
            }
            case 3->{ //Search Teams
                displayAllTeams();
                System.out.print("Enter Team Name to search: ");
                    input.nextLine();
                    String searchTeamName = input.nextLine();
                    Team foundTeam = searchTeamByName(searchTeamName);
                    
                    if (foundTeam != null) {
                        System.out.println("Team found: " + foundTeam.getTeamName() + " in " + foundTeam.getRegion());
                    } else {
                        System.out.println("Team not found.");
                    }
            }
            case 4->{ //Search Players
                displayAllPlayers();
                System.out.print("Enter Player Username to search: ");
                    input.nextLine();
                    String searchUsername = input.nextLine();
                    Player foundPlayer = searchPlayerByUsername(searchUsername);
                    
                    if (foundPlayer != null) {
                        System.out.println("Player found: " + foundPlayer.getUsername());
                    } else {
                        System.out.println("Player not found.");
                    }
            }
            case 5->{
                choice = 5;
            }
        }
        if(choice == 5){
           break; 
            }
        }
    }
    public static Team searchTeamByName(String teamName) {
        for (Team team : Teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    public static Player searchPlayerByUsername(String username) {
        for (Player player : Players) {
            if (player.getUsername().equalsIgnoreCase(username)) {
                return player;
            }
        }
        return null;
    }
    
        public static void displayAllPlayers() {
        if (Players.isEmpty()) {
            System.out.println("No players available.");
        } else {
            System.out.println("List of Players:");
            System.out.println("[Username] - [Role]");
            for (Player player : Players) {
                System.out.println(player.getUsername() + " - " + player.getRole());
            }
        }
    }

    public static void displayAllTeams() {
        if (Teams.isEmpty()) {
            System.out.println("No teams available.");
        } else {
            System.out.println("List of Teams:");
            System.out.println("[Team Name] - [Region]");
            for (Team team : Teams) {
                System.out.println(team.getTeamName() + " - " + team.getRegion());
            }
        }
    }
}
 