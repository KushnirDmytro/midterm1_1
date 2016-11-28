package SkyPasses;

import InterfacesPass.ILimitedForDrives;
import SpecsPass.SpecDrivesLimited;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class LimitedForDrivesWeekendPass extends LimitedForDrivesPass implements ILimitedForDrives {
    public LimitedForDrivesWeekendPass(SpecDrivesLimited spec){
        this.spec = spec;
    }
}
