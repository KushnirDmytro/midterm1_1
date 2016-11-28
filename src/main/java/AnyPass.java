import java.util.Date;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public abstract class AnyPass implements ISkyPass {
    SkyPassSpec spec;

    public String getID() {
        return this.spec.ID;
    }

    public SkyPassTypes getType() {
        return this.spec.passType;
    }

    public Date getExpire() {
        return this.spec.expireDate;
    }

    public RestrictionType getRestrictionType() {
        return this.spec.restrictionType;
    }
}
