/**
 * Created by D1mD1m on 11/28/2016.
 */
public class BanningRequest {
    private Boolean isBanned = false;
    private String ID;
    BanningRequest(String ID){
        this.ID = ID;
    }
    public void setBanned(boolean value){
        this.isBanned = value;
    }

    public String getID(){
        return this.ID;
    }

    public boolean getBanned(){
        return this.isBanned;
    }
}
