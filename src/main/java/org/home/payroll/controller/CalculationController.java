package org.home.payroll.controller;

import org.home.payroll.domain.PaycheckEntity;
import org.home.payroll.service.CalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll/calculations")
public class CalculationController {
    CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("paycheck/{id}")
    public ResponseEntity<PaycheckEntity> calculatePaycheckByEmployeeById(@PathVariable int id) {
        PaycheckEntity paycheck = calculationService.calculatePaycheckByEmployeeById(id);
        return ResponseEntity.ok(paycheck);
    }
}
