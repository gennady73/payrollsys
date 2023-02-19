package org.home.payroll.repository;

import org.home.payroll.domain.PaycheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PaycheckRepository extends JpaRepository<PaycheckEntity, Integer> {
//    public Collection<PaycheckEntity> getPaychecksById(Collection<PaycheckEntity> paychecksById);
//
//    public void setPaychecksById(Collection<PaycheckEntity> paychecksById);

    List<PaycheckEntity> findByEmployeeId(int employeeId);

    List<PaycheckEntity> findByPayPeriodStartDateBetween(Date startDate, Date endDate);

    List<PaycheckEntity> findByPayDate(Date payDate);
}