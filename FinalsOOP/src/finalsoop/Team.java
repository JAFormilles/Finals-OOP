package finalsoop;
import java.util.ArrayList;

public class Team {
    private ArrayList<String> achievements;
    private Region region;
    
    
    public Team(ArrayList<String> achievements, Region region){
        this.achievements = achievements;
        this.region = region;
    }
    
    //Setter n Getter
    public void addAchievement(String userAchievement){
        achievements.add(userAchievement);
    }
    public ArrayList<String> getAchievement(){
        return achievements;
    }
}
