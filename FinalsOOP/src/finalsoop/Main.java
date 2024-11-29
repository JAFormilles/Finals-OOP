/*
League of Legends Team Manager Program

Made by:
Basit, Brian Joseph
Formilles, Julius Andrei
Makayan III, Amorsolo
Pitargue, Linus Abel⠀⠀
*/
package finalsoop;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList <Team> Teams = new ArrayList<>();
    public static ArrayList <Player> Players = new ArrayList<>();
        
    public static void main(String[] args) {
        clearScreen();
        while(true){
        try{
        System.out.println("");
        System.out.println("""
                           ================================
                           [LEAGUE OF LEGENDS TEAM MANAGER]
                           ================================
                           [1] Create Team
                           [2] Create Person
                           [3] Search Team
                           [4] Search Person
                           [5] Generate and Display File
                           [6] Exit
                           """);
        System.out.print("Choice: ");
        int choice = 0;
        try{
           choice = input.nextInt(); 
        } 
        catch(InputMismatchException e){
            System.out.println("Incorrect Input.");
            input.nextLine();
        }
        catch (Exception e){
            System.out.println("Error Occured.");
            input.nextLine();
        }
        
        switch(choice){
            case 1->{ //Create Team
                clearScreen();
                Team tempTeam = new Team();
                boolean doesTeamExist = false;
                System.out.print("Enter Team Name: ");
                input.nextLine();
                String teamNameInput = input.nextLine().toUpperCase();
                tempTeam.setTeamName(teamNameInput);
                
                
                for (Team team : Teams) {
                if(team.doesTeamExist(teamNameInput)){
                    doesTeamExist = true;
                    break;
                    }else{
                    doesTeamExist = false;
                    }
                }
                
                if(doesTeamExist == false){
                System.out.println("(LCK LPL LEC LTA LCP)");
                System.out.print("Enter Region: ");
                String regionChoice = input.nextLine().toUpperCase();
                Region userRegion = Region.valueOf(regionChoice);
                tempTeam.setRegion(userRegion);
                
                Teams.add(tempTeam);
                System.out.println("Team Created Successfully.");
                }else{
                    System.out.println("Team Already Exists!");
                }
                
            }
            case 2->{ //Create Person/Player/Coach
                clearScreen();
                System.out.println("Choose what type to create:");
                System.out.println("[1] Player");
                System.out.println("[2] Coach");
                System.out.print("Choice: ");
                int personChoice = input.nextInt();
                if(personChoice == 1){
                    Player tempPlayer = new Player();
                    boolean doesPlayerExist = false;
                    System.out.print("Enter Player's Username: ");
                    input.nextLine();
                    String usernameInput = input.nextLine();
                    for(Player player : Players){
                        if(player.doesPlayerExist(usernameInput)){
                            doesPlayerExist = true;
                            break;
                        }
                    }
                    if(doesPlayerExist){
                        System.out.println("Player Already Exists.");
                        continue;
                    } else {
                        tempPlayer.setUsername(usernameInput);
                    }
                    
                    
                    System.out.println("(Top, Jungle, Middle, Bottom, Support)");
                    System.out.print("Enter Role: ");
                    String roleInput = input.nextLine().toUpperCase();
                    Role roleChoice = Role.valueOf(roleInput);
                    tempPlayer.setRole(roleChoice);
                    
                    Players.add(tempPlayer);
                    System.out.println("Player Created Successfully.");
                }
                else if(personChoice == 2){
                    Coach tempCoach = new Coach();
                    boolean doesPlayerExist = false;

                    System.out.print("Enter Coach's Username: ");
                    input.nextLine();
                    String usernameInput = input.nextLine();
                    for(Player player : Players){
                        if(player.doesPlayerExist(usernameInput)){
                            doesPlayerExist = true;
                            break;
                        }
                    }
                    if(doesPlayerExist){
                        System.out.println("Player Already Exists.");
                        continue;
                    } else{
                        tempCoach.setUsername(usernameInput);
                        tempCoach.setRole(Role.COACH);
                        Players.add(tempCoach);
                        System.out.println("Player Created Successfully.");
                    }

                }
            }
            case 3->{ //Search Teams
                clearScreen();
                displayAllTeams();
                System.out.print("Enter Team Name to search: ");
                    input.nextLine();
                    String searchTeamName = input.nextLine();
                    Team foundTeam = searchTeamByName(searchTeamName);
                    
                    if (foundTeam != null) {
                        System.out.println("Team found: " + foundTeam.getTeamName() + " in " + foundTeam.getRegion());
                        teamMenu(foundTeam);
                    } else {
                        System.out.println("Team not found.");
                    }
                    
            }
            case 4->{ //Search Players
                clearScreen();
                displayAllPlayers();
                System.out.print("Enter Player Username to search: ");
                    input.nextLine();
                    String searchUsername = input.nextLine();
                    Player foundPlayer = searchPlayerByUsername(searchUsername);
                    
                    if (foundPlayer != null) {
                        System.out.println("Player found: " + foundPlayer.getUsername());
                        playerCoachMenu(foundPlayer);
                    } else {
                        System.out.println("Player not found.");
                    }
                
            }
            case 5->{ //Generate File
                clearScreen();
                try(PrintWriter Writer = new PrintWriter("Teams.txt")){
                    Writer.println("[Team Name - Region]");
                 for(Team team : Teams){
                     Writer.println(team.getTeamName() + " - " + team.getRegion());
                 }
            System.out.println("Teams File Generated Successfully.");
        }catch(IOException e){
            System.out.println("Error Occurred: "+e.getMessage());
        }
                
                try(PrintWriter Writer = new PrintWriter("Players.txt")){
                    Writer.println("[Username - Role]");
                    for(Player player : Players){
                        Writer.println(player.getUsername()+" - " + player.getRole());
                    }
                    System.out.println("Players File Generated Successfully.");
                }catch(IOException e){
                    System.out.println("Error Occurred: "+e.getMessage());
                }
                
                System.out.println("");
                System.out.println("Contents of Teams.txt :");
                try(BufferedReader Reader = new BufferedReader(new FileReader("Teams.txt"))){
                    String fileLine;
                    while((fileLine = Reader.readLine()) != null){
                    System.out.println(fileLine);
                }
                }catch(IOException e){
                    e.printStackTrace();
                }
                
                System.out.println("");
                System.out.println("Contents of Players.txt :");
                try(BufferedReader Reader = new BufferedReader(new FileReader("Players.txt"))){
                    String fileLine;
                    while((fileLine = Reader.readLine()) != null){
                    System.out.println(fileLine);
                }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
    
            
            case 6->{ // Exit Program
                choice = 6;
            }
            default ->{
                continue;
            }
        }
        if(choice == 6){
           break; 
            }
        }
        catch(InputMismatchException e){
            System.out.println("Incorrect Input.");
            input.nextLine();
        }
        catch(Exception e){
                System.out.println("Error Occurred.");
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
    
    public static void teamMenu(Team team) {
    while (true) {
        System.out.println("\nTeam Menu:");
        System.out.println("[1] Display Team Details");
        System.out.println("[2] Add Player/Coach");
        System.out.println("[3] Remove Player/Coach");
        System.out.println("[4] Add Team Achievement");
        System.out.println("[5] Remove Team Achievement");
        System.out.println("[6] Delete Team");
        System.out.println("[7] Exit Team Menu");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        input.nextLine(); 

        switch (choice) {
                case 1 -> { //Display Team Details
                    clearScreen();
                    System.out.println("Team Name: " + team.getTeamName());
                    System.out.println("Region: " + team.getRegion());
                    System.out.println("Achievements: " + team.getAchievements());
                    System.out.println("Members: ");
                    if(team.getMembers() == null){
                        System.out.println("No members...");
                        break;
                    }
                    for (Player member : team.getMembers()) {
                        System.out.println(" - " + member.getUsername() + " (" + member.getRole() + ")");
                    }
                }
                case 2 -> { // Add Player/Coach
                clearScreen();
                if (Players.isEmpty()) {
                    System.out.println("No Player/Coach has been created.");
                    break;
                    
                }

                System.out.print("Enter Player/Coach Username: ");
                String username = input.nextLine();
                Player existingPlayer = searchPlayerByUsername(username);
                if (existingPlayer != null) {
                    if (existingPlayer.getStatus() == Status.UNSIGNED) {
                        team.addMember(existingPlayer);
                        existingPlayer.setStatus(Status.ACTIVE);
                        System.out.println("Player/Coach added successfully and status set to ACTIVE.");
                    } else {
                        System.out.println("Player/Coach is currently signed with another team.");
                    }
                } else {
                    System.out.println("Player/Coach not found. Please enter a valid username.");
                }
            }
                case 3 -> { // Remove Player/Coach
                    clearScreen();
                    System.out.print("Enter Username to remove: ");
                    String username = input.nextLine();
                    Player playerToRemove = null;
                    for (Player member : team.getMembers()) {
                        if (member.getUsername().equalsIgnoreCase(username)) {
                            playerToRemove = member;
                            break;
                        }
                    }
                    if (playerToRemove != null) {
                        team.removeMember(playerToRemove);
                        playerToRemove.setStatus(Status.UNSIGNED);
                        System.out.println("Player/Coach removed successfully.");
                    } else {
                        System.out.println("Player/Coach not found.");
                    }
                }
                case 4 -> { // Add Team Achievement
                    clearScreen();
                    System.out.print("Enter Achievement to add: ");
                    String achievement = input.nextLine();
                    team.addAchievement(achievement);
                }
                case 5 -> { // Remove Team Achievement
                    clearScreen();
                    System.out.print("Enter Achievement to remove: ");
                    String achievement = input.nextLine();
                    team.removeAchievement(achievement);
                }
                case 6 -> { // Delete Team
                    clearScreen();
                    System.out.print("Are you sure you want to delete the team '" + team.getTeamName() + "'? (yes/no): ");
                    String confirmation = input.nextLine();
                        if (confirmation.equalsIgnoreCase("yes")) {
                            for (Player member : team.getMembers()) {
                                member.setStatus(Status.UNSIGNED);
                                team.removeMember(member);
                                }
                            Teams.remove(team);
                            System.out.println("Team '" + team.getTeamName() + "' has been deleted.");
                            return; 
                        } else {
                            System.out.println("Team deletion canceled.");
                        }

                }
                case 7 -> {
                    return; 
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void playerCoachMenu(Player player) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlayer/Coach Menu:");
            System.out.println("[1] Display Details");
            System.out.println("[2] Change Status");
            System.out.println("[3] Retire");
            System.out.println("[4] Change Role");
            System.out.println("[5] Add Personal Achievement");
            System.out.println("[6] Remove Personal Achievement");
            System.out.println("[7] Delete Player");
            System.out.println("[8] Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> { // Display Details
                    clearScreen();
                    System.out.println("Player/Coach Details:");
                    System.out.println("Name: " + player.getUsername());
                    System.out.println("Status: " + player.getStatus());
                    System.out.println("Role: " + player.getRole());
                    
                    String signedTeamName = "None (Currently Unsigned)";
                        for (Team team : Teams) {

                            if (team.getMembers().contains(player)) {

                                signedTeamName = team.getTeamName();

                                break; 

                            }

                        }
                    System.out.println("Team Name: " + signedTeamName);

                    System.out.println("Team Achievements: ");
                    System.out.println(player.getTeamAchievements());
                    System.out.println("Personal Achievements: ");
                    System.out.println(player.getPersonalAchievements());
                }
                case 2 -> { // Change Status
                clearScreen();
                System.out.println("(ACTIVE, INACTIVE)");

                System.out.print("Enter Status: ");

                String statusChoice = input.nextLine().toUpperCase(); 


                try {

                    Status userStatus = Status.valueOf(statusChoice); 

                    if (userStatus == Status.UNSIGNED && player.getStatus() != Status.UNSIGNED) {

                        System.out.println("Cannot change status to UNSIGNED while the player is ACTIVE, INACTIVE, or RETIRED.");

                    } else if(userStatus == Status.RETIRED){
                        System.out.println("Cannot change status to RETIRED directly. Use the retire functionality");
                    }
                        
                        else {

                        player.setStatus(userStatus); 

                        System.out.println("Status updated to: " + userStatus);

                    }

                } catch (IllegalArgumentException e) {

                    System.out.println("Invalid status entered. Please enter ACTIVE, INACTIVE.");

                }

            }
                case 3 -> { // Retire
                    clearScreen();
                    player.setStatus(Status.RETIRED);
                    for(Team team : Teams){
                        team.removeMember(player);
                    }
                    System.out.println(player.getUsername() + " has been retired.");
                    return;
                }
                case 4 -> { // Change Role
                    clearScreen();
                    if (player.getRole() == Role.COACH) { 
                        System.out.println("Coaches cannot change their role.");
                    } else {
                        System.out.println("(TOP, JUNGLE, MIDDLE, BOTTOM, SUPPORT)");
                        System.out.print("Enter Role choice: ");
                        String roleChoice = input.nextLine().toUpperCase(); // Read input once and convert to uppercase

                        try {
                            Role userRole = Role.valueOf(roleChoice); // Convert input to Role enum
                            player.setRole(userRole); // Set the player's role
                            System.out.println("Role updated to: " + userRole);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid role entered. Please enter a valid role (TOP, JUNGLE, MIDDLE, BOTTOM, ADC).");
                        }
                    }
            }
                case 5 -> { // Add personal Achievement
                    clearScreen();
                    System.out.print("Enter Achievement to add: ");
                    String achievement = input.nextLine();
                    player.addPersonalAchievement(achievement);
                }
                
                case 6 -> { // Remove Personal Achievement
                    clearScreen();
                    System.out.print("Enter Achievement to remove: ");
                    String achievement = input.nextLine();
                    player.removePersonalAchievement(achievement);
                }
                case 7 -> { // Delete Player
                    clearScreen();
                    System.out.print("Are you sure you want to delete the player '" + player.getUsername() + "'? (yes/no): ");
                    String confirmation = input.nextLine();
                        if (confirmation.equalsIgnoreCase("yes")) {
                            Players.remove(player);
                            for(Team team : Teams){
                                team.removeMember(player);
                            }
                            return;
                        } else {
                            System.out.println("Team deletion canceled.");
                        }
                }
                case 8 -> { //Exit Menu
                    clearScreen();
                    System.out.println("Exiting menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void clearScreen(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
    }
}
 