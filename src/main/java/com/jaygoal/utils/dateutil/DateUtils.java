package com.jaygoal.utils.dateutil;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class DateUtils {

    /**
     * 日期字符串（yyyy-MM-dd 格式）转化为日期
     *
     * @param dateTime yyyy-MM-dd格式时间串
     *
     * @return 时间对象
     *
     * @throws ParseException
     */
    public static Date converToDate (String dateTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(DateFormat.DATE_FORMAT);
        return df.parse(dateTime);
    }

    /**
     * 日期字符串转化为日期
     *
     * @param dateTime 时间串
     * @param format   格式
     *
     * @return 时间对象
     *
     * @throws ParseException
     */
    public static Date converToDate (String dateTime, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.parse(dateTime);
    }

    /**
     * 将日期格式化为字符串（yyyy-MM-dd格式）
     *
     * @param date 日期
     *
     * @return 格式化结果
     */
    public static String formatDate (Date date) {
        return formatDate(date, DateFormat.DATE_FORMAT);
    }

    /**
     * 将日期格式化为字符串，自定义格式
     *
     * @param date       日期
     * @param dateFormat 格式
     *
     * @return 格式化后的日期
     */
    public static String formatDate (Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将日期格式化为字符串，自定义格式
     *
     * @param date       日期
     * @param dateFormat 格式
     *
     * @return 格式化后的日期
     */
    public static String formatDate (Long date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将当前日期格式化为字符串（yyyy-MM-dd格式）
     *
     * @return 格式化结果
     */
    public static String formatCurrentDate () {
        return formatCurrentDate(DateFormat.DATE_FORMAT);
    }

    /**
     * 当前日期
     *
     * @return
     */
    public static Date currentDate () {
        return new Date();
    }

    /**
     * 使用自定义格式格式化当前日期
     *
     * @param dateFormat 输出显示的时间格式
     *
     * @return 格式化结果
     */
    public static String formatCurrentDate (String dateFormat) {
        return formatDate(new Date(), dateFormat);
    }

    /**
     * 截取某一时间戳 为yyyy-mm-dd
     *
     * @param dateTime 时间
     *
     * @return
     *
     * @throws ParseException
     */
    public static Date cutTimestampToDate (String dateTime) throws ParseException {
        Date date = converToDate(dateTime, DateFormat.DATE24_FORMAT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();

    }

    /**
     * 获取当前日期前一天
     *
     * @return 前一天的日期
     */
    public static String lastDay () {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return formatDate(date);
    }

    /**
     * 获取当前日期前n天的日期
     *
     * @param n 前n天
     *
     * @return 前n天的日期
     */
    public static String prevDay (int n) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        date = calendar.getTime();
        return formatDate(date);
    }
    public static String prevDay (Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        date = calendar.getTime();
        return formatDate(date);
    }
    /**
     * 获取当前日期后n天的日期
     *
     * @param n
     *
     * @return
     */
    public static String nextDay (int n) {
        return nextDay(new Date(), n);
    }

    /**
     * 日期后n天的日期
     *
     * @param n
     *
     * @return
     */
    public static String nextDay (Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +n);
        date = calendar.getTime();
        return formatDate(date);
    }

    /**
     * @description: (@param)date后n天的日期
     * @param: [date, n]
     * @return: java.util.Date
     * @auther: HuYiGong
     * @date: 2019/8/21 15:08
     */
    public static Date nextDay (String date, int n) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(converToDate(date));
        calendar.add(Calendar.DAY_OF_MONTH, +n);
        return calendar.getTime();
    }

    public static Date nextDay (Long date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));
        calendar.add(Calendar.DAY_OF_MONTH, +n);
        return calendar.getTime();
    }

    /**
     * @description: (@param)date后n天的日期
     * @param: [date, n]
     * @return: java.util.Date
     * @auther: HuYiGong
     * @date: 2019/8/22 16:44
     */
    public static Date nextDate (Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +n);
        return calendar.getTime();
    }

    /**
     * 获取当前日期前一周
     *
     * @return 前一周的日期
     */
    public static String lastWeek () {
        return prevDay(7);
    }

    /**
     * 获取当前年
     */
    public static String getCurrentYear () {
        Date date = new Date();
        return new SimpleDateFormat(DateFormat.YEAR_FORMAT).format(date);
    }

    /**
     * 是否在今天
     *
     * @param date 时间
     *
     * @return 返回true代表在今天, 返回false不在今天
     */
    public static Boolean isToday (Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat(DateFormat.DATE_FORMAT);
        return fmt.format(date).equals(fmt.format(new Date()));
    }

    /**
     * 是否在今天
     *
     * @param dateTime 时间
     *
     * @return 返回true代表在今天, 返回false不在今天
     *
     * @throws ParseException
     */
    public static Boolean isToday (String dateTime) throws ParseException {
        Date date = converToDate(dateTime);
        return isToday(date);
    }

    /**
     * 获取该时间里的年份
     *
     * @param dataTime
     *
     * @return
     *
     * @throws ParseException
     */
    public static String getYear (Date dataTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataTime);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    /**
     * 获取该时间里的月份
     *
     * @param dataTime
     *
     * @return
     *
     * @throws ParseException
     */
    public static String getMonth (Date dataTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataTime);
        return String.valueOf(calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取该时间里的天
     *
     * @param dataTime
     *
     * @return
     *
     * @throws ParseException
     */
    public static String getDay (Date dataTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataTime);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 获取上个月时间
     *
     * @param date
     *
     * @return
     *
     * @throws Exception
     */
    public static Date prevMonth (Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取该时间的小时
     *
     * @param dateTime
     *
     * @return
     *
     * @throws ParseException
     */
    public static String getHour (Date dateTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return String.valueOf(hour > 12 ? hour - 12 : hour);
    }

    public static String getHour_24 (Date dateTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return String.valueOf(hour);
    }

    public static String getWeek (Date dateTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        String weekStr = "";
        switch(week){
            case 1:
                weekStr = "星期天";
                break;
            case 2:
                weekStr = "星期一";
                break;
            case 3:
                weekStr = "星期二";
                break;
            case 4:
                weekStr = "星期三";
                break;
            case 5:
                weekStr = "星期四";
                break;
            case 6:
                weekStr = "星期五";
                break;
            case 7:
                weekStr = "星期六";
                break;
            default:
                break;
        }

        return String.valueOf(weekStr);
    }



    /**
     * 获取该时间的分钟
     *
     * @param dateTime
     *
     * @return
     */
    public static String getMinutes (Date dateTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        return String.valueOf(calendar.get(Calendar.MINUTE));
    }

    /**
     * 获取该时间的时段
     *
     * @param dateTime
     *
     * @return
     */
    public static String getTimeInterval (Date dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            return "上午";
        } else if (hour >= 12 && hour < 13) {
            return "正午";
        } else {
            return "下午";
        }
    }

    /**
     * 获取上个月时间
     *
     * @param date
     *
     * @return
     *
     * @throws Exception
     */
    public static Date prevMonth (Long date) throws Exception {
        Date date1 = new Date();
        date1.setTime(date);
        return prevMonth(date1);
    }

    /**
     * 是否是闰月
     *
     * @param month 月份数
     *
     * @return
     */
    public static boolean isLeapMouth (String month) {
        return !"4".equals(month) && !"6".equals(month) && !"9".equals(month) && !"11".equals(month);
    }

    /**
     * 是否是闰年
     *
     * @param year
     *
     * @return
     */
    public static boolean isLeapYear (String year) {
        Integer yearNum = Integer.valueOf(year);
        return (yearNum % 4 == 0) && (yearNum % 100 != 0) || (yearNum % 400 == 0);
    }

    /**
     * 根据年、月获取结束日期
     *
     * @param year  年
     * @param month 月
     *
     * @return
     */
    public static String getEndDate (String year, String month) {
        String endDate = year + "-" + month + "-30";
        // 如果闰月，是31天
        if (isLeapMouth(month)) {
            //月份是二月份
            if ("2".equals(month)) {
                //如果闰年
                if (isLeapYear(year)) {
                    endDate = year + "-" + month + "-29";
                } else {
                    endDate = year + "-" + month + "-28";
                }
            } else {
                endDate = year + "-" + month + "-31";
            }
        }
        return endDate;
    }


    /**
     * 获取日期区间 ()
     *
     * @param year    年度
     * @param quarter 季度数
     *
     * @return
     *
     * @throws ParseException
     */
    public static DateInterval getDateInterval (String year, String quarter) throws ParseException {
        DateInterval di = new DateInterval();
        if (StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)) {
            return di;
        }
        String startTime = "";
        String endTime = "";

        if (Quarter.FIRST.getNum().equals(quarter)) {
            startTime = year + "-" + Quarter.FIRST.getStartDate();
            endTime = year + "-" + Quarter.FIRST.getEndDate();
        }
        if (Quarter.SECOND.getNum().equals(quarter)) {
            startTime = year + "-" + Quarter.SECOND.getStartDate();
            endTime = year + "-" + Quarter.SECOND.getEndDate();
        }
        if (Quarter.THIRDLY.getNum().equals(quarter)) {
            startTime = year + "-" + Quarter.THIRDLY.getStartDate();
            endTime = year + "-" + Quarter.THIRDLY.getEndDate();
        }
        if (Quarter.FOURTHLY.getNum().equals(quarter)) {
            startTime = year + "-" + Quarter.FOURTHLY.getStartDate();
            endTime = (Integer.parseInt(year) + 1) + "-" + Quarter.FOURTHLY.getEndDate();
        }
        di.setStart(startTime);
        di.setEnd(endTime);
        di.setStartDate(converToDate(startTime));
        di.setEndDate(converToDate(endTime));

        return di;
    }

    /**
     * 获取日期区间
     *
     * @param year 年度
     *
     * @return
     *
     * @throws ParseException
     */
    public static DateInterval getDateInterval (String year) throws ParseException {
        DateInterval di = new DateInterval();
        if (StringUtils.isEmpty(year)) {
            return di;
        }
        String startTime = year + "01-01";
        String endTime = year + "12-31";
        di.setStart(startTime);
        di.setEnd(endTime);
        return di;
    }

    /**
     * 获得当前的年份和季度
     *
     * @param nowDate
     *
     * @return
     *
     * @throws ParseException
     */
    public static Map<String, Object> getNowQuarter (Date nowDate) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        String quarter = "1";
        if (month >= 3 && month <= 5) {
        } else if (month >= 6 && month <= 8) {
            quarter = "2";
        } else if (month >= 9 && month <= 11) {
            quarter = "3";
        } else {
            quarter = "4";
            if (month >= 1 && month <= 2) {
                year = year - 1;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("year", year + "");
        map.put("quarter", quarter);
        return map;
    }

    /**
     * @description: 去掉日期中时间部分
     * @param: [date]
     * @return: java.util.Date
     * @auther: HuYiGong
     * @date: 2019/11/16 16:59
     */
    public static Date removeTimePart(Date date) {
        LocalDate localDate=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return java.sql.Date.valueOf(localDate);
    }

    /**
     * 日期区间类
     */
    public static class DateInterval {

        private String start;

        private String end;

        private Date startDate;

        private Date endDate;

        public String getStart () {
            return start;
        }

        public void setStart (String start) {
            this.start = start;
        }

        public String getEnd () {
            return end;
        }

        public void setEnd (String end) {
            this.end = end;
        }

        public Date getStartDate () {
            return startDate;
        }

        public void setStartDate (Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate () {
            return endDate;
        }

        public void setEndDate (Date endDate) {
            this.endDate = endDate;
        }
    }

    /**
     * 根据起止时间计算中间时间
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 天、时、分、秒字符串
     */
    public static String calculateTime(Date startDate, Date endDate){
        //转换成秒
        long between  = (endDate.getTime() - startDate.getTime())/1000;
        return getTotalString(between);
    }

    /**
     * 根据起止时间计算中间时间
     * @param startTime 开始时间字符串
     * @param endTime 结束时间字符串
     * @param format 时间格式
     * @return 天、时、分、秒字符串
     * @throws ParseException 转换异常
     */
    public static String calculateTime(String startTime, String endTime, String format) throws ParseException {
        Date startDate = DateUtils.converToDate(startTime, format);
        Date endDate = DateUtils.converToDate(endTime, format);
        //转换成秒
        long between  = (endDate.getTime() - startDate.getTime())/1000;
        return getTotalDayString(between);
    }

    /**
     * 根据秒数获取字符串信息
     * @param between 秒数
     * @return 字符串
     */
    public static String getTotalString(long between) {
//        long day = between / (24 * 60 * 60);
//        between = between - (day * 24 * 60 * 60);
        long hour = between / (60 * 60);
        between = between - (hour * 60 * 60);
        long minute = between / 60;
        long second = between - (minute * 60);
        return MessageFormat.format("{0}时{1}分{2}秒", hour, minute, second);
    }

    public static String getTotalDayString(long between) {
        long day = between / (24 * 60 * 60);
        between = between - (day * 24 * 60 * 60);
        long hour = between / (60 * 60);
        between = between - (hour * 60 * 60);
        long minute = between / 60;
        long second = between - (minute * 60);
        return MessageFormat.format("{0}天{1}时{2}分{3}秒", day,hour, minute, second);
    }

    /**
     * 根据秒数获取分钟数
     * @param between 秒数
     * @return 分钟数
     */
    public static long getTotalMinute(long between) {
        long result = between / 60;
        if(between<60 && between!=0){
            result=1;
        }
        return result;
    }

    /**
     * 根据天时分秒获取对应的秒数
     * @param totalTime 天时分秒字符串
     * @return 秒数
     */
    public static long getSecondFromString(String totalTime) {
        if(StringUtils.isBlank(totalTime)){
            return 0;
        }
        String[] nums = totalTime.split("[\\u4e00-\\u9fa5]");
        if(nums.length!=3){
            return 0;
        }
        //转换成秒
//        long day = NumberUtils.toLong(nums[0]) * (24*60*60);
        long hour = NumberUtils.toLong(nums[0]) * (60*60);
        long minute = NumberUtils.toLong(nums[1]) * 60;
        long second = NumberUtils.toLong(nums[2]);
        return hour+minute+second;
    }
}
