/**
 * Created by D1mD1m on 11/28/2016.
 */
public  class LimitedForDrivesPass extends LimitedPass implements ILimitedForDrives{
    // contains SpecDrivesLimited spec;

    public void removeOneDrive(){
        if ( ((SpecDrivesLimited)this.spec).drivesLeft > 0 ){
            ((SpecDrivesLimited)this.spec).drivesLeft = ((SpecDrivesLimited)this.spec).drivesLeft - 1;
        }
        else throw new IllegalArgumentException("negative values of drives are forbidden");
    }
    public DrivesAmountType getDrivesType() {
        return ((SpecDrivesLimited)this.spec).drivesType;
    }

    public int getDrivesLeft() {
        return ((SpecDrivesLimited)this.spec).drivesLeft;
    }
}
