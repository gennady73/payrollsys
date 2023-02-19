package org.home.payroll.service;

import org.home.payroll.domain.PaymentRuleEntity;
import org.home.payroll.repository.PaymentRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaymentRuleService {

    @Autowired
    private PaymentRuleRepository paymentRuleRepository;

    public List<PaymentRuleEntity> getAllPaymentRules() {
        return paymentRuleRepository.findAll();
    }

    public PaymentRuleEntity getPaymentRuleById(int id) {
        return paymentRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment rule with id " + id + " not found"));
    }

    public PaymentRuleEntity createPaymentRule(PaymentRuleEntity paymentRule) {
        return paymentRuleRepository.save(paymentRule);
    }

    public PaymentRuleEntity updatePaymentRule(int id, PaymentRuleEntity paymentRule) {
        PaymentRuleEntity existingPaymentRule = paymentRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment rule with id " + id + " not found"));

        existingPaymentRule.setName(paymentRule.getName());
        existingPaymentRule.setDescription(paymentRule.getDescription());
        existingPaymentRule.setCalculationType(paymentRule.getCalculationType());
        existingPaymentRule.setAmount(paymentRule.getAmount());

        return paymentRuleRepository.save(existingPaymentRule);
    }

    public void deletePaymentRule(int id) {
        PaymentRuleEntity paymentRule = paymentRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment rule with id " + id + " not found"));

        paymentRuleRepository.delete(paymentRule);
    }
}
