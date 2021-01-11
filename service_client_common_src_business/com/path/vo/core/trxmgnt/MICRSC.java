package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class MICRSC extends GridParamsSC
{ 
    private BigDecimal code;
    private String bank;
    private String instRef;
    private BigDecimal instRefDec;
    private BigDecimal cifNo;
    private String accType;
    private String accAddRef;
    private BigDecimal accNo;
    private String gmi;
    private String addRef;
    private String fieldType;

    public BigDecimal getCode()
    {
        return code;
    }
    public void setCode(BigDecimal code)
    {
        this.code = code;
    }
    public String getBank()
    {
        return bank;
    }
    public void setBank(String bank)
    {
        this.bank = bank;
    }
    public String getInstRef()
    {
        return instRef;
    }
    public void setInstRef(String instRef)
    {
        this.instRef = instRef;
    }
    public BigDecimal getInstRefDec()
    {
        return instRefDec;
    }
    public void setInstRefDec(BigDecimal instRefDec)
    {
        this.instRefDec = instRefDec;
    }
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public String getAccType()
    {
        return accType;
    }
    public void setAccType(String accType)
    {
        this.accType = accType;
    }
    public String getAccAddRef()
    {
        return accAddRef;
    }
    public void setAccAddRef(String accAddRef)
    {
        this.accAddRef = accAddRef;
    }
    public BigDecimal getAccNo()
    {
        return accNo;
    }
    public void setAccNo(BigDecimal accNo)
    {
        this.accNo = accNo;
    }
    public String getGmi()
    {
        return gmi;
    }
    public void setGmi(String gmi)
    {
        this.gmi = gmi;
    }
    public String getAddRef()
    {
        return addRef;
    }
    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }
    public String getFieldType()
    {
        return fieldType;
    }
    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }
}