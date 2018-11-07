package Util;

import java.time.LocalDate;

public class DateUtil {
    public boolean dateValidate(String date){
        LocalDate fDate;
        try {
            String[] dateArr = date.split("/");
            fDate = LocalDate.of(
                    Integer.valueOf(dateArr[2]),
                    Integer.valueOf(dateArr[1]),
                    Integer.valueOf(dateArr[0]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }

        LocalDate currDate = LocalDate.now();

        if(fDate.getYear() <  currDate.getYear()){
            return false;
        } else if(fDate.getYear() ==  currDate.getYear() &&
                fDate.getMonthValue() < currDate.getMonthValue()){
            return false;
        } else if (fDate.getYear() ==  currDate.getYear() &&
                fDate.getMonthValue() == currDate.getMonthValue() &&
                fDate.getDayOfMonth() < currDate.getDayOfMonth()){
            return false;
        }
        return true;
    }
}
