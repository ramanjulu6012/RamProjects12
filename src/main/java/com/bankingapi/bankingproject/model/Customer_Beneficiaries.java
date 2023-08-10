package com.bankingapi.bankingproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerbenificiaries")
public class Customer_Beneficiaries {
    @Id
    private int id;
    private int customerid;
    private int accountid;
    private String benificiaryacno;
    private String benificiarybank;
    private String benificiarybranch;
    private String benificiaryifsc;
    private float maxtxnamount;
    public Customer_Beneficiaries() {
    }
    public Customer_Beneficiaries(int id, int customerid, int accountid, String benificiaryacno, String benificiarybank,
            String benificiarybranch, String benificiaryifsc, float maxtxnamount) {
        this.id = id;
        this.customerid = customerid;
        this.accountid = accountid;
        this.benificiaryacno = benificiaryacno;
        this.benificiarybank = benificiarybank;
        this.benificiarybranch = benificiarybranch;
        this.benificiaryifsc = benificiaryifsc;
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
    public String getBenificiaryacno() {
        return benificiaryacno;
    }
    public void setBenificiaryacno(String benificiaryacno) {
        this.benificiaryacno = benificiaryacno;
    }
    public String getBenificiarybank() {
        return benificiarybank;
    }
    public void setBenificiarybank(String benificiarybank) {
        this.benificiarybank = benificiarybank;
    }
    public String getBenificiarybranch() {
        return benificiarybranch;
    }
    public void setBenificiarybranch(String benificiarybranch) {
        this.benificiarybranch = benificiarybranch;
    }
    public String getBenificiaryifsc() {
        return benificiaryifsc;
    }
    public void setBenificiaryifsc(String benificiaryifsc) {
        this.benificiaryifsc = benificiaryifsc;
    }
    public float getMaxtxnamount() {
        return maxtxnamount;
    }
    public void setMaxtxnamount(float maxtxnamount) {
        this.maxtxnamount = maxtxnamount;
    }

    

    
}
