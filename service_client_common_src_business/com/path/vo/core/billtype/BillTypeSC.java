package com.path.vo.core.billtype;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.csmfom.FomBillTypeCO;

public class BillTypeSC extends GridParamsSC
{
    private BigDecimal billType;
    private BigDecimal cifNo;
    private BigDecimal cyCode;
    private BigDecimal trxTypeCode;
    private String language;
    private List<FomBillTypeCO> fomBillTypeGrid_lst;

    private String billTypeStr;
    
    //Rania - 829901
    private String showSoRefLookup;
    private BigDecimal accCif;
    //
    
    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getTrxTypeCode()
    {
	return trxTypeCode;
    }

    public void setTrxTypeCode(BigDecimal trxTypeCode)
    {
	this.trxTypeCode = trxTypeCode;
    }

    public BigDecimal getBillType()
    {
	return billType;
    }

    public void setBillType(BigDecimal billType)
    {
	this.billType = billType;
    }

    public BigDecimal getCyCode()
    {
	return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
	this.cyCode = cyCode;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public List<FomBillTypeCO> getFomBillTypeGrid_lst()
    {
	return fomBillTypeGrid_lst;
    }

    public void setFomBillTypeGrid_lst(List<FomBillTypeCO> fomBillTypeGridLst)
    {
	fomBillTypeGrid_lst = fomBillTypeGridLst;
    }

    public String getBillTypeStr()
    {
        return billTypeStr;
    }

    public void setBillTypeStr(String billTypeStr)
    {
        this.billTypeStr = billTypeStr;
    }

    public String getShowSoRefLookup()
    {
        return showSoRefLookup;
    }

    public void setShowSoRefLookup(String showSoRefLookup)
    {
        this.showSoRefLookup = showSoRefLookup;
    }

    public BigDecimal getAccCif()
    {
        return accCif;
    }

    public void setAccCif(BigDecimal accCif)
    {
        this.accCif = accCif;
    }
}
