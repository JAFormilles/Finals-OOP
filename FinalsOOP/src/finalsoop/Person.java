package finalsoop;

public abstract class Person {
    protected String username;
    
    protected String Nationality;
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    
    public void setNationality(String userNationality){
        Nationality = userNationality;
    }
    
    public String getNationality(){
        return Nationality;
    }
}
