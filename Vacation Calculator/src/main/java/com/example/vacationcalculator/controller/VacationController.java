package com.example.vacationcalculator.controller;

import com.example.vacationcalculator.model.VacationRequest;
import com.example.vacationcalculator.model.VacationResponse;
import com.example.vacationcalculator.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VacationController
{

    @Autowired
    private VacationService vacationService;

    @GetMapping("/calculacte")
    public VacationResponse calculateVacation(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) String startDate)
    {

        VacationRequest request = new VacationRequest();
        request.setAverageSalary(averageSalary);
        request.setVacationDays(vacationDays);

        if (startDate != null && !startDate.isEmpty())
        {
            request.setStartDate(java.time.LocalDate.parse(startDate));
        }

        return vacationService.calculateVacationPay(request);
    }
}