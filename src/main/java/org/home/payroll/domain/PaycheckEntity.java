package org.home.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "paycheck", schema = "payroll", catalog = "test_db")
public class PaycheckEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "payment_rule_id")
    private int paymentRuleId;
    @Basic
    @Column(name = "pay_date")
    private Date payDate;
    @Basic
    @Column(name = "pay_period_start_date")
    private Date payPeriodStartDate;
    @Basic
    @Column(name = "pay_period_end_date")
    private Date payPeriodEndDate;
    @Basic
    @Column(name = "gross_pay")
    private BigDecimal grossPay;
    @Basic
    @Column(name = "net_pay")
    private BigDecimal netPay;
    @Basic
    @Column(name = "deductions")
    private String deductions;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private EmployeeEntity employeeByEmployeeId;
    @ManyToOne
    @JoinColumn(name = "payment_rule_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private PaymentRuleEntity paymentRuleByPaymentRuleId;
    @OneToMany(mappedBy = "paycheckByPaycheckId")
    private Collection<ReportEntity> reportsById;

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

    public int getPaymentRuleId() {
        return paymentRuleId;
    }

    public void setPaymentRuleId(int paymentRuleId) {
        this.paymentRuleId = paymentRuleId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getPayPeriodStartDate() {
        return payPeriodStartDate;
    }

    public void setPayPeriodStartDate(Date payPeriodStartDate) {
        this.payPeriodStartDate = payPeriodStartDate;
    }

    public Date getPayPeriodEndDate() {
        return payPeriodEndDate;
    }

    public void setPayPeriodEndDate(Date payPeriodEndDate) {
        this.payPeriodEndDate = payPeriodEndDate;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(BigDecimal grossPay) {
        this.grossPay = grossPay;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
    }

    public String getDeductions() {
        return deductions;
    }

    public void setDeductions(String deductions) {
        this.deductions = deductions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaycheckEntity that = (PaycheckEntity) o;
        return id == that.id && employeeId == that.employeeId && paymentRuleId == that.paymentRuleId && Objects.equals(payDate, that.payDate) && Objects.equals(payPeriodStartDate, that.payPeriodStartDate) && Objects.equals(payPeriodEndDate, that.payPeriodEndDate) && Objects.equals(grossPay, that.grossPay) && Objects.equals(netPay, that.netPay) && Objects.equals(deductions, that.deductions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, paymentRuleId, payDate, payPeriodStartDate, payPeriodEndDate, grossPay, netPay, deductions);
    }

    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    public PaymentRuleEntity getPaymentRuleByPaymentRuleId() {
        return paymentRuleByPaymentRuleId;
    }

    public void setPaymentRuleByPaymentRuleId(PaymentRuleEntity paymentRuleByPaymentRuleId) {
        this.paymentRuleByPaymentRuleId = paymentRuleByPaymentRuleId;
    }

    public Collection<ReportEntity> getReportsById() {
        return reportsById;
    }

    public void setReportsById(Collection<ReportEntity> reportsById) {
        this.reportsById = reportsById;
    }
}
