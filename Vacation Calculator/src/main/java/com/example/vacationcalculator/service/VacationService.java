package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.VacationRequest;
import com.example.vacationcalculator.model.VacationResponse;
import com.example.vacationcalculator.util.HolidayUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VacationService
{

    public VacationResponse calculateVacationPay(VacationRequest request)
    {
        if (request.getAverageSalary() <= 0)
        {
            throw new IllegalArgumentException("Средняя зарплата должна быть положительной");
        }
        if (request.getVacationDays() <= 0)
        {
            throw new IllegalArgumentException("Количество дней отпуска должно быть положительным");
        }

        double averageSalary = request.getAverageSalary();
        int vacationDays = request.getVacationDays();
        LocalDate startDate = request.getStartDate();

        int actualWorkingDays;

        if (startDate != null)
        {
            actualWorkingDays = HolidayUtil.countWorkingDays(startDate, vacationDays);
        }
        else
        {
            actualWorkingDays = vacationDays;
        }

        double dailyEarnings = averageSalary / 12.0 / 29.3;

        double vacationPay = dailyEarnings * actualWorkingDays;

        return new VacationResponse(vacationPay, actualWorkingDays);
    }
}