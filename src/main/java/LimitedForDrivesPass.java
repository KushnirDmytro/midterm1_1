/**
 * Created by D1mD1m on 11/28/2016.
 */
public  class LimitedForDrivesPass extends LimitedPass implements ILimitedForDrives{
    SpecDrivesLimited spec;


    public DrivesAmountType getDrivesType() {
        return ((SpecDrivesLimited)this.spec).drivesType;
    }

    public int getDrivesLeft() {
        return ((SpecDrivesLimited)this.spec).drivesLeft;
    }
}
