package org.home.payroll.controller;

import org.home.payroll.domain.PaycheckEntity;
import org.home.payroll.service.PaycheckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll/paychecks")
public class PaycheckController {

    private final PaycheckService paycheckService;

    public PaycheckController(PaycheckService paycheckService) {
        this.paycheckService = paycheckService;
    }

    @GetMapping("/{id}")
    public PaycheckEntity getPaycheckById(@PathVariable int id) {
        return paycheckService.getPaycheckById(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<PaycheckEntity> getPaychecksByEmployeeId(@PathVariable int employeeId) {
        return paycheckService.getPaychecksByEmployeeId(employeeId);
    }

    @PostMapping
    public PaycheckEntity createPaycheck(@RequestBody PaycheckEntity paycheck) {
        return paycheckService.createPaycheck(paycheck);
    }

    @PutMapping("/{id}")
    public PaycheckEntity updatePaycheck(@PathVariable int id, @RequestBody PaycheckEntity paycheck) {
        return paycheckService.updatePaycheck(id, paycheck);
    }

    @DeleteMapping("/{id}")
    public void deletePaycheck(@PathVariable int id) {
        paycheckService.deletePaycheck(id);
    }
}
