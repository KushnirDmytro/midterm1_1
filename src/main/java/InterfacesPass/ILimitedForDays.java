package InterfacesPass;

import EnumsPass.DaysAmountType;

import java.util.Date;

/**
 * Created by D1mD1m on 11/28/2016.
 */
public interface ILimitedForDays extends ILimitedPass {
    DaysAmountType getDaysType();
    Date getExpire();
}
