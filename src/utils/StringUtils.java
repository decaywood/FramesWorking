package utils;

import java.util.Date;

/**
 * @author: decaywood
 * @date: 2015/9/24 14:25
 */
public class StringUtils {

    public static Date[] timeTransform(String param) {
        Date[] dates = new Date[2];
        dates[0] = new Date();
        dates[1] = new Date();
        return dates;
    }
}
