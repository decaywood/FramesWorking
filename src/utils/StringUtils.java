package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mamamiyear
 * @date 15-9-24
 */

public class StringUtils {

    public static Date[] timeTransform(String ABSTime) {

        String dateStr = ABSTime.substring(4, 12);
        String timeStr = ABSTime.substring(12);
        Date date;
        Date time;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
            time = new SimpleDateFormat("HHmmss").parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("ABS日期格式错误, 应为:ABS yyyyMMddHHmmss.");
            date = null;
            time = null;
        }
        Date[] dateAndTime = new Date[2];
        dateAndTime[0] = new Date();
        dateAndTime[1] = new Date();
        dateAndTime[0] = date;
        dateAndTime[1] = time;
        return dateAndTime;
    }

}
