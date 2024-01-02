package com.bankingapi.bankingproject.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_master")
public class ProductMaster  {
    @Id
    private int ProductCode;
    private String ProductName;
    private int ModuleType;
    private int ProductStatus;
    public ProductMaster() {
    }
    public ProductMaster(int productCode, String productName, int moduleType, int productStatus) {
        ProductCode = productCode;
        ProductName = productName;
        ModuleType = moduleType;
        ProductStatus = productStatus;
    }
    public int getProductCode() {
        return ProductCode;
    }
    public void setProductCode(int productCode) {
        ProductCode = productCode;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String productName) {
        ProductName = productName;
    }
    public int getModuleType() {
        return ModuleType;
    }
    public void setModuleType(int moduleType) {
        ModuleType = moduleType;
    }
    public int getProductStatus() {
        return ProductStatus;
    }
    public void setProductStatus(int productStatus) {
        ProductStatus = productStatus;
    }
    
    

    }
