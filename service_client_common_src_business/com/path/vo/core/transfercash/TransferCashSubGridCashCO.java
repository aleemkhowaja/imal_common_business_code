/**
 * @Date:Feb 7, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.transfercash;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSTELLER_CASH_BALANCE_DETVO;
import com.path.vo.common.cydenom.TrsCurrencyDetCO;
import com.path.vo.core.common.RetailBaseVO;

public class TransferCashSubGridCashCO extends RetailBaseVO
{

    private CTSTELLER_CASH_BALANCE_DETVO ctstellerCashBalanceDetVO;

    private BigDecimal balance;

    private String cashGridCurDesc;

    private BigDecimal decimalPts;
    
    private BigDecimal cashShortOver;
    
    private String cyDenomGridUpdates;
    
    /*
     * currency denomination
     */
    private List<TrsCurrencyDetCO> trsCurrencyDetCOs;
    
    private String cashFromVaultDesc;
    private String cashToVaultDesc;
    
    public CTSTELLER_CASH_BALANCE_DETVO getCtstellerCashBalanceDetVO()
    {
	return ctstellerCashBalanceDetVO;
    }

    public void setCtstellerCashBalanceDetVO(CTSTELLER_CASH_BALANCE_DETVO ctstellerCashBalanceDetVO)
    {
	this.ctstellerCashBalanceDetVO = ctstellerCashBalanceDetVO;
    }

    public BigDecimal getBalance()
    {
	return balance;
    }

    public void setBalance(BigDecimal balance)
    {
	this.balance = balance;
    }

    public BigDecimal getDecimalPts()
    {
	return decimalPts;
    }

    public void setDecimalPts(BigDecimal decimalPts)
    {
	this.decimalPts = decimalPts;
    }

    public String getCashGridCurDesc()
    {
	return cashGridCurDesc;
    }

    public void setCashGridCurDesc(String cashGridCurDesc)
    {
	this.cashGridCurDesc = cashGridCurDesc;
    }

    public BigDecimal getCashShortOver()
    {
        return cashShortOver;
    }

    public void setCashShortOver(BigDecimal cashShortOver)
    {
        this.cashShortOver = cashShortOver;
    }

    public String getCyDenomGridUpdates()
    {
        return cyDenomGridUpdates;
    }

    public void setCyDenomGridUpdates(String cyDenomGridUpdates)
    {
        this.cyDenomGridUpdates = cyDenomGridUpdates;
    }

    public List<TrsCurrencyDetCO> getTrsCurrencyDetCOs()
    {
        return trsCurrencyDetCOs;
    }

    public void setTrsCurrencyDetCOs(List<TrsCurrencyDetCO> trsCurrencyDetCOs)
    {
        this.trsCurrencyDetCOs = trsCurrencyDetCOs;
    }

    public String getCashFromVaultDesc()
    {
        return cashFromVaultDesc;
    }

    public void setCashFromVaultDesc(String cashFromVaultDesc)
    {
        this.cashFromVaultDesc = cashFromVaultDesc;
    }

    public String getCashToVaultDesc()
    {
        return cashToVaultDesc;
    }

    public void setCashToVaultDesc(String cashToVaultDesc)
    {
        this.cashToVaultDesc = cashToVaultDesc;
    }

}
