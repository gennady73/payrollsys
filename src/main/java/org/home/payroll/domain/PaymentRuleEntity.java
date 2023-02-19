package org.home.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "payment_rule", schema = "payroll", catalog = "test_db")
public class PaymentRuleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "calculation_type")
    private String calculationType;
    @Basic
    @Column(name = "amount")
    private BigDecimal amount;
//    @OneToMany(mappedBy = "paymentRuleByPaymentRuleId")
//    private Collection<PaycheckEntity> paychecksById;

    public PaymentRuleEntity(String name, String description, String calculationType, BigDecimal amount) {
        this.name = name;
        this.description = description;
        this.calculationType = calculationType;
        this.amount = amount;
    }

    public PaymentRuleEntity() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRuleEntity that = (PaymentRuleEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(calculationType, that.calculationType) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, calculationType, amount);
    }

//    public Collection<PaycheckEntity> getPaychecksById() {
//        return paychecksById;
//    }
//
//    public void setPaychecksById(Collection<PaycheckEntity> paychecksById) {
//        this.paychecksById = paychecksById;
//    }
}
