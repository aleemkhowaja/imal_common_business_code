package com.path.vo.core.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.AMF_EASY_CASHVO;
import com.path.dbmaps.vo.AMF_EXTENDEDVO;
import com.path.dbmaps.vo.FMSFACILITYDETVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * AccountsGAProfitDeclarationCO.java used to
 */
public class AccountsGAProfitDeclarationCO extends RetailBaseVO
{
    
    private AMF_EASY_CASHVO amfEasyCashVO = new AMF_EASY_CASHVO();
    
    private AMFVO amfVO = new AMFVO();
    
    
    private AMF_EXTENDEDVO  amfExtendedVO = new AMF_EXTENDEDVO();
    
    private FMSFACILITYDETVO fmsFacilityDetVO = new FMSFACILITYDETVO(); 
    
    
    private List<String> listWarningMsg = new ArrayList<String>();
    
    private BigDecimal currentRowNumbers;
    
    
    private Date usedDate;
    private Date firstWorkingDate;
    
    private BigDecimal addNumber5;
    private BigDecimal addNumber6;
    
    private BigDecimal decimalPoints;
   private String profitDeclGridUpdates; 
    private String cyFormatter;
   
   
   private List<AccountsGAProfitDeclarationCO> profitDeclAllRecList = new ArrayList<AccountsGAProfitDeclarationCO>();
    
    public AMF_EASY_CASHVO getAmfEasyCashVO()
    {
        return amfEasyCashVO;
    }

    public void setAmfEasyCashVO(AMF_EASY_CASHVO amfEasyCashVO)
    {
        this.amfEasyCashVO = amfEasyCashVO;
    }

    public AMFVO getAmfVO()
    {
        return amfVO;
    }

    public void setAmfVO(AMFVO amfVO)
    {
        this.amfVO = amfVO;
    }

    public BigDecimal getCurrentRowNumbers()
    {
        return currentRowNumbers;
    }

    public void setCurrentRowNumbers(BigDecimal currentRowNumbers)
    {
        this.currentRowNumbers = currentRowNumbers;
    }

    public AMF_EXTENDEDVO getAmfExtendedVO()
    {
        return amfExtendedVO;
    }

    public void setAmfExtendedVO(AMF_EXTENDEDVO amfExtendedVO)
    {
        this.amfExtendedVO = amfExtendedVO;
    }

    public Date getUsedDate()
    {
        return usedDate;
    }

    public void setUsedDate(Date usedDate)
    {
        this.usedDate = usedDate;
    }

    public Date getFirstWorkingDate()
    {
        return firstWorkingDate;
    }

    public void setFirstWorkingDate(Date firstWorkingDate)
    {
        this.firstWorkingDate = firstWorkingDate;
    }

    public List<String> getListWarningMsg()
    {
        return listWarningMsg;
    }

    public void setListWarningMsg(List<String> listWarningMsg)
    {
        this.listWarningMsg = listWarningMsg;
    }

    public BigDecimal getAddNumber5()
    {
        return addNumber5;
    }

    public void setAddNumber5(BigDecimal addNumber5)
    {
        this.addNumber5 = addNumber5;
    }

    public BigDecimal getAddNumber6()
    {
        return addNumber6;
    }

    public void setAddNumber6(BigDecimal addNumber6)
    {
        this.addNumber6 = addNumber6;
    }

    public FMSFACILITYDETVO getFmsFacilityDetVO()
    {
        return fmsFacilityDetVO;
    }

    public void setFmsFacilityDetVO(FMSFACILITYDETVO fmsFacilityDetVO)
    {
        this.fmsFacilityDetVO = fmsFacilityDetVO;
    }


    public String getProfitDeclGridUpdates()
    {
        return profitDeclGridUpdates;
    }

    public void setProfitDeclGridUpdates(String profitDeclGridUpdates)
    {
        this.profitDeclGridUpdates = profitDeclGridUpdates;
    }

    public List<AccountsGAProfitDeclarationCO> getProfitDeclAllRecList()
    {
        return profitDeclAllRecList;
    }

    public void setProfitDeclAllRecList(List<AccountsGAProfitDeclarationCO> profitDeclAllRecList)
    {
        this.profitDeclAllRecList = profitDeclAllRecList;
    }

    public BigDecimal getDecimalPoints()
    {
        return decimalPoints;
    }

    public void setDecimalPoints(BigDecimal decimalPoints)
    {
        this.decimalPoints = decimalPoints;
    }

    public String getCyFormatter()
    {
        return cyFormatter;
    }

    public void setCyFormatter(String cyFormatter)
    {
        this.cyFormatter = cyFormatter;
    }

    
    
    
}
