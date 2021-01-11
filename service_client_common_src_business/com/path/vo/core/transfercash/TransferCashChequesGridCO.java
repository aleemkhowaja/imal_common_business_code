/**
 * @Date:Feb 7, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.transfercash;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSTELLER_CASH_BALANCE_CHEQUEVO;
import com.path.vo.core.common.RetailBaseVO;

public class TransferCashChequesGridCO extends RetailBaseVO
{
    private CTSTELLER_CASH_BALANCE_CHEQUEVO ctstellerCashBalanceChequeVO;
    private String currencyDesc;
    private BigDecimal decimalPts;
    private String rowToDeleted;
    private String trxTypeChequeDesc;
    private String chequeFromVaultDesc;
    private String chequeToVaultDesc;

    public String getRowToDeleted()
    {
        return rowToDeleted;
    }

    public void setRowToDeleted(String rowToDeleted)
    {
        this.rowToDeleted = rowToDeleted;
    }

    public String getCurrencyDesc()
    {
	return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
	this.currencyDesc = currencyDesc;
    }

    public BigDecimal getDecimalPts()
    {
	return decimalPts;
    }

    public void setDecimalPts(BigDecimal decimalPts)
    {
	this.decimalPts = decimalPts;
    }

    public CTSTELLER_CASH_BALANCE_CHEQUEVO getCtstellerCashBalanceChequeVO()
    {
        return ctstellerCashBalanceChequeVO;
    }

    public void setCtstellerCashBalanceChequeVO(CTSTELLER_CASH_BALANCE_CHEQUEVO ctstellerCashBalanceChequeVO)
    {
        this.ctstellerCashBalanceChequeVO = ctstellerCashBalanceChequeVO;
    }

    public String getTrxTypeChequeDesc()
    {
        return trxTypeChequeDesc;
    }

    public void setTrxTypeChequeDesc(String trxTypeChequeDesc)
    {
        this.trxTypeChequeDesc = trxTypeChequeDesc;
    }

    public String getChequeFromVaultDesc()
    {
        return chequeFromVaultDesc;
    }

    public void setChequeFromVaultDesc(String chequeFromVaultDesc)
    {
        this.chequeFromVaultDesc = chequeFromVaultDesc;
    }

    public String getChequeToVaultDesc()
    {
        return chequeToVaultDesc;
    }

    public void setChequeToVaultDesc(String chequeToVaultDesc)
    {
        this.chequeToVaultDesc = chequeToVaultDesc;
    }

}
