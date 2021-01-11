/**
 * @Date:Feb 7, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.transfercash;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CASH_BALANCE_REMITTVO;
import com.path.vo.core.common.RetailBaseVO;

public class TransferCashRemittanceGridCO extends RetailBaseVO
{
    private CASH_BALANCE_REMITTVO cashBalanceRemittVO;
    private String remittDesc;
    private String remittType;
    private String currencyDesc;
    private BigDecimal seqNo;
    private BigDecimal decimalPts;
    private BigDecimal amount;
    private String remitFromVaultDesc;
    private String remitToVaultDesc;
    private Boolean remittanceGridSerialDisabled = false;
    private BigDecimal denomination; //Rania - 504699 - SBI170064 - Prize Bond Management
    private String prizeBondTypeList; //Rania - 504699 - SBI170064 - Prize Bond Management
    private Date remittDateUpdated; //Rania - 504699 - SBI170064 - Prize Bond Management
    
    public CASH_BALANCE_REMITTVO getCashBalanceRemittVO()
    {
	return cashBalanceRemittVO;
    }

    public void setCashBalanceRemittVO(CASH_BALANCE_REMITTVO cashBalanceRemittVO)
    {
	this.cashBalanceRemittVO = cashBalanceRemittVO;
    }

    public String getRemittDesc()
    {
	return remittDesc;
    }

    public void setRemittDesc(String remittDesc)
    {
	this.remittDesc = remittDesc;
    }

    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    public BigDecimal getSeqNo()
    {
        return seqNo;
    }

    public void setSeqNo(BigDecimal seqNo)
    {
        this.seqNo = seqNo;
    }

    public BigDecimal getDecimalPts()
    {
        return decimalPts;
    }

    public void setDecimalPts(BigDecimal decimalPts)
    {
        this.decimalPts = decimalPts;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getRemitFromVaultDesc()
    {
        return remitFromVaultDesc;
    }

    public void setRemitFromVaultDesc(String remitFromVaultDesc)
    {
        this.remitFromVaultDesc = remitFromVaultDesc;
    }

    public String getRemitToVaultDesc()
    {
        return remitToVaultDesc;
    }

    public void setRemitToVaultDesc(String remitToVaultDesc)
    {
        this.remitToVaultDesc = remitToVaultDesc;
    }

    public String getRemittType()
    {
        return remittType;
    }

    public void setRemittType(String remittType)
    {
        this.remittType = remittType;
    }

    public Boolean getRemittanceGridSerialDisabled()
    {
        return remittanceGridSerialDisabled;
    }

    public void setRemittanceGridSerialDisabled(Boolean remittanceGridSerialDisabled)
    {
        this.remittanceGridSerialDisabled = remittanceGridSerialDisabled;
    }

    public BigDecimal getDenomination()
    {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination)
    {
        this.denomination = denomination;
    }

    public String getPrizeBondTypeList()
    {
        return prizeBondTypeList;
    }

    public void setPrizeBondTypeList(String prizeBondTypeList)
    {
        this.prizeBondTypeList = prizeBondTypeList;
    }

    public Date getRemittDateUpdated()
    {
        return remittDateUpdated;
    }

    public void setRemittDateUpdated(Date remittDateUpdated)
    {
        this.remittDateUpdated = remittDateUpdated;
    }
}
