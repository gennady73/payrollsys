package org.home.payroll.controller;

import org.home.payroll.domain.PaymentRuleEntity;
import org.home.payroll.service.PaymentRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/payroll/payment-rules")
public class PaymentRuleController {
    @Autowired
    private PaymentRuleService paymentRuleService;

    @PostMapping
    public ResponseEntity<PaymentRuleEntity> createPaymentRule(@RequestBody PaymentRuleEntity paymentRuleEntity) {
        PaymentRuleEntity createdPaymentRule = paymentRuleService.createPaymentRule(paymentRuleEntity);
        return ResponseEntity.created(URI.create("/payment-rules/" + createdPaymentRule.getId())).body(createdPaymentRule);
    }

    @GetMapping
    public ResponseEntity<List<PaymentRuleEntity>> getAllPaymentRules() {
        return ResponseEntity.ok(paymentRuleService.getAllPaymentRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentRuleEntity> getPaymentRuleById(@PathVariable int id) {
        return ResponseEntity.ok(paymentRuleService.getPaymentRuleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentRuleEntity> updatePaymentRule(@PathVariable int id, @RequestBody PaymentRuleEntity paymentRule){
        PaymentRuleEntity updatedPaymentRule = paymentRuleService.updatePaymentRule(id, paymentRule);
        return ResponseEntity.ok(updatedPaymentRule);
    }
}