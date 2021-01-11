package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomCifJointAccSC extends GridParamsSC
{
    private BigDecimal cifCode;
    private BigDecimal lineNo;
    private BigDecimal lovType;
    private String langCode;
    private BigDecimal jointCifNo;
    private BigDecimal cifType;
    private String callingMode;
    private String confirmMsg;
    private BigDecimal compCodeCif;
    
    private BigDecimal cifNo;

    public String getCallingMode()
    {
	return callingMode;
    }

    public void setCallingMode(String callingMode)
    {
	this.callingMode = callingMode;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public BigDecimal getJointCifNo()
    {
	return jointCifNo;
    }

    public void setJointCifNo(BigDecimal jointCifNo)
    {
	this.jointCifNo = jointCifNo;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getLovType()
    {
	return lovType;
    }

    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public String getConfirmMsg()
    {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg)
    {
        this.confirmMsg = confirmMsg;
    }


    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }
    
    

}