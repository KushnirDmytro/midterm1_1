import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class Turnique {
    final String turniqueID;
    Date thisDay;
    Register ourRegister; //suppose to be unique

    Turnique(String turniqueID, Date validDate, Register ourRegister){
        this.turniqueID = turniqueID;
        this.thisDay = validDate;
        this.ourRegister = ourRegister;
    }


    public void setDay(Date validDate){
        this.thisDay = validDate;
    }

    public void updateRegisterLink(Register newRegister) {
        this.ourRegister = newRegister;
    }

    private void writeLog(ISkyPass pass,
                          boolean result,
                          Time time){

        ourRegister.logger.addLog(new LogRecord(
                pass.getSpec(),
                result,
                this.thisDay,
                time,
                this.turniqueID) );
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
                    writeLog(pass, true, (Time) Calendar.getInstance().getTime());
                    return true;
                }
                else if (pass.getRestrictionType() == RestrictionType.DAYSLIMITED){
                    if ( ((LimitedForDaysPass)pass).getExpire().after(thisDay) ){
                        writeLog(pass, true, (Time) Calendar.getInstance().getTime());
                        return true;
                    }
                }
                else if(pass.getRestrictionType() == RestrictionType.DRIVESLIMITED){
                    if (((LimitedForDrivesPass)pass).getDrivesLeft() > 0){
                        ((LimitedForDrivesPass)pass).removeOneDrive();
                        writeLog(pass, true, (Time) Calendar.getInstance().getTime());
                        return true; // allowed ride & removed one
                    }
                }
                else throw new InputMismatchException("reading from pass failed"); // reading process failed situation
            }
            writeLog(pass, false, (Time) Calendar.getInstance().getTime());
            return false;
        }
    }
}
