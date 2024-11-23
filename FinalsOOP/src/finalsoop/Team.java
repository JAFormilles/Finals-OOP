package finalsoop;
import java.util.ArrayList;

public class Team {
    private ArrayList<String> achievements;
    private Region region;
    
    
    public Team(ArrayList<String> achievements, Region region){
        this.achievements = achievements;
        this.region = region;
    }
    public Team(Region region){
        this.region = region;
    }
    
    //Setter n Getter
    public void addAchievement(String userAchievement){
        achievements.add(userAchievement);
    }
    public void removeAchievement(String userAchievement){
        if(achievements.contains(userAchievement)){
            achievements.remove(userAchievement);
            System.out.println("Achievement removed: " + userAchievement);
        } else {
            System.out.println("Achievement not found: " + userAchievement);
        }
    }
    
    public ArrayList<String> getAchievement(){
        return achievements;
    }
    
    public void setRegion(Region region){
        this.region = region;
    }
    
    public Region getRegion(){
        return region;
    }
}
