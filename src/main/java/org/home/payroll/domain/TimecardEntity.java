package org.home.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "timecard", schema = "payroll", catalog = "test_db")
public class TimecardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "work_date")
    private Date workDate;
    @Basic
    @Column(name = "hours_worked")
    private BigDecimal hoursWorked;
    @Basic
    @Column(name = "job_code")
    private String jobCode;
    @Basic
    @Column(name = "approved")
    private boolean approved;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private EmployeeEntity employeeByEmployeeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public BigDecimal getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(BigDecimal hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimecardEntity that = (TimecardEntity) o;
        return id == that.id && employeeId == that.employeeId && approved == that.approved && Objects.equals(workDate, that.workDate) && Objects.equals(hoursWorked, that.hoursWorked) && Objects.equals(jobCode, that.jobCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, workDate, hoursWorked, jobCode, approved);
    }

    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
