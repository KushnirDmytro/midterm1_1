import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public interface ISkyPass {
    String getID();
    SkyPassTypes getType();
    Date getExpire();
    RestrictionType getRestrictionType();
}