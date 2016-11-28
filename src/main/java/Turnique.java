import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.Date;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class Turnique implements Observable{
    Date thisDay;

    public void addListener(InvalidationListener listener) {

    }

    public void removeListener(InvalidationListener listener) {

    }

    class Validator{
        public Boolean validate(ISkyPass pass){
            if (pass.getExpire().after(thisDay)){
                if (pass.getID())
            }
        }
    }
}
