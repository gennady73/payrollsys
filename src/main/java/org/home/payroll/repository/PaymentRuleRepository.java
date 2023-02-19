package org.home.payroll.repository;

import org.home.payroll.domain.PaymentRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRuleRepository extends JpaRepository<PaymentRuleEntity, Integer> {

}