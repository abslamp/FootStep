package timer.common;

import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Log4j2
public class DateUtils {

    private static SimpleDateFormat sdf ;

    static {
         sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static void main(String[] args) {

        Date now = new Date();

        System.out.println(now);
        System.out.println(getNextOrBeforeDay(now,-2));
        System.out.println(getWeek(now));
        System.out.println(getFormatString(now ));
    }

    /**
     * 获得指定日期周围的某一天
     *
     * @param aDay
     * @param delta
     * @return
     */
    public static Date getNextOrBeforeDay(Date aDay,int delta) {

        String specifiedDay = sdf.format(aDay);
        Calendar calendar = Calendar.getInstance();

        Date date = null;
        try {
            date = sdf.parse(specifiedDay);
        } catch (ParseException e) {
            log.error(date+"==>>"+e.toString());
        }
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + delta);

        String newDay = sdf.format(calendar.getTime());

        Date result = null;
        try {
            result = sdf.parse(newDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        week = week < 0 ? 0 : week;
        return week;
    }

    public static String getFormatString(Date date){
        return sdf.format(date);
    }

}

