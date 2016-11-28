package InterfacesPass;

import EnumsPass.RestrictionType;
import EnumsPass.SkyPassTypes;
import SpecsPass.SkyPassSpec;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public interface ISkyPass {
    String getID();
    SkyPassTypes getType();
    RestrictionType getRestrictionType();
    SkyPassSpec getSpec();
}