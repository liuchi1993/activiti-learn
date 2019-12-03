package cn.liuc.activitidemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2019/12/3 21:16
 */
public class DateTimeUtil {

    public static final String EMPTY_STRING = "";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final int TIMESTAMP_SECOND_LEN = 10;
    public static final int TIMESTAMP_MILLISECOND_LEN = 13;

    public static String timeStamp2Date(long timeStamp,
                                        String format) {
        if (format == null || format.trim().equals(EMPTY_STRING)) {
            format = DEFAULT_DATE_FORMAT;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        int length = String.valueOf(timeStamp).trim().length();
        if (length == TIMESTAMP_SECOND_LEN) {
            return simpleDateFormat.format(new Date(timeStamp * 1000));
        } else if (length == TIMESTAMP_MILLISECOND_LEN) {
            return simpleDateFormat.format(new Date(timeStamp));
        } else {
            throw new RuntimeException("TimeStamp is invalid");
        }
    }

    public static String timeStamp2Date(long timeStamp) {
        return timeStamp2Date(timeStamp, DEFAULT_DATE_FORMAT);
    }

    public static long timeStampSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static long timeStampMilli() {
        return System.currentTimeMillis();
    }
}
