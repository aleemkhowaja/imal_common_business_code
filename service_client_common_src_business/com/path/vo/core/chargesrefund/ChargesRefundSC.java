package com.path.vo.core.chargesrefund;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class ChargesRefundSC extends GridParamsSC
{
    private String langCode;
    private BigDecimal lovType;
    private String progRef;
    private String appName;
    private String entityType;
    private BigDecimal refundCode;
    private BigDecimal lineNo;
    private Date fromDate;
    private Date toDate;
    private BigDecimal custAccBr;
    private BigDecimal custAccCy;
    private BigDecimal custAccGl;
    private BigDecimal custAccCif;
    private BigDecimal custAccSl;
    private String btnRetrieveClk;
    private String enableLogging;
    private List<ChargesRefundCO> sysRefCursor;
    private BigDecimal errorCode;
    private String errorDesc;
    
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public BigDecimal getLovType()
    {
        return lovType;
    }
    public void setLovType(BigDecimal lovType)
    {
        this.lovType = lovType;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public BigDecimal getRefundCode()
    {
        return refundCode;
    }
    public void setRefundCode(BigDecimal refundCode)
    {
        this.refundCode = refundCode;
    }
    public BigDecimal getLineNo()
    {
        return lineNo;
    }
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
    
    public BigDecimal getCustAccBr()
    {
        return custAccBr;
    }
    public void setCustAccBr(BigDecimal custAccBr)
    {
        this.custAccBr = custAccBr;
    }
    public BigDecimal getCustAccCy()
    {
        return custAccCy;
    }
    public void setCustAccCy(BigDecimal custAccCy)
    {
        this.custAccCy = custAccCy;
    }
    public BigDecimal getCustAccGl()
    {
        return custAccGl;
    }
    public void setCustAccGl(BigDecimal custAccGl)
    {
        this.custAccGl = custAccGl;
    }
    public BigDecimal getCustAccCif()
    {
        return custAccCif;
    }
    public void setCustAccCif(BigDecimal custAccCif)
    {
        this.custAccCif = custAccCif;
    }
    public BigDecimal getCustAccSl()
    {
        return custAccSl;
    }
    public void setCustAccSl(BigDecimal custAccSl)
    {
        this.custAccSl = custAccSl;
    }
    public Date getFromDate()
    {
        return fromDate;
    }
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }
    public Date getToDate()
    {
        return toDate;
    }
    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }
    public String getBtnRetrieveClk()
    {
        return btnRetrieveClk;
    }
    public void setBtnRetrieveClk(String btnRetrieveClk)
    {
        this.btnRetrieveClk = btnRetrieveClk;
    }
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getErrorDesc()
    {
        return errorDesc;
    }
    public void setErrorDesc(String errorDesc)
    {
        this.errorDesc = errorDesc;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getEntityType()
    {
        return entityType;
    }
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
    public String getEnableLogging()
    {
        return enableLogging;
    }
    public void setEnableLogging(String enableLogging)
    {
        this.enableLogging = enableLogging;
    }
    public List<ChargesRefundCO> getSysRefCursor()
    {
        return sysRefCursor;
    }
    public void setSysRefCursor(List<ChargesRefundCO> sysRefCursor)
    {
        this.sysRefCursor = sysRefCursor;
    }
}
