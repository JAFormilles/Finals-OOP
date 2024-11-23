package finalsoop;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<String> achievements;
    private Region region;
    private ArrayList<Player> members;
    
    
    public Team(String teamName, Region region){
        this.teamName = teamName;
        this.region = region;
    }
    public Team(Region region){
        this.region = region;
    }
    
    //Setter n Getter
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public String getTeamName(){
        return teamName;
    }
    
    
    public void addAchievement(String userAchievement){
        if(achievements.contains(userAchievement)){
            System.out.println("Achievement already exists.");
        } else {
        achievements.add(userAchievement);
        for(Player member : members){
            member.addTeamAchievement(userAchievement);
            }
        System.out.println("Achievement added: " + userAchievement);
        }
    }
    public void removeAchievement(String userAchievement){
        if(achievements.contains(userAchievement)){
            achievements.remove(userAchievement);
            for(Player member : members){
            member.removeTeamAchievement(userAchievement);
            }
            System.out.println("Achievement removed: " + userAchievement);
        } else {
            System.out.println("Achievement not found: " + userAchievement);
        }
    }
    public ArrayList<String> getAchievements(){
        return achievements;
    }
    
    
    public void setRegion(Region region){
        this.region = region;
    }
    public Region getRegion(){
        return region;
    }
}
