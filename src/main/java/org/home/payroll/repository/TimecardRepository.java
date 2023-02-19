package org.home.payroll.repository;

import org.home.payroll.domain.TimecardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimecardRepository extends JpaRepository<TimecardEntity, Integer> {
//    public Collection<TimecardEntity> getTimecardsById(Collection<TimecardEntity> timecardsById);
//
//    public void setTimecardsById(Collection<TimecardEntity> timecardsById);
//
//    public EmployeeEntity getEmployeeByTimecardId(TimecardEntity timecardId);
//
//    public void setEmployeeByTimecardId(EmployeeEntity employeeId);
    @Query("SELECT t FROM TimecardEntity t WHERE t.employeeId = :employeeId")
    List<TimecardEntity> findByEmployeeId(@Param("employeeId") int employeeId);
}