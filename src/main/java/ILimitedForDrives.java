/**
 * Created by D1mD1m on 11/28/2016.
 */
public interface ILimitedForDrives extends ILimitedPass {
    DrivesAmountType getDrivesType();
    int getDrivesLeft();
}
