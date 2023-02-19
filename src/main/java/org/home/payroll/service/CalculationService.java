package org.home.payroll.service;

import org.home.payroll.domain.EmployeeEntity;
import org.home.payroll.domain.PaycheckEntity;
import org.home.payroll.domain.PaymentRuleEntity;
import org.home.payroll.domain.TimecardEntity;
import org.home.payroll.repository.EmployeeRepository;
import org.home.payroll.repository.PaycheckRepository;
import org.home.payroll.repository.PaymentRuleRepository;
import org.home.payroll.repository.TimecardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CalculationService {

    PaymentRuleRepository paymentRuleRepository;
    TimecardRepository timecardRepository;
    EmployeeRepository employeeRepository;
    PaycheckRepository paycheckRepository;
    public PaycheckEntity calculatePaycheckByEmployeeById(int employeeId) {
        // Get the employee's payment rule and timecards from the database
        PaymentRuleEntity paymentRule = paymentRuleRepository.findByEmployeeId(employeeId);
        List<TimecardEntity> timecards = timecardRepository.findByEmployeeId(employeeId);

        // Calculate the total hours worked and the pay amount
        BigDecimal totalHours = BigDecimal.ZERO;
        for (TimecardEntity timecard : timecards) {
            totalHours.add( timecard.getHoursWorked() );
        }
        BigDecimal payAmount;
        if (paymentRule.getCalculationType().equals("FIX")) {
            // Fixed salary payment rule
            payAmount = paymentRule.getAmount();
        } else if (paymentRule.getCalculationType().equals("HOUR")) {
            // Hourly payment rule
            BigDecimal hourlyRate = paymentRule.getAmount();
            payAmount = totalHours.multiply(hourlyRate);
        } else {
            // Commission payment rule
            BigDecimal commissionRate = paymentRule.getAmount();
            BigDecimal totalSales = BigDecimal.ZERO;
            // Get the employee's sales data from the database
            // TBD
//            List<SalesEntity> sales = salesRepository.findByEmployeeId(employeeId);
//            for (SalesEntity sale : sales) {
//                totalSales = totalSales.add(sale.getAmount());
//            }
            totalSales = BigDecimal.ONE; // TBD test value is 1
            payAmount = totalSales.multiply(commissionRate);
        }

        // Create a new paycheck entity and save it to the database
        EmployeeEntity employee = employeeRepository.findById(employeeId).get();
        PaycheckEntity paycheck = new PaycheckEntity();
        paycheck.setEmployeeId(employee.getId());
        paycheck.setPaymentRuleId(paymentRule.getId());
        paycheck.setPayPeriodStartDate(timecards.get(0).getWorkDate());
        paycheck.setPayPeriodEndDate(timecards.get(timecards.size() - 1).getWorkDate());
        paycheck.setTotalHours(totalHours);
        paycheck.setPayAmount(payAmount);
        paycheckRepository.save(paycheck);

        return paycheck;
    }

}
