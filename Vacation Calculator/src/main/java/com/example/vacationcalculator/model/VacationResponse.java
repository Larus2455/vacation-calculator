package com.example.vacationcalculator.model;

public class VacationResponse
{
    private double vacationPay;
    private int actualWorkingDays;

    public VacationResponse()
    {
    }

    public VacationResponse(double vacationPay, int actualWorkingDays)
    {
        this.vacationPay = vacationPay;
        this.actualWorkingDays = actualWorkingDays;
    }

    public double getVacationPay()
    {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay)
    {
        this.vacationPay = vacationPay;
    }

    public int getActualWorkingDays()
    {
        return actualWorkingDays;
    }

    public void setActualWorkingDays(int actualWorkingDays)
    {
        this.actualWorkingDays = actualWorkingDays;
    }
}