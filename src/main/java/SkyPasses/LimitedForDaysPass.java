package SkyPasses;

import EnumsPass.DaysAmountType;
import InterfacesPass.ILimitedForDays;
import SpecsPass.SpecDaysLimited;

import java.util.Date;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public abstract class LimitedForDaysPass extends LimitedPass implements ILimitedForDays {
    // contains SpecsPass.SpecDaysLimited spec;

    public DaysAmountType getDaysType() {
        return ((SpecDaysLimited)this.spec).daysType;
    }
    public Date getExpire() {
        return ((SpecDaysLimited)this.spec).expireDate;
    }


}
