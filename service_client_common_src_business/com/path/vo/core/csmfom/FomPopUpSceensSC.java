package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class FomPopUpSceensSC extends BaseSC
{
    /**this class is using for  search criteria ij order to get the max line no from aby popup realted to FOM
     * 
     */
 
    private BigDecimal cifNo;
    private String tableName;
    private BigDecimal cifCode;
    private BigDecimal lineNumber;
    private String useLineNumber="";
    private String useLineNo="";
    private String useMainlineno="";
    private String  DEFAULT_ADD ;
    private String  detailsType ;
    private String useChildLineNo = "";//Rania - SBI190008 - SECP requirement for Ultimate Beneficial Owner
  
    public String getDEFAULT_ADD()
    {
	return DEFAULT_ADD;
    }

    public void setDEFAULT_ADD(String dEFAULTADD)
    {
	DEFAULT_ADD = dEFAULTADD;
    }

    public String getTableName()
    {
        return tableName;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
  
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public BigDecimal getCifCode()
    {
        return cifCode;
    }
    public void setCifCode(BigDecimal cifCode)
    {
        this.cifCode = cifCode;
    }
    public BigDecimal getLineNumber()
    {
        return lineNumber;
    }
    public void setLineNumber(BigDecimal lineNumber)
    {
        this.lineNumber = lineNumber;
    }
    public String getUseLineNumber()
    {
        return useLineNumber;
    }
    public void setUseLineNumber(String useLineNumber)
    {
        this.useLineNumber = useLineNumber;
    }
    public String getUseLineNo()
    {
        return useLineNo;
    }
    public void setUseLineNo(String useLineNo)
    {
        this.useLineNo = useLineNo;
    }

    public String getUseMainlineno()
    {
	return useMainlineno;
    }

    public void setUseMainlineno(String useMainlineno)
    {
	this.useMainlineno = useMainlineno;
    }

    public String getDetailsType()
    {
	return detailsType;
    }

    public void setDetailsType(String detailsType)
    {
	this.detailsType = detailsType;
    }
    
    public String getUseChildLineNo()
    {
        return useChildLineNo;
    }
    public void setUseChildLineNo(String useChildLineNo)
    {
        this.useChildLineNo = useChildLineNo;
    }
}