package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.VacationRequest;
import com.example.vacationcalculator.model.VacationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VacationServiceTest
{

    @Autowired
    private VacationService vacationService;

    // расчет без даты начала отпуска
    @Test
    public void testCalculateWithoutStartDate()
    {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(60000.0);
        request.setVacationDays(14);

        VacationResponse response = vacationService.calculateVacationPay(request);

        assertNotNull(response);
        assertEquals(14, response.getActualWorkingDays());
        assertTrue(response.getVacationPay() > 0);
        assertEquals(9569.96, response.getVacationPay(), 1.0);
    }

    // расчет с датой начала (февраль без праздников)
    @Test
    public void testCalculateWithStartDateNoHolidays()
    {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(60000.0);
        request.setVacationDays(14);
        request.setStartDate(java.time.LocalDate.of(2026, 2, 1));

        VacationResponse response = vacationService.calculateVacationPay(request);

        assertNotNull(response);
        assertTrue(response.getActualWorkingDays() > 0);
        assertTrue(response.getActualWorkingDays() < 14);
        assertTrue(response.getVacationPay() > 0);
    }

    // расчет с датой начала в январе (много праздников)
    @Test
    public void testCalculateWithStartDateJanuaryHolidays()
    {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(60000.0);
        request.setVacationDays(14);
        request.setStartDate(java.time.LocalDate.of(2026, 1, 1));

        VacationResponse response = vacationService.calculateVacationPay(request);

        assertNotNull(response);
        assertTrue(response.getActualWorkingDays() < 14);
        assertTrue(response.getVacationPay() > 0);
    }

    // 1 день отпуска
    @Test
    public void testCalculateOneDayVacation()
    {
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(30000.0);
        request.setVacationDays(1);

        VacationResponse response = vacationService.calculateVacationPay(request);

        assertNotNull(response);
        assertEquals(1, response.getActualWorkingDays());
        assertTrue(response.getVacationPay() > 0);
    }
}