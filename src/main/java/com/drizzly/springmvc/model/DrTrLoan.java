package com.drizzly.springmvc.model;
// Generated 17 Oct, 2015 9:14:35 PM by Hibernate Tools 4.3.1


import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DrTrLoan generated by hbm2java
 */
@Entity
@Table(name = "DR_TR_LOAN")
public class DrTrLoan  implements java.io.Serializable {


     @Id
     @GeneratedValue
     @Column(name = "LN_ID")
     private Long lnId;
     @Column(name = "LN_AMOUNT")
     private BigInteger lnAmount;
     @Column(name = "LN_RECEIVED_DATE")
     private Date lnReceivedDate;
     @Column(name = "LN_CLOSED_DATE")
     private Date lnClosedDate;
     @ManyToOne
     @JoinColumn(name = "LN_EM_ID")
     private DrMaEmployee drMaEmployee;

    public DrTrLoan() {
    }

	
    public DrTrLoan(DrMaEmployee drMaEmployee, BigInteger lnAmount, Date lnReceivedDate) {
        this.drMaEmployee = drMaEmployee;
        this.lnAmount = lnAmount;
        this.lnReceivedDate = lnReceivedDate;
    }
    public DrTrLoan(DrMaEmployee drMaEmployee, BigInteger lnAmount, Date lnReceivedDate, Date lnClosedDate) {
       this.drMaEmployee = drMaEmployee;
       this.lnAmount = lnAmount;
       this.lnReceivedDate = lnReceivedDate;
       this.lnClosedDate = lnClosedDate;
    }
   
    public Long getLnId() {
        return this.lnId;
    }
    
    public void setLnId(Long lnId) {
        this.lnId = lnId;
    }
    public DrMaEmployee getDrMaEmployee() {
        return this.drMaEmployee;
    }
    
    public void setDrMaEmployee(DrMaEmployee drMaEmployee) {
        this.drMaEmployee = drMaEmployee;
    }
    public BigInteger getLnAmount() {
        return this.lnAmount;
    }
    
    public void setLnAmount(BigInteger lnAmount) {
        this.lnAmount = lnAmount;
    }
    public Date getLnReceivedDate() {
        return this.lnReceivedDate;
    }
    
    public void setLnReceivedDate(Date lnReceivedDate) {
        this.lnReceivedDate = lnReceivedDate;
    }
    public Date getLnClosedDate() {
        return this.lnClosedDate;
    }
    
    public void setLnClosedDate(Date lnClosedDate) {
        this.lnClosedDate = lnClosedDate;
    }




}


