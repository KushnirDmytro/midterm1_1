package SkyPasses;

import InterfacesPass.ILimitedForDays;
import SpecsPass.SpecDaysLimited;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class LimitedForDaysWeekendPass extends LimitedForDaysPass implements ILimitedForDays {
    public LimitedForDaysWeekendPass(SpecDaysLimited spec){
        this.spec = spec;
    }
}
