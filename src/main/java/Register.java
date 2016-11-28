import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;

import java.sql.Time;
import java.util.*;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class Register{
    /**
     * singletone class woth double functions: contains banned register, performs verification, creates new Passes
     */
    ArrayList<String> blockedRegister;
    private ArrayList<LogRecord> SkyPassLog;
    Logger logger;

    private Register() {
        this.logger = new Logger();
        blockedRegister = new ArrayList<String>();
    }

    private static Register ourInstance = new Register();

    public static Register getInstance() {
        return ourInstance;
    }



    public static ISkyPass stPassesFactory(SkyPassSpec spec){
        if (spec.restrictionType == RestrictionType.UNLIMITED){
            return new UnlimitedPass((UnlimitedSkyPassSpec) spec);
        }
        else if (spec.restrictionType == RestrictionType.DAYSLIMITED){
            if (spec.passType == SkyPassTypes.WEEKEND){
                return new LimitedForDaysWeekendPass((SpecDaysLimited) spec);
            }
            if (spec.passType == SkyPassTypes.WORKDAYS){
                return new LimitedForDaysWorkdayPass((SpecDaysLimited) spec);
            }
        }
        else if (spec.restrictionType == RestrictionType.DRIVESLIMITED){
            if (spec.passType == SkyPassTypes.WEEKEND){
                return new LimitedForDrivesWeekendPass((SpecDrivesLimited) spec);
            }
            if (spec.passType == SkyPassTypes.WORKDAYS){
                return new LimitedForDrivesWorkdayPass((SpecDrivesLimited) spec);
            }
        }
        throw new InputMismatchException("spec type for SkyPass is unrecognised");
    }



    class IDGenerator{
        Integer lastID = 00000000; //just for case
        Integer buf;
        public String generateNewID(){
            lastID+=1;
            StringBuilder result = new StringBuilder();
            buf = lastID % 100000000;
            result.append(buf.toString());
            buf = buf % 10000000;
            result.append(buf.toString());
            buf = buf % 1000000;
            result.append(buf.toString());
            buf = buf % 100000;
            result.append(buf.toString());
            buf = buf % 10000;
            result.append(buf.toString());
            buf = buf % 1000;
            result.append(buf.toString());
            buf = buf % 100;
            result.append(buf.toString());
            buf = buf % 10;
            result.append(buf.toString());
            lastID+=1;
            return result.toString();
        }
    }


    public class Logger{

        void addLog(LogRecord record){
            SkyPassLog.add(record);
        }


        ArrayList<LogRecord> getRawLogs(){
            return SkyPassLog;
        }
    }

    public void verify(BanningRequest thisRequest){
        if (blockedRegister.contains(thisRequest.getID())){
            thisRequest.setBanned(true);
        }
    }

}
