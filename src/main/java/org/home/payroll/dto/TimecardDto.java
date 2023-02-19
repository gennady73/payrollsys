package org.home.payroll.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TimecardDto {
    private int id;
    private int employeeId;
    private Date date;
    private BigDecimal hoursWorked;

    public TimecardDto() {}

    public TimecardDto(int id, int employeeId, Date date, BigDecimal hoursWorked) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

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
        return date;
    }

    public void setWorkDate(Date date) {
        this.date = date;
    }

    public BigDecimal getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(BigDecimal hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
