package SkyPasses;

import InterfacesPass.ILimitedForDrives;
import SpecsPass.SpecDrivesLimited;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public class LimitedForDrivesWorkdayPass extends LimitedForDrivesPass implements ILimitedForDrives {
    public LimitedForDrivesWorkdayPass(SpecDrivesLimited spec){
        this.spec = spec;
    }
}
