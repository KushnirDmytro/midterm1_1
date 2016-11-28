import java.sql.Time;
import java.util.Date;

/**
 * Created by D1mD1m on 11/28/2016.
 */

public class LogRecord{
    SkyPassSpec spec;
    boolean result;
    Date date;
    Time time;
    String TurniqueID;

    LogRecord(SkyPassSpec spec,
              boolean result,
              Date date,
              Time time,
              String TurniqueID){

        this.spec = spec;
        this.result = result;
        this.date = date;
        this.time = time;
        this.TurniqueID = TurniqueID;
    }
}
