package com.core.po;

import java.util.Date;

public class Customer {
    private Integer custId;

    private String custName;

    private Integer custUserId;

    private Integer custCreateId;

    private String custSource;

    private String custIndustry;

    private String vustLevel;

    private String custLinkman;

    private String custPhone;

    private String custMoblie;

    private String custZipcode;

    private String custAddress;

    private Date cust_createtime;

    private Integer start;

    private Integer rows;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Integer getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(Integer custUserId) {
        this.custUserId = custUserId;
    }

    public Integer getCustCreateId() {
        return custCreateId;
    }

    public void setCustCreateId(Integer custCreateId) {
        this.custCreateId = custCreateId;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource == null ? null : custSource.trim();
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry == null ? null : custIndustry.trim();
    }

    public String getVustLevel() {
        return vustLevel;
    }

    public void setVustLevel(String vustLevel) {
        this.vustLevel = vustLevel == null ? null : vustLevel.trim();
    }

    public String getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(String custLinkman) {
        this.custLinkman = custLinkman == null ? null : custLinkman.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustMoblie() {
        return custMoblie;
    }

    public void setCustMoblie(String custMoblie) {
        this.custMoblie = custMoblie == null ? null : custMoblie.trim();
    }

    public String getCustZipcode() {
        return custZipcode;
    }

    public void setCustZipcode(String custZipcode) {
        this.custZipcode = custZipcode == null ? null : custZipcode.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

    public Date getCust_createtime() {
        return cust_createtime;
    }

    public void setCust_createtime(Date cust_createtime) {
        this.cust_createtime = cust_createtime;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}