package com.path.vo.core.facilitytypeclass;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.V_DRAWDOWN_CLASSVO;
import com.path.lib.vo.BaseVO;

public class FacilityTypeClassCO extends BaseVO
{
    private V_DRAWDOWN_CLASSVO viewDrawDownClassVO;
    private String FacilityStatus;
    private BigDecimal cifIdNo;
    private String cifLongName;

    private BigDecimal compCode;
    private BigDecimal branch;
    private BigDecimal code;
    private BigDecimal lineNbr;
    private BigDecimal productClass;
    private BigDecimal category;
    private BigDecimal dealYield;
    private Date maturityDate;
    private BigDecimal classtype;
    private BigDecimal facilityValue;
    private String generalFacilityType;
    private String briefNameClass;
    private String briefNameCategory;
    private String briefNameDocType;

    public String getFacilityStatus()
    {
	return FacilityStatus;
    }

    public void setFacilityStatus(String facilityStatus)
    {
	FacilityStatus = facilityStatus;
    }

    public BigDecimal getCifIdNo()
    {
	return cifIdNo;
    }

    public void setCifIdNo(BigDecimal cifIdNo)
    {
	this.cifIdNo = cifIdNo;
    }

    public String getCifLongName()
    {
	return cifLongName;
    }

    public void setCifLongName(String cifLongName)
    {
	this.cifLongName = cifLongName;
    }

    public V_DRAWDOWN_CLASSVO getViewDrawDownClassVO()
    {
	return viewDrawDownClassVO;
    }

    public void setViewDrawDownClassVO(V_DRAWDOWN_CLASSVO viewDrawDownClassVO)
    {
	this.viewDrawDownClassVO = viewDrawDownClassVO;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranch()
    {
	return branch;
    }

    public void setBranch(BigDecimal branch)
    {
	this.branch = branch;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    public BigDecimal getLineNbr()
    {
	return lineNbr;
    }

    public void setLineNbr(BigDecimal lineNbr)
    {
	this.lineNbr = lineNbr;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public BigDecimal getCategory()
    {
	return category;
    }

    public void setCategory(BigDecimal category)
    {
	this.category = category;
    }

    public BigDecimal getDealYield()
    {
	return dealYield;
    }

    public void setDealYield(BigDecimal dealYield)
    {
	this.dealYield = dealYield;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public BigDecimal getClasstype()
    {
	return classtype;
    }

    public void setClasstype(BigDecimal classtype)
    {
	this.classtype = classtype;
    }

    public BigDecimal getFacilityValue()
    {
	return facilityValue;
    }

    public void setFacilityValue(BigDecimal facilityValue)
    {
	this.facilityValue = facilityValue;
    }

    public String getGeneralFacilityType()
    {
	return generalFacilityType;
    }

    public void setGeneralFacilityType(String generalFacilityType)
    {
	this.generalFacilityType = generalFacilityType;
    }

    public String getBriefNameClass()
    {
	return briefNameClass;
    }

    public void setBriefNameClass(String briefNameClass)
    {
	this.briefNameClass = briefNameClass;
    }

    public String getBriefNameCategory()
    {
	return briefNameCategory;
    }

    public void setBriefNameCategory(String briefNameCategory)
    {
	this.briefNameCategory = briefNameCategory;
    }

    public String getBriefNameDocType()
    {
	return briefNameDocType;
    }

    public void setBriefNameDocType(String briefNameDocType)
    {
	this.briefNameDocType = briefNameDocType;
    }

}
