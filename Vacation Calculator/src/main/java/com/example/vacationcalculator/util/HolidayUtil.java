package com.example.vacationcalculator.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class HolidayUtil
{

    private static final Set<LocalDate> holidays = new HashSet<>();

    static
    {
        holidays.add(LocalDate.of(2026, Month.JANUARY, 1));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 2));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 3));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 4));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 5));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 6));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 7));
        holidays.add(LocalDate.of(2026, Month.JANUARY, 8));
        holidays.add(LocalDate.of(2026, Month.FEBRUARY, 23));
        holidays.add(LocalDate.of(2026, Month.MARCH, 8));
        holidays.add(LocalDate.of(2026, Month.MAY, 1));
        holidays.add(LocalDate.of(2026, Month.MAY, 9));
        holidays.add(LocalDate.of(2026, Month.JUNE, 12));
        holidays.add(LocalDate.of(2026, Month.NOVEMBER, 4));
    }

    public static boolean isHoliday(LocalDate date)
    {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY ||
                holidays.contains(date);
    }

    public static int countWorkingDays(LocalDate startDate, int totalDays)
    {
        int workingDays = 0;
        LocalDate currentDate = startDate;

        for (int i = 0; i < totalDays; i++)
        {
            if (!isHoliday(currentDate))
            {
                workingDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return workingDays;
    }
}