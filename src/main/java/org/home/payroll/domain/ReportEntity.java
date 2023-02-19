package org.home.payroll.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "report", schema = "payroll", catalog = "test_db")
public class ReportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "paycheck_id")
    private int paycheckId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "report_data")
    private String reportData;
    @ManyToOne
    @JoinColumn(name = "paycheck_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private PaycheckEntity paycheckByPaycheckId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaycheckId() {
        return paycheckId;
    }

    public void setPaycheckId(int paycheckId) {
        this.paycheckId = paycheckId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportEntity that = (ReportEntity) o;
        return id == that.id && paycheckId == that.paycheckId && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(reportData, that.reportData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paycheckId, name, startDate, endDate, reportData);
    }

    public PaycheckEntity getPaycheckByPaycheckId() {
        return paycheckByPaycheckId;
    }

    public void setPaycheckByPaycheckId(PaycheckEntity paycheckByPaycheckId) {
        this.paycheckByPaycheckId = paycheckByPaycheckId;
    }
}
