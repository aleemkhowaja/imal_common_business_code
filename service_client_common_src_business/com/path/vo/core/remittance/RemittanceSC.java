package com.path.vo.core.remittance;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class RemittanceSC extends GridParamsSC
{
    private String remittanceType;
    private BigDecimal remittType;
    private BigDecimal trsCy;
    private BigDecimal remittFrmNum;
    private BigDecimal remittToNum;
    private String byCompOrBr;
    private String remittCy;
    private String operator; 
    private String status;
    private BigDecimal headUser;
    private BigDecimal user;
    private boolean isVault;
    private BigDecimal teller;
    private String remitByHeadteller;
    private BigDecimal headTeller;
    private String serialNo;
    private BigDecimal trxType;
    private String remittanceStr;
    
    private String cbInd;
    private String trsType;
    private String langCode;
    private BigDecimal	trsAcBr;
    private BigDecimal trsAcCy;
    private BigDecimal trsAcGl;
    private BigDecimal trsAcCif;
    private BigDecimal trsAcSl;
    private BigDecimal trsNo;
    
    public String getCbInd()
    {
        return cbInd;
    }

    public void setCbInd(String cbInd)
    {
        this.cbInd = cbInd;
    }

    public String getTrsType()
    {
        return trsType;
    }

    public void setTrsType(String trsType)
    {
        this.trsType = trsType;
    }

    public String getLangCode()
    {
        return langCode;
    }

    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }

    public BigDecimal getTrsAcBr()
    {
        return trsAcBr;
    }

    public void setTrsAcBr(BigDecimal trsAcBr)
    {
        this.trsAcBr = trsAcBr;
    }

    public BigDecimal getTrsAcCy()
    {
        return trsAcCy;
    }

    public void setTrsAcCy(BigDecimal trsAcCy)
    {
        this.trsAcCy = trsAcCy;
    }

    public BigDecimal getTrsAcGl()
    {
        return trsAcGl;
    }

    public void setTrsAcGl(BigDecimal trsAcGl)
    {
        this.trsAcGl = trsAcGl;
    }

    public BigDecimal getTrsAcCif()
    {
        return trsAcCif;
    }

    public void setTrsAcCif(BigDecimal trsAcCif)
    {
        this.trsAcCif = trsAcCif;
    }

    public BigDecimal getTrsAcSl()
    {
        return trsAcSl;
    }

    public void setTrsAcSl(BigDecimal trsAcSl)
    {
        this.trsAcSl = trsAcSl;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public String getRemittanceType()
    {
	return remittanceType;
    }

    public void setRemittanceType(String remittanceType)
    {
	this.remittanceType = remittanceType;
    }

    public BigDecimal getRemittFrmNum()
    {
        return remittFrmNum;
    }

    public void setRemittFrmNum(BigDecimal remittFrmNum)
    {
        this.remittFrmNum = remittFrmNum;
    }

    public BigDecimal getRemittToNum()
    {
        return remittToNum;
    }

    public void setRemittToNum(BigDecimal remittToNum)
    {
        this.remittToNum = remittToNum;
    }

    public String getByCompOrBr()
    {
        return byCompOrBr;
    }

    public void setByCompOrBr(String byCompOrBr)
    {
        this.byCompOrBr = byCompOrBr;
    }

    public BigDecimal getRemittType()
    {
        return remittType;
    }

    public void setRemittType(BigDecimal remittType)
    {
        this.remittType = remittType;
    }

    public BigDecimal getTrsCy()
    {
        return trsCy;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
        this.trsCy = trsCy;
    }

    public String getRemittCy()
    {
        return remittCy;
    }

    public void setRemittCy(String remittCy)
    {
        this.remittCy = remittCy;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public BigDecimal getHeadUser()
    {
        return headUser;
    }

    public void setHeadUser(BigDecimal headUser)
    {
        this.headUser = headUser;
    }

    public BigDecimal getUser()
    {
        return user;
    }

    public void setUser(BigDecimal user)
    {
        this.user = user;
    }

    public boolean isVault()
    {
        return isVault;
    }

    public void setVault(boolean isVault)
    {
        this.isVault = isVault;
    }

    public BigDecimal getTeller()
    {
        return teller;
    }

    public void setTeller(BigDecimal teller)
    {
        this.teller = teller;
    }
    /**
     * @return the remitByHeadteller
     */
    public String getRemitByHeadteller()
    {
        return remitByHeadteller;
    }

    /**
     * @param remitByHeadteller the remitByHeadteller to set
     */
    public void setRemitByHeadteller(String remitByHeadteller)
    {
        this.remitByHeadteller = remitByHeadteller;
    }

    /**
     * @return the headTeller
     */
    public BigDecimal getHeadTeller()
    {
        return headTeller;
    }

    /**
     * @param headTeller the headTeller to set
     */
    public void setHeadTeller(BigDecimal headTeller)
    {
        this.headTeller = headTeller;
    }

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public BigDecimal getTrxType() {
		return trxType;
	}

	public void setTrxType(BigDecimal trxType) {
		this.trxType = trxType;
	}

    /**
     * @return the remittanceStr
     */
    public String getRemittanceStr()
    {
        return remittanceStr;
    }

    /**
     * @param remittanceStr the remittanceStr to set
     */
    public void setRemittanceStr(String remittanceStr)
    {
        this.remittanceStr = remittanceStr;
    }



}
