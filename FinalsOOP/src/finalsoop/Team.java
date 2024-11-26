package finalsoop;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<String> achievements;
    private Region region;
    private ArrayList<Player> members;
    
    public Team(){
        teamName = null;
        achievements = null;
        region = null;
        members = null;
        achievements = new ArrayList<>();
        members = new ArrayList<>();
    }
    public Team(String teamName, Region region){
        this.teamName = teamName;
        this.region = region;
    }
    public Team(Region region){
        this.region = region;
    }
    
    //Setter n Getter
    public void addMember(Player player){
        members.add(player);
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public String getTeamName(){
        return teamName;
    }
    
    
    public void addAchievement(String userAchievement){
        if(achievements.contains(userAchievement)){
            System.out.println("Team Achievement already exists.");
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
            System.out.println("Team Achievement removed: " + userAchievement);
        } else {
            System.out.println("Team Achievement not found: " + userAchievement);
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
    
    public boolean doesTeamExist(String teamNameInput){
    return teamNameInput.equals(teamName);
    }
    
    public ArrayList<Player> getMembers(){
        return members;
    }
    
    public void removeMember(Player playerToRemove){
        Player toRemove = null;
        
        String playerToRemoveUsername = playerToRemove.getUsername();
        for(Player member : members){
            if(member.getUsername().equals(playerToRemoveUsername)){
                toRemove = member;
                break;
            }
        }
        if(toRemove != null){
            members.remove(toRemove);
        }
                
    }
}
