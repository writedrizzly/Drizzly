/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author rajaguru
 */
@Entity
@Table(name = "DR_TR_ACCOUNTS")
@NamedQueries({ @NamedQuery(name = "DrTrAccounts.findAll", query = "SELECT d FROM DrTrAccounts d") })
public class DrTrAccounts implements Serializable , IAccounts{
    @Basic(optional = false)
    @Column(name = "AC_STAFF")
    private long acStaff;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "AC_ID")
    private Integer acId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AC_CREDIT")
    private BigDecimal acCredit;
    @Column(name = "AC_DEBIT")
    private BigDecimal acDebit;
    @Basic(optional = false)
    @Column(name = "AC_NOTE")
    private String acNote;
    @Basic(optional = false)
    @Column(name = "AC_DATE")
    @Temporal(TemporalType.DATE)
    private Date acDate;
    @Column(name = "AC_CATEGORY")
    private String acCategory;

    @Transient
    @Temporal(TemporalType.DATE)
    private Date acFromDate;
    
    @Transient
    @Temporal(TemporalType.DATE)
    private Date acToDate;
    
    public DrTrAccounts() {
    }

    public DrTrAccounts(Integer acId) {
        this.acId = acId;
    }

    public DrTrAccounts(Integer acId, String acNote, Date acDate, Date acFromDate, Date acToDate) {
        this.acId = acId;
        this.acNote = acNote;
        this.acDate = acDate;
        this.acFromDate = acFromDate;
        this.acToDate = acToDate;
    }

    public Date getAcFromDate() {
        return acFromDate;
    }

    public void setAcFromDate(Date acFromDate) {
        this.acFromDate = acFromDate;
    }

    public Date getAcToDate() {
        return acToDate;
    }

    public void setAcToDate(Date acToDate) {
        this.acToDate = acToDate;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public BigDecimal getAcCredit() {
        return acCredit;
    }

    public void setAcCredit(BigDecimal acCredit) {
        this.acCredit = acCredit;
    }

    public BigDecimal getAcDebit() {
        return acDebit;
    }

    public void setAcDebit(BigDecimal acDebit) {
        this.acDebit = acDebit;
    }

    public String getAcNote() {
        return acNote;
    }

    public void setAcNote(String acNote) {
        this.acNote = acNote;
    }

    public Date getAcDate() {
        return acDate;
    }

    public void setAcDate(Date acDate) {
        this.acDate = acDate;
    }

    public String getAcCategory() {
        return acCategory;
    }

    public void setAcCategory(String acCategory) {
        this.acCategory = acCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acId != null ? acId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrTrAccounts)) {
            return false;
        }
        DrTrAccounts other = (DrTrAccounts) object;
        if ((this.acId == null && other.acId != null) || (this.acId != null && !this.acId.equals(other.acId))) {
            return false;
        }
        return true;
    }

    public long getAcStaff() {
        return acStaff;
    }

    public void setAcStaff(long acStaff) {
        this.acStaff = acStaff;
    }

    @Override
    public String toString() {
        return "DrTrAccounts{" + "acStaff=" + acStaff + ", acId=" + acId + ", acCredit=" + acCredit + ", acDebit=" + acDebit + ", acNote=" + acNote + ", acDate=" + acDate + ", acCategory=" + acCategory + ", acFromDate=" + acFromDate + ", acToDate=" + acToDate + '}';
    }
    
}
