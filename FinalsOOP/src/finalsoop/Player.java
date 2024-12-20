package finalsoop;
import java.util.ArrayList;

public class Player extends Person{
    protected String username;
    protected Role role;
    protected Status status;
    protected ArrayList <String> teamAchievements;
    protected ArrayList <String> personalAchievements;
    
    Player(){
        username = null;
        role = null;
        status = Status.UNSIGNED;  
        teamAchievements = new ArrayList<>();
        personalAchievements = new ArrayList<>();
    }
    public void addTeamAchievement(String userAchievement){
        teamAchievements.add(userAchievement);
    }
    public void removeTeamAchievement(String userAchievement){
        if(teamAchievements.contains(userAchievement)){
            teamAchievements.remove(userAchievement);
        } else {
        }
    }
    public ArrayList <String> getTeamAchievements(){
        return teamAchievements;
    }
    
    public void addPersonalAchievement(String userAchievement){
        if(personalAchievements.contains(userAchievement)){
            System.out.println("Personal Achievement already exists.");
        } else {
            personalAchievements.add(userAchievement);
            System.out.println("Personal Achievement added: " + userAchievement);
        }
    }
    public void removePersonalAchievement(String userAchievement){
        if(personalAchievements.contains(userAchievement)){
            personalAchievements.remove(userAchievement);
            System.out.println("Achievement removed: " + userAchievement);
        } else {
            System.out.println("Achievement not found: " + userAchievement);
        }
    }
    public ArrayList <String> getPersonalAchievements(){
        return personalAchievements;
    }
    
    public void setRole(Role userRole){
        role = userRole;
    }
    public Role getRole(){
        return role;
    }
    public void setStatus(Status userStatus){
        status = userStatus;
    }
    public Status getStatus(){
        return status;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public boolean doesPlayerExist(String usernameInput){
    return usernameInput.equalsIgnoreCase(username);
    }
}
