package com.common;

import java.util.Calendar;

/**
 * Created by hestersmile on 2016/12/28.
 */
public class DateUtil {
    public static String getNowDateStr(String separator){
          Calendar now = Calendar.getInstance();
          int year = now.get(Calendar.YEAR);
          int month = now.get(Calendar.MONTH)+1;
           int day = now.get(Calendar.DATE);

           return year + separator + month + separator + day;
       }
}
