package SkyPasses;

import EnumsPass.RestrictionType;
import EnumsPass.SkyPassTypes;
import InterfacesPass.ISkyPass;
import SpecsPass.SkyPassSpec;

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

    public RestrictionType getRestrictionType() {
        return this.spec.restrictionType;
    }

    public SkyPassSpec getSpec(){
        return this.getSpec();
    }
}
