package com.example.vacationcalculator.model;

import java.time.LocalDate;

public class VacationRequest
{
    private double averageSalary;
    private int vacationDays;
    private LocalDate startDate;

    public VacationRequest()
    {
    }

    public double getAverageSalary()
    {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary)
    {
        this.averageSalary = averageSalary;
    }

    public int getVacationDays()
    {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays)
    {
        this.vacationDays = vacationDays;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }
}