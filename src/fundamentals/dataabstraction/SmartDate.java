package fundamentals.dataabstraction;

import java.util.Calendar;

public class SmartDate {

    private final int value;

    public SmartDate(int m, int d, int y) {
        if (!isLegal(m, d, y))
            throw new IllegalArgumentException(m + "/" + d + "/" + y + " is illegal!");

        value = y * 512 + m * 32 + d;
    }

    private boolean isLegal(int m, int d, int y) {
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m <= 0 || d <= 0 || y <= 0) return false;
        if (m > 12) return false;
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            daysOfMonth[2] = 29;

        return d <= daysOfMonth[m];
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
}
