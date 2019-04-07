package fundamentals.dataabstraction;

import java.util.Calendar;

public class SmartDate {

    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int value;

    public SmartDate(int m, int d, int y) {
        if (!isLegal(m, d, y))
            throw new IllegalArgumentException(m + "/" + d + "/" + y + " is illegal!");

        value = y * 512 + m * 32 + d;
    }

    public SmartDate(String date) {
        String[] fields = date.split("/");
        int month = Integer.parseInt(fields[0]);
        int day = Integer.parseInt(fields[1]);
        int year = Integer.parseInt(fields[2]);
        if (!isLegal(month, day, year))
            throw new IllegalArgumentException(month + "/" + day + "/" + year + " is illegal!");

        value = year * 512 + month * 32 + day;
    }

    private boolean isLegal(int m, int d, int y) {
        if (m < 1 || m > 12) return false;
        if (d < 1 || d > DAYS[m]) return false;
        return m != 2 || d != 29 || isLeapYear(y);
    }

    private boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public String dayOfTheWeek() {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        Calendar calendar = Calendar.getInstance();
        calendar.set(year(), month() - 1, day());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return daysOfWeek[dayOfWeek - 1];
    }

    public int month() {
        return (value / 32) % 16;
    }

    public int day() {
        return value % 32;
    }

    public int year() {
        return value / 512;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        SmartDate that = (SmartDate) x;
        if (this.day() != that.day()) return false;
        if (this.month() != that.month()) return false;
        return this.year() == that.year();
    }
}
