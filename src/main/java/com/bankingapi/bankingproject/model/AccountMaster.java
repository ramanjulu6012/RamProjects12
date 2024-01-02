package com.bankingapi.bankingproject.model;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_master") 
public class AccountMaster  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountno")
    private int accountno;
    @Column(name = "branchid")
    private int branchid;
    @Column(name = "productid")
    private int productid;
    @Column(name = "customerid")
    private int customerid;
    @Column(name = "name")
    private String name;
    @Column(name = "accountstatus")
    private int accountstatus;
    @Column(name = "accountopendate")
    private Date accountopendate;
    @Column(name = "balance")
    private float balance;
    @Column(name = "accountclosedate")
    private Date accountclosedate;
    @Column(name = "modeofoperation")
    private int modeofoperation;
    @Column(name = "openbyuser")
    private int openbyuser;
    @Column(name = "closedbyuser")
    private int closedbyuser;
    public AccountMaster() {
    }
    public AccountMaster(int accountno, int branchid, int productid, int customerid, String name, int accountstatus,
            Date accountopendate, float balance, Date accountclosedate, int modeofoperation, int openbyuser,
            int closedbyuser) {
        this.accountno = accountno;
        this.branchid = branchid;
        this.productid = productid;
        this.customerid = customerid;
        this.name = name;
        this.accountstatus = accountstatus;
        this.accountopendate = accountopendate;
        this.balance = balance;
        this.accountclosedate = accountclosedate;
        this.modeofoperation = modeofoperation;
        this.openbyuser = openbyuser;
        this.closedbyuser = closedbyuser;
    }

    public AccountMaster(int accountno, float balance ) {
        this.accountno = accountno;
        this.balance = balance;
    }
    public int getAccountno() {
        return accountno;
    }
    public void setAccountno(int accountno) {
        this.accountno = accountno;
    }
    public int getBranchid() {
        return branchid;
    }
    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
    public int getCustomerid() {
        return customerid;
    }
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAccountstatus() {
        return accountstatus;
    }
    public void setAccountstatus(int accountstatus) {
        this.accountstatus = accountstatus;
    }
    public Date getAccountopendate() {
        return accountopendate;
    }
    public void setAccountopendate(Date accountopendate) {
        this.accountopendate = accountopendate;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public Date getAccountclosedate() {
        return accountclosedate;
    }
    public void setAccountclosedate(Date accountclosedate) {
        this.accountclosedate = accountclosedate;
    }
    public int getModeofoperation() {
        return modeofoperation;
    }
    public void setModeofoperation(int modeofoperation) {
        this.modeofoperation = modeofoperation;
    }
    public int getOpenbyuser() {
        return openbyuser;
    }
    public void setOpenbyuser(int openbyuser) {
        this.openbyuser = openbyuser;
    }
    public int getClosedbyuser() {
        return closedbyuser;
    }
    public void setClosedbyuser(int closedbyuser) {
        this.closedbyuser = closedbyuser;
    }
    
    
}
