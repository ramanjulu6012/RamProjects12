package com.bankingapi.bankingproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_beneficiaries")
public class CustomerBeneficiaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerid;
    private int accountid;
    private String beneficiaryacno;
    private String beneficiarybank;
    private String beneficiarybranch;
    private String beneficiaryifsc;
    private float maxtxnamount;

    public CustomerBeneficiaries() {
    }

    public CustomerBeneficiaries(int id, int customerid, int accountid, String beneficiaryacno, String beneficiarybank,
            String beneficiarybranch, String beneficiaryifsc, float maxtxnamount) {
        this.id = id;
        this.customerid = customerid;
        this.accountid = accountid;
        this.beneficiaryacno = beneficiaryacno;
        this.beneficiarybank = beneficiarybank;
        this.beneficiarybranch = beneficiarybranch;
        this.beneficiaryifsc = beneficiaryifsc;
        this.maxtxnamount = maxtxnamount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getbeneficiaryacno() {
        return beneficiaryacno;
    }

    public void setbeneficiaryacno(String beneficiaryacno) {
        this.beneficiaryacno = beneficiaryacno;
    }

    public String getbeneficiarybank() {
        return beneficiarybank;
    }

    public void setbeneficiarybank(String beneficiarybank) {
        this.beneficiarybank = beneficiarybank;
    }

    public String getbeneficiarybranch() {
        return beneficiarybranch;
    }

    public void setbeneficiarybranch(String beneficiarybranch) {
        this.beneficiarybranch = beneficiarybranch;
    }

    public String getbeneficiaryifsc() {
        return beneficiaryifsc;
    }

    public void setbeneficiaryifsc(String beneficiaryifsc) {
        this.beneficiaryifsc = beneficiaryifsc;
    }

    public float getMaxtxnamount() {
        return maxtxnamount;
    }

    public void setMaxtxnamount(float maxtxnamount) {
        this.maxtxnamount = maxtxnamount;
    }

}
