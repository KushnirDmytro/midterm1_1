import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Date;
import java.util.InputMismatchException;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class Turnique {
    Date thisDay;
    Register ourRegister; //suppose to be unique

    public void setDay(Date validDate){
        this.thisDay = validDate;
    }

    public void updateRegisterLink(Register newRegister) {
        this.ourRegister = newRegister;
    }


    class Validator {
        public Boolean validate(ISkyPass pass) throws InputMismatchException{
            BanningRequest doesBanned;
            try {
                doesBanned = new BanningRequest(pass.getID());
            }
            catch (InputMismatchException e){
                return false; // first case of reading failed
            }
            ourRegister.verify(doesBanned);
            if (!doesBanned.getBanned()){
                if(pass.getRestrictionType() == RestrictionType.UNLIMITED){
                    return true;
                }
                else if (pass.getRestrictionType() == RestrictionType.DAYSLIMITED){
                    if ( ((LimitedForDaysPass)pass).getExpire().after(thisDay) ){
                        return true;
                    }
                }
                else if(pass.getRestrictionType() == RestrictionType.DRIVESLIMITED){
                    if (((LimitedForDrivesPass)pass).getDrivesLeft() > 0){
                        ((LimitedForDrivesPass)pass).removeOneDrive();
                        return true; // allowed ride & removed one
                    }
                }
                else throw new InputMismatchException("reading from pass failed"); // reading process failed situation
            }
            return false;
        }
    }
}
