/**
 * Created by D1mD1m on 11/28/2016.
 */
public abstract class LimitedForDaysPass extends LimitedPass implements ILimitedForDays{
    // contains SpecDaysLimited spec;

    public DaysAmountType getDaysType() {
        return ((SpecDaysLimited)this.spec).daysType;
    }

}
