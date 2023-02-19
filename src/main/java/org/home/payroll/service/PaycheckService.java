package org.home.payroll.service;

import org.home.payroll.domain.PaycheckEntity;
import org.home.payroll.repository.PaycheckRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaycheckService {

    private final PaycheckRepository paycheckRepository;

    public PaycheckService(PaycheckRepository paycheckRepository) {
        this.paycheckRepository = paycheckRepository;
    }

    public PaycheckEntity getPaycheckById(int id) {
        return paycheckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paycheck with id " + id + " not found"));
    }

    public List<PaycheckEntity> getPaychecksByEmployeeId(int employeeId) {
        return paycheckRepository.findByEmployeeId(employeeId);
    }

    public PaycheckEntity createPaycheck(PaycheckEntity paycheck) {
        return paycheckRepository.save(paycheck);
    }

    public PaycheckEntity updatePaycheck(int id, PaycheckEntity paycheck) {
        paycheck.setId(id);
        return paycheckRepository.save(paycheck);
    }

    public void deletePaycheck(int id) {
        paycheckRepository.deleteById(id);
    }
}
