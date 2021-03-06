package com.drizzly.springmvc.model;
// Generated 17 Oct, 2015 9:14:35 PM by Hibernate Tools 4.3.1

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/**
 * DrMaFees generated by hbm2java
 */
@Entity
@Table(name = "DR_MA_FEES")
public class DrMaFees  implements java.io.Serializable, IFees {


    @Id
    @Column(name = "FE_ID")
    @GeneratedValue
    private Long feId;
    @Column(name = "FE_AMOUNT_TERM")
    private BigInteger feAmountTerm;
    @Column(name = "FE_AMOUNT_YEAR")
    private BigInteger feAmountYear;
    @Column(name = "FE_AMOUNT_MONTH")
    private BigInteger feAmountMonth;
    @Column(name = "FE_REGISTRATION")
    private BigInteger feRegistration;
    @ManyToOne
    @JoinColumn(name = "FE_CT_ID")
    private DrMaCategory drMaCategory;
    @Column(name = "FE_YEAR")
    private Integer year;

    public DrMaFees() {
    }

    public DrMaFees(DrMaCategory drMaCategory, BigInteger feAmountTerm, BigInteger feAmountYear, BigInteger feAmountMonth, BigInteger feRegistration) {
       this.drMaCategory = drMaCategory;
       this.feAmountTerm = feAmountTerm;
       this.feAmountYear = feAmountYear;
       this.feAmountMonth = feAmountMonth;
       this.feRegistration = feRegistration;
    }
   
    @Override
    public Long getFeId() {
        return this.feId;
    }
    
    public void setFeId(Long feId) {
        this.feId = feId;
    }
    @Override
    public DrMaCategory getDrMaCategory() {
        return this.drMaCategory;
    }
    
    public void setDrMaCategory(DrMaCategory drMaCategory) {
        this.drMaCategory = drMaCategory;
    }

    @Override
    public BigInteger getFeAmountTerm() {
        return feAmountTerm;
    }

    public void setFeAmountTerm(BigInteger feAmountTerm) {
        this.feAmountTerm = feAmountTerm;
    }

    @Override
    public BigInteger getFeAmountYear() {
        return feAmountYear;
    }

    public void setFeAmountYear(BigInteger feAmountYear) {
        this.feAmountYear = feAmountYear;
    }

    @Override
    public BigInteger getFeAmountMonth() {
        return feAmountMonth;
    }

    public void setFeAmountMonth(BigInteger feAmountMonth) {
        this.feAmountMonth = feAmountMonth;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigInteger getFeRegistration() {
        return feRegistration;
    }

    public void setFeRegistration(BigInteger feRegistration) {
        this.feRegistration = feRegistration;
    }
}


