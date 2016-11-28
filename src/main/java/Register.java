import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class Register{

    ArrayList<String> blockedRegister;

    private static Register ourInstance = new Register();

    public static Register getInstance() {
        return ourInstance;
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

    private Register() {
        public ISkyPass passesFactory(SkyPassSpec spec){
        }



    }

    public void verify(BanningRequest thisRequest){
        if (blockedRegister.contains(thisRequest.getID())){
            thisRequest.setBanned(true);
        }
    }

}
